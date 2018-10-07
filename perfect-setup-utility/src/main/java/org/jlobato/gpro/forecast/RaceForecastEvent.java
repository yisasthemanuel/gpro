package org.jlobato.gpro.forecast;

import java.util.EventObject;

public class RaceForecastEvent extends EventObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1255589215557625249L;
	/**
	 * 
	 */
	private IRaceForecast raceForecast;

	/**
	 * Constructor
	 * 
	 * @param source
	 * @param raceForecast
	 */
	public RaceForecastEvent(Object source, IRaceForecast raceForecast) {
		super(source);
		this.raceForecast = raceForecast;
	}
	
	/**
	 * 
	 * @return
	 */
	public IRaceForecast getRaceForecast() {
		return this.raceForecast;
	}

}
