package org.jlobato.gpro.driver;

/**
 * Interfaz que han de cumplir todas la implementaciones que calculen el
 * Overall de un piloto (Driver OA)
 * 
 * @author JLOBATO
 *
 */
public interface DriverOverallCalculatorStrategy {
	
	/**
	 * Cálculo del OA en función de todas las características del piloto
	 * 
	 * @param driver Características del piloto
	 * @return Devuelve un entero con el nivel correspondiente del piloto
	 */
	public int calculateOverall(IDriver driver);
	
	/**
	 * Cálculo del OA sin tener en cuenta la motivación del piloto 
	 * 
	 * @param driver Características del piloto
	 * @return Devuelve un entero con el nivel correspondiente del piloto
	 */
	public int calculateOverallNoMotivation(IDriver driver);
}
