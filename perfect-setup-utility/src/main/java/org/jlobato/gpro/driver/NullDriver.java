package org.jlobato.gpro.driver;

import java.beans.PropertyChangeListener;

public class NullDriver implements IDriver {
	/**
	 * serial version UID
	 *
	 */
	private static final long serialVersionUID = 4488852051912927393L;

	public NullDriver() {
	}

	/**
	 * @see org.jlobato.gpro.driver.Driver#getSetupRange()
	 */
	public int getSetupRange() {
		return 999;
	}

	/**
	 *
	 * @param listener
	 * @see org.jlobato.gpro.driver.IDriver#addPropertyChangeListener(java.beans.PropertyChangeListener)
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener) {
	}

	/**
	 *
	 * @return
	 * @see org.jlobato.gpro.driver.IDriver#getAge()
	 */
	public int getAge() {
		return 0;
	}

	/**
	 *
	 * @return
	 * @see org.jlobato.gpro.driver.IDriver#getAggressiveness()
	 */
	public int getAggressiveness() {
		return 0;
	}

	/**
	 *
	 * @return
	 * @see org.jlobato.gpro.driver.IDriver#getCharisma()
	 */
	public int getCharisma() {
		return 0;
	}

	/**
	 *
	 * @return
	 * @see org.jlobato.gpro.driver.IDriver#getConcentration()
	 */
	public int getConcentration() {
		return 0;
	}

	/**
	 *
	 * @return
	 * @see org.jlobato.gpro.driver.IDriver#getExperience()
	 */
	public int getExperience() {
		return 0;
	}

	/**
	 *
	 * @return
	 * @see org.jlobato.gpro.driver.IDriver#getMotivation()
	 */
	public int getMotivation() {
		return 0;
	}

	/**
	 *
	 * @return
	 * @see org.jlobato.gpro.driver.IDriver#getName()
	 */
	public String getName() {
		return "";
	}

	/**
	 *
	 * @return
	 * @see org.jlobato.gpro.driver.IDriver#getNationality()
	 */
	public String getNationality() {
		return "";
	}

	/**
	 *
	 * @return
	 * @see org.jlobato.gpro.driver.IDriver#getOverall()
	 */
	public int getOverall() {
		return 0;
	}

	/**
	 *
	 * @return
	 * @see org.jlobato.gpro.driver.IDriver#getReputation()
	 */
	public int getReputation() {
		return 0;
	}

	/**
	 *
	 * @return
	 * @see org.jlobato.gpro.driver.IDriver#getStamina()
	 */
	public int getStamina() {
		return 0;
	}

	/**
	 *
	 * @return
	 * @see org.jlobato.gpro.driver.IDriver#getTalent()
	 */
	public int getTalent() {
		return 0;
	}

	/**
	 *
	 * @return
	 * @see org.jlobato.gpro.driver.IDriver#getTechInsight()
	 */
	public int getTechInsight() {
		return 0;
	}

	/**
	 *
	 * @return
	 * @see org.jlobato.gpro.driver.IDriver#getWeight()
	 */
	public int getWeight() {
		return 0;
	}

	/**
	 *
	 * @param listener
	 * @see org.jlobato.gpro.driver.IDriver#removePropertyChangeListener(java.beans.PropertyChangeListener)
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener) {
	}

	/**
	 *
	 * @param age
	 * @see org.jlobato.gpro.driver.IDriver#setAge(int)
	 */
	public void setAge(int age) {
	}

	/**
	 *
	 * @param aggressiveness
	 * @see org.jlobato.gpro.driver.IDriver#setAggressiveness(int)
	 */
	public void setAggressiveness(int aggressiveness) {
	}

	/**
	 *
	 * @param charisma
	 * @see org.jlobato.gpro.driver.IDriver#setCharisma(int)
	 */
	public void setCharisma(int charisma) {
	}

	/**
	 *
	 * @param concentration
	 * @see org.jlobato.gpro.driver.IDriver#setConcentration(int)
	 */
	public void setConcentration(int concentration) {
	}

	/**
	 *
	 * @param experience
	 * @see org.jlobato.gpro.driver.IDriver#setExperience(int)
	 */
	public void setExperience(int experience) {
	}

	/**
	 *
	 * @param motivation
	 * @see org.jlobato.gpro.driver.IDriver#setMotivation(int)
	 */
	public void setMotivation(int motivation) {
	}

	/**
	 *
	 * @param name
	 * @see org.jlobato.gpro.driver.IDriver#setName(java.lang.String)
	 */
	public void setName(String name) {
	}

	/**
	 *
	 * @param nationality
	 * @see org.jlobato.gpro.driver.IDriver#setNationality(java.lang.String)
	 */
	public void setNationality(String nationality) {
	}

	/**
	 *
	 * @param reputation
	 * @see org.jlobato.gpro.driver.IDriver#setReputation(int)
	 */
	public void setReputation(int reputation) {
	}

	/**
	 *
	 * @param stamina
	 * @see org.jlobato.gpro.driver.IDriver#setStamina(int)
	 */
	public void setStamina(int stamina) {
	}

	/**
	 *
	 * @param talent
	 * @see org.jlobato.gpro.driver.IDriver#setTalent(int)
	 */
	public void setTalent(int talent) {
	}

	/**
	 *
	 * @param techInsight
	 * @see org.jlobato.gpro.driver.IDriver#setTechInsight(int)
	 */
	public void setTechInsight(int techInsight) {
	}

	/**
	 *
	 * @param weight
	 * @see org.jlobato.gpro.driver.IDriver#setWeight(int)
	 */
	public void setWeight(int weight) {
	}

	/**
	 * Siempre devuelve que es menor que el objeto pasado como argumento
	 */
	public int compareTo(Object arg0) {
		return -1;
	}
}
