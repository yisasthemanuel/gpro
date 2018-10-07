package org.jlobato.gpro.forecast;


public class EstimatedRaceTemperatureCalculatorFactory {
	
	/**
	 * 
	 */
	public static final int NINETY_MINUTES_RACE = 0;
	/**
	 * 
	 */
	public static final int WHOLE_RACE = 1;
	
	/**
	 * 
	 */
	public static final int DURATION_RACE = 2;
	
	/**
	 * 
	 */
	private static EstimatedRaceTemperatureCalculatorFactory instance;
	
	/**
	 * 
	 */
	private int defaultStrategy;

	/**
	 * 
	 * @param defaultStrategy
	 */
	private EstimatedRaceTemperatureCalculatorFactory(int defaultStrategy) {
		this.defaultStrategy = defaultStrategy;
	}

	public EstimatedRaceTemperatureCalculatorFactory() {
		this(NINETY_MINUTES_RACE);
	}

	/**
	 * 
	 * @return
	 */
	public static EstimatedRaceTemperatureCalculatorFactory getInstance() {
		if (instance == null) instance = new EstimatedRaceTemperatureCalculatorFactory();
		return instance;
	}
	
	/**
	 * 
	 * @param defaultStrategy
	 * @return
	 */
	public static EstimatedRaceTemperatureCalculatorFactory getInstance(int defaultStrategy) {
		instance = new EstimatedRaceTemperatureCalculatorFactory(defaultStrategy);
		return instance;
	}

	/**
	 * 
	 * @return
	 */
	public EstimatedRaceTemperatureCalculatorStrategy create() {
		return this.create(defaultStrategy); 
	}

	/**
	 * 
	 * @param strategy
	 * @return
	 */
	public EstimatedRaceTemperatureCalculatorStrategy create(int strategy) {
		EstimatedRaceTemperatureCalculatorStrategy result = null;
		switch(strategy) {
		case NINETY_MINUTES_RACE:
			result = new NinetyMinutesEstimatedRaceTemperatureStrategy();
			break;
		case WHOLE_RACE:
			result = new WholeRaceEstimatedRaceTemperatureStrategy();
			break;
		default:
			throw new IllegalArgumentException("Se ha pasado un tipo de estrategia para el calculador de temperatura estimada de carrera erróneo");
		}
		return result;
	}
	
	/**
	 * 
	 * @param strategy
	 * @param minutes
	 * @return
	 */
	public EstimatedRaceTemperatureCalculatorStrategy create(int strategy, int minutes) {
		EstimatedRaceTemperatureCalculatorStrategy result = null;
		switch(strategy) {
		case NINETY_MINUTES_RACE:
			result = new NinetyMinutesEstimatedRaceTemperatureStrategy();
			break;
		case WHOLE_RACE:
			result = new WholeRaceEstimatedRaceTemperatureStrategy();
			break;
		case DURATION_RACE:
			result = new MinutesEstimatedRaceTemperatureStrategy(minutes);
			break;
		default:
			throw new IllegalArgumentException("Se ha pasado un tipo de estrategia para el calculador de temperatura estimada de carrera erróneo");
		}
		return result;
	}

}
