package org.jlobato.gpro.setup;

/**
 * @author jlobato
 *
 */
public class CalculadorSetupCambioTemperaturaFactory {
	/**
	 * 
	 */
	public static final int CV_PN_TEMPERATURE_STRATEGY = 1;

	/**
	 * 
	 */
	public static final int RL_TEMPERATURE_STRATEGY = 2;
	
	/**
	 * 
	 */
	private static CalculadorSetupCambioTemperaturaFactory instance;
	/**
	 * 
	 */
	private int defaultStrategy;
	
	/**
	 * 
	 */
	private CalculadorSetupCambioTemperaturaFactory() {
		this(RL_TEMPERATURE_STRATEGY);
	}
	
	/**
	 * 
	 * @param defaultStrategy
	 */
	private CalculadorSetupCambioTemperaturaFactory(int defaultStrategy) {
		this.defaultStrategy = defaultStrategy;
	}
	
	/**
	 * 
	 * @return
	 */
	public static CalculadorSetupCambioTemperaturaFactory getInstance() {
		if (instance == null) {
			instance = new CalculadorSetupCambioTemperaturaFactory();
		}
		return instance;
	}

	/**
	 * 
	 * @param defaultStrategy
	 * @return
	 */
	public static CalculadorSetupCambioTemperaturaFactory getInstance(int defaultStrategy) {
		instance = new CalculadorSetupCambioTemperaturaFactory(defaultStrategy);
		return instance;
	}
	
	/**
	 * 
	 * @return
	 */
	public CalculadorSetupCambioTemperaturaStrategy create() {
		return create(this.defaultStrategy);
	}
	
	/**
	 * 
	 * @param strategy
	 * @return
	 */
	public CalculadorSetupCambioTemperaturaStrategy create(int strategy) {
		CalculadorSetupCambioTemperaturaStrategy result = null;
		switch(strategy) {
		case CV_PN_TEMPERATURE_STRATEGY:
			result = new CalculadorSetupCambioTemperaturaCVPNStrategy();
			break;
		case RL_TEMPERATURE_STRATEGY:
			result = new CalculadorSetupCambioTemperaturaRLStrategy();
			break;
		default:
			throw new IllegalArgumentException("Se ha pasado un tipo de estrategia para el calculador de setup por cambio de temperatura erróneo");
		}
		return result;
	}
}
