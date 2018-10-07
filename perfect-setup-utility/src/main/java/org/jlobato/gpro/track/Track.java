/**
 * 
 */
package org.jlobato.gpro.track;

import java.io.Serializable;

/**
 * @author jlobato
 *
 */
public interface Track extends Serializable {
	/**
	 * Track Name
	 * 
	 * @return The name of the track
	 */
	public String getName();
	
	/**
	 * Track Downforce
	 * 
	 * @return the downforce of the track
	 */
	public String getDownforce();
	
	/**
	 * Track Overtaking
	 * 
	 * @return the overtaking degree of the track
	 */
	public String getOvertaking();
	
	/**
	 * Wear cost of the track
	 * 
	 * @return the wear cost of the track
	 */
	public String getWear();
	
	/**
	 * Fuel Consumption of the track. Used to predict fuel needed for a race
	 * 
	 * @return fuel consumption constant for this track
	 */
	public String getFuelConsumption();
	
	/**
	 * Tyre Compound Delta for this track.
	 * 
	 * @return tyre compound delta constant for this track
	 */
	public String getTyreCompoundDelta();
	
}
