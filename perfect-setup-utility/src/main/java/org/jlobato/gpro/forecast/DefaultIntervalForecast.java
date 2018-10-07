package org.jlobato.gpro.forecast;

public class DefaultIntervalForecast implements IIntervalForecast {
	/**
	 *
	 */
	private static final long serialVersionUID = 6313430015455640785L;
	private IForecast finalForecast;
	private IForecast initialForecast;
	private int duration;

	/**
	 *
	 */
	public DefaultIntervalForecast() {
		this(new DefaultForecast(), new DefaultForecast(), 30);
	}

	/**
	 *
	 * @param initialForecast
	 * @param finalForecast
	 * @param duration
	 */
	public DefaultIntervalForecast(IForecast initialForecast, IForecast finalForecast, int duration) {
		super();
		this.duration = duration;
		this.finalForecast = finalForecast;
		this.initialForecast = initialForecast;
	}



	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}
	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
	/**
	 * @return the initialForecast
	 */
	public IForecast getInitialForecast() {
		return initialForecast;
	}
	/**
	 * @param initialForecast the initialForecast to set
	 */
	public void setInitialForecast(IForecast initialForecast) {
		this.initialForecast = initialForecast;
	}
	/**
	 * @return the finalForecast
	 */
	public IForecast getFinalForecast() {
		return finalForecast;
	}
	/**
	 * @param finalForecast the finalForecast to set
	 */
	public void setFinalForecast(IForecast finalForecast) {
		this.finalForecast = finalForecast;
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
		buffer.append("Temp: ");
		buffer.append(getInitialForecast().getTemperature() + "º");
		buffer.append("-");
		buffer.append(getFinalForecast().getTemperature() + "º");
		buffer.append(";");

		buffer.append("Humedad: ");
		buffer.append(getInitialForecast().getHumidity() + "%");
		buffer.append("-");
		buffer.append(getFinalForecast().getHumidity() + "%");
		buffer.append(";");

		buffer.append("Prob. de lluvias: ");
		buffer.append(getInitialForecast().getWeather() + "%");
		if (getInitialForecast().getWeather() != getFinalForecast().getWeather()) {
			buffer.append("-");
			buffer.append(getFinalForecast().getWeather() + "%");
		}
		buffer.append(";");

		buffer.append("]");
		return buffer.toString();
	}

}
