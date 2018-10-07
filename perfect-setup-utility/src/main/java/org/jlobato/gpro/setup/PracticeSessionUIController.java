package org.jlobato.gpro.setup;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.LineNumberReader;
import java.io.StringReader;
import java.util.Enumeration;
import java.util.HashMap;

import javax.swing.AbstractButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

import org.jlobato.gpro.driver.IDriver;
import org.jlobato.gpro.forecast.CarSetupUpdater;
import org.jlobato.gpro.forecast.RaceForecastEvent;
import org.jlobato.gpro.forecast.RaceForecastListener;
import org.jlobato.gpro.languages.ConstantesLanguages;
import org.jlobato.gpro.languages.ILanguage;
import org.jlobato.gpro.languages.LanguageManager;
import org.jlobato.gpro.techdirector.ITechnicalDirector;

public class PracticeSessionUIController implements DocumentListener, ActionListener, PracticeSessionListener, RaceForecastListener {
	private PracticeSessionUI ui;
	private IDriver driver;
	private JFrame frame;
	private ITechnicalDirector techDirector;
	
	/**
	 * 
	 */
	private CarSetupUpdater setupUpdater = new CarSetupUpdater();


	public PracticeSessionUIController(PracticeSessionUI ui, IDriver driver, ITechnicalDirector techDirector, JFrame f) {
		this.driver = driver;
		this.frame = f;
		this.techDirector = techDirector;
		setPracticeSessionUI(ui);
	}

	/**
	 *
	 * @param ui
	 */
	public void setPracticeSessionUI(PracticeSessionUI ui) {
		this.ui = ui;
		this.ui.getDriverCommentsReceived().getDocument().addDocumentListener(this);
		this.ui.getNextSetupButton().addActionListener(this);
		this.ui.getClearPracticeButton().addActionListener(this);
		//this.ui.getPerfectSetupButton().addActionListener(this);
		Enumeration<AbstractButton> commsButton = this.ui.getCommsButtonGroup().getElements();
		while(commsButton.hasMoreElements()) {
			AbstractButton button = (AbstractButton)commsButton.nextElement();
			button.addActionListener(this);
		}
	}

