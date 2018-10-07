package org.jlobato.gpro.setup;

/**
 * 
 * @author jlobato
 *
 */
public interface CalculadorSetupCambioClimaStrategy {
	
	/**
	 * 
	 * @param originalSetup
	 * @param originalWeather
	 * @param targetWeather
	 * @param targetTemperature
	 * @return
	 */
	public CarSetup getWeatherChangedSetup(CarSetup originalSetup, double originalWeather, double targetWeather, double targetTemperature);

}
