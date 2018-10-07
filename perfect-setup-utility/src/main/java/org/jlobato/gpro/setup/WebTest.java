package org.jlobato.gpro.setup;

import java.util.Properties;

import org.jlobato.gpro.forecast.ContextoPasarelaRaceForecastWebGPRO;
import org.jlobato.gpro.forecast.IContextoPasarelaRaceForecast;
import org.jlobato.gpro.forecast.IPasarelaRaceForecast;
import org.jlobato.gpro.forecast.RaceForecastException;
import org.jlobato.gpro.forecast.RaceForecastWebGrabber;

public class WebTest {

	/**
	 * @param args
	 * @throws RaceForecastException
	 */
	public static void main(String[] args) throws RaceForecastException {
		Properties props = new Properties();
		props.put(ContextoPasarelaRaceForecastWebGPRO.GPRO_URL_PROPERTY, "http://www.gpro.se/es/gpro.asp");
		props.put(ContextoPasarelaRaceForecastWebGPRO.GPRO_USERNAME_PROPERTY, "yisasthemanuel");
		props.put(ContextoPasarelaRaceForecastWebGPRO.GPRO_PASSWORD_PROPERTY, "oxford");

		RaceForecastWebGrabber grabber = new RaceForecastWebGrabber(
				props.getProperty(ContextoPasarelaRaceForecastWebGPRO.GPRO_URL_PROPERTY),
				props.getProperty(ContextoPasarelaRaceForecastWebGPRO.GPRO_USERNAME_PROPERTY),
				props.getProperty(ContextoPasarelaRaceForecastWebGPRO.GPRO_PASSWORD_PROPERTY));

		IContextoPasarelaRaceForecast contexto = new ContextoPasarelaRaceForecastWebGPRO(props, grabber);
		IPasarelaRaceForecast pasarela = contexto.getPasarela();
		pasarela.getRaceForecast();

	}
}
