package org.jlobato.gpro.forecast;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.IntrospectionException;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Properties;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

import org.jlobato.gpro.forecast.RaceForecastUI.ForecastUI;
import org.jlobato.gpro.forecast.RaceForecastUI.IntervalForecastUI;
import org.jlobato.gpro.languages.ConstantesLanguages;
import org.jlobato.gpro.languages.ILanguage;
import org.jlobato.gpro.languages.LanguageManager;
import org.jlobato.gpro.setup.CarSetup;
import org.jlobato.gpro.setup.Main;
import org.jlobato.gpro.setup.PracticeSession;
import org.jlobato.gpro.setup.PracticeSessionEvent;
import org.jlobato.gpro.setup.PracticeSessionListener;
import org.jlobato.gpro.setup.SetupUtilityMediator;
import org.jlobato.gpro.update.UpdateServiceManager;

/**
 *
 * @author JLOBATO
 *
 */
public class RaceForecastController implements ActionListener, RaceForecastGrabListener, PropertyChangeListener, PracticeSessionListener, RaceForecastListener {
	
	public static final String NO_USER_INFO_TITLE_KEY = "no.user.info.title";
	public static final String NO_USER_INFO_MESSAGE_KEY = "no.user.info.message";
	
	
	public static final HashMap<String, String> RACE_FORECAST_TOKENS_EN = new HashMap<String, String>();
	public static final HashMap<String, String> RACE_FORECAST_TOKENS_ES = new HashMap<String, String>();
	
	static {
		RACE_FORECAST_TOKENS_EN.put(NO_USER_INFO_TITLE_KEY, "No user info");
		RACE_FORECAST_TOKENS_EN.put(NO_USER_INFO_MESSAGE_KEY, "No username or password set at user information tab");
		
		
		RACE_FORECAST_TOKENS_ES.put(NO_USER_INFO_TITLE_KEY, "Sin usuario");
		RACE_FORECAST_TOKENS_ES.put(NO_USER_INFO_MESSAGE_KEY, "No ha introducido usuario o password en la pestaña de información de usuario");
	}
	

	/**
	 *
	 */
	private RaceForecastUI ui;

	/**
	 *
	 */
	private PropertyLock humidityQ1Lock = new PropertyLock();

	private PropertyLock temperatureQ1Lock = new PropertyLock();

	private PropertyLock humidityQ2Lock = new PropertyLock();

	private PropertyLock temperatureQ2Lock = new PropertyLock();

	/**
	 * 
	 */
	private CarSetupUpdater setupUpdater = new CarSetupUpdater();

	/**
	 *
	 * @param ui
	 */
	public RaceForecastController(RaceForecastUI ui) {
		setRaceForecastUI(ui);
	}

	/**
	 *
	 * @param ui
	 */
	public void setRaceForecastUI(RaceForecastUI ui) {
		this.ui = ui;
		this.ui.getGrabButton().addActionListener(this);

		attachForecastUI(this.ui.getQ1UI(), humidityQ1Lock, temperatureQ1Lock);
		attachForecastUI(this.ui.getQ2UI(), humidityQ2Lock, temperatureQ2Lock);
	}

	/**
	 *
	 */
	private void attachForecastUI(ForecastUI foreCastUI, PropertyLock humidityLock, PropertyLock temperatureLock) {
		//TODO Falta el caso en que el modelo de carrera ya esté disponible. Hay que pintarlo
		//Esto es mejorable, pero debería controlarse cuando se lanza el evento de race forecast changed
		//TODO Al lanzarse ese evento, se actualizan los modelos internos y es en ese momento cuando se puede ejecutar este código
		if (foreCastUI.getModel() != null) {
			foreCastUI.getModel().addPropertyChangeListener(this);
			foreCastUI.getHumidityField().getDocument().addDocumentListener(new ForecastControllerInnerDocumentListener(foreCastUI.getModel(), IForecast.HUMIDITY_PROPERTY, humidityLock));
			foreCastUI.getTemperatureField().getDocument().addDocumentListener(new ForecastControllerInnerDocumentListener(foreCastUI.getModel(), IForecast.TEMPERATURE_PROPERTY, temperatureLock));
			foreCastUI.getWeatherCombo().addActionListener(new ForecastControllerInnerActionListener(foreCastUI.getModel()));
		}
		ui.addRaceForecastListener(this);
	}

