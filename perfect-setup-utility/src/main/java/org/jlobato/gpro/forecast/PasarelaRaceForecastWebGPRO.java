package org.jlobato.gpro.forecast;


/**
 *
 * @author JLOBATO
 *
 */
public class PasarelaRaceForecastWebGPRO implements IPasarelaRaceForecast {

	/**
	 *
	 */
	private ContextoPasarelaRaceForecastWebGPRO contexto;
	/**
	 *
	 */
	private String gproUrl;
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
	private RaceForecastWebGrabber grabber;

	/**
	 *
	 * @param contextoPasarelaRaceForecastWebGPRO
	 * @throws RaceForecastException
	 */
	public PasarelaRaceForecastWebGPRO(ContextoPasarelaRaceForecastWebGPRO contexto) throws RaceForecastException {
		try {
			configura(contexto);
		} catch (RaceForecastException e) {
			throw new RaceForecastException("Se ha producido una excepción durante la configuración de la pasarela PasarelaRaceForecastWebGPRO", e);
		}
	}

	/**
	 *
	 */
	public void configura(IContextoPasarelaRaceForecast contexto) throws RaceForecastException {
		this.contexto = (ContextoPasarelaRaceForecastWebGPRO)contexto;
		this.gproUrl = this.contexto.getGPROUrl();
		this.username = this.contexto.getGPROUsername();
		this.password = this.contexto.getGPROPassword();
		this.grabber = this.contexto.getGPROWeatherGrabber();
	}

	/**
	 *
	 */
	public IRaceForecast getRaceForecast() throws RaceForecastException {
		IRaceForecast result = null;

		//Obtenemos el recolector de datos de GPRO
		//RaceForecastWebGrabber grabber = new RaceForecastWebGrabber(this.gproUrl, this.username, this.password);
		result = this.grabber.doGrab();

		return result;
	}

}
