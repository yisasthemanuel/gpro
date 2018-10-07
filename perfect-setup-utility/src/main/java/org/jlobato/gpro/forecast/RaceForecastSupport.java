package org.jlobato.gpro.forecast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * @author jlobato
 *
 */
public class RaceForecastSupport {
	
	/**
	 * 
	 */
	protected Object source;

	/**
	 * 
	 */
	private ArrayList<RaceForecastListener> listeners;
	

	/**
	 * 
	 * @param source
	 */
	public RaceForecastSupport(Object source) {
		this.source = source;
		this.listeners = new ArrayList<RaceForecastListener>();
	}

	/**
	 * 
	 * @param listener
	 */
	public void addRaceForecastListener(RaceForecastListener listener) {
		this.listeners.add(listener);
	}

	/**
	 * 
	 * @param listener
	 */
	public void removeRaceForecastListener(RaceForecastListener listener) {
		this.listeners.remove(listener);
	}

	/**
	 * 
	 * @param model
	 */
	public void fireRaceForecastChanged(IRaceForecast model) {
		List<RaceForecastListener> notifiers = null;
		synchronized (listeners) {
			notifiers = (List<RaceForecastListener>)listeners.clone();
		}

		Iterator<RaceForecastListener> i = notifiers.iterator();
		while (i.hasNext()) {
			RaceForecastListener listener = i.next();
			RaceForecastEvent evt = new RaceForecastEvent(getSource(), model);
			listener.raceForecastChanged(evt);
		}
		
	}

	/**
	 * 
	 * @return
	 */
	public Object getSource() {
		return this.source;
	}

}
