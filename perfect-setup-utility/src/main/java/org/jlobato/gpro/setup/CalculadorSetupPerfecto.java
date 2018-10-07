package org.jlobato.gpro.setup;

import org.jlobato.gpro.driver.IDriver;
import org.jlobato.gpro.techdirector.ITechnicalDirector;

/**
 *
 * @author JLOBATO
 *
 */
public interface CalculadorSetupPerfecto {
	/**
	 *
	 * @param practiceLap
	 * @param driver
	 * @param techDirector
	 * @return
	 */
	public CarSetup getNextCarSetup(PracticeLap practiceLap, IDriver driver, ITechnicalDirector techDirector);

	/**
	 *
	 * @param session
	 * @param driver
	 * @param techDirector
	 * @return
	 * @throws CalculadorSetupPerfectoException
	 */
	public CarSetup getPerfectSetup(PracticeSession session, IDriver driver, ITechnicalDirector techDirector) throws CalculadorSetupPerfectoException;

	/**
	 *
	 * @param session
	 * @param driver
	 * @param techDirector
	 * @return
	 */
	public CarFringe getCarFringe(PracticeSession session, IDriver driver, ITechnicalDirector techDirector);
}
