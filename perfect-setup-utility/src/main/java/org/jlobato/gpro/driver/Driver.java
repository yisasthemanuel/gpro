package org.jlobato.gpro.driver;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author JLOBATO
 *
 */
public class Driver implements IDriver {

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
	private int concentration;
	/**
	 *
	 */
	private int talent;
	/**
	 *
	 */
	private int experience;
	/**
	 *
	 */
	private int techInsight;
	/**
	 *
	 */
	private int aggressiveness;
	/**
	 *
	 */
	private int stamina;
	/**
	 *
	 */
	private int motivation;
	/**
	 *
	 */
	private int reputation;
	/**
	 *
	 */
	private int age;
	/**
	 *
	 */
	private int weight;
	/**
	 *
	 */
	private int charisma;

	/**
	 *
	 */
	private PropertyChangeSupport support;

	/**
	 *
	 * @param name
	 * @param nationality
	 * @param concentration
	 * @param talent
	 * @param aggressiveness
	 * @param experience
	 * @param techInsight
	 * @param stamina
	 * @param charisma
	 * @param motivation
	 * @param reputation
	 * @param weight
	 * @param age
	 */
	public Driver(String name, String nationality, int concentration,
			int talent, int aggressiveness, int experience, int techInsight,
			int stamina, int charisma, int motivation, int reputation,
			int weight, int age) {
		this.age = age;
		this.aggressiveness = aggressiveness;
		this.charisma = charisma;
		this.concentration = concentration;
		this.experience = experience;
		this.motivation = motivation;
		this.name = name;
		this.nationality = nationality;
		this.reputation = reputation;
		this.stamina = stamina;
		this.talent = talent;
		this.techInsight = techInsight;
		this.weight = weight;

		//PropertyChangeSupport
		this.support = new PropertyChangeSupport(this);
	}

	/**
	 *
	 * @param name
	 * @param experience
	 * @param techInsight
	 */
	public Driver(String name, int experience, int techInsight) {
		this(name, "", 0, 0, 0, experience, techInsight, 0, 0, 0, 0, 0, 0);
	}

