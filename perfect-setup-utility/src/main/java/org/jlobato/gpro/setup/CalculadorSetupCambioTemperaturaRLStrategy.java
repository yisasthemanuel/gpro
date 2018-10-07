package org.jlobato.gpro.setup;

/**
 * 
 * @author jlobato
 *
 */
public class CalculadorSetupCambioTemperaturaRLStrategy extends CalculadorSetupCambioTemperaturaFactorStrategy {
	
	private static final double WINGS_TEMP_FACTOR = 4.20784689;
	private static final double ENGINE_TEMP_FACTOR = -3.27620016;
	private static final double BRAKES_TEMP_FACTOR = 5.332795056;
	private static final double GEAR_TEMP_FACTOR = -3.387799043;
	private static final double SUSPENSION_TEMP_FACTOR = -5.998464913;
	
	
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
