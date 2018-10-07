package org.jlobato.gpro.forecast;

import java.util.EventObject;

/**
 *
 * @author JLOBATO
 *
 */
public class RaceForecastGrabEvent extends EventObject {

	/**
	 * serial uid version
	 */
	private static final long serialVersionUID = 2474478037248840503L;
	/**
	 *
	 */
	private Throwable rootException;

	/**
	 *
	 * @param source
	 */
	public RaceForecastGrabEvent(Object source) {
		this(source, null);
	}

	/**
	 *
	 * @param source
	 * @param rootException
	 */
	public RaceForecastGrabEvent(Object source, Throwable rootException) {
		super(source);
		this.rootException = rootException;
	}

	/**
	 *
	 * @return
	 */
	public Throwable getRootException() {
		return this.rootException;
	}

}
