/**
 *
 */
package org.jlobato.gpro.setup;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import org.jlobato.gpro.driver.Driver;
import org.jlobato.gpro.driver.DriverUI;
import org.jlobato.gpro.driver.DriverUIController;
import org.jlobato.gpro.driver.IDriver;
import org.jlobato.gpro.forecast.DefaultRaceForecast;
import org.jlobato.gpro.forecast.IRaceForecast;
import org.jlobato.gpro.forecast.RaceForecastController;
import org.jlobato.gpro.forecast.RaceForecastUI;
import org.jlobato.gpro.forecast.RaceForecastWebGrabber;
import org.jlobato.gpro.languages.ConstantesLanguages;
import org.jlobato.gpro.languages.LanguageManager;
import org.jlobato.gpro.season.Season;
import org.jlobato.gpro.techdirector.ITechnicalDirector;
import org.jlobato.gpro.techdirector.TechnicalDirector;
import org.jlobato.gpro.techdirector.TechnicalDirectorUI;
import org.jlobato.gpro.techdirector.TechnicalDirectorUIController;
import org.jlobato.gpro.update.UpdateServiceManager;
import org.jlobato.gpro.user.IUsuario;
import org.jlobato.gpro.user.Usuario;
import org.jlobato.gpro.user.UsuarioUI;
import org.jlobato.gpro.user.UsuarioUIController;

/**
 * @author JLOBATO
 *
 */
public class Main {
	/**
	 * 
	 */
	public static final String GPRO_URL = "http://gpro.net";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame f = new JFrame("GPRO Setup Utility");
		f.setSize(400, 150);

		//Configuración de los idiomas disponibles
		LanguageManager.getInstance(ConstantesLanguages.AVAILABLE_LANGUAGES, GPRODriverComment.CAR_SETUP_PARTS_DESCRIPTIONS);
		LanguageManager.getInstance().addBundles(ConstantesLanguages.ESPAÑOL, RaceForecastWebGrabber.WEB_GRABBER_TOKENS_ES);
		LanguageManager.getInstance().addBundles(ConstantesLanguages.INGLES, RaceForecastWebGrabber.WEB_GRABBER_TOKENS_EN);
		LanguageManager.getInstance().addBundles(ConstantesLanguages.ESPAÑOL, RaceForecastController.RACE_FORECAST_TOKENS_ES);
		LanguageManager.getInstance().addBundles(ConstantesLanguages.INGLES, RaceForecastController.RACE_FORECAST_TOKENS_EN);

		//Fichero de log
		try {
			PrintStream logStream = new PrintStream("out.log"); 
			System.setErr(logStream);
			System.setOut(logStream);
		} catch (Exception e) {
			e.printStackTrace();
		}


		FileInputStream fis = null;
		IDriver driver = new Driver();
		ObjectInputStream ois = null;
		
		//Creando el driver
		try {
			fis = new FileInputStream("driver.ser");
			ois = new ObjectInputStream(fis);
			driver = (IDriver)ois.readObject();
		} catch(Exception e) {

		} finally {
			if (fis != null) try { fis.close(); } catch (Exception c) {}
		}


		//Creando la sesi�n de pr�cticas
		PracticeSession theSession = new PracticeSession();
		try {
			fis = new FileInputStream("practice.ser");
			ois = new ObjectInputStream(fis);
			theSession = (PracticeSession)ois.readObject();
		} catch(Exception e) {

		} finally {
			if (fis != null) try { fis.close(); } catch (Exception c) {}
		}

		//Creando el director t�cnico
		ITechnicalDirector techDirector = new TechnicalDirector();
		try {
			fis = new FileInputStream("techdirector.ser");
			ois = new ObjectInputStream(fis);
			techDirector = (ITechnicalDirector)ois.readObject();
		} catch(Exception e) {

		} finally {
			if (fis != null) try { fis.close(); } catch (Exception c) {}
		}

		//Creando el pron�stico del clima
		IRaceForecast raceForecast = new DefaultRaceForecast();
		try {
			fis = new FileInputStream("forecast.ser");
			ois = new ObjectInputStream(fis);
			raceForecast = (IRaceForecast)ois.readObject();
		} catch(Exception e) {

		} finally {
			if (fis != null) try { fis.close(); } catch (Exception c) {}
		}

		//Creando el usuario
		IUsuario usuario = new Usuario();
		try {
			fis = new FileInputStream("usuario.ser");
			ois = new ObjectInputStream(fis);
			usuario = (IUsuario)ois.readObject();
		} catch(Exception e) {

		} finally {
			if (fis != null) try { fis.close(); } catch (Exception c) {}
		}
		
		//Creando las temporadas
		ArrayList<Season> seasons = null;
		try {
			fis = new FileInputStream("seasons.ser");
			ois = new ObjectInputStream(fis);
			seasons = (ArrayList<Season>)ois.readObject();
		} catch(Exception e) {

		} finally {
			if (fis != null) try { fis.close(); } catch (Exception c) {}
		}
		
		if (seasons != null) {
			Iterator<Season> seasonsIt = seasons.iterator();
			while (seasonsIt.hasNext()) {
				Season season = seasonsIt.next();
				System.out.println("Season: " + season);
			}
		}
		
		SetupUtilityMediator.getInstance(usuario);

		JTabbedPane pane = new JTabbedPane(JTabbedPane.TOP);

		//Creando la vista del piloto y su controlador
		DriverUI driverUI = new DriverUI();
		driverUI.setModel(driver);
		DriverUIController controller = new DriverUIController(driverUI);
		driver.addPropertyChangeListener(controller);

		//Creando la vista del director t�cnico y su controlador
		TechnicalDirectorUI techDirectorUI = new TechnicalDirectorUI();
		techDirectorUI.setTechnicalDirector(techDirector);
		TechnicalDirectorUIController techController = new TechnicalDirectorUIController(techDirectorUI);
		techDirector.addPropertyChangeListener(techController);

		//Creando la vista de la sesi�n de pr�cticas y su controlador
		PracticeSessionUI practiceSessionUI = new PracticeSessionUI();
		PracticeSessionUIController practiceController = new PracticeSessionUIController(practiceSessionUI, driver, techDirector, f);
		theSession.addPracticeSessionListener(practiceController);
		practiceSessionUI.setModel(theSession);

		//Creando la vista del pron�stico del clima y su controlador
		RaceForecastUI raceForecastUI = new RaceForecastUI();
		RaceForecastController forecastController = new RaceForecastController(raceForecastUI);
		raceForecastUI.setModel(raceForecast);
		theSession.addPracticeSessionListener(forecastController);
		
		raceForecastUI.setEnabled(false);
		
		raceForecastUI.addRaceForecastListener(practiceController);
		
		UsuarioUI userUI = new UsuarioUI();
		userUI.setModel(usuario);
		UsuarioUIController usuarioController = new UsuarioUIController(userUI);
		usuario.addPropertyChangeListener(usuarioController);
		
		
		pane.addTab("Driver", driverUI);
		pane.addTab("Technical Director", techDirectorUI);
		pane.addTab("Setup", practiceSessionUI);
		pane.addTab("Weather", raceForecastUI);
		pane.addTab("User Info", userUI);

		//Configuraci�n del servicio de actualizaci�n
		UpdateServiceManager.getInstance(1);

		f.getContentPane().add(pane);
		f.addWindowListener(new SerializeDriverBeforeExit(driverUI, practiceSessionUI, techDirectorUI, raceForecastUI, userUI));
		f.pack();
		f.setVisible(true);
	}

}