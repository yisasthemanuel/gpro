package org.jlobato.gpro.services;

import java.util.ArrayList;
import java.util.List;

import org.jlobato.gpro.xbean.Manager;

/**
 * Servicios relacionados con los managers
 * 
 * @author JLOBATO
 *
 */
public class ManagerService implements IManagerService {

	/**
	 * Devuelve la lista de todos los managers de la aplicación
	 */
	public List findAll() {
		ArrayList result = new ArrayList<>();
		result.add(new Manager("JESUS", "Jesús Pérez"));
		result.add(new Manager("MIKKO", "Mikko Suhonen"));
		return result;
	}

}
