/**
 * 
 */
package org.jlobato.gpro.season;

import java.io.Serializable;
import java.util.Date;

import org.jlobato.gpro.track.Track;

/**
 * @author jlobato
 *
 */
public interface Race extends Serializable {
	/**
	 * Season in which this race is taken place.
	 * 
	 * @return season reference
	 */
	public Season getSeason();
	
	/**
	 * Track in which this race is taken place.
	 * 
	 * @return track reference
	 */
	public Track getTrack();
	
	/**
	 * Race order number inside the season
	 * 
	 * @return 1 for the first race, 2 for the second and so on
	 */
	public int getRaceNumber();
	
	/**
	 * Date of the race.
	 * 
	 * @return the date of the race
	 */
	public Date getDate();

}
