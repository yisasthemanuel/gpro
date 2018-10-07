package org.jlobato.gpro.driver;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Logger;

import org.jlobato.gpro.languages.ILanguage;
import org.jlobato.gpro.languages.LanguageManager;

import net.sourceforge.jwebunit.junit.WebTester;

/**
 *
 * @author JLOBATO
 *
 */
public class DriveDataWebGrabber {

	public static final String NEW_STYLE_ALT_PRESENT = "";
	public static final String NEW_STYLE_IMAGE_PRESENT = "/images/xdriver.gif";
	public static final String CLIMA_LLUVIA_TOKEN = "clima.lluvia.token";
	public static final String TEMPERATURA_TOKEN = "temperatura.token";
	public static final String HUMEDAD_TOKEN = "humedad.token";
	public static final String LLUVIA_TOKEN = "lluvia.token";
	public static final String CLIMA_QUALI_TOKEN = "clima.quali.token";
	public static final String CLIMA_CARRERA_TOKEN = "clima.carrera.token";
	public static final String GRADOS_TOKEN = "grados.token";
	public static final String PORCENTAJE_TOKEN = "porcentaje.token";
	public static final String GUION_TOKEN = "guion.token";
	public static final String PRACTICE_TOKEN = "practice.token";
	public static final String PRACTICE_OLD_STYLE_TOKEN = "practice.old.style.token";
	public static final String LOGOUT_TOKEN = "logout.token";
	public static final String DRIVER_TOKEN = "driver.token";
	
	private static final String PASSWORD_FIELD_NAME = "textPassword";
	private static final String LOGIN_FIELD_NAME = "textLogin";
	private static final String SUBMIT_BUTTON_LABEL = "Submit2";
	

	public static final HashMap<String, String> WEB_GRABBER_TOKENS_EN = new HashMap<String, String>();
	public static final HashMap<String, String> WEB_GRABBER_TOKENS_ES = new HashMap<String, String>();
	
	static {
		WEB_GRABBER_TOKENS_EN.put(DRIVER_TOKEN, ">Driver<");
		WEB_GRABBER_TOKENS_EN.put(LOGOUT_TOKEN, "Logout");
		WEB_GRABBER_TOKENS_EN.put(PRACTICE_TOKEN, "Practice");
		WEB_GRABBER_TOKENS_EN.put(PRACTICE_OLD_STYLE_TOKEN, "Practice & Qualify 1");
		WEB_GRABBER_TOKENS_EN.put(GUION_TOKEN, "-");
		WEB_GRABBER_TOKENS_EN.put(PORCENTAJE_TOKEN, "%");
		WEB_GRABBER_TOKENS_EN.put(GRADOS_TOKEN, "&deg;");
		WEB_GRABBER_TOKENS_EN.put(CLIMA_CARRERA_TOKEN, "WeatherR");
		WEB_GRABBER_TOKENS_EN.put(CLIMA_QUALI_TOKEN, "WeatherQ");
		WEB_GRABBER_TOKENS_EN.put(LLUVIA_TOKEN, "probability:");
		WEB_GRABBER_TOKENS_EN.put(HUMEDAD_TOKEN, "Humidity:");
		WEB_GRABBER_TOKENS_EN.put(TEMPERATURA_TOKEN, "Temp:");
		WEB_GRABBER_TOKENS_EN.put(CLIMA_LLUVIA_TOKEN, "Rain");

		WEB_GRABBER_TOKENS_ES.put(DRIVER_TOKEN, ">Piloto<");
		WEB_GRABBER_TOKENS_ES.put(LOGOUT_TOKEN, "Salir");
		WEB_GRABBER_TOKENS_ES.put(PRACTICE_TOKEN, "Práctica");
		WEB_GRABBER_TOKENS_ES.put(PRACTICE_OLD_STYLE_TOKEN, "Práctica y Clasificación 1");
		WEB_GRABBER_TOKENS_ES.put(GUION_TOKEN, "-");
		WEB_GRABBER_TOKENS_ES.put(PORCENTAJE_TOKEN, "%");
		WEB_GRABBER_TOKENS_ES.put(GRADOS_TOKEN, "&deg;");
		WEB_GRABBER_TOKENS_ES.put(CLIMA_CARRERA_TOKEN, "WeatherR");
		WEB_GRABBER_TOKENS_ES.put(CLIMA_QUALI_TOKEN, "WeatherQ");
		WEB_GRABBER_TOKENS_ES.put(LLUVIA_TOKEN, "lluvias:");
		WEB_GRABBER_TOKENS_ES.put(HUMEDAD_TOKEN, "Humedad:");
		WEB_GRABBER_TOKENS_ES.put(TEMPERATURA_TOKEN, "Temp:");
		WEB_GRABBER_TOKENS_ES.put(CLIMA_LLUVIA_TOKEN, "Lluvia");
	}
	
	/**
	 *
	 */
	private String url;
	/**
	 *
	 */
	private String username;
	/**
	 *
	 */
	private String password;
	/**
	 *
	 */
	//private RaceForecastGrabSupport support;
	
