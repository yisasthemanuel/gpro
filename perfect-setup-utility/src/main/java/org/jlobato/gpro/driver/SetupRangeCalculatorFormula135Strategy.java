package org.jlobato.gpro.driver;

import org.jlobato.gpro.techdirector.ITechnicalDirector;
import org.jlobato.gpro.techdirector.TechnicalDirectorConstants;

public class SetupRangeCalculatorFormula135Strategy implements SetupRangeCalculatorStrategy {

	/**
	 *
	 * @param driver
	 * @return
	 * @see org.jlobato.gpro.driver.SetupRangeCalculatorStrategy#calculateDriverSetupRange(org.jlobato.gpro.driver.IDriver)
	 */
	public int calculateDriverSetupRange(IDriver driver) {
		return (int)Math.round(getInternalDriverSetupRange(driver) / 2.0);
		//return (int)Math.round((DriverConstants.SETUP_DELTA - (driver.getExperience() * DriverConstants.EXPERIENCE_WEIGHT) - (driver.getTechInsight() * DriverConstants.TECHINSIGHT_WEIGHT)) / 2.0);
	}

	/**
	 *
	 * @param driver
	 * @return
	 */
	private double getInternalDriverSetupRange(IDriver driver) {
		return (DriverConstants.SETUP_DELTA - (driver.getExperience() * DriverConstants.EXPERIENCE_WEIGHT) - (driver.getTechInsight() * DriverConstants.TECHINSIGHT_WEIGHT));
	}

	/**
	 *
	 * @param techDirector
	 * @return
	 */
	private double getInternalTDWingsSetupDelta(ITechnicalDirector techDirector) {
		double result = 0.0;
		if (techDirector != null) {
			result = (TechnicalDirectorConstants.WINGS_EXPERIENCE_WEIGHT * techDirector.getExperience())
					+ (TechnicalDirectorConstants.WINGS_AERO_WEIGHT * techDirector.getAerodynamics());
		}
		//Esta sería la suya realmente, pero la de arriba es más eficiente y sencilla de entender
		//result = (TechnicalDirectorConstants.WINGS_EXPERIENCE_WEIGHT * ((techDirector != null) ? techDirector.getExperience() : 0.0) + (TechnicalDirectorConstants.WINGS_AERO_WEIGHT * ((techDirector != null) ? techDirector.getAerodynamics() : 0.0)));
		return result;
	}

	/**
	 *
	 * @param techDirector
	 * @return
	 */
	private double getInternalTDEngineSetupDelta(ITechnicalDirector techDirector) {
		double result = 0.0;
		if (techDirector != null) {
			result = (TechnicalDirectorConstants.ENGINE_EXPERIENCE_WEIGHT * techDirector.getExperience())
					+ (TechnicalDirectorConstants.ENGINE_ELECTRO_WEIGHT * techDirector.getElectronics())
					+ (TechnicalDirectorConstants.ENGINE_MECH_WEIGHT * techDirector.getMechanics());
		}
		return result;
	}

	/**
	 *
	 * @param techDirector
	 * @return
	 */
	private double getInternalTDBrakesSetupDelta(ITechnicalDirector techDirector) {
		double result = 0.0;
		if (techDirector != null) {
			result = (TechnicalDirectorConstants.BRAKES_EXPERIENCE_WEIGHT * techDirector.getExperience())
					+ (TechnicalDirectorConstants.BRAKES_ELECTRO_WEIGHT * techDirector.getElectronics())
					+ (TechnicalDirectorConstants.BRAKES_MECH_WEIGHT * techDirector.getMechanics())
					+ (TechnicalDirectorConstants.BRAKES_AERO_WEIGHT * techDirector.getAerodynamics());
		}
		return result;
	}

	/**
	 *
	 * @param techDirector
	 * @return
	 */
	private double getInternalTDGearboxSetupDelta(ITechnicalDirector techDirector) {
		double result = 0.0;
		if (techDirector != null) {
			result = (TechnicalDirectorConstants.GEARBOX_EXPERIENCE_WEIGHT * techDirector.getExperience())
					+ (TechnicalDirectorConstants.GEARBOX_ELECTRO_WEIGHT * techDirector.getElectronics())
					+ (TechnicalDirectorConstants.GEARBOX_MECH_WEIGHT * techDirector.getMechanics());
		}
		return result;
	}

