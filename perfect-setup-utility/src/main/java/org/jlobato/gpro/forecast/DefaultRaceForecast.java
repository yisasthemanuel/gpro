package org.jlobato.gpro.forecast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author JLOBATO
 *
 */
public class DefaultRaceForecast implements IRaceForecast {
	private static ArrayList<IIntervalForecast> EMPTY_RACEFORECAST;
	static {
		EMPTY_RACEFORECAST = new ArrayList<IIntervalForecast>(4);
		EMPTY_RACEFORECAST.add(new DefaultIntervalForecast(new DefaultForecast(), new DefaultForecast(), 30));
		EMPTY_RACEFORECAST.add(new DefaultIntervalForecast(new DefaultForecast(), new DefaultForecast(), 30));
		EMPTY_RACEFORECAST.add(new DefaultIntervalForecast(new DefaultForecast(), new DefaultForecast(), 30));
		EMPTY_RACEFORECAST.add(new DefaultIntervalForecast(new DefaultForecast(), new DefaultForecast(), 30));
	}
	/**
	 * serial version uid
	 */
	private static final long serialVersionUID = 5952744569242310133L;
	/**
	 *
	 */
	private IForecast q1Forecast;
	/**
	 *
	 */
	private IForecast q2Forecast;
	/**
	 *
	 */
	private List<IIntervalForecast> raceForecast;

	/**
	 *
	 * @param q1Forecast
	 * @param q2Forecast
	 * @param raceForecast
	 */
	public DefaultRaceForecast(IForecast q1Forecast, IForecast q2Forecast, List<IIntervalForecast> raceForecast) {
		super();
		this.q1Forecast = q1Forecast;
		this.q2Forecast = q2Forecast;
		this.raceForecast = raceForecast;
	}

	/**
	 *
	 */
	public DefaultRaceForecast() {
		this(new DefaultForecast(), new DefaultForecast(), new ArrayList<IIntervalForecast>());
	}

	/**
	 * @param forecast the q1Forecast to set
	 */
	public void setQ1Forecast(IForecast forecast) {
		q1Forecast = forecast;
	}

	/**
	 * @param forecast the q2Forecast to set
	 */
	public void setQ2Forecast(IForecast forecast) {
		q2Forecast = forecast;
	}

	/**
	 * @param raceForecast the raceForecast to set
	 */
	public void setRaceForecast(List<IIntervalForecast> raceForecast) {
		this.raceForecast = raceForecast;
	}

	/**
	 *
	 */
	public IForecast getQ1Forecast() {
		return q1Forecast;
	}

	/**
	 *
	 */
	public IForecast getQ2Forecast() {
		return q2Forecast;
	}

	/**
	 *
	 */
	public List<IIntervalForecast> getRaceForecast() {
		return raceForecast;
	}

	/**
	 *
	 * @param forecast
	 */
	public void addRaceIntervalForecast(IIntervalForecast forecast) {
		if (this.raceForecast == null) {
			this.raceForecast = new ArrayList<IIntervalForecast>();
		}
		this.raceForecast.add(forecast);
	}

	/**
	 *
	 * @param forecast
	 */
	public void removeRaceIntervalForecast(IIntervalForecast forecast) {
		this.raceForecast.remove(forecast);
	}

	/**
	 *
	 */
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	/**
	 *
	 */
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[");
		buffer.append("Q1=" + getQ1Forecast());
		buffer.append(";");

		buffer.append("Q2=" + getQ2Forecast());
		buffer.append(";");

		buffer.append("RACE=");
		buffer.append("[");
		int min = 0;
		Iterator<IIntervalForecast> i = getRaceForecast().iterator();
		while(i.hasNext()) {
			IIntervalForecast intervalForecast = i.next();
			buffer.append(min);
			buffer.append("-");
			min += intervalForecast.getDuration();
			buffer.append(min);
			buffer.append("=");
			buffer.append(intervalForecast);
		}
		buffer.append("]");

		buffer.append("]");
		return buffer.toString();
	}

	/**
	 * 
	 */
	public double getEstimatedRaceTemperature() {
		EstimatedRaceTemperatureCalculatorStrategy calculator = EstimatedRaceTemperatureCalculatorFactory.getInstance().create();
		return calculator.getEstimatedTemperature(this);
	}
}
