package org.jlobato.gpro.forecast;

import java.util.Properties;

/**
 *
 * @author JLOBATO
 *
 */
public class ContextoPasarelaRaceForecastWebGPRO implements	IContextoPasarelaRaceForecast {
	/**
	 *
	 */
	public static final String GPRO_PASSWORD_PROPERTY = "org.jlobato.gpro.forecast.gpro.password";
	/**
	 *
	 */
	public static final String GPRO_USERNAME_PROPERTY = "org.jlobato.gpro.forecast.gpro.username";
	/**
	 *
	 */
	public static final String GPRO_URL_PROPERTY = "org.jlobato.gpro.forecast.gpro.url";
	/**
	 *
	 */
	private Properties properties;
	/**
	 *
	 */
	private RaceForecastWebGrabber grabber;

	/**
	 *
	 * @param properties
	 */
	public ContextoPasarelaRaceForecastWebGPRO(Properties properties, RaceForecastWebGrabber grabber) {
		this.properties = properties;
		this.grabber = grabber;
	}


	/**
	 *
	 */
	public IPasarelaRaceForecast getPasarela() throws RaceForecastException {
		return new PasarelaRaceForecastWebGPRO(this);
	}


	/**
	 * @throws RaceForecastException
	 *
	 */
	public String getGPROUrl() throws RaceForecastException {
		return getPropiedadNoNula(GPRO_URL_PROPERTY);
	}

	/**
	 *
	 * @return
	 * @throws RaceForecastException
	 */
	public String getGPROUsername() throws RaceForecastException {
		return getPropiedadNoNula(GPRO_USERNAME_PROPERTY);
	}

	/**
	 *
	 * @return
	 * @throws RaceForecastException
	 */
	public String getGPROPassword() throws RaceForecastException {
		return getPropiedadNoNula(GPRO_PASSWORD_PROPERTY);
	}

	/**
	 *
	 * @param nomPropiedad
	 * @return
	 * @throws ExportacionNotasAulaException
	 */
	private String getPropiedadNoNula(String nomPropiedad) throws RaceForecastException {
		String valor = properties.getProperty(nomPropiedad);
		if (valor == null) {
			throw new RaceForecastException("No existe la propiedad " + nomPropiedad);
		}

		return valor;
	}


	public RaceForecastWebGrabber getGPROWeatherGrabber() {
		return this.grabber;
	}


}
