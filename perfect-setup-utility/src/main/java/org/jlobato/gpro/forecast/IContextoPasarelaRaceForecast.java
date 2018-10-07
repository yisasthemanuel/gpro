package org.jlobato.gpro.forecast;


/**
 *
 * @author JLOBATO
 *
 */
public interface IContextoPasarelaRaceForecast {

	/**
	 *
	 * @return
	 */
	public String getGPROUrl() throws RaceForecastException;

	/**
	 *
	 * @return
	 * @throws RaceForecastException
	 */
	public IPasarelaRaceForecast getPasarela() throws RaceForecastException;
}
