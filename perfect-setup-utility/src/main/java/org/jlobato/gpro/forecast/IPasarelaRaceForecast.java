package org.jlobato.gpro.forecast;

/**
 * Pasarela que deben implementar las clases que obtengan directamente
 * de GPRO el pronóstico de carrera
 *
 * @author JLOBATO
 *
 */
public interface IPasarelaRaceForecast {

	/**
	 *
	 * @param contexto
	 */
	public void configura(IContextoPasarelaRaceForecast contexto) throws RaceForecastException;

	/**
	 *
	 * @return
	 * @throws RaceForecastException
	 */
	public IRaceForecast getRaceForecast() throws RaceForecastException;
}
