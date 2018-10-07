package org.jlobato.gpro.setup;

import java.io.Serializable;

public class LapTime implements Cloneable, Serializable, Comparable {
	private String lapTime;
	private String driverMistake;
	private String netTime;

	/**
	 * serial version UID
	 */
	private static final long serialVersionUID = -4361785023584196800L;

	/**
	 *
	 * @param lapTime
	 */
	public LapTime(String lapTime) {
		this(lapTime, "0.000", lapTime);
	}

	/**
	 *
	 * @param lapTime
	 * @param driverMistake
	 * @param netTime
	 */
	public LapTime(String lapTime, String driverMistake, String netTime) {
		this.lapTime = lapTime;
		this.driverMistake = driverMistake;
		this.netTime = netTime;
	}

	public int compareTo(Object arg0) {
		LapTime other = (LapTime)arg0;
		return other.getLapTime().compareTo(other.getLapTime());
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
		LapTime other = (LapTime)obj;
		return this.getLapTime().equals(other.getLapTime()) && this.getDriverMistake().equals(other.getDriverMistake());
	}

	/**
	 * @return
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return this.getLapTime().hashCode() + this.getDriverMistake().hashCode();
	}



	/**
	 * @return
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.getLapTime() + " ");
		sb.append(this.getDriverMistake() + " ");
		sb.append(this.getNetTime());
		return sb.toString();
	}

	/**
	 * @return the lapTime
	 */
	public String getLapTime() {
		return lapTime;
	}

	/**
	 * @param lapTime the lapTime to set
	 */
	public void setLapTime(String lapTime) {
		this.lapTime = lapTime;
	}

	/**
	 * @return the driverMistake
	 */
	public String getDriverMistake() {
		return driverMistake;
	}

	/**
	 * @param driverMistake the driverMistake to set
	 */
	public void setDriverMistake(String driverMistake) {
		this.driverMistake = driverMistake;
	}

	/**
	 * @return the netTime
	 */
	public String getNetTime() {
		return netTime;
	}

	/**
	 * @param netTime the netTime to set
	 */
	public void setNetTime(String netTime) {
		this.netTime = netTime;
	}

}
