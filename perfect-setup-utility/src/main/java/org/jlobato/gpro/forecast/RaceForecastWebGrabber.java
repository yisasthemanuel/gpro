package org.jlobato.gpro.forecast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Logger;

import net.sourceforge.jwebunit.junit.WebTester;

import org.jlobato.gpro.languages.ILanguage;
import org.jlobato.gpro.languages.LanguageManager;

/**
 *
 * @author JLOBATO
 *
 */
public class RaceForecastWebGrabber {

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
	public static final String CLIMA_TOKEN = "clima.token";
	
	private static final String PASSWORD_FIELD_NAME = "textPassword";
	private static final String LOGIN_FIELD_NAME = "textLogin";
	private static final String SUBMIT_BUTTON_LABEL = "Submit2";
	private static final String TITLE_LABEL = "title";
	

	public static final HashMap<String, String> WEB_GRABBER_TOKENS_EN = new HashMap<String, String>();
	public static final HashMap<String, String> WEB_GRABBER_TOKENS_ES = new HashMap<String, String>();
	
	static {
		WEB_GRABBER_TOKENS_EN.put(CLIMA_TOKEN, "forecast");
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

		WEB_GRABBER_TOKENS_ES.put(CLIMA_TOKEN, "clima");
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
	private RaceForecastGrabSupport support;
	
	private Logger logger = Logger.getLogger(RaceForecastWebGrabber.class.getName());

	/**
	 *
	 * @param url
	 * @param username
	 * @param password
	 */
	public RaceForecastWebGrabber(String url, String username, String password) {
		this.password = password;
		this.url = url;
		this.username = username;
		this.support = new RaceForecastGrabSupport(this);
	}

	/**
	 *
	 * @return
	 */
	public IRaceForecast doGrab() {
		WebTester tester = new WebTester();
		IRaceForecast raceForecast = null;

		try {
			support.fireGrabStarted();

			logger.info("Accediendo a la página principal de GPRO");
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
			
			
			//Aquí es donde va el tema de si el usuario utiliza o no el nuevo estilo de la web
			boolean newStyleOffice = false;
			try {
				tester.assertImagePresentPartial(NEW_STYLE_IMAGE_PRESENT, NEW_STYLE_ALT_PRESENT);
				//Si la imagen está presente el usuario tiene configurado el estilo nuevo de web
				newStyleOffice = true;
			} catch(Throwable e) {
				
			}

			logger.info("Estilo detectado en GPRO: " + ((newStyleOffice) ? "NEW_STYLE" : "OLD_STYLE"));
			
			//A partir de aqu� todo es sensible al idioma
			//Recopilamos los tokens sensibles al idioma para su utilizaci�n en el resto de la clase
			String practiceToken = LanguageManager.getInstance().getBundle(language, newStyleOffice ? PRACTICE_TOKEN : PRACTICE_OLD_STYLE_TOKEN);
			String temperatureToken = LanguageManager.getInstance().getBundle(language, TEMPERATURA_TOKEN);
			String gradosToken = LanguageManager.getInstance().getBundle(language, GRADOS_TOKEN);
			String humedadToken = LanguageManager.getInstance().getBundle(language, HUMEDAD_TOKEN);
			String porcentajeToken = LanguageManager.getInstance().getBundle(language, PORCENTAJE_TOKEN);
			String climaQualiToken = LanguageManager.getInstance().getBundle(language, CLIMA_QUALI_TOKEN);
			String climaCarreraToken = LanguageManager.getInstance().getBundle(language, CLIMA_CARRERA_TOKEN);
			String guionToken = LanguageManager.getInstance().getBundle(language, GUION_TOKEN);
			String climaToken = LanguageManager.getInstance().getBundle(language, CLIMA_TOKEN);
			String logoutToken = LanguageManager.getInstance().getBundle(language, LOGOUT_TOKEN);
			
			tester.assertLinkPresentWithExactText(practiceToken);
			tester.clickLinkWithExactText(practiceToken);
			
			String pageSource = tester.getPageSource();
			logger.info("Page source para la práctica: " + pageSource);

			int fromIndex = 0;
			int weatherFromIndex = 0;
			//Aquí se crea el forecast de la Q1
			DefaultForecast q1Forecast = new DefaultForecast();
			fromIndex = addForecastChunk(pageSource, fromIndex, temperatureToken, gradosToken, "TEMP Q1", new TemperatureForecastUpdater(q1Forecast));
			fromIndex = addForecastChunk(pageSource, fromIndex, humedadToken, porcentajeToken, "HUMI Q1", new HumidityForecastUpdater(q1Forecast));
			weatherFromIndex = addWeather(pageSource, weatherFromIndex, climaQualiToken, TITLE_LABEL, "\"", "CLIM Q1", new WeatherForecastUpdater(q1Forecast, language));

			//System.out.println("q1Forecast: " + q1Forecast);

			//Aqu� se crea el forecast de la Q2
			DefaultForecast q2Forecast = new DefaultForecast();
			fromIndex = addForecastChunk(pageSource, fromIndex, temperatureToken, gradosToken, "TEMP Q2", new TemperatureForecastUpdater(q2Forecast));
			fromIndex = addForecastChunk(pageSource, fromIndex, humedadToken, porcentajeToken, "HUMI Q2", new HumidityForecastUpdater(q2Forecast));
			weatherFromIndex = addWeather(pageSource, weatherFromIndex, climaCarreraToken, TITLE_LABEL, "\"", "CLIM Q2", new WeatherForecastUpdater(q2Forecast, language));

			//System.out.println("q2Forecast: " + q2Forecast);

			raceForecast = new DefaultRaceForecast(q1Forecast, q2Forecast, new ArrayList<IIntervalForecast>());

			DefaultForecast r1ForecastStart = new DefaultForecast();
			DefaultForecast r1ForecastEnd = new DefaultForecast();
			fromIndex = addRaceTemperature(pageSource, fromIndex, temperatureToken, gradosToken, guionToken, "TEMP RACE Q1", new TemperatureForecastUpdater(r1ForecastStart), new TemperatureForecastUpdater(r1ForecastEnd));
			fromIndex = addRaceTemperature(pageSource, fromIndex, humedadToken, porcentajeToken, guionToken, "HUMI RACE Q1", new HumidityForecastUpdater(r1ForecastStart), new HumidityForecastUpdater(r1ForecastEnd));

			DefaultForecast r2ForecastStart = new DefaultForecast();
			DefaultForecast r2ForecastEnd = new DefaultForecast();
			fromIndex = addRaceTemperature(pageSource, fromIndex, temperatureToken, gradosToken, guionToken, "TEMP RACE Q2", new TemperatureForecastUpdater(r2ForecastStart), new TemperatureForecastUpdater(r2ForecastEnd));
			fromIndex = addRaceTemperature(pageSource, fromIndex, humedadToken, porcentajeToken, guionToken, "HUMI RACE Q2", new HumidityForecastUpdater(r2ForecastStart), new HumidityForecastUpdater(r2ForecastEnd));

			DefaultForecast r3ForecastStart = new DefaultForecast();
			DefaultForecast r3ForecastEnd = new DefaultForecast();
			fromIndex = addRaceTemperature(pageSource, fromIndex, temperatureToken, gradosToken, guionToken, "TEMP RACE Q3", new TemperatureForecastUpdater(r3ForecastStart), new TemperatureForecastUpdater(r3ForecastEnd));
			fromIndex = addRaceTemperature(pageSource, fromIndex, humedadToken, porcentajeToken, guionToken, "HUMI RACE Q3", new HumidityForecastUpdater(r3ForecastStart), new HumidityForecastUpdater(r3ForecastEnd));

			DefaultForecast r4ForecastStart = new DefaultForecast();
			DefaultForecast r4ForecastEnd = new DefaultForecast();
			fromIndex = addRaceTemperature(pageSource, fromIndex, temperatureToken, gradosToken, guionToken, "TEMP RACE Q4", new TemperatureForecastUpdater(r4ForecastStart), new TemperatureForecastUpdater(r4ForecastEnd));
			fromIndex = addRaceTemperature(pageSource, fromIndex, humedadToken, porcentajeToken, guionToken, "HUMI RACE Q4", new HumidityForecastUpdater(r4ForecastStart), new HumidityForecastUpdater(r4ForecastEnd));

			//Ahora nos sacamos las probabilidades de lluvia para la carrerita
			int nextFromIndex = pageSource.indexOf(climaToken);
			nextFromIndex = addRaceForecast(pageSource, nextFromIndex, raceForecast, r1ForecastStart, r1ForecastEnd, language);
			nextFromIndex = addRaceForecast(pageSource, nextFromIndex, raceForecast, r2ForecastStart, r2ForecastEnd, language);
			nextFromIndex = addRaceForecast(pageSource, nextFromIndex, raceForecast, r3ForecastStart, r3ForecastEnd, language);
			nextFromIndex = addRaceForecast(pageSource, nextFromIndex, raceForecast, r4ForecastStart, r4ForecastEnd, language);

			//Logout
			tester.assertLinkPresentWithExactText(logoutToken);
			tester.clickLinkWithExactText(logoutToken);

			//Evento de finalizaci�n
			support.fireGrabEnded();
		} catch(Throwable e) {
			support.fireGrabFailed(e);
			support.fireGrabEnded();
		} finally {
			//Cerramos la navegaci�n
			tester.closeBrowser();
		}


		return raceForecast;
	}

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

	/**
	 *
	 * @param listener
	 */
	public void addRaceForecastGrabListener(RaceForecastGrabListener listener) {
		this.support.addRaceForecastGrabListener(listener);
	}

	/**
	 *
	 * @param listener
	 */
	public void removeRaceForecastGrabListener(RaceForecastGrabListener listener) {
		this.support.removeRaceForecastGrabListener(listener);
	}

	/**
	 *
	 * @param pageSource
	 * @param fromIndex
	 * @param raceForecast
	 * @param startForecast
	 * @param endForecast
	 * @return
	 */
	private int addRaceForecast(String pageSource, int fromIndex, IRaceForecast raceForecast, IForecast startForecast, IForecast endForecast, ILanguage language) {
		String lluviasToken = LanguageManager.getInstance().getBundle(language, LLUVIA_TOKEN);
		String porcentajeToken = LanguageManager.getInstance().getBundle(language, PORCENTAJE_TOKEN);
		String guionToken = LanguageManager.getInstance().getBundle(language, GUION_TOKEN);
		
		
		int indexOfLluvias = pageSource.indexOf(lluviasToken, fromIndex) + lluviasToken.length();
		int indexOfTD = pageSource.indexOf("</td>", indexOfLluvias);
		int result = indexOfTD + "</td>".length();
		String stringProbLluvia = pageSource.substring(indexOfLluvias, indexOfTD);
		String[] stringProbLluviaSplit = stringProbLluvia.split(porcentajeToken);
		String probabilidadMinima = stringProbLluviaSplit[0].trim();
		String probabilidadMaxima = "0";
		if (stringProbLluviaSplit.length > 2) {
			String[] stringProbabilidadMaximaSplit = stringProbLluviaSplit[1].split(guionToken);
			probabilidadMaxima = stringProbabilidadMaximaSplit[1];
		}

		((DefaultForecast)startForecast).setWeather(Double.valueOf(probabilidadMinima));
		((DefaultForecast)endForecast).setWeather(Double.valueOf(probabilidadMaxima));
		IIntervalForecast rq1Forecast = new DefaultIntervalForecast(startForecast, endForecast, 30);
		raceForecast.getRaceForecast().add(rq1Forecast);

		return result;
	}
	/**
	 *
	 * @param pageSource
	 * @param startPattern
	 * @param endPattern
	 * @param label
	 * @param updater
	 * @return
	 */
	private int addForecastChunk(String pageSource, int fromIndex, String startPattern, String endPattern, String label, ForecastUpdater updater) {
		int tempQ1 = pageSource.indexOf(startPattern, fromIndex);
		int tempQ1b = pageSource.indexOf(endPattern, tempQ1);
		String q1Temperature = pageSource.substring(tempQ1 + startPattern.length(), tempQ1b).trim();
		//System.out.println(label + ": " + q1Temperature);
		updater.updateForecast(q1Temperature);
		return tempQ1b + endPattern.length();

	}

	/**
	 *
	 * @param pageSource
	 * @param fromIndex
	 * @param startPattern
	 * @param endPattern
	 * @param splitPattern
	 * @param label
	 * @param updater
	 * @return
	 */
	private int addWeather(String pageSource, int fromIndex, String startPattern, String endPattern, String splitPattern, String label, ForecastUpdater updater) {
		int weatherQ1 = pageSource.indexOf(startPattern, fromIndex);
		int weatherQ1ini = pageSource.indexOf(endPattern, weatherQ1 - 50) + endPattern.length();
		String titleQ1Attr = pageSource.substring(weatherQ1ini, weatherQ1);
		String[] titleQ1AttrParts = titleQ1Attr.split(splitPattern);
		updater.updateForecast(titleQ1AttrParts[1]);
		System.out.println(label + ": " + titleQ1AttrParts[1]);

		return weatherQ1 + startPattern.length();

	}

	/**
	 *
	 * @param pageSource
	 * @param fromIndex
	 * @param startPattern
	 * @param endPattern
	 * @param separatorPattern
	 * @param label
	 * @param updaterStart
	 * @param updaterEnd
	 * @return
	 */
	private int addRaceTemperature(String pageSource, int fromIndex, String startPattern, String endPattern, String separatorPattern, String label, ForecastUpdater updaterStart, ForecastUpdater updaterEnd) {
		int result = 0;
		int raceQ1ini = pageSource.indexOf(startPattern, fromIndex);
		int raceQ1inib = pageSource.indexOf(endPattern, raceQ1ini);
		String raceQ1iniTemp = pageSource.substring(raceQ1ini + startPattern.length(), raceQ1inib).trim();
		updaterStart.updateForecast(raceQ1iniTemp);

		int raceQ1fin = pageSource.indexOf(separatorPattern, raceQ1inib);
		int raceQ1finb = pageSource.indexOf(endPattern, raceQ1fin);
		String raceQ1finTemp = pageSource.substring(raceQ1fin + separatorPattern.length(), raceQ1finb).trim();
		updaterEnd.updateForecast(raceQ1finTemp);

		result = raceQ1finb;
		return result;
	}

	/**
	 *
	 * @author JLOBATO
	 *
	 */
	private abstract class ForecastUpdater {
		public abstract void updateForecast(String value);
	}

	/**
	 *
	 * @author JLOBATO
	 *
	 */
	private class TemperatureForecastUpdater extends ForecastUpdater {
		/**
		 *
		 */
		private DefaultForecast forecast;

		/**
		 *
		 * @param forecast
		 */
		public TemperatureForecastUpdater(DefaultForecast forecast) {
			this.forecast = forecast;
		}

		/**
		 *
		 */
		public void updateForecast(String value) {
			this.forecast.setTemperature(Double.valueOf(value));
		}

	}

	/**
	 *
	 * @author JLOBATO
	 *
	 */
	private class HumidityForecastUpdater extends ForecastUpdater {
		/**
		 *
		 */
		private DefaultForecast forecast;

		/**
		 *
		 * @param forecast
		 */
		public HumidityForecastUpdater(DefaultForecast forecast) {
			this.forecast = forecast;
		}

		/**
		 *
		 */
		public void updateForecast(String value) {
			this.forecast.setHumidity(Double.valueOf(value));
		}

	}

	/**
	 *
	 * @author JLOBATO
	 *
	 */
	private class WeatherForecastUpdater extends ForecastUpdater {
		/**
		 *
		 */
		private DefaultForecast forecast;
		/**
		 * 
		 */
		private ILanguage language;

		/**
		 *
		 * @param forecast
		 */
		public WeatherForecastUpdater(DefaultForecast forecast, ILanguage language) {
			this.forecast = forecast;
			this.language = language;
		}

		/**
		 *
		 */
		public void updateForecast(String value) {
			//Pendiente lógica de poner a seco o mojado
			if (value != null && value.equals(LanguageManager.getInstance().getBundle(this.language, CLIMA_LLUVIA_TOKEN))) {
				this.forecast.setWeather(IRaceForecast.WET_WEATHER);
			}
			else {
				this.forecast.setWeather(IRaceForecast.DRY_WEATHER);
			}
		}

	}
}