	/**
	 *
	 * @param techDirector
	 * @return
	 */
	private double getInternalTDSuspensionSetupDelta(ITechnicalDirector techDirector) {
		double result = 0.0;
		if (techDirector != null) {
			result = (TechnicalDirectorConstants.SUSPENSION_EXPERIENCE_WEIGHT * techDirector.getExperience())
					+ (TechnicalDirectorConstants.SUSPENSION_AERO_WEIGHT * techDirector.getElectronics())
					+ (TechnicalDirectorConstants.SUSPENSION_MECH_WEIGHT * techDirector.getMechanics());
		}
		return result;
	}

	/**
	 *
	 * @param driver
	 * @param techDirector
	 * @return
	 * @see org.jlobato.gpro.driver.SetupRangeCalculatorStrategy#calculateWingsSetupRange(org.jlobato.gpro.driver.IDriver, org.jlobato.gpro.techdirector.ITechnicalDirector)
	 */
	public int calculateWingsSetupRange(IDriver driver, ITechnicalDirector techDirector) {
		double wingsRange = getInternalDriverSetupRange(driver) - getInternalTDWingsSetupDelta(techDirector);
		return (int)Math.round(wingsRange / 2.0);
	}

	/**
	 *
	 * @param driver
	 * @param techDirector
	 * @return
	 * @see org.jlobato.gpro.driver.SetupRangeCalculatorStrategy#calculateEngineSetupRange(org.jlobato.gpro.driver.IDriver, org.jlobato.gpro.techdirector.ITechnicalDirector)
	 */
	public int calculateEngineSetupRange(IDriver driver, ITechnicalDirector techDirector) {
		double engineRange = getInternalDriverSetupRange(driver) - getInternalTDEngineSetupDelta(techDirector);
		return (int)Math.round(engineRange / 2.0);
	}

	/**
	 *
	 * @param driver
	 * @param techDirector
	 * @return
	 * @see org.jlobato.gpro.driver.SetupRangeCalculatorStrategy#calculateBrakesSetupRange(org.jlobato.gpro.driver.IDriver, org.jlobato.gpro.techdirector.ITechnicalDirector)
	 */
	public int calculateBrakesSetupRange(IDriver driver, ITechnicalDirector techDirector) {
		double brakesRange = getInternalDriverSetupRange(driver) - getInternalTDBrakesSetupDelta(techDirector);
		return (int)Math.round(brakesRange / 2.0);
	}

	/**
	 *
	 * @param driver
	 * @param techDirector
	 * @return
	 * @see org.jlobato.gpro.driver.SetupRangeCalculatorStrategy#calculateGearboxSetupRange(org.jlobato.gpro.driver.IDriver, org.jlobato.gpro.techdirector.ITechnicalDirector)
	 */
	public int calculateGearboxSetupRange(IDriver driver, ITechnicalDirector techDirector) {
		double gearboxRange = getInternalDriverSetupRange(driver) - getInternalTDGearboxSetupDelta(techDirector);
		return (int)Math.round(gearboxRange / 2.0);
	}

	/**
	 *
	 * @param driver
	 * @param techDirector
	 * @return
	 * @see org.jlobato.gpro.driver.SetupRangeCalculatorStrategy#calculateSuspensionSetupRange(org.jlobato.gpro.driver.IDriver, org.jlobato.gpro.techdirector.ITechnicalDirector)
	 */
	public int calculateSuspensionSetupRange(IDriver driver, ITechnicalDirector techDirector) {
		double suspensionRange = getInternalDriverSetupRange(driver) - getInternalTDSuspensionSetupDelta(techDirector);
		return (int)Math.round(suspensionRange / 2.0);
	}

	/**
	 *
	 * @param driver
	 * @return
	 * @see org.jlobato.gpro.driver.SetupRangeCalculatorStrategy#getDriverSetupRange(org.jlobato.gpro.driver.IDriver)
	 */
	public int getDriverSetupRange(IDriver driver) {
		return (int)Math.round(getInternalDriverSetupRange(driver));
	}

}
