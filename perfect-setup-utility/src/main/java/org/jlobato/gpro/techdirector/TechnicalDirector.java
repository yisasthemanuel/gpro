package org.jlobato.gpro.techdirector;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author JLOBATO
 *
 */
public class TechnicalDirector implements ITechnicalDirector {

	/**
	 *
	 */
	private int overall;
	/**
	 *
	 */
	private int leadership;
	/**
	 *
	 */
	private int mechanics;
	/**
	 *
	 */
	private int electronics;
	/**
	 *
	 */
	private int aerodynamics;
	/**
	 *
	 */
	private int experience;
	/**
	 *
	 */
	private int pitCoordination;
	/**
	 *
	 */
	private int motivation;
	/**
	 *
	 */
	private String name;
	/**
	 *
	 */
	private String nationality;

	/**
	 *
	 */
	private PropertyChangeSupport support;

	/**
	 * serial version UID
	 */
	private static final long serialVersionUID = -8757226232583358918L;
	/**
	 *
	 */
	public TechnicalDirector() {
		this("", "", 0, 0, 0, 0, 0, 0, 0, 0);
	}

	/**
	 *
	 * @param name
	 * @param nationality
	 * @param overall
	 * @param leadership
	 * @param mechanics
	 * @param electronics
	 * @param aerodynamics
	 * @param experience
	 * @param pitCoordination
	 * @param motivation
	 */
	public TechnicalDirector(String name,
			String nationality,
			int overall,
			int leadership,
			int mechanics,
			int electronics,
			int aerodynamics,
			int experience,
			int pitCoordination,
			int motivation) {
		this.aerodynamics = aerodynamics;
		this.electronics = electronics;
		this.experience = experience;
		this.leadership = leadership;
		this.mechanics = mechanics;
		this.motivation = motivation;
		this.name = name;
		this.nationality = nationality;
		this.overall = overall;
		this.pitCoordination = pitCoordination;
	}



	/**
	 * @return the overall
	 */
	public int getOverall() {
		return overall;
	}



	/**
	 * @param overall the overall to set
	 */
	public void setOverall(int overall) {
		this.overall = overall;
	}



	/**
	 * @return the leadership
	 */
	public int getLeadership() {
		return leadership;
	}



	/**
	 * @param leadership the leadership to set
	 */
	public void setLeadership(int leadership) {
		int oldValue = this.leadership;
		this.leadership = leadership;
		if (support != null) {
			support.firePropertyChange(ITechnicalDirector.LEADERSHIP_PROPERTY, oldValue, leadership);
		}
	}



	/**
	 * @return the mechanics
	 */
	public int getMechanics() {
		return mechanics;
	}



	/**
	 * @param mechanics the mechanics to set
	 */
	public void setMechanics(int mechanics) {
		int oldValue = this.mechanics;
		this.mechanics = mechanics;
		if (support != null) {
			support.firePropertyChange(ITechnicalDirector.MECHANICS_PROPERTY, oldValue, mechanics);
		}
	}



	/**
	 * @return the electronics
	 */
	public int getElectronics() {
		return electronics;
	}



	/**
	 * @param electronics the electronics to set
	 */
	public void setElectronics(int electronics) {
		int oldValue = this.electronics;
		this.electronics = electronics;
		if (support != null) {
			support.firePropertyChange(ITechnicalDirector.ELECTRONICS_PROPERTY, oldValue, electronics);
		}
	}



	/**
	 * @return the aerodynamics
	 */
	public int getAerodynamics() {
		return aerodynamics;
	}



	/**
	 * @param aerodynamics the aerodynamics to set
	 */
	public void setAerodynamics(int aerodynamics) {
		int oldValue = this.aerodynamics;
		this.aerodynamics = aerodynamics;
		if (support != null) {
			support.firePropertyChange(ITechnicalDirector.AERODYNAMICS_PROPERTY, oldValue, aerodynamics);
		}
	}



	/**
	 * @return the experience
	 */
	public int getExperience() {
		return experience;
	}



	/**
	 * @param experience the experience to set
	 */
	public void setExperience(int experience) {
		int oldValue = this.experience;
		this.experience = experience;
		if (support != null) {
			support.firePropertyChange(ITechnicalDirector.EXPERIENCE_PROPERTY, oldValue, experience);
		}
	}



	/**
	 * @return the pitCoordination
	 */
	public int getPitCoordination() {
		return pitCoordination;
	}



	/**
	 * @param pitCoordination the pitCoordination to set
	 */
	public void setPitCoordination(int pitCoordination) {
		int oldValue = this.pitCoordination;
		this.pitCoordination = pitCoordination;
		if (support != null) {
			support.firePropertyChange(ITechnicalDirector.PITCOORDINATION_PROPERTY, oldValue, pitCoordination);
		}
	}



	/**
	 * @return the motivation
	 */
	public int getMotivation() {
		return motivation;
	}



	/**
	 * @param motivation the motivation to set
	 */
	public void setMotivation(int motivation) {
		int oldValue = this.motivation;
		this.motivation = motivation;
		if (support != null) {
			support.firePropertyChange(ITechnicalDirector.MOTIVATION_PROPERTY, oldValue, motivation);
		}
	}


	/**
	 * El criterio de ordenación por defecto será el overall
	 *
	 * @param otherTechDirector
	 * @return
	 * @see java.lang.Comparable#compareTo(T)
	 */
	public int compareTo(Object otherTechDirector) {
		ITechnicalDirector other = (ITechnicalDirector)otherTechDirector;
		return this.getOverall() - other.getOverall();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		String oldValue = this.name;
		this.name = name;
		if (support != null) {
			support.firePropertyChange(ITechnicalDirector.NAME_PROPERTY, oldValue, name);
		}
	}



	/**
	 * @return the nationality
	 */
	public String getNationality() {
		return nationality;
	}



	/**
	 * @param nationality the nationality to set
	 */
	public void setNationality(String nationality) {
		String oldValue = this.nationality;
		this.nationality = nationality;
		if (support != null) {
			support.firePropertyChange(ITechnicalDirector.NATIONALITY_PROPERTY, oldValue, nationality);
		}
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
	 * @return
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		String lineSeparator = System.getProperty("line.separator");
		buffer.append("Name: " + getName() + lineSeparator);
		buffer.append("Nationality: " + getNationality() + lineSeparator);
		buffer.append("Overall: " + getOverall() + lineSeparator);
		buffer.append("Leadership: " + getLeadership() + lineSeparator);

		buffer.append("R&D mechanics: " + getMechanics() + lineSeparator);
		buffer.append("R&D electronics: " + getElectronics() + lineSeparator);
		buffer.append("R&D aerodynamics: " + getAerodynamics() + lineSeparator);

		buffer.append("Experience: " + getExperience() + lineSeparator);
		buffer.append("Pit coordination: " + getPitCoordination() + lineSeparator);

		buffer.append("Motivation: " + getMotivation() + lineSeparator);
		//TODO Incluir el dato de la edad para el TD
		//buffer.append("Age: " + getAge());

		return buffer.toString();
	}

	/**
	 *
	 * @param listener
	 * @see org.jlobato.gpro.techdirector.ITechnicalDirector#addPropertyChangeListener(java.beans.PropertyChangeListener)
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		if (support == null) {
			support = new PropertyChangeSupport(this);
		}
		support.addPropertyChangeListener(listener);
	}

	/**
	 *
	 * @param listener
	 * @see org.jlobato.gpro.techdirector.ITechnicalDirector#removePropertyChangeListener(java.beans.PropertyChangeListener)
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		if (support != null) {
			support.removePropertyChangeListener(listener);
		}
	}

}
