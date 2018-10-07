package org.jlobato.gpro.forecast;

import java.util.ArrayList;
import java.util.Iterator;

import org.jlobato.gpro.utils.GPROUtils;

public abstract class AbstractEstimatedRaceTemperatureStrategy implements EstimatedRaceTemperatureCalculatorStrategy {

	/**
	 * 
	 * @param raceForecast
	 * @return
	 */
	public double getEstimatedTemperature(IRaceForecast raceForecast) {
		Iterator<IIntervalForecast> i = raceForecast.getRaceForecast().iterator();
		int duration = 0;
		int temperatureSum = 0;
		ArrayList<Double> temperatures = new ArrayList<Double>();
		while(i.hasNext() && (duration < getRaceDuration())) {
			IIntervalForecast interval = i.next();
			duration += interval.getDuration();
			temperatureSum += interval.getInitialForecast().getTemperature();
			temperatures.add(interval.getInitialForecast().getTemperature());
			temperatureSum += interval.getFinalForecast().getTemperature();
			temperatures.add(interval.getFinalForecast().getTemperature());
		}
		//Se hace un redondeo a dos decimales
		double result = GPROUtils.redondeo((temperatureSum / (double)temperatures.size()), 2);
		return result;
	}

	/**
	 * 
	 * @return
	 */
	public abstract int getRaceDuration();
}
