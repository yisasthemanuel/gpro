package org.jlobato.gpro.dao.mybatis.facade;

import java.util.List;

import org.jlobato.gpro.dao.mybatis.mappers.ManagerResultMapper;
import org.jlobato.gpro.dao.mybatis.model.Manager;
import org.jlobato.gpro.dao.mybatis.model.ManagerResult;
import org.jlobato.gpro.dao.mybatis.model.ManagerResultExample;
import org.jlobato.gpro.dao.mybatis.model.Race;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
/**
 * 
 * @author JLOBATO
 *
 */
public class FachadaManagerResultService {
	
	@Autowired
	protected ManagerResultMapper managerResultDAO;
	
	/**
	 * 
	 * @param manager
	 * @param race
	 * @param gridPosition
	 * @param racePosition
	 */
	public void updateManagerResult(Manager manager, Race race, Short gridPosition, Short racePosition) {
		ManagerResult theResult = findManagerResult(manager, race);
		if (theResult == null) {
			//Creamos el registro
			theResult = new ManagerResult().withIdManager(manager.getIdManager())
					.withIdRace(race.getIdRace())
					.withIdSeason(race.getIdSeason())
					.withGridPosition(gridPosition)
					.withRacePosition(racePosition);
			managerResultDAO.insert(theResult);
		}
		else {
			//Actualizamos
			theResult.withGridPosition(gridPosition).withRacePosition(racePosition);
			managerResultDAO.updateByPrimaryKey(theResult);
		}
	}
	
	/**
	 * 
	 * @param manager
	 * @param race
	 * @return
	 */
	public ManagerResult findManagerResult(Manager manager, Race race) {
		ManagerResult result = null;
		ManagerResultExample example = new ManagerResultExample();
		example.createCriteria().andIdRaceEqualTo(race.getIdRace()).andIdSeasonEqualTo(race.getIdSeason()).andIdManagerEqualTo(manager.getIdManager());
		List<ManagerResult> results = managerResultDAO.selectByExample(example);
		if (!results.isEmpty()) {
			result = results.get(0);
		}
		return result;
		
	}
	
	/**
	 * 
	 * @param manager
	 * @param race
	 */
	public void deleteManagerResult(Manager manager, Race race) {
		ManagerResultExample example = new ManagerResultExample();
		example.createCriteria().andIdRaceEqualTo(race.getIdRace()).andIdSeasonEqualTo(race.getIdSeason()).andIdManagerEqualTo(manager.getIdManager());
		managerResultDAO.deleteByExample(example);
	}

}
