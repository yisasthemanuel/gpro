package org.jlobato.gpro.setup;

import java.io.Serializable;

public class CarFringe implements Serializable, Cloneable {

	/**
	 * serial uid
	 */
	private static final long serialVersionUID = -3761413093643043169L;

	/**
	 *
	 */
	private Fringe wingsFringe;
	/**
	 *
	 */
	private Fringe engineFringe;
	/**
	 *
	 */
	private Fringe brakesFringe;
	/**
	 *
	 */
	private Fringe gearboxFringe;
	/**
	 *
	 */
	private Fringe suspensionFringe;

	/**
	 *
	 * @param wingsFringe
	 * @param engineFringe
	 * @param brakesFringe
	 * @param gearboxFringe
	 * @param suspensionFringe
	 */
	public CarFringe(Fringe wingsFringe, Fringe engineFringe, Fringe brakesFringe, Fringe gearboxFringe, Fringe suspensionFringe) {
		this.brakesFringe = brakesFringe;
		this.engineFringe = engineFringe;
		this.gearboxFringe = gearboxFringe;
		this.suspensionFringe = suspensionFringe;
		this.wingsFringe = wingsFringe;
	}

	/**
	 *
	 */
	public CarFringe() {

	}


	/**
	 * @return the wingsFringe
	 */
	public Fringe getWingsFringe() {
		return wingsFringe;
	}
	/**
	 * @param wingsFringe the wingsFringe to set
	 */
	public void setWingsFringe(Fringe wingsFringe) {
		this.wingsFringe = wingsFringe;
	}
	/**
	 * @return the engineFringe
	 */
	public Fringe getEngineFringe() {
		return engineFringe;
	}
	/**
	 * @param engineFringe the engineFringe to set
	 */
	public void setEngineFringe(Fringe engineFringe) {
		this.engineFringe = engineFringe;
	}
	/**
	 * @return the brakesFringe
	 */
	public Fringe getBrakesFringe() {
		return brakesFringe;
	}
	/**
	 * @param brakesFringe the brakesFringe to set
	 */
	public void setBrakesFringe(Fringe brakesFringe) {
		this.brakesFringe = brakesFringe;
	}
	/**
	 * @return the gearboxFringe
	 */
	public Fringe getGearboxFringe() {
		return gearboxFringe;
	}
	/**
	 * @param gearboxFringe the gearboxFringe to set
	 */
	public void setGearboxFringe(Fringe gearboxFringe) {
		this.gearboxFringe = gearboxFringe;
	}
	/**
	 * @return the suspensionFringe
	 */
	public Fringe getSuspensionFringe() {
		return suspensionFringe;
	}
	/**
	 * @param suspensionFringe the suspensionFringe to set
	 */
	public void setSuspensionFringe(Fringe suspensionFringe) {
		this.suspensionFringe = suspensionFringe;
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
		return "[" + "WINGS=" + getWingsFringe() + ";" + "ENGINE=" + getEngineFringe() + ";" + "BRAKES=" + getBrakesFringe() + ";" + "GEARBOX=" + getGearboxFringe() + ";" + "SUSPENSION=" + getSuspensionFringe() + "]";
	}


}
