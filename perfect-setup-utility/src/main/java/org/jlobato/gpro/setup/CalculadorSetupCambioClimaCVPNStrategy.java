package org.jlobato.gpro.setup;

/**
 * 
 * @author jlobato
 *
 */
public class CalculadorSetupCambioClimaCVPNStrategy implements CalculadorSetupCambioClimaStrategy {
	public static final double WINGS_WEATHER_FACTOR = -5.611111111;
	public static final double ENGINE_WEATHER_FACTOR = 5.166666667;
	public static final double BRAKES_WEATHER_FACTOR = -2.930555556;
	public static final double GEAR_WEATHER_FACTOR = 4.149390244;
	public static final double SUSPENSION_WEATHER_FACTOR = 4.513888889;
	
	public static final double WEATHER_TEMPERATURE_REFERENCE = 51;
	

	/**
	 * 
	 */
	public CarSetup getWeatherChangedSetup(CarSetup originalSetup, double originalWeather, double targetWeather, double targetTemperature) {
		//Factor de cambio de clima. WET->DRY debe valer 1.0 - DRY->WET debe valer -1 - En cualquier otro caso 0
		double weatherChange = (originalWeather - targetWeather) / 100.0;
		double temperatureFactor = WEATHER_TEMPERATURE_REFERENCE - targetTemperature;
		
		CarSetup result = null;
		
		//FW
		Integer frontWingMod = null;
		if (originalSetup.getFrontWing() != null) {
			frontWingMod = new Integer((int)Math.round(originalSetup.getFrontWing().intValue() + (weatherChange * WINGS_WEATHER_FACTOR * temperatureFactor)));
		}
		
		//RW
		Integer rearWingMod = null;
		if (originalSetup.getRearWing() != null) {
			rearWingMod = new Integer((int)Math.round(originalSetup.getRearWing().intValue() + (weatherChange * WINGS_WEATHER_FACTOR * temperatureFactor)));
		}
		
		//EN
		Integer engineMod = null;
		if (originalSetup.getEngine() != null) {
			engineMod = new Integer((int)Math.round(originalSetup.getEngine().intValue() + (weatherChange * ENGINE_WEATHER_FACTOR * temperatureFactor)));
		}
		
		//BR
		Integer brakesMod = null;
		if (originalSetup.getBrakes() != null) {
			brakesMod = new Integer((int)Math.round(originalSetup.getBrakes().intValue() + (weatherChange * BRAKES_WEATHER_FACTOR * temperatureFactor)));
		}
		
		//GE
		Integer gearboxMod = null;
		if (originalSetup.getGearbox() != null) {
			gearboxMod = new Integer((int)Math.round(originalSetup.getGearbox().intValue() + (weatherChange * GEAR_WEATHER_FACTOR * targetTemperature)));
		}
		
		//SU
		Integer suspensionMod = null;
		if (originalSetup.getSuspension() != null) {
			suspensionMod = new Integer((int)Math.round(originalSetup.getSuspension().intValue() + (weatherChange * SUSPENSION_WEATHER_FACTOR * temperatureFactor)));
		}
		
		
		
		result = new CarSetup(frontWingMod, rearWingMod, engineMod, brakesMod, gearboxMod, suspensionMod);
		
		return result;
	}

}
