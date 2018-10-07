package org.jlobato.gpro.forecast;

import java.io.Serializable;

/**
 * Pron�stico de tiempo para un intervalo de tiempo
 *
 * @author JLOBATO
 *
 */
public interface IIntervalForecast extends Cloneable, Serializable {
	/**
	 * Pron�stico al comienzo del intervalo
	 * @return
	 */
	public IForecast getInitialForecast();
	/**
	 * Pron�stico al final del intervalo
	 * @return
	 */
	public IForecast getFinalForecast();

	/**
	 * Duraci�n del intervalo en minutos
	 *
	 * @return Duraci�n en minutos del intervalo de tiempo
	 */
	public int getDuration();
}
