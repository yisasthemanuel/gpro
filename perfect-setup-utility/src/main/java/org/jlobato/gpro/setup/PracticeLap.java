package org.jlobato.gpro.setup;

import java.io.Serializable;
import java.util.HashMap;

public class PracticeLap implements Serializable, Comparable<Object>, Cloneable {
	private Integer lapNumber;
	private LapTime lapTime;
	private CarSetup setup;
	private HashMap<String, DriverComment> comms;
	private PracticeSession session;

	/**
	 * serial version UID
	 */
	private static final long serialVersionUID = -7058744640077977258L;

	/**
	 *
	 * @param session
	 * @param lapNumber
	 * @param lapTime
	 * @param setup
	 * @param comms
	 */
	public PracticeLap(PracticeSession session, Integer lapNumber, LapTime lapTime, CarSetup setup, HashMap<String, DriverComment> comms) {
		this.comms = comms;
		this.lapNumber = lapNumber;
		this.lapTime = lapTime;
		this.setup = setup;
		session.addPracticeLap(this);
	}

	/**
	 * @return the session
	 */
	public PracticeSession getSession() {
		return session;
	}

	/**
	 * @param session the session to set
	 */
	public void setSession(PracticeSession session) {
		this.session = session;
	}

	/**
	 * @return the lapNumber
	 */
	public Integer getLapNumber() {
		return lapNumber;
	}

	/**
	 * @param lapNumber the lapNumber to set
	 */
	public void setLapNumber(Integer lapNumber) {
		this.lapNumber = lapNumber;
	}

	/**
	 * @return the lapTime
	 */
	public LapTime getLapTime() {
		return lapTime;
	}

	/**
	 * @param lapTime the lapTime to set
	 */
	public void setLapTime(LapTime lapTime) {
		this.lapTime = lapTime;
	}

	/**
	 * @return the setup
	 */
	public CarSetup getSetup() {
		return setup;
	}

	/**
	 * @param setup the setup to set
	 */
	public void setSetup(CarSetup setup) {
		this.setup = setup;
	}

	/**
	 * @return the comms
	 */
	public HashMap<String, DriverComment> getComms() {
		return comms;
	}

	/**
	 * @param comms the comms to set
	 */
	public void setComms(HashMap<String, DriverComment> comms) {
		this.comms = comms;
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
	 *
	 * @param arg0
	 * @return
	 * @see java.lang.Comparable#compareTo(T)
	 */
	public int compareTo(Object arg0) {
		PracticeLap other = (PracticeLap)arg0;
		return getLapNumber().compareTo(other.getLapNumber());
	}

	/**
	 * @param obj
	 * @return
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		PracticeLap other = (PracticeLap)obj;
		return this.getLapNumber().equals(other.getLapNumber()) && this.getLapTime().equals(other.getLapTime()) && this.getSetup().equals(other.getSetup());
	}

	/**
	 * @return
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return this.getLapNumber().hashCode() + this.getLapTime().hashCode() + this.getSetup().hashCode();
	}

	/**
	 * @return
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return super.toString();
	}

	/**
	 *
	 * @param carPart
	 * @return
	 */
	public Integer getLastChange(String carPart) {
		Integer result = null;
		PracticeLap formerLap = getSession().getFormerLap(this);
		if (formerLap != null) {
			int valueChange;
			if (carPart.equals(CarSetup.FRONTWING_SETUP)) {
				valueChange = formerLap.getSetup().getFrontWing().intValue() - this.getSetup().getFrontWing().intValue();
			}else if (carPart.equals(CarSetup.ENGINE_SETUP)) {
				valueChange = formerLap.getSetup().getEngine().intValue() - this.getSetup().getEngine().intValue();
			}else if (carPart.equals(CarSetup.BRAKES_SETUP)) {
				valueChange = formerLap.getSetup().getBrakes().intValue() - this.getSetup().getBrakes().intValue();
			}else if (carPart.equals(CarSetup.GEARBOX_SETUP)) {
				valueChange = formerLap.getSetup().getGearbox().intValue() - this.getSetup().getGearbox().intValue();
			}else if (carPart.equals(CarSetup.SUSPENSION_SETUP)) {
				valueChange = formerLap.getSetup().getSuspension().intValue() - this.getSetup().getSuspension().intValue();
			}else {
				throw new IllegalArgumentException("Se ha pasado una parte del coche incorrecta a la hora de obtener el último cambio en el setup");
			}
			//if (valueChange < 0) {
			//	valueChange = valueChange * -1;
			//}
			//TODO Esto queda un poco oscuro. Mejor cambiar el orden de los factores en las 5 restas anteriores
			//o mejorar la forma de obtener el valueChange
			result = new Integer(valueChange * -1);
		}
		return result;
	}

	public DriverComment getLastComment(String carPart) {
		DriverComment result = null;
		PracticeLap formerLap = getSession().getFormerLap(this);
		if (formerLap != null) {
			result = (DriverComment)formerLap.getComms().get(carPart);
		}
		return result;
	}

}