	/**
	 *
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(RaceForecastUI.GRAB_WEATHER_COMMAND)) {
			//Validamos previamente que hay usuario y password especificados
			String username = SetupUtilityMediator.getInstance().getUsuario().getContextoUsuario().getUsername();
			String password = SetupUtilityMediator.getInstance().getUsuario().getContextoUsuario().getPassword();
			ILanguage userLanguage = SetupUtilityMediator.getInstance().getUserLanguage();
			
			if ((username == null || password == null) || (username.equals("") || password.equals(""))) {
				JOptionPane.showMessageDialog(this.ui, LanguageManager.getInstance().getBundle(userLanguage, NO_USER_INFO_MESSAGE_KEY), LanguageManager.getInstance().getBundle(userLanguage, NO_USER_INFO_TITLE_KEY), JOptionPane.ERROR_MESSAGE);
				return;
			}
			Properties props = new Properties();
			props.put(ContextoPasarelaRaceForecastWebGPRO.GPRO_URL_PROPERTY, Main.GPRO_URL);
			props.put(ContextoPasarelaRaceForecastWebGPRO.GPRO_USERNAME_PROPERTY, username);
			props.put(ContextoPasarelaRaceForecastWebGPRO.GPRO_PASSWORD_PROPERTY, password);

			RaceForecastWebGrabber grabber = new RaceForecastWebGrabber(
					props.getProperty(ContextoPasarelaRaceForecastWebGPRO.GPRO_URL_PROPERTY),
					props.getProperty(ContextoPasarelaRaceForecastWebGPRO.GPRO_USERNAME_PROPERTY),
					props.getProperty(ContextoPasarelaRaceForecastWebGPRO.GPRO_PASSWORD_PROPERTY));

			grabber.addRaceForecastGrabListener(this);

			//Se lanza la actualización
			PasarelaRaceForecastRunnable updater = new PasarelaRaceForecastRunnable(props, grabber, this.ui);
			UpdateServiceManager.getInstance().updateWeatherService(updater);
		}

	}

	/**
	 *
	 * @author JLOBATO
	 *
	 */
	private class PasarelaRaceForecastRunnable implements Runnable {

		/**
		 *
		 */
		private Properties props;

		/**
		 *
		 */
		private RaceForecastUI ui;

		/**
		 *
		 */
		private RaceForecastWebGrabber grabber;

		/**
		 *
		 * @param props
		 * @param grabber
		 * @param ui
		 */
		public PasarelaRaceForecastRunnable(Properties props, RaceForecastWebGrabber grabber, RaceForecastUI ui) {
			this.props = props;
			this.ui = ui;
			this.grabber = grabber;
		}

		/**
		 *
		 */
		public void run() {
			try {
				IContextoPasarelaRaceForecast contexto = new ContextoPasarelaRaceForecastWebGPRO(props, grabber);
				IPasarelaRaceForecast pasarela = contexto.getPasarela();
				this.ui.setModel(pasarela.getRaceForecast());
			} catch (RaceForecastException ex) {
				ex.printStackTrace();
			}

		}

	}

	/**
	 *
	 */
	public void grabEnded(RaceForecastGrabEvent evt) {
		this.ui.getGrabButton().setEnabled(true);
		this.ui.setEnabled(false);
	}

	/**
	 *
	 */
	public void grabStarted(RaceForecastGrabEvent evt) {
		this.ui.getGrabButton().setEnabled(false);
		this.ui.setEnabled(false);
		this.ui.getEstimatedRaceTempLabel().setText("--");
	}

	/**
	 *
	 */
	public void grabFailed(RaceForecastGrabEvent evt) {
		JOptionPane.showMessageDialog(this.ui, evt.getRootException().getMessage());
	}


