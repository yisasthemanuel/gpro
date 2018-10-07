package org.jlobato.gpro.forecast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 *
 * @author JLOBATO
 *
 */
public class RaceForecastGrabSupport {

	/**
	 *
	 */
	private ArrayList<RaceForecastGrabListener> listeners;
	/**
	 *
	 */
	private Object source;

	public RaceForecastGrabSupport(Object source) {
		this.source = source;
		this.listeners = new ArrayList<RaceForecastGrabListener>();
	}

	/**
	 * @return the source
	 */
	public Object getSource() {
		return source;
	}

	/**
	 * @return the listener
	 */
	public ArrayList<RaceForecastGrabListener> getListeners() {
		return listeners;
	}

	/**
	 *
	 * @param listener
	 */
	public void addRaceForecastGrabListener(RaceForecastGrabListener listener) {
		listeners.add(listener);
	}

	/**
	 *
	 * @param listener
	 */
	public void removeRaceForecastGrabListener(RaceForecastGrabListener listener) {
		listeners.remove(listener);
	}

	@SuppressWarnings("unchecked")
	/**
	 *
	 */
	void fireGrabStarted() {
		List<RaceForecastGrabListener> observers = null;
		synchronized (listeners) {
			observers = (List<RaceForecastGrabListener>) listeners.clone();
		}
		Iterator<RaceForecastGrabListener> iterator = observers.iterator();
		while (iterator.hasNext()) {
			RaceForecastGrabListener observer = iterator.next();
			RaceForecastGrabEvent evt = new RaceForecastGrabEvent(getSource());
			observer.grabStarted(evt);
		}
	}

	@SuppressWarnings("unchecked")
	/**
	 *
	 */
	void fireGrabEnded() {
		List<RaceForecastGrabListener> observers = null;
		synchronized (listeners) {
			observers = (List<RaceForecastGrabListener>) listeners.clone();
		}
		Iterator<RaceForecastGrabListener> iterator = observers.iterator();
		while (iterator.hasNext()) {
			RaceForecastGrabListener observer = iterator.next();
			RaceForecastGrabEvent evt = new RaceForecastGrabEvent(getSource());
			observer.grabEnded(evt);
		}
	}

	/**
	 *
	 * @param e
	 */
	@SuppressWarnings("unchecked")
	public void fireGrabFailed(Throwable e) {
		List<RaceForecastGrabListener> observers = null;
		synchronized (listeners) {
			observers = (List<RaceForecastGrabListener>) listeners.clone();
		}
		Iterator<RaceForecastGrabListener> iterator = observers.iterator();
		while (iterator.hasNext()) {
			RaceForecastGrabListener observer = iterator.next();
			RaceForecastGrabEvent evt = new RaceForecastGrabEvent(getSource(), e);
			observer.grabFailed(evt);
		}
	}
}
