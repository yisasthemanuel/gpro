package org.jlobato.gpro.forecast;

/**
 * 
 * @author jlobato
 *
 */
public interface EstimatedRaceTemperatureCalculatorStrategy {
	
	/**
	 * Calcula la temperatura estimada de carrera en función del pronóstico de clima de carrera
	 * 
	 * @param raceForecast Pronóstico de clima de carrera 
	 * @return Temperatura estimada durante toda la carrera
	 */
	public double getEstimatedTemperature(IRaceForecast raceForecast);

}
