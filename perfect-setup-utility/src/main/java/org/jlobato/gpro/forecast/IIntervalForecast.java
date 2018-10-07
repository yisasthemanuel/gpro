package org.jlobato.gpro.forecast;

import java.io.Serializable;

/**
 * Pronóstico de tiempo para un intervalo de tiempo
 *
 * @author JLOBATO
 *
 */
public interface IIntervalForecast extends Cloneable, Serializable {
	/**
	 * Pronóstico al comienzo del intervalo
	 * @return
	 */
	public IForecast getInitialForecast();
	/**
	 * Pronóstico al final del intervalo
	 * @return
	 */
	public IForecast getFinalForecast();

	/**
	 * Duración del intervalo en minutos
	 *
	 * @return Duración en minutos del intervalo de tiempo
	 */
	public int getDuration();
}
