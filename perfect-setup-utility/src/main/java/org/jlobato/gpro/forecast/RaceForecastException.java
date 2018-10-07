package org.jlobato.gpro.forecast;

/**
 *
 * @author JLOBATO
 *
 */
public class RaceForecastException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = -5218494554629537129L;

	/**
	 *
	 */
	public RaceForecastException() {
	}

	/**
	 *
	 * @param message
	 */
	public RaceForecastException(String message) {
		super(message);
	}

	/**
	 *
	 * @param cause
	 */
	public RaceForecastException(Throwable cause) {
		super(cause);
	}

	/**
	 *
	 * @param message
	 * @param cause
	 */
	public RaceForecastException(String message, Throwable cause) {
		super(message, cause);
	}

}
