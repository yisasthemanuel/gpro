package org.jlobato.gpro.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jlobato.gpro.dao.mybatis.facade.FachadaManager;
import org.jlobato.gpro.dao.mybatis.facade.FachadaManagerResultService;
import org.jlobato.gpro.dao.mybatis.facade.FachadaSeason;
import org.jlobato.gpro.dao.mybatis.model.Race;
import org.jlobato.gpro.xbean.results.ManagerResults;
import org.jlobato.gpro.xbean.Manager;
import org.jlobato.gpro.xbean.results.ManagerResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicios relacionados con los managers
 * 
 * @author JLOBATO
 *
 */
@Service
public class ManagerService implements IManagerService {
	
	@Autowired
	private FachadaManagerResultService resultsService;
	
	@Autowired
	private FachadaManager managerService;
	
	@Autowired
	private FachadaSeason seasonService;

	/**
	 * Devuelve la lista de todos los managers de la aplicación
	 */
	public List<Manager> findAll() {
		ArrayList<Manager> result = new ArrayList<>();
		result.add(new Manager("JESUS", "Jesús Pérez"));
		result.add(new Manager("MIKKO", "Mikko Suhonen"));
		return result;
	}

	/**
	 * 
	 */
	public void putResults(ManagerResults results) {
		Race race = seasonService.getRace(results.getIdSeason(), results.getIdRace());
		for (Iterator<ManagerResult> managerResults = results.getResults().iterator(); managerResults.hasNext();) {
			ManagerResult managerResult = managerResults.next();
			org.jlobato.gpro.dao.mybatis.model.Manager manager = managerService.getManagerByCode(managerResult.getCodeManager());
			
			resultsService.updateManagerResult(manager,
					race,
					(managerResult.getGridPosition() == 0) ? null : new Short((short)managerResult.getGridPosition()),
					(managerResult.getRacePosition() == 0) ? null : new Short((short)managerResult.getRacePosition())
				);
		}
	}

}