	/**
	 *
	 */
	public Driver() {
		this("", "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	}

	/**
	 * serial version UID
	 */
	private static final long serialVersionUID = 8085956394922628318L;

	/**
	 *
	 * @return
	 * @see org.jlobato.gpro.driver.IDriver#getName()
	 */
	public String getName() {
		return name;
	}

	/**
	 *
	 * @param name
	 * @see org.jlobato.gpro.driver.IDriver#setName(java.lang.String)
	 */
	public void setName(String name) {
		String oldValue = this.name;
		this.name = name;
		if (support != null) {
			support.firePropertyChange(NAME_PROPERTY, oldValue, name);
		}
	}
	/* (non-Javadoc)
	 * @see org.jlobato.gpro.driver.IDriver#getConcentration()
	 */
	public int getConcentration() {
		return concentration;
	}
	/* (non-Javadoc)
	 * @see org.jlobato.gpro.driver.IDriver#setConcentration(int)
	 */
	public void setConcentration(int concentration) {
		int oldValue = this.concentration;
		this.concentration = concentration;
		if (support != null) {
			support.firePropertyChange(CONCENTRATION_PROPERTY, oldValue, concentration);
		}
	}
	/* (non-Javadoc)
	 * @see org.jlobato.gpro.driver.IDriver#getTalent()
	 */
	public int getTalent() {
		return talent;
	}
	/* (non-Javadoc)
	 * @see org.jlobato.gpro.driver.IDriver#setTalent(int)
	 */
	public void setTalent(int talent) {
		int oldValue = this.talent;
		this.talent = talent;
		if (support != null) {
			support.firePropertyChange(TALENT_PROPERTY, oldValue, talent);
		}
	}
	/* (non-Javadoc)
	 * @see org.jlobato.gpro.driver.IDriver#getExperience()
	 */
	public int getExperience() {
		return experience;
	}
	/* (non-Javadoc)
	 * @see org.jlobato.gpro.driver.IDriver#setExperience(int)
	 */
	public void setExperience(int experience) {
		int oldValue = this.experience;
		this.experience = experience;
		if (support != null) {
			support.firePropertyChange(EXPERIENCE_PROPERTY, oldValue, experience);
		}
	}
	/* (non-Javadoc)
	 * @see org.jlobato.gpro.driver.IDriver#getTechInsight()
	 */
	public int getTechInsight() {
		return techInsight;
	}
	/* (non-Javadoc)
	 * @see org.jlobato.gpro.driver.IDriver#setTechInsight(int)
	 */
	public void setTechInsight(int techInsight) {
		int oldValue = this.techInsight;
		this.techInsight = techInsight;
		if (support != null) {
			support.firePropertyChange(TECH_INSIGHT_PROPERTY, oldValue, techInsight);
		}
	}
	/* (non-Javadoc)
	 * @see org.jlobato.gpro.driver.IDriver#getAggressiveness()
	 */
	public int getAggressiveness() {
		return aggressiveness;
	}
	/* (non-Javadoc)
	 * @see org.jlobato.gpro.driver.IDriver#setAggressiveness(int)
	 */
	public void setAggressiveness(int aggressiveness) {
		int oldValue = this.aggressiveness;
		this.aggressiveness = aggressiveness;
		if (support != null) {
			support.firePropertyChange(AGGRESSIVENESS_PROPERTY, oldValue, aggressiveness);
		}
	}
	/* (non-Javadoc)
	 * @see org.jlobato.gpro.driver.IDriver#getStamina()
	 */
	public int getStamina() {
		return stamina;
	}
	/* (non-Javadoc)
	 * @see org.jlobato.gpro.driver.IDriver#setStamina(int)
	 */
	public void setStamina(int stamina) {
		int oldValue = this.stamina;
		this.stamina = stamina;
		if (support != null) {
			support.firePropertyChange(STAMINA_PROPERTY, oldValue, stamina);
		}
	}
	/* (non-Javadoc)
	 * @see org.jlobato.gpro.driver.IDriver#getMotivation()
	 */
	public int getMotivation() {
		return motivation;
	}
	/* (non-Javadoc)
	 * @see org.jlobato.gpro.driver.IDriver#setMotivation(int)
	 */
	public void setMotivation(int motivation) {
		int oldValue = this.motivation;
		this.motivation = motivation;
		if (support != null) {
			support.firePropertyChange(MOTIVATION_PROPERTY, oldValue, motivation);
		}
	}
	/* (non-Javadoc)
	 * @see org.jlobato.gpro.driver.IDriver#getReputation()
	 */
	public int getReputation() {
		return reputation;
	}
	/* (non-Javadoc)
	 * @see org.jlobato.gpro.driver.IDriver#setReputation(int)
	 */
	public void setReputation(int reputation) {
		int oldValue = this.reputation;
		this.reputation = reputation;
		if (support != null) {
			support.firePropertyChange(IDriver.REPUTATION_PROPERTY, oldValue, reputation);
		}
	}
	/* (non-Javadoc)
	 * @see org.jlobato.gpro.driver.IDriver#getAge()
	 */
	public int getAge() {
		return age;
	}
	/* (non-Javadoc)
	 * @see org.jlobato.gpro.driver.IDriver#setAge(int)
	 */
	public void setAge(int age) {
		int oldValue = this.age;
		this.age = age;
		if (support != null) {
			support.firePropertyChange(AGE_PROPERTY, oldValue, age);
		}
	}
	/* (non-Javadoc)
	 * @see org.jlobato.gpro.driver.IDriver#getWeight()
	 */
	public int getWeight() {
		return weight;
	}
	/* (non-Javadoc)
	 * @see org.jlobato.gpro.driver.IDriver#setWeight(int)
	 */
	public void setWeight(int weight) {
		int oldValue = this.weight;
		this.weight = weight;
		if (support != null) {
			support.firePropertyChange(WEIGHT_PROPERTY, oldValue, weight);
		}
	}
	/* (non-Javadoc)
	 * @see org.jlobato.gpro.driver.IDriver#getCharisma()
	 */
	public int getCharisma() {
		return charisma;
	}
	/* (non-Javadoc)
	 * @see org.jlobato.gpro.driver.IDriver#setCharisma(int)
	 */
	public void setCharisma(int charisma) {
		int oldValue = this.charisma;
		this.charisma = charisma;
		if (support != null) {
			support.firePropertyChange(CHARISMA_PROPERTY, oldValue, charisma);
		}
	}
	/* (non-Javadoc)
	 * @see org.jlobato.gpro.driver.IDriver#getNationality()
	 */
	public String getNationality() {
		return nationality;
	}
	/* (non-Javadoc)
	 * @see org.jlobato.gpro.driver.IDriver#setNationality(java.lang.String)
	 */
	public void setNationality(String nationality) {
		String oldValue = this.nationality;
		this.nationality = nationality;
		if (support != null) {
			support.firePropertyChange(IDriver.NATIONALITY_PROPERTY, oldValue, nationality);
		}
	}
	/* (non-Javadoc)
	 * @see org.jlobato.gpro.driver.IDriver#getOverall()
	 */
	public int getOverall() {
		DriverOverallCalculatorStrategy overallCalculatorStrategy = DriverOverallCalculatorFactory.getInstance().create();
		return overallCalculatorStrategy.calculateOverall(this);
	}

	/* (non-Javadoc)
	 * @see org.jlobato.gpro.driver.IDriver#getSetupRange()
	 */
	public int getSetupRange() {
		SetupRangeCalculatorStrategy setupRangeCalculator = SetupRangeCalculatorFactory.getInstance().create();
		//return setupRangeCalculator.calculateDriverSetupRange(this);
		return setupRangeCalculator.getDriverSetupRange(this);
	}

	/* (non-Javadoc)
	 * @see org.jlobato.gpro.driver.IDriver#addPropertyChangeListener(java.beans.PropertyChangeListener)
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		if (support == null) {
			support = new PropertyChangeSupport(this);
		}
		support.addPropertyChangeListener(listener);
	}

	/* (non-Javadoc)
	 * @see org.jlobato.gpro.driver.IDriver#removePropertyChangeListener(java.beans.PropertyChangeListener)
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		if (support != null) {
			support.removePropertyChangeListener(listener);
		}
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		String lineSeparator = System.getProperty("line.separator");
		buffer.append("Name: " + getName() + lineSeparator);
		buffer.append("Nationality: " + getNationality() + lineSeparator);
		buffer.append("Concentration: " + getConcentration() + lineSeparator);

		buffer.append("Talent: " + getTalent() + lineSeparator);
		buffer.append("Aggressiveness: " + getAggressiveness() + lineSeparator);
		buffer.append("Experience: " + getExperience() + lineSeparator);

		buffer.append("Technical Insight: " + getTechInsight() + lineSeparator);
		buffer.append("Stamina: " + getStamina() + lineSeparator);
		buffer.append("Charisma: " + getCharisma() + lineSeparator);

		buffer.append("Motivation: " + getMotivation() + lineSeparator);
		buffer.append("Reputation: " + getReputation() + lineSeparator);
		buffer.append("Weight: " + getWeight() + lineSeparator);
		buffer.append("Age: " + getAge());

		return buffer.toString();
	}

	/**
	 * Implementación del compareTo
	 * En esta primera versión, el criterio de comparación es el nombre del piloto.
	 *
	 * En un futuro será:
	 * 1. El overall
	 * 2. El talento
	 * 3. La concentración
	 */
	public int compareTo(Object driver) {
		int result = 0;
		if (driver != null) {
			IDriver other = (IDriver)driver;
			result = this.getName().compareTo(other.getName());
		}
		else {
			//Si el otro objeto es nulo, este siempre será mayor
			result = 1;
		}
		return result;
	}

}