	private class ForecastControllerInnerActionListener implements ActionListener {

		private IForecast forecast;

		public ForecastControllerInnerActionListener(IForecast forecast) {
			this.forecast = forecast;
		}

		/**
		 *
		 */
		public void actionPerformed(ActionEvent evt) {
			String value = ((JComboBox)evt.getSource()).getSelectedItem().toString();
			double newValue = value.equals(IForecast.LLUVIA_LABEL) ? 1 : value.equals(IForecast.SECO_LABEL) ? 0 : -1;
			//Utilizo esto para no lanzar otro evento
			((DefaultForecast)forecast).weather = newValue;
		}
	}

	private class ForecastControllerInnerDocumentListener implements DocumentListener {

		private Object source;
		private String property;
		private PropertyDescriptor descriptor;
		private PropertyLock lock;
		private boolean convertToDouble;

		/**
		 *
		 * @param source
		 * @param property
		 * @param lock
		 */
		public ForecastControllerInnerDocumentListener(Object source, String property, PropertyLock lock) {
			this(source, property, lock, true);
		}

		public ForecastControllerInnerDocumentListener(Object source, String property, PropertyLock lock, boolean convertToDouble) {
			this.source = source;
			this.property = property;
			this.lock = lock;
			this.convertToDouble = convertToDouble;
			try {
				this.descriptor = new PropertyDescriptor(this.property, source.getClass());
			} catch (IntrospectionException e) {
				e.printStackTrace();
				this.descriptor = null;
			}
		}

		/**
		 *
		 */
		public void changedUpdate(DocumentEvent e) {
			doTextUpdate(e);
		}

		/**
		 *
		 */
		public void insertUpdate(DocumentEvent e) {
			doTextUpdate(e);
		}

		/**
		 *
		 */
		public void removeUpdate(DocumentEvent e) {
			doTextUpdate(e);
		}

		/**
		 * @param e
		 */
		private void doTextUpdate(DocumentEvent e) {
			synchronized (lock) {
				if (!lock.isValue()) {
					lock.setValue(true);
					try {
						Object theNewValue = (convertToDouble) ? getDoubleValue(e) : (Object)getString(e);
						if (this.descriptor != null) {
							this.descriptor.getWriteMethod().invoke(this.source, new Object [] {theNewValue});

						}
					} catch (Exception e1) {
						e1.printStackTrace();
					} finally {
						lock.setValue(false);
					}
				}
			}
		}

		private String getString(DocumentEvent e) throws BadLocationException {
			String newValue = e.getDocument().getText(0, e.getDocument().getLength());
			return newValue;
		}

		/**
		 * @param e
		 * @return
		 * @throws BadLocationException
		 */
		private Double getDoubleValue(DocumentEvent e) throws BadLocationException {
			String newValue = e.getDocument().getText(0, e.getDocument().getLength());
			if (newValue != null && newValue.equals("")) {
				newValue = "0";
			}
			Double theNewValue = new Double(newValue);
			return theNewValue;
		}

	}


	/**
	 *
	 * @author JLOBATO
	 *
	 */
	private class PropertyLock {
		/**
		 *
		 */
		private boolean value;
		/**
		 *
		 */
		public PropertyLock() {
			this(false);
		}

		/**
		 *
		 * @param value
		 */
		public PropertyLock(boolean value) {
			this.value = value;
		}

		/**
		 * @return the value
		 */
		public boolean isValue() {
			return value;
		}

		/**
		 * @param value the value to set
		 */
		public void setValue(boolean value) {
			this.value = value;
		}
	}

