/**
 * 
 */
package org.jlobato.gpro.setup;

/**
 * @author jlobato
 *
 */
public interface CalculadorSetupCambioTemperaturaStrategy {
	
	/**
	 * 
	 * @param originalSetup
	 * @param originalTemperature
	 * @param targetTemperature
	 * @return
	 */
	public CarSetup getChangedSetup(CarSetup originalSetup, double originalTemperature, double targetTemperature);

}
