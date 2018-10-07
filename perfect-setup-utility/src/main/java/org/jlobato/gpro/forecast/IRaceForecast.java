package org.jlobato.gpro.forecast;

import java.io.Serializable;
import java.util.List;

/**
 * Interfaz que representa un pronóstico de tiempo para una carrera
 * completa en GPRO
 *
 * @author JLOBATO
 *
 */
public interface IRaceForecast extends Serializable, Cloneable {
	/**
	 * Constante para tiempo seco
	 */
	public static final double DRY_WEATHER = 0.0;
	/**
	 * Constante para tiempo mojado
	 */
	public static final double WET_WEATHER = 100.0;

	/**
	 * Duración por defecto de los intervalos de tiempo para los pronósticos
	 * de tiempo
	 */
	public static final int DEFATUL_INTERVAL_DURATION = 30;

	/**
	 * Pronóstico de tiempo para la Q1
	 * @return
	 */
	public IForecast getQ1Forecast();

	/**
	 * Pronóstico de tiempo para la Q2
	 * @return
	 */
	public IForecast getQ2Forecast();

	/**
	 * Pronóstico de tiempo para toda la carrera
	 * @return Lista con los pronósticos de tiempo para cada intervalo de carrera
	 */
	public List<IIntervalForecast> getRaceForecast();
	
	/**
	 * Devuelve la temperatura estimada durante la carrera
	 * @return la temperatura estimada de carrera basándose en el pronóstico
	 */
	public double getEstimatedRaceTemperature();
}
