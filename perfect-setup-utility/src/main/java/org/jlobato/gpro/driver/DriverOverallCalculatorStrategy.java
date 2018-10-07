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
	 * C�lculo del OA en funci�n de todas las caracter�sticas del piloto
	 * 
	 * @param driver Caracter�sticas del piloto
	 * @return Devuelve un entero con el nivel correspondiente del piloto
	 */
	public int calculateOverall(IDriver driver);
	
	/**
	 * C�lculo del OA sin tener en cuenta la motivaci�n del piloto 
	 * 
	 * @param driver Caracter�sticas del piloto
	 * @return Devuelve un entero con el nivel correspondiente del piloto
	 */
	public int calculateOverallNoMotivation(IDriver driver);
}
