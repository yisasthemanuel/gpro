package org.jlobato.gpro.forecast;

/**
 *
 * @author JLOBATO
 *
 */
public interface RaceForecastGrabListener {

	/**
	 *
	 * @param evt
	 */
	public void grabStarted(RaceForecastGrabEvent evt);

	/**
	 *
	 * @param evt
	 */
	public void grabEnded(RaceForecastGrabEvent evt);

	/**
	 *
	 * @param evt
	 */
	public void grabFailed(RaceForecastGrabEvent evt);

}
