package org.jlobato.gpro.setup;

import java.util.EventObject;

/**
 *
 * @author JLOBATO
 *
 */
public class PracticeSessionEvent extends EventObject {

	/**
	 * serial version UID
	 */
	private static final long serialVersionUID = -4012408693457800915L;

	/**
	 *
	 */
	private CarSetup setup;

	private CarFringe fringe;

	/**
	 *
	 * @param source
	 * @param setup
	 */
	public PracticeSessionEvent(Object source, CarSetup setup) {
		super(source);
		this.setup = setup;
	}

	/**
	 *
	 * @param source
	 * @param carFringe
	 */
	public PracticeSessionEvent(Object source, CarFringe carFringe) {
		super(source);
		this.fringe = carFringe;
	}

	/**
	 *
	 * @return
	 */
	public CarSetup getSetup() {
		return this.setup;
	}

	/**
	 * @return the fringe
	 */
	public CarFringe getFringe() {
		return fringe;
	}

}
