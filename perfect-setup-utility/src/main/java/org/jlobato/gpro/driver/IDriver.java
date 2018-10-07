package org.jlobato.gpro.driver;

import java.beans.PropertyChangeListener;
import java.io.Serializable;

public interface IDriver extends Serializable, Comparable {

	public static final String TECH_INSIGHT_PROPERTY = "techInsight";
	public static final String EXPERIENCE_PROPERTY = "experience";
	public static final String CONCENTRATION_PROPERTY = "concentration";
	public static final String TALENT_PROPERTY = "talent";
	public static final String AGGRESSIVENESS_PROPERTY = "aggressiveness";
	public static final String STAMINA_PROPERTY = "stamina";
	public static final String CHARISMA_PROPERTY = "charisma";
	public static final String MOTIVATION_PROPERTY = "motivation";
	public static final String WEIGHT_PROPERTY = "weight";
	public static final String NAME_PROPERTY = "name";
	public static final String REPUTATION_PROPERTY = "reputation";
	public static final String AGE_PROPERTY = "age";
	public static final String NATIONALITY_PROPERTY = "nationality";

	/**
	 * @return the name
	 */
	public String getName();

	/**
	 * @param name the name to set
	 */
	public void setName(String name);

	/**
	 * @return the concentration
	 */
	public int getConcentration();

	/**
	 * @param concentration the concentration to set
	 */
	public void setConcentration(int concentration);

	/**
	 * @return the talent
	 */
	public int getTalent();

	/**
	 * @param talent the talent to set
	 */
	public void setTalent(int talent);

	/**
	 * @return the experience
	 */
	public int getExperience();

	/**
	 * @param experience the experience to set
	 */
	public void setExperience(int experience);

	/**
	 * @return the techInsight
	 */
	public int getTechInsight();

	/**
	 * @param techInsight the techInsight to set
	 */
	public void setTechInsight(int techInsight);

	/**
	 * @return the aggressiveness
	 */
	public int getAggressiveness();

	/**
	 * @param aggressiveness the aggressiveness to set
	 */
	public void setAggressiveness(int aggressiveness);

	/**
	 * @return the stamina
	 */
	public int getStamina();

	/**
	 * @param stamina the stamina to set
	 */
	public void setStamina(int stamina);

	/**
	 * @return the motivation
	 */
	public int getMotivation();

	/**
	 * @param motivation the motivation to set
	 */
	public void setMotivation(int motivation);

	/**
	 * @return the reputation
	 */
	public int getReputation();

	/**
	 * @param reputation the reputation to set
	 */
	public void setReputation(int reputation);

	/**
	 * @return the age
	 */
	public int getAge();

	/**
	 * @param age the age to set
	 */
	public void setAge(int age);

	/**
	 * @return the weight
	 */
	public int getWeight();

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight);

	/**
	 * @return the charisma
	 */
	public int getCharisma();

	/**
	 * @param charisma the charisma to set
	 */
	public void setCharisma(int charisma);

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
	 * @return
	 */
	public int getOverall();

	/**
	 *
	 * @return
	 */
	public int getSetupRange();

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