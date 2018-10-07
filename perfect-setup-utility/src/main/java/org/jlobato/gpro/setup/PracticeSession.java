package org.jlobato.gpro.setup;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author JLOBATO
 *
 */
public class PracticeSession implements Comparable<PracticeSession>, Cloneable, Serializable {

	/**
	 *
	 */
	private ArrayList<PracticeLap> practiceLaps;

	/**
	 *
	 */
	private CarSetup perfectSetup;

	/**
	 *
	 */
	private CarFringe carFringe;

	/**
	 *
	 */
	private transient PracticeSessionSupport support;

	/**
	 * 
	 */
	private CarSetup q2Setup;

	/**
	 * 
	 */
	private CarSetup raceSetup;

	/**
	 * serial version UID
	 */
	private static final long serialVersionUID = -1298365697236026537L;

	/**
	 * Número máximo de runs para una sesión de prácticas
	 */
	public static final int MAX_PRACTICE_RUNS = 8;

	/**
	 *
	 */
	public PracticeSession () {
		this.support = new PracticeSessionSupport(this);
	}

	/**
	 *
	 * @param arg0
	 * @return
	 * @see java.lang.Comparable#compareTo(T)
	 */
	public int compareTo(PracticeSession o) {
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
		return super.equals(obj);
	}

	/**
	 * @return
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return super.hashCode();
	}

	/**
	 * @return
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return super.toString();
	}

	/**
	 * @return the practiceLaps
	 */
	public ArrayList<PracticeLap> getPracticeLaps() {
		if (practiceLaps == null) {
			practiceLaps = new ArrayList<PracticeLap>();
		}
		return practiceLaps;
	}

	/**
	 * @param practiceLaps the practiceLaps to set
	 */
	public void setPracticeLaps(ArrayList<PracticeLap> practiceLaps) {
		this.practiceLaps = practiceLaps;
		Iterator<PracticeLap> iterator = practiceLaps.iterator();
		while (iterator.hasNext()) {
			PracticeLap current = (PracticeLap)iterator.next();
			current.setSession(this);
		}
		//TODO Lanzaría un evento de setPracticeLaps
	}

	/**
	 *
	 * @param practiceLap
	 */
	public void addPracticeLap(PracticeLap practiceLap) {
		if (getPracticeLaps().add(practiceLap)) {
			practiceLap.setSession(this);
		}
		//TODO Lanzaría un evento de PracticeLap added
	}

	/**
	 *
	 * @param practiceLap
	 */
	public void removePracticeLap(PracticeLap practiceLap) {
		if (getPracticeLaps().remove(practiceLap)) {
			practiceLap.setSession(null);
		}
		//TODO Lanzaría un evento de PracticeLap removed
	}

	/**
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public PracticeLap getLastPracticeLap() {
		PracticeLap result = null;
		if (getPracticeLaps() != null && !getPracticeLaps().isEmpty()) {
			List laps = new ArrayList<PracticeLap>(getPracticeLaps());
			Collections.sort(laps);
			result = (PracticeLap)laps.get(laps.size() - 1);
		}
		return result;
	}

	/**
	 *
	 * @param practiceLap
	 * @return
	 */
	public PracticeLap getFormerLap(PracticeLap practiceLap) {
		PracticeLap result = null;
		Iterator<PracticeLap> iterator = getPracticeLaps().iterator();
		boolean found = false;
		while(iterator.hasNext() && !found ) {
			PracticeLap current = (PracticeLap)iterator.next();
			if (current.getLapNumber().intValue() == (practiceLap.getLapNumber().intValue() - 1)) {
				result = current;
				found = true;
			}
		}
		return result;
	}

	/**
	 * Versión chusquera del clear: creamos una lista nueva
	 * y de la antigua nos olvidamos
	 */
	public void clear() {
		setPracticeLaps(new ArrayList<PracticeLap>());
	}

	/**
	 * @return the perfectSetup
	 */
	public CarSetup getPerfectSetup() {
		return perfectSetup;
	}

	/**
	 * @param perfectSetup the perfectSetup to set
	 */
	public void setPerfectSetup(CarSetup perfectSetup) {
		this.perfectSetup = perfectSetup;
		if (support == null) {
			support = new PracticeSessionSupport(this);
		}
		support.firePerfectSetupChanged(this.perfectSetup);
	}

	/**
	 *
	 * @param listener
	 */
	public void addPracticeSessionListener(PracticeSessionListener listener) {
		if (support == null) {
			support = new PracticeSessionSupport(this);
		}
		support.addPracticeSessionListener(listener);
	}

	/**
	 *
	 * @param listener
	 */
	public void removePracticeSessionListener(PracticeSessionListener listener) {
		if (support != null) {
			support.removePracticeSessionListener(listener);
		}
	}

	/**
	 * @return the carFringe
	 */
	public CarFringe getCarFringe() {
		return carFringe;
	}

	/**
	 * @param carFringe the carFringe to set
	 */
	public void setCarFringe(CarFringe carFringe) {
		this.carFringe = carFringe;
		if (support == null) {
			support = new PracticeSessionSupport(this);
		}
		support.fireCarFringeChanged(this.carFringe);
	}

	/**
	 * 
	 * @param q2Setup
	 */
	public void setQ2Setup(CarSetup q2Setup) {
		this.q2Setup = q2Setup;
		if (support == null) {
			support = new PracticeSessionSupport(this);
		}
		support.fireQ2SetupChanged(this.q2Setup);
		
	}

	/**
	 * 
	 * @param raceSetup
	 */
	public void setRaceSetup(CarSetup raceSetup) {
		this.raceSetup = raceSetup;
		if (support == null) {
			support = new PracticeSessionSupport(this);
		}
		support.fireRaceSetupChanged(this.raceSetup);
	}

	/**
	 * 
	 * @return
	 */
	public CarSetup getQ2Setup() {
		return q2Setup;
	}

	/**
	 * 
	 * @return
	 */
	public CarSetup getRaceSetup() {
		return raceSetup;
	}

}
