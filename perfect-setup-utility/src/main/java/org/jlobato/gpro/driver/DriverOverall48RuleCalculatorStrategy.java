package org.jlobato.gpro.driver;


public class DriverOverall48RuleCalculatorStrategy implements
		DriverOverallCalculatorStrategy {

	public static final double CONCENTRATION_WEIGHT = 8.0 / 48.0;
	public static final double TALENT_WEIGHT = 12.0 / 48.0;
	public static final double AGGRESSIVENESS_WEIGHT = 7.0 / 48.0;
	public static final double EXPERIENCE_WEIGHT = 4.0 / 48.0;
	public static final double TECHINSIGHT_WEIGHT = 6.0 / 48.0;
	public static final double STAMINA_WEIGHT = 7.0 / 48.0;
	public static final double CHARISMA_WEIGHT = 4.0 / 48.0;
	public static final double MOTIVATION_WEIGHT = 4.0 / 48.0;
	public static final double WEIGHT_WEIGHT = -4.0 / 48.0;


	public int calculateOverall(IDriver driver) {
		int result = 0;
		if (driver != null) {
			double total = getOverallDouble(driver);
			result = (int)Math.round(total);
		}
		return result;
	}


	public int calculateOverallNoMotivation(IDriver driver) {
		int result = 0;
		if (driver != null) {
			double total = getOverallDoubleNoMotivation(driver);
			result = (int)Math.round(total);
		}
		return result;
	}

	private double getOverallDoubleNoMotivation(IDriver driver) {
		double result = 0;
		double concentration = driver.getConcentration() * CONCENTRATION_WEIGHT;
		double talent = driver.getTalent() * TALENT_WEIGHT;
		double aggressiveness = driver.getAggressiveness() * AGGRESSIVENESS_WEIGHT;
		double experience = driver.getExperience() * EXPERIENCE_WEIGHT;
		double techInsight = driver.getTechInsight() * TECHINSIGHT_WEIGHT;
		double stamina = driver.getStamina() * STAMINA_WEIGHT;
		double charisma = driver.getCharisma() * CHARISMA_WEIGHT;
		double weight = driver.getWeight() * WEIGHT_WEIGHT;

		result = concentration + talent + aggressiveness + experience + techInsight + stamina + charisma + weight;
		return result;
	}

	private double getOverallDouble(IDriver driver) {
		double result = 0;
		result = getOverallDoubleNoMotivation(driver);
		result += (driver.getMotivation() * MOTIVATION_WEIGHT);
		return result;
	}

}
