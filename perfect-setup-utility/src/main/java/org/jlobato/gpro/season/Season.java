/**
 * 
 */
package org.jlobato.gpro.season;

import java.io.Serializable;

/**
 * GPRO Season. Each season has 17 races scheduled every Tuesday and Friday.
 * 
 * @author jlobato
 *
 */
public interface Season extends Serializable {
	
	/**
	 * Name of the season. Normally "S" followed by season number: S1, S2, ..., S42
	 * 
	 * @return
	 */
	public String getName();
	
	/**
	 * The order number of this season
	 * 
	 * @return 1 for the first season, 2 for the second and so on
	 */
	public int getSeasonNumber();

}
