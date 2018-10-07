package org.jlobato.gpro.setup;

/**
 * 
 * @author jlobato
 *
 */
public interface PracticeSessionListener {

	/**
	 * 
	 * @param evt
	 */
	public void perfectSetupChanged(PracticeSessionEvent evt);

	/**
	 * 
	 * @param evt
	 */
	public void carFringeChanged(PracticeSessionEvent evt);

	/**
	 * 
	 * @param evt
	 */
	public void q2SetupChanged(PracticeSessionEvent evt);

	/**
	 * 
	 * @param evt
	 */
	public void raceSetupChanged(PracticeSessionEvent evt);

}
