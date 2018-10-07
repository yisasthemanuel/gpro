package org.jlobato.gpro.setup;

/**
 * 
 * @author jlobato
 *
 */
public class CalculadorSetupCambioTemperaturaCVPNStrategy extends CalculadorSetupCambioTemperaturaFactorStrategy {
	
	private static final double WINGS_TEMP_FACTOR = 3.361735883;
	private static final double ENGINE_TEMP_FACTOR = -1.832325294;
	private static final double BRAKES_TEMP_FACTOR = 4.435267647;
	private static final double GEAR_TEMP_FACTOR = -1.829441177;
	private static final double SUSPENSION_TEMP_FACTOR = -9.052915294;

	/**
	 * 
	 */
	public double getWingsFactor() {
		return WINGS_TEMP_FACTOR;
	}

	/**
	 * 
	 */
	public double getEngineFactor() {
		return ENGINE_TEMP_FACTOR;
	}

	/**
	 * 
	 */
	public double getBrakesFactor() {
		return BRAKES_TEMP_FACTOR;
	}

	/**
	 * 
	 */
	public double getGearboxFactor() {
		return GEAR_TEMP_FACTOR;
	}

	/**
	 * 
	 */
	public double getSuspensionFactor() {
		return SUSPENSION_TEMP_FACTOR;
	}
}
