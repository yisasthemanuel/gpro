package org.jlobato.gpro.forecast;

public class MinutesEstimatedRaceTemperatureStrategy extends AbstractEstimatedRaceTemperatureStrategy {
	
	private int raceDuration;
	
	public MinutesEstimatedRaceTemperatureStrategy(int raceDuration) {
		this.raceDuration = raceDuration;
	}

	@Override
	public int getRaceDuration() {
		return raceDuration;
	}

}
