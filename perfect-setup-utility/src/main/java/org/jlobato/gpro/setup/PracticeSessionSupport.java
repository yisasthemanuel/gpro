package org.jlobato.gpro.setup;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author JLOBATO
 *
 */
public class PracticeSessionSupport {

	/**
	 *
	 */
	private ArrayList<PracticeSessionListener> listeners;

	/**
	 *
	 */
	private Object source;

	public PracticeSessionSupport(Object source) {
		this.source = source;
		listeners = new ArrayList<PracticeSessionListener>();
	}

	/**
	 * @return the listeners
	 */
	public List<PracticeSessionListener> getListeners() {
		return listeners;
	}

	/**
	 * @return the source
	 */
	public Object getSource() {
		return source;
	}

	/**
	 *
	 * @param listener
	 */
	public void addPracticeSessionListener(PracticeSessionListener listener) {
		listeners.add(listener);
	}

	/**
	 *
	 * @param listener
	 */
	public void removePracticeSessionListener(PracticeSessionListener listener) {
		listeners.remove(listener);
	}

	/**
	 *
	 * @param setup
	 */
	public void firePerfectSetupChanged(CarSetup setup) {
		List<PracticeSessionListener> notifiers = null;
		synchronized (listeners) {
			notifiers = (List<PracticeSessionListener>)listeners.clone();
		}

		Iterator<PracticeSessionListener> i = notifiers.iterator();
		while (i.hasNext()) {
			PracticeSessionListener listener = i.next();
			PracticeSessionEvent evt = new PracticeSessionEvent(getSource(), setup);
			listener.perfectSetupChanged(evt);
		}
	}

	/**
	 *
	 * @param carFringe
	 */
	public void fireCarFringeChanged(CarFringe carFringe) {
		List<PracticeSessionListener> notifiers = null;
		synchronized (listeners) {
			notifiers = (List<PracticeSessionListener>)listeners.clone();
		}

		Iterator<PracticeSessionListener> i = notifiers.iterator();
		while (i.hasNext()) {
			PracticeSessionListener listener = i.next();
			PracticeSessionEvent evt = new PracticeSessionEvent(getSource(), carFringe);
			listener.carFringeChanged(evt);
		}
	}

	public void fireQ2SetupChanged(CarSetup q2Setup) {
		List<PracticeSessionListener> notifiers = null;
		synchronized (listeners) {
			notifiers = (List<PracticeSessionListener>)listeners.clone();
		}

		Iterator<PracticeSessionListener> i = notifiers.iterator();
		while (i.hasNext()) {
			PracticeSessionListener listener = i.next();
			PracticeSessionEvent evt = new PracticeSessionEvent(getSource(), q2Setup);
			listener.q2SetupChanged(evt);
		}
	}

	public void fireRaceSetupChanged(CarSetup raceSetup) {
		List<PracticeSessionListener> notifiers = null;
		synchronized (listeners) {
			notifiers = (List<PracticeSessionListener>)listeners.clone();
		}

		Iterator<PracticeSessionListener> i = notifiers.iterator();
		while (i.hasNext()) {
			PracticeSessionListener listener = i.next();
			PracticeSessionEvent evt = new PracticeSessionEvent(getSource(), raceSetup);
			listener.raceSetupChanged(evt);
		}
	}

}