	private Logger logger = Logger.getLogger(DriveDataWebGrabber.class.getName());

	/**
	 *
	 * @param url
	 * @param username
	 * @param password
	 */
	public DriveDataWebGrabber(String url, String username, String password) {
		this.password = password;
		this.url = url;
		this.username = username;
	}

	/**
	 *
	 * @return
	 */
	public Driver doGrab() {
		WebTester tester = new WebTester();
		Driver driver = null;

		try {

			logger.info("Accediendo a la página principal de GPRO");
			tester.setScriptingEnabled(false);
			tester.beginAt(this.url);
			tester.assertButtonPresent(SUBMIT_BUTTON_LABEL);
			
			

			//tester.assertImagePresent(SPAIN_IMAGE_SRC, SPAIN_IMAGE_ALT);
			//tester.clickLinkWithImage(SPAIN_IMAGE_SRC);
			tester.setTextField(LOGIN_FIELD_NAME, this.username);
			tester.setTextField(PASSWORD_FIELD_NAME, this.password);
			logger.info("Entrando en GPRO con usuario/clave: " + this.username + "/" + this.password);
			tester.submit();
			
			
			//Aquí es donde debería ir el reconocimiento de idioma, una vez que estamos logados
			ILanguage language = getLanguage(tester);
			logger.info("Lenguaje detectado en GPRO: " + language.getKey());
			
			String source = tester.getPageSource();
			String driverToken = LanguageManager.getInstance().getBundle(language, DRIVER_TOKEN);
			
			PrintWriter pw = new PrintWriter(new FileOutputStream("theSource.html"));
			pw.write(source);
			pw.close();
		
			
			
			int index = source.indexOf(driverToken);
			index = source.indexOf("href", index);
			index = source.indexOf(">", index);
			int indexEnd = source.indexOf("</", index);
			
			String piloto = source.substring(index + 1, indexEnd);
			
			
			//Aquí es donde va el tema de si el usuario utiliza o no el nuevo estilo de la web
			boolean newStyleOffice = false;
			try {
				tester.assertImagePresentPartial(NEW_STYLE_IMAGE_PRESENT, NEW_STYLE_ALT_PRESENT);
				//Si la imagen está presente el usuario tiene configurado el estilo nuevo de web
				newStyleOffice = true;
			} catch(Throwable e) {
				
			}

			logger.info("Estilo detectado en GPRO: " + ((newStyleOffice) ? "NEW_STYLE" : "OLD_STYLE"));
			
			//A partir de aquí todo es sensible al idioma
			//Recopilamos los tokens sensibles al idioma para su utilización en el resto de la clase
			String logoutToken = LanguageManager.getInstance().getBundle(language, LOGOUT_TOKEN);
			
			tester.assertLinkPresentWithExactText(piloto);
			tester.clickLinkWithExactText(piloto);
			
			String pageSource = tester.getPageSource();
			logger.info("Page source para la práctica: " + pageSource);
			
			pw = new PrintWriter(new FileOutputStream("driver.html"));
			pw.write(pageSource);
			pw.close();


			//Logout
			tester.assertLinkPresentWithExactText(logoutToken);
			tester.clickLinkWithExactText(logoutToken);

			//Evento de finalización
		} catch(Throwable e) {
			e.printStackTrace();
		} finally {
			//Cerramos la navegación
			tester.closeBrowser();
		}


		return driver;
	}
	
/*	public static void main(String args[]) {
		LanguageManager.getInstance(ConstantesLanguages.AVAILABLE_LANGUAGES, GPRODriverComment.CAR_SETUP_PARTS_DESCRIPTIONS);
		LanguageManager.getInstance().addBundles(ConstantesLanguages.ESPAÑOL, WEB_GRABBER_TOKENS_ES);
		LanguageManager.getInstance().addBundles(ConstantesLanguages.INGLES, WEB_GRABBER_TOKENS_EN);
		LanguageManager.getInstance().addBundles(ConstantesLanguages.ESPAÑOL, RaceForecastController.RACE_FORECAST_TOKENS_ES);
		LanguageManager.getInstance().addBundles(ConstantesLanguages.INGLES, RaceForecastController.RACE_FORECAST_TOKENS_EN);		
		
		new DriveDataWebGrabber(Main.GPRO_URL, "yisasthemanuel", "oxford").doGrab();
	}*/

	private ILanguage getLanguage(WebTester tester) {
		ILanguage result = null;
		boolean found = false;

		Iterator<ILanguage> languages = LanguageManager.getInstance().getLanguages();

		while (languages.hasNext() && !found) {
			ILanguage language = languages.next();
			try {
				tester.assertLinkPresentWithExactText(language.getToken());
				result = language;
				found = true;
			}catch (Throwable t) {
				t.printStackTrace(System.out);
			}
		}
		System.out.println("LANGUAGE SELECCIONADO: " + result.getKey());
		return result;
	}

}
