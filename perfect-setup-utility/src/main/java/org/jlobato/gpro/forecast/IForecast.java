package org.jlobato.gpro.forecast;

import java.beans.PropertyChangeListener;
import java.io.Serializable;

/**
 * Interfaz que repesenta un pronósitico de tiempo en GPRO
 *
 * @author JLOBATO
 *
 */
public interface IForecast extends Serializable, Cloneable {
	public static final String HUMIDITY_PROPERTY = "humidity";
	public static final String TEMPERATURE_PROPERTY = "temperature";
	public static final String WEATHER_PROPERTY = "weather";
	public static final String LLUVIA_LABEL = "Lluvia";
	public static final String SECO_LABEL = "Seco";

	/**
	 * Temperatura en grados centígrados
	 * @return
	 */
	public double getTemperature();

	/**
	 * Humedad relativa
	 * @return
	 */
	public double getHumidity();

	/**
	 * Clima: 0: seco - 100.0: mojado
	 * @return
	 */
	public double getWeather();

	/**
	 *
	 * @param listener
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener);

	/**
	 *
	 * @param listener
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener);

}
