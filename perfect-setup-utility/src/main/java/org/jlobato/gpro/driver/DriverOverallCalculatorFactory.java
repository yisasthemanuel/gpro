package org.jlobato.gpro.driver;

public class DriverOverallCalculatorFactory {
	/**
	 * 
	 */
	public static final int OVERALL_CALCULATOR_48_RULE = 1;

	/**
	 * 
	 */
	private static DriverOverallCalculatorFactory instance;
	/**
	 * 
	 */
	private int defaultOverallCalculatorStrategy;

	/**
	 * 
	 */
	private DriverOverallCalculatorFactory() {
		this(OVERALL_CALCULATOR_48_RULE);
	}

	/**
	 * 
	 * @param defaultSetupRangeStrategy
	 */
	private DriverOverallCalculatorFactory(int defaultSetupRangeStrategy) {
		this.defaultOverallCalculatorStrategy = defaultSetupRangeStrategy;
	}

	/**
	 * 
	 * @return
	 */
	public static DriverOverallCalculatorFactory getInstance() {
		if (instance == null) {
			instance = new DriverOverallCalculatorFactory();
		}
		return instance;
	}

	/**
	 * 
	 * @param defaultSetupRangeStrategy
	 * @return
	 */
	public static DriverOverallCalculatorFactory getInstance(int defaultSetupRangeStrategy) {
		instance = new DriverOverallCalculatorFactory(defaultSetupRangeStrategy);
		return instance;
	}


	/**
	 * 
	 * @return
	 */
	public DriverOverallCalculatorStrategy create() {
		return create(defaultOverallCalculatorStrategy);
	}

	/**
	 * 
	 * @param setupRangeStrategy
	 * @return
	 */
	public DriverOverallCalculatorStrategy create(int setupRangeStrategy) {
		DriverOverallCalculatorStrategy result = null;
		switch (setupRangeStrategy) {
		case OVERALL_CALCULATOR_48_RULE:
			result = new DriverOverall48RuleCalculatorStrategy();
			break;
		default:
			throw new IllegalArgumentException("Se ha pasado un tipo de estrategia para el cálculo del OA del piloto errónea");
		}
		return result;
	}


}