	/**
	 *
	 */
	public void changedUpdate(DocumentEvent e) {
		try {
			String newValue = e.getDocument().getText(0, e.getDocument().getLength());
			ui.getNextSetupButton().setEnabled(newValue != null && !newValue.equals("") && ui.getDriverCommentsReceived().isEditable());
		} catch (BadLocationException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 *
	 */
	public void insertUpdate(DocumentEvent e) {
		try {
			String newValue = e.getDocument().getText(0, e.getDocument().getLength());
			ui.getNextSetupButton().setEnabled(newValue != null && !newValue.equals("") && ui.getDriverCommentsReceived().isEditable());
		} catch (BadLocationException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 *
	 */
	public void removeUpdate(DocumentEvent e) {
		try {
			String newValue = e.getDocument().getText(0, e.getDocument().getLength());
			ui.getNextSetupButton().setEnabled(newValue != null && !newValue.equals("") && ui.getDriverCommentsReceived().isEditable());
		} catch (BadLocationException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 *
	 */
	public void actionPerformed(ActionEvent e) {
		ILanguage userLanguage = SetupUtilityMediator.getInstance().getUserLanguage();
		
		//TODO Refactorizar todo el método porque se puede mejorar muy mucho
		if (e.getActionCommand().startsWith("COMMS_")) {
			Integer selectedLap = new Integer(e.getActionCommand().substring(e.getActionCommand().length() - 1, e.getActionCommand().length()));
			if (selectedLap.intValue() < this.ui.getModel().getPracticeLaps().size()) {
				PracticeLap theLap = (PracticeLap)this.ui.getModel().getPracticeLaps().get(selectedLap.intValue() - 1);

				String comments = new DriverCommentsParser().getComments(theLap);

				comments = LanguageManager.getInstance().getBundle(userLanguage, ConstantesLanguages.PRACTICE_LAP_KEY) +
					" " +
					theLap.getLapNumber().toString() +
					" " +
					LanguageManager.getInstance().getBundle(userLanguage, ConstantesLanguages.COMMENTS_DRIVER_KEY) +
					":\n\n" +
					comments;
				ui.getDriverCommentsReceived().setEditable(false);
				ui.getDriverCommentsReceived().setFont(ui.getDriverCommentsReceived().getFont().deriveFont(Font.BOLD));
				ui.getDriverCommentsReceived().setText(comments);
			}
			else {
				ui.getDriverCommentsReceived().setEditable(true);
				ui.getDriverCommentsReceived().setFont(ui.getDriverCommentsReceived().getFont().deriveFont(Font.PLAIN));
				ui.getDriverCommentsReceived().setText("");
				ui.getDriverCommentsReceived().requestFocus();
			}
		} else if (e.getActionCommand().equals("PERFECT")) {
			CalculadorSetupPerfecto calculador = new CalculadorSetupPerfectoRacing4Spain();
			try {
				CarSetup perfectSetup = calculador.getPerfectSetup(this.ui.getModel(), driver, techDirector);
				this.ui.getModel().setPerfectSetup(perfectSetup);
			}catch(CalculadorSetupPerfectoException ise) {
				JOptionPane.showMessageDialog(this.ui, ise.getMessage(), LanguageManager.getInstance().getBundle(userLanguage, ConstantesLanguages.NO_PERFECT_SETUP_FOUND_KEY), JOptionPane.ERROR_MESSAGE);
			}
		} else if (e.getSource().equals(this.ui.getNextSetupButton())) {
			DriverCommentsParser theParser = new DriverCommentsParser();
			CalculadorSetupPerfecto calculador = new CalculadorSetupPerfectoRacing4Spain();
			JTextArea textArea = this.ui.getDriverCommentsReceived();
			LineNumberReader reader = new LineNumberReader(new StringReader(textArea.getText()));
			try {
				HashMap<String, DriverComment> theComments = theParser.getComments(reader);

				PracticeSession session = this.ui.getModel();
				CarSetup nextSetup = null;
				if (session.getPracticeLaps().size() < PracticeSession.MAX_PRACTICE_RUNS) {
					Integer lapNumber = new Integer(session.getPracticeLaps().size() + 1);
					//Calculamos el siguiente setup
					//Estamos en la primera vuelta, así que hay que crear la vuelta con los valores que
					//haya en la primera fila
					if (lapNumber.intValue() == 1) {
						PracticeLap practiceLap = null;
						//Primera vuelta, hay que crear la vuelta inicial
						practiceLap = new PracticeLap(session,
								lapNumber,
								new LapTime(this.ui.getPracticeLapUI(lapNumber).getLapTime().getText(),
										this.ui.getPracticeLapUI(lapNumber).getDriverMistake().getText(),
										this.ui.getPracticeLapUI(lapNumber).getNetTime().getText()),
								new CarSetup(this.ui.getPracticeLapUI(lapNumber).getFrontWing().getText(),
										this.ui.getPracticeLapUI(lapNumber).getRearWing().getText(),
										this.ui.getPracticeLapUI(lapNumber).getEngine().getText(),
										this.ui.getPracticeLapUI(lapNumber).getBrakes().getText(),
										this.ui.getPracticeLapUI(lapNumber).getGearbox().getText(),
										this.ui.getPracticeLapUI(lapNumber).getSuspension().getText()),
								theComments);
						nextSetup = calculador.getNextCarSetup(practiceLap, driver, techDirector);
					}
					else {
						//Estamos en una vuelta posterior a la primera, obtenemos el setup directamente de la vista
						//Obtenemos el practice UI de la última vuelta
						lapNumber = new Integer(lapNumber.intValue() - 1);
						PracticeLapUI practiceUI = this.ui.getPracticeLapUI(lapNumber);
						PracticeLap lap = practiceUI.getPracticeLap();
						//Ponemos el setup que tiene la vuelta en la vista
						lap.setSetup(new CarSetup(practiceUI.getFrontWing().getText(),
								practiceUI.getRearWing().getText(),
								practiceUI.getEngine().getText(),
								practiceUI.getBrakes().getText(),
								practiceUI.getGearbox().getText(),
								practiceUI.getSuspension().getText()));
						//Ponemos los comentarios asociados a la vuelta
						lap.setComms(theComments);
						lap.setLapTime(new LapTime(practiceUI.getLapTime().getText(),
								practiceUI.getDriverMistake().getText(),
								practiceUI.getNetTime().getText()));
						nextSetup = calculador.getNextCarSetup(lap, driver, techDirector);
					}
					//Hemos calculado el siguiente setup, procedemos a crear la nueva vuelta y a actualizar
					//la vista
					if (nextSetup != null) {
						Integer nextLapNumber = new Integer(lapNumber.intValue() + 1);
						//Creamos por defecto una vuelta con todo satisfecho
						@SuppressWarnings("unused")
						PracticeLap nextPracticeLap = new PracticeLap(session,
								nextLapNumber,
								new LapTime("", "", ""),
								nextSetup,
								new HashMap<String, DriverComment>());
						//Actualizamos la vista
						//TODO Esto es matar moscas a cañonazos. Lo mejor sería actualizar sólo el practice UI
						this.ui.setModel(session);
						//TODO Se recalcula el setup perfecto, pero lo suyo sería lanzar un evento de practice lap added y ahí actualizar
						CalculadorSetupPerfecto perfectSetupCalculator = new CalculadorSetupPerfectoRacing4Spain();
						try {
							CarSetup perfectSetup = perfectSetupCalculator.getPerfectSetup(this.ui.getModel(), driver, techDirector);
							this.ui.getModel().setPerfectSetup(perfectSetup);
							CarFringe carFringe = perfectSetupCalculator.getCarFringe(this.ui.getModel(), driver, techDirector);
							this.ui.getModel().setCarFringe(carFringe);
							//Aquí metemos el cálculo del weather para ir validándolo
							
							//1. Obtener el modelo de clima. Hay que tirar de la vista de weather y acceder al método getModel()
							//2. Si hay modelo disponible partir de la Q1
							//3. Calcular la Q2 en base a los cambios
							//4. Calcular la Race en base a los datos de los 4 intervalos. Hay que implementar un calculador de temperatura media de carrera estimado
							//5. Implementar la vista para representar los resultados. En principio serán simples System.out, luego será una vista Swing
						}catch(CalculadorSetupPerfectoException ise) {
						}
						this.frame.pack();
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				if (reader != null) try {reader.close();} catch(Exception cl) {}
			}
		}
		else if (e.getSource().equals(this.ui.getClearPracticeButton())) {
			PracticeSession session = this.ui.getModel();
			session.clear();
			this.ui.setModel(session);
			CalculadorSetupPerfecto perfectSetupCalculator = new CalculadorSetupPerfectoRacing4Spain();
			try {
				CarSetup perfectSetup = perfectSetupCalculator.getPerfectSetup(this.ui.getModel(), driver, techDirector);
				this.ui.getModel().setPerfectSetup(perfectSetup);
				CarFringe carFringe = perfectSetupCalculator.getCarFringe(this.ui.getModel(), driver, techDirector);
				this.ui.getModel().setCarFringe(carFringe);
				//TODO Limpiar los setup de la Q2 y de Carrera
				this.ui.getModel().setQ2Setup(new CarSetup((Integer)null, null, null, null, null, null));
				this.ui.getModel().setRaceSetup(new CarSetup((Integer)null, null, null, null, null, null));
			}catch(CalculadorSetupPerfectoException ise) {
			}
			this.frame.pack();
		}
	}

	/**
	 *
	 * @param evt
	 * @see org.jlobato.gpro.setup.PracticeSessionListener#perfectSetupChanged(org.jlobato.gpro.setup.PracticeSessionEvent)
	 */
	public void perfectSetupChanged(PracticeSessionEvent evt) {
		CarSetup perfectSetup = evt.getSetup();
		this.ui.getPerfectSetupUI().setCarSetup(perfectSetup);
	}

	/**
	 *
	 */
	public void carFringeChanged(PracticeSessionEvent evt) {
		CarFringe carFringe = evt.getFringe();
		this.ui.getFringeSetupUI().setCarFringe(carFringe);
	}

	public void q2SetupChanged(PracticeSessionEvent evt) {
		CarSetup q2Setup = evt.getSetup();
		this.ui.getQ2SetupUI().setCarSetup(q2Setup);
		
	}

	public void raceSetupChanged(PracticeSessionEvent evt) {
		CarSetup raceSetup = evt.getSetup();
		this.ui.getRaceSetupUI().setCarSetup(raceSetup);
		
	}

	public void raceForecastChanged(RaceForecastEvent evt) {
		setupUpdater.updateSetup(this.ui.getModel(), this.ui.getModel().getPerfectSetup(), evt.getRaceForecast());
	}

}
