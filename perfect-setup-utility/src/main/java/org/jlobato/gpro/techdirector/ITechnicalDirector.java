package org.jlobato.gpro.techdirector;

import java.beans.PropertyChangeListener;
import java.io.Serializable;

/**
 *
 * @author JLOBATO
 *
 */
public interface ITechnicalDirector extends Cloneable, Comparable, Serializable {

	/**
	 *
	 */
	public static final String NAME_PROPERTY = "name";
	public static final String NATIONALITY_PROPERTY = "nationality";
	public static final String MOTIVATION_PROPERTY = "motivation";
	public static final String PITCOORDINATION_PROPERTY = "pitCoordination";
	public static final String EXPERIENCE_PROPERTY = "experience";
	public static final String AERODYNAMICS_PROPERTY = "aerodynamics";
	public static final String ELECTRONICS_PROPERTY = "electronics";
	public static final String MECHANICS_PROPERTY = "mechanics";
	public static final String LEADERSHIP_PROPERTY = "leadership";

	/**
	 * @return the overall
	 */
	public int getOverall();

	/**
	 * @return the leadership
	 */
	public int getLeadership();

	/**
	 * @return the mechanics
	 */
	public int getMechanics();

	/**
	 * @return the electronics
	 */
	public int getElectronics();

	/**
	 * @return the aerodynamics
	 */
	public int getAerodynamics();

	/**
	 * @return the experience
	 */
	public int getExperience();

	/**
	 * @return the pitCoordination
	 */
	public int getPitCoordination();

	/**
	 * @return the motivation
	 */
	public int getMotivation();

	/**
	 * @param overall the overall to set
	 */
	public void setOverall(int overall);

	/**
	 * @param leadership the leadership to set
	 */
	public void setLeadership(int leadership);

	/**
	 * @param mechanics the mechanics to set
	 */
	public void setMechanics(int mechanics);

	/**
	 * @param electronics the electronics to set
	 */
	public void setElectronics(int electronics);

	/**
	 * @param aerodynamics the aerodynamics to set
	 */
	public void setAerodynamics(int aerodynamics);

	/**
	 * @param experience the experience to set
	 */
	public void setExperience(int experience);

	/**
	 * @param pitCoordination the pitCoordination to set
	 */
	public void setPitCoordination(int pitCoordination);

	/**
	 * @param motivation the motivation to set
	 */
	public void setMotivation(int motivation);

	/**
	 * @return the name
	 */
	public String getName();

	/**
	 * @param name the name to set
	 */
	public void setName(String name);

	/**
	 * @return the nationality
	 */
	public String getNationality();

	/**
	 * @param nationality the nationality to set
	 */
	public void setNationality(String nationality);

	/**
	 *
	 * @param listener
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener);

	/**
	 *
	 * @param listener
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener);

}
