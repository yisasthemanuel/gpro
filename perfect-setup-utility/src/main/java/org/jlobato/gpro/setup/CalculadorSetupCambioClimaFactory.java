/**
 * 
 */
package org.jlobato.gpro.setup;

/**
 * @author jlobato
 *
 */
public class CalculadorSetupCambioClimaFactory {
	/**
	 * 
	 */
	public static final int CV_PN_WEATHER_STRATEGY = 1;

	/**
	 * 
	 */
	private static CalculadorSetupCambioClimaFactory instance;
	/**
	 * 
	 */
	private int defaultStrategy;
	
	/**
	 * 
	 */
	private CalculadorSetupCambioClimaFactory() {
		this(CV_PN_WEATHER_STRATEGY);
	}
	
	/**
	 * 
	 * @param defaultStrategy
	 */
	private CalculadorSetupCambioClimaFactory(int defaultStrategy) {
		this.defaultStrategy = defaultStrategy;
	}
	
	/**
	 * 
	 * @return
	 */
	public static CalculadorSetupCambioClimaFactory getInstance() {
		if (instance == null) {
			instance = new CalculadorSetupCambioClimaFactory();
		}
		return instance;
	}

	/**
	 * 
	 * @param defaultStrategy
	 * @return
	 */
	public static CalculadorSetupCambioClimaFactory getInstance(int defaultStrategy) {
		instance = new CalculadorSetupCambioClimaFactory(defaultStrategy);
		return instance;
	}
	
	/**
	 * 
	 * @return
	 */
	public CalculadorSetupCambioClimaStrategy create() {
		return create(this.defaultStrategy);
	}
	
	/**
	 * 
	 * @param strategy
	 * @return
	 */
	public CalculadorSetupCambioClimaStrategy create(int strategy) {
		CalculadorSetupCambioClimaStrategy result = null;
		switch(strategy) {
		case CV_PN_WEATHER_STRATEGY:
			result = new CalculadorSetupCambioClimaCVPNStrategy();
			break;
		default:
			throw new IllegalArgumentException("Se ha pasado un tipo de estrategia para el calculador de setup por cambio de clima erróneo");
		}
		return result;
	}
	
}