	/**
	 *
	 */
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getSource().equals(this.ui.getQ1UI().getModel())) {
			IForecast source = (IForecast)evt.getSource();
			if (evt.getPropertyName().equals(IForecast.HUMIDITY_PROPERTY)) {
				updateTextField(this.ui.getQ1UI().getHumidityField(), source.getHumidity(), this.humidityQ1Lock);
			}
			else if (evt.getPropertyName().equals(IForecast.TEMPERATURE_PROPERTY)) {
				updateTextField(this.ui.getQ1UI().getHumidityField(), source.getHumidity(), this.temperatureQ1Lock);
			}
			else if (evt.getPropertyName().equals(IForecast.WEATHER_PROPERTY)) {
				updateCombo(this.ui.getQ1UI().getWeatherCombo(), source.getWeather());
			}

		} else if (evt.getSource().equals(this.ui.getQ2UI().getModel())) {
			IForecast source = (IForecast)evt.getSource();
			if (evt.getPropertyName().equals(IForecast.HUMIDITY_PROPERTY)) {
				updateTextField(this.ui.getQ2UI().getHumidityField(), source.getHumidity(), this.humidityQ2Lock);
			}
			else if (evt.getPropertyName().equals(IForecast.TEMPERATURE_PROPERTY)) {
				updateTextField(this.ui.getQ2UI().getHumidityField(), source.getHumidity(), this.temperatureQ2Lock);
			}
			else if (evt.getPropertyName().equals(IForecast.WEATHER_PROPERTY)) {
				updateCombo(this.ui.getQ2UI().getWeatherCombo(), source.getWeather());
			}
		}
	}

	/**
	 *
	 * @param weatherCombo
	 * @param weather
	 */
	private void updateCombo(JComboBox weatherCombo, double weather) {
		weatherCombo.setSelectedItem((weather == 1) ? IForecast.LLUVIA_LABEL : (weather < 0) ? " " : IForecast.SECO_LABEL);
	}

	/*
	 *
	 */
	private void updateTextField(JTextField textField, double newValue, PropertyLock lock) {
		synchronized(lock) {
			if (!lock.isValue()) {
				textField.setText(Double.toString(newValue));
				lock.setValue(false);
			}
		}
	}

	public void perfectSetupChanged(PracticeSessionEvent evt) {
		//Perfect setup
		CarSetup perfectSetup = evt.getSetup();
		//Sesión de prácticas
		PracticeSession theSession = (PracticeSession)evt.getSource();
		//Actualizamos setup
		setupUpdater.updateSetup(theSession, perfectSetup, this.ui.getModel());
	}


	public void carFringeChanged(PracticeSessionEvent evt) {
		//No se hace nada, no nos afecta
	}
	

	public void q2SetupChanged(PracticeSessionEvent evt) {
		//No se hace nada, no nos afecta
	}

	public void raceSetupChanged(PracticeSessionEvent evt) {
		//No se hace nada, no nos afecta
	}

	public void raceForecastChanged(RaceForecastEvent evt) {
		if (evt.getRaceForecast() != null) {
			RaceForecastUI ui = (RaceForecastUI)evt.getSource();
			IRaceForecast model = evt.getRaceForecast();
			//Actualizamos la vista de la Q1
			//TODO Esto debe lanzar un evento y que el controlador se ponga como listener de las propiedades
			ui.getQ1UI().setModel(model.getQ1Forecast());
			//Actualizamos la vista de la Q2
			//TODO Esto debe lanzar un evento y que el controlador se ponga como listener de las propiedades
			ui.getQ2UI().setModel(model.getQ2Forecast());
			//Actualizamos la vista de la carrera
			if (model.getRaceForecast() != null) {
				for (int i = 0; i < ui.getRaceForecastsUI().size(); i++) {
					IntervalForecastUI intervalUI = ui.getRaceForecastsUI().get(i);
					IIntervalForecast intervalForecast = new DefaultIntervalForecast();
					//Si no hay intervalos se pinta uno vacío, pero no se añade al modelo
					if (model.getRaceForecast().size() > i) {
						intervalForecast = model.getRaceForecast().get(i);
					}
					intervalUI.setModel(intervalForecast);
				}
			}
			//Temperatura estimada de carrera
			try {
				ui.getEstimatedRaceTempLabel().setText(Double.toString(model.getEstimatedRaceTemperature()));
			} catch (Exception e) {
				//Si se produce alguna excepción, no se modifica el valor de la temperatura estimada inicial (que debe ser "Sin temperatura")
			}
		}
		
	}

}
