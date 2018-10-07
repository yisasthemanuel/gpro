package org.jlobato.gpro.forecast;

/**
 * 
 * @author jlobato
 *
 */
public interface EstimatedRaceTemperatureCalculatorStrategy {
	
	/**
	 * Calcula la temperatura estimada de carrera en funci�n del pron�stico de clima de carrera
	 * 
	 * @param raceForecast Pron�stico de clima de carrera 
	 * @return Temperatura estimada durante toda la carrera
	 */
	public double getEstimatedTemperature(IRaceForecast raceForecast);

}
