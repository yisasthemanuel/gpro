package org.jlobato.gpro.driver;

import org.jlobato.gpro.techdirector.ITechnicalDirector;

public interface SetupRangeCalculatorStrategy {
	/**
	 *
	 * @param driver
	 * @return
	 */
	public int calculateDriverSetupRange(IDriver driver);

	/**
	 *
	 * @param driver
	 * @return
	 */
	public int getDriverSetupRange(IDriver driver);

	/**
	 *
	 * @param driver
	 * @param techDirector
	 * @return
	 */
	public int calculateWingsSetupRange(IDriver driver, ITechnicalDirector techDirector);

	/**
	 *
	 * @param driver
	 * @param techDirector
	 * @return
	 */
	public int calculateEngineSetupRange(IDriver driver, ITechnicalDirector techDirector);

	/**
	 *
	 * @param driver
	 * @param techDirector
	 * @return
	 */
	public int calculateBrakesSetupRange(IDriver driver, ITechnicalDirector techDirector);

	/**
	 *
	 * @param driver
	 * @param techDirector
	 * @return
	 */
	public int calculateGearboxSetupRange(IDriver driver, ITechnicalDirector techDirector);

	/**
	 *
	 * @param driver
	 * @param techDirector
	 * @return
	 */
	public int calculateSuspensionSetupRange(IDriver driver, ITechnicalDirector techDirector);
}
