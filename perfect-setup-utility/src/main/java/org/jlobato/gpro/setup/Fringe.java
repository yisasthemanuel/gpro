package org.jlobato.gpro.setup;

import java.io.Serializable;

/**
 *
 * @author JLOBATO
 *
 */
public class Fringe implements Serializable, Cloneable {

	/**
	 * serial uid
	 */
	private static final long serialVersionUID = 8728981464061449548L;

	/**
	 *
	 */
	private Integer maximum;
	/**
	 *
	 */
	private Integer minimum;
	/**
	 *
	 */
	private Integer signum;

	/**
	 *
	 * @param maximum
	 * @param minimum
	 * @param signum
	 */
	public Fringe(Integer maximum, Integer minimum, Integer signum) {
		this.maximum = maximum;
		this.minimum = minimum;
		this.signum = signum;
	}

	/**
	 *
	 */
	public Fringe() {
	}

	/**
	 * @return the maximum
	 */
	public Integer getMaximum() {
		return maximum;
	}

	/**
	 * @param maximum the maximum to set
	 */
	public void setMaximum(Integer maximum) {
		this.maximum = maximum;
	}

	/**
	 * @return the minimum
	 */
	public Integer getMinimum() {
		return minimum;
	}

	/**
	 * @param minimum the minimum to set
	 */
	public void setMinimum(Integer minimum) {
		this.minimum = minimum;
	}

	/**
	 * @return the signum
	 */
	public Integer getSignum() {
		return signum;
	}

	/**
	 * @param signum the signum to set
	 */
	public void setSignum(Integer signum) {
		this.signum = signum;
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
		return ((maximum != null) ? maximum.toString() : "") + " - " + ((minimum != null) ? minimum.toString() : "") + " " + ((signum != null) ? ((signum.intValue() > 0) ? "LOWER" : "HIGHER") : "LOWER");
	}

}
