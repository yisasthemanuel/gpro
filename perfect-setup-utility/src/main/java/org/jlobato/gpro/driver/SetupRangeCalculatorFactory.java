package org.jlobato.gpro.driver;

public class SetupRangeCalculatorFactory {

	public static final int SETUPRANGE_150_RULE = 1;

	private static SetupRangeCalculatorFactory instance;
	private int defaultSetupRangeStrategy;

	private SetupRangeCalculatorFactory() {
		this(SETUPRANGE_150_RULE);
	}

	private SetupRangeCalculatorFactory(int defaultSetupRangeStrategy) {
		this.defaultSetupRangeStrategy = defaultSetupRangeStrategy;
	}

	public static SetupRangeCalculatorFactory getInstance() {
		if (instance == null) {
			instance = new SetupRangeCalculatorFactory();
		}
		return instance;
	}

	public static SetupRangeCalculatorFactory getInstance(int defaultSetupRangeStrategy) {
		instance = new SetupRangeCalculatorFactory(defaultSetupRangeStrategy);
		return instance;
	}


	public SetupRangeCalculatorStrategy create() {
		return create(defaultSetupRangeStrategy);
	}

	public SetupRangeCalculatorStrategy create(int setupRangeStrategy) {
		SetupRangeCalculatorStrategy result = null;
		switch (setupRangeStrategy) {
		case SETUPRANGE_150_RULE:
			result = new SetupRangeCalculatorFormula135Strategy();
			break;
		default:
			throw new IllegalArgumentException(
					"Se ha pasado un tipo de estrategia erróneo");
		}
		return result;
	}

}
