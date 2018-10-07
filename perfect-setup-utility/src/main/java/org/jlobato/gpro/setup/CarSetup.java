package org.jlobato.gpro.setup;

import java.io.Serializable;

public class CarSetup implements Cloneable, Comparable, Serializable {

	public static final CarSetup ALL500_SETUP = new CarSetup(new Integer(500), new Integer(500), new Integer(500), new Integer(500), new Integer(500), new Integer(500));

	public static final String FRONTWING_SETUP = "FW";
	public static final String REARWING_SETUP = "RW";
	public static final String ENGINE_SETUP = "EN";
	public static final String BRAKES_SETUP = "BR";
	public static final String GEARBOX_SETUP = "GE";
	public static final String SUSPENSION_SETUP = "SU";

	private Integer frontWing;
	private Integer rearWing;
	private Integer engine;
	private Integer brakes;
	private Integer gearbox;
	private Integer suspension;

	/**
	 * serial version UID
	 */
	private static final long serialVersionUID = 6179430775931045290L;



	/**
	 *
	 * @param frontWing
	 * @param rearWing
	 * @param engine
	 * @param brakes
	 * @param gearbox
	 * @param suspension
	 */
	public CarSetup(Integer frontWing, Integer rearWing, Integer engine, Integer brakes, Integer gearbox, Integer suspension) {
		this.brakes = brakes;
		this.engine = engine;
		this.frontWing = frontWing;
		this.gearbox = gearbox;
		this.rearWing = rearWing;
		this.suspension = suspension;
	}

	/**
	 *
	 * @param frontWing
	 * @param rearWing
	 * @param engine
	 * @param brakes
	 * @param gearbox
	 * @param suspension
	 */
	public CarSetup(int frontWing, int rearWing, int engine, int brakes, int gearbox, int suspension) {
		this(new Integer(frontWing), new Integer(rearWing), new Integer(engine), new Integer(brakes), new Integer(gearbox), new Integer(suspension));
	}

	/**
	 * 
	 * @param frontWing
	 * @param rearWing
	 * @param engine
	 * @param brakes
	 * @param gearbox
	 * @param suspension
	 */
	public CarSetup(String frontWing, String rearWing, String engine, String brakes, String gearbox, String suspension) {
		this(new Integer(frontWing), new Integer(rearWing), new Integer(engine), new Integer(brakes), new Integer(gearbox), new Integer(suspension));
	}

	/**
	 * 
	 * @param frontWing
	 * @param rearWing
	 * @param engine
	 * @param brakes
	 * @param gearbox
	 * @param suspension
	 */
	public CarSetup(long frontWing, long rearWing, long engine, long brakes, long gearbox, long suspension) {
		this(new Integer((int)frontWing), new Integer((int)rearWing), new Integer((int)engine), new Integer((int)brakes), new Integer((int)gearbox), new Integer((int)suspension));
	}

	/**
	 * @return the frontWing
	 */
	public Integer getFrontWing() {
		return frontWing;
	}

	/**
	 * @param frontWing the frontWing to set
	 */
	public void setFrontWing(Integer frontWing) {
		this.frontWing = frontWing;
	}

	/**
	 * @return the rearWing
	 */
	public Integer getRearWing() {
		return rearWing;
	}

	/**
	 * @param rearWing the rearWing to set
	 */
	public void setRearWing(Integer rearWing) {
		this.rearWing = rearWing;
	}

	/**
	 * @return the engine
	 */
	public Integer getEngine() {
		return engine;
	}

	/**
	 * @param engine the engine to set
	 */
	public void setEngine(Integer engine) {
		this.engine = engine;
	}

	/**
	 * @return the brakes
	 */
	public Integer getBrakes() {
		return brakes;
	}

	/**
	 * @param brakes the brakes to set
	 */
	public void setBrakes(Integer brakes) {
		this.brakes = brakes;
	}

	/**
	 * @return the gearbox
	 */
	public Integer getGearbox() {
		return gearbox;
	}

	/**
	 * @param gearbox the gearbox to set
	 */
	public void setGearbox(Integer gearbox) {
		this.gearbox = gearbox;
	}

	/**
	 * @return the suspension
	 */
	public Integer getSuspension() {
		return suspension;
	}

	/**
	 * @param suspension the suspension to set
	 */
	public void setSuspension(Integer suspension) {
		this.suspension = suspension;
	}

	/**
	 *
	 * @param arg0
	 * @return
	 * @see java.lang.Comparable#compareTo(T)
	 */
	public int compareTo(Object arg0) {
		return 0;
	}


	/**
	 * @return
	 * @throws CloneNotSupportedException
	 * @see java.lang.Object#clone()
	 */
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	/**
	 * @param obj
	 * @return
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		CarSetup other = (CarSetup)obj;
		boolean result = this.getFrontWing().equals(other.getFrontWing()) && this.getRearWing().equals(other.getRearWing()) && this.getEngine().equals(other.getEngine()) && this.getBrakes().equals(other.getBrakes()) && this.getGearbox().equals(other.getGearbox()) && this.getSuspension().equals(other.getSuspension());
		return result;
	}

	/**
	 * @return
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return this.getFrontWing().hashCode() + this.getRearWing().hashCode() + this.getEngine().hashCode() + this.getBrakes().hashCode() + this.getGearbox().hashCode() + this.getSuspension().hashCode();
	}

	/**
	 * @return
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.getFrontWing() + " ");
		sb.append(this.getRearWing() + " ");
		sb.append(this.getEngine() + " ");
		sb.append(this.getBrakes() + " ");
		sb.append(this.getGearbox() + " ");
		sb.append(this.getSuspension());

		return sb.toString();
	}

}
