package org.jlobato.gpro.forecast;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author JLOBATO
 *
 */
public class DefaultForecast implements IForecast {

	/**
	 * serial version uid
	 */
	private static final long serialVersionUID = 6244003341439072600L;

	/**
	 * Humedad
	 */
	private double humidity;
	/**
	 * Temperatura
	 */
	private double temperature;
	/**
	 * Clima
	 */
	double weather;

	/**
	 *
	 */
	private PropertyChangeSupport support;


	/**
	 * Constructor
	 */
	public DefaultForecast() {
		super();
		this.support = new PropertyChangeSupport(this);
	}

	/**
	 *
	 * @param humidity
	 * @param temperature
	 * @param weather
	 */
	public DefaultForecast(double temperature, double humidity, double weather) {
		this();
		this.humidity = humidity;
		this.temperature = temperature;
		this.weather = weather;
	}

	/**
	 * @param humidity the humidity to set
	 */
	public void setHumidity(double humidity) {
		double oldValue = this.humidity;
		this.humidity = humidity;
		if (support != null) {
			support.firePropertyChange(IForecast.HUMIDITY_PROPERTY, oldValue, humidity);
		}
	}

	/**
	 * @param temperature the temperature to set
	 */
	public void setTemperature(double temperature) {
		double oldValue = this.humidity;
		this.temperature = temperature;
		if (support != null) {
			support.firePropertyChange(IForecast.TEMPERATURE_PROPERTY, oldValue, temperature);
		}
	}

	/**
	 * @param weather the weather to set
	 */
	public void setWeather(double weather) {
		double oldValue = this.humidity;
		this.weather = weather;
		if (support != null) {
			support.firePropertyChange(IForecast.WEATHER_PROPERTY, oldValue, weather);
		}
	}

	/**
	 * @return the humidity
	 */
	public double getHumidity() {
		return humidity;
	}

	/**
	 * @return the temperature
	 */
	public double getTemperature() {
		return temperature;
	}

	/**
	 * @return the weather
	 */
	public double getWeather() {
		return weather;
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
		return "[Temp: " + getTemperature() + "�C;Humedad: " + getHumidity() + "%;Lluvia: " + getWeather() + "%]";
	}

	/**
	 *
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		if  (support == null) {
			support = new PropertyChangeSupport(this);
		}
		support.addPropertyChangeListener(listener);
	}

	/**
	 *
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		if  (support != null) {
			support.addPropertyChangeListener(listener);
		}
	}

}
