package org.jlobato.gpro.setup;

/**
 * 
 * @author jlobato
 *
 */
public abstract class CalculadorSetupCambioTemperaturaFactorStrategy implements CalculadorSetupCambioTemperaturaStrategy {

	/**
	 * 
	 */
	public CarSetup getChangedSetup(CarSetup originalSetup,	double originalTemperature, double targetTemperature) {
		CarSetup result = null;
		
		//FW
		Integer frontWingMod = null;
		if (originalSetup.getFrontWing() != null) {
			frontWingMod = new Integer((int)Math.round(originalSetup.getFrontWing().intValue() + ((targetTemperature - originalTemperature) * getWingsFactor())));
		}
		
		//RW
		Integer rearWingMod = null;
		if (originalSetup.getRearWing() != null) {
			rearWingMod = new Integer((int)Math.round(originalSetup.getRearWing().intValue() + ((targetTemperature - originalTemperature) * getWingsFactor())));
		}
		
		//EN
		Integer engineMod = null;
		if (originalSetup.getEngine() != null) {
			engineMod = new Integer((int)Math.round(originalSetup.getEngine().intValue() + ((targetTemperature - originalTemperature) * getEngineFactor())));
		}
		
		//BR
		Integer breaksMod = null;
		if (originalSetup.getBrakes() != null) {
			breaksMod = new Integer((int)Math.round(originalSetup.getBrakes().intValue() + ((targetTemperature - originalTemperature) * getBrakesFactor())));
		}
		
		//GE
		Integer gearboxMod = null;
		if (originalSetup.getGearbox() != null) {
			gearboxMod = new Integer((int)Math.round(originalSetup.getGearbox().intValue() + ((targetTemperature - originalTemperature) * getGearboxFactor())));
		}
		
		//SU
		Integer suspensionMod = null;
		if (originalSetup.getSuspension() != null) {
			suspensionMod = new Integer((int)Math.round(originalSetup.getSuspension().intValue() + ((targetTemperature - originalTemperature) * getSuspensionFactor())));
		}
		
		
		result = new CarSetup(frontWingMod, rearWingMod, engineMod, breaksMod, gearboxMod, suspensionMod);
		
		return result;
	}

	/**
	 * 
	 * @return
	 */
	public abstract double getWingsFactor();
	
	/**
	 * 
	 * @return
	 */
	public abstract double getEngineFactor();
	
	/**
	 * 
	 * @return
	 */
	public abstract double getBrakesFactor();
	
	/**
	 * 
	 * @return
	 */
	public abstract double getGearboxFactor();
	
	/**
	 * 
	 * @return
	 */
	public abstract double getSuspensionFactor();

}
