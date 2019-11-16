package org.jlobato.gpro.dao.mybatis.facade;

import java.util.List;

import org.jlobato.gpro.dao.mybatis.mappers.ManagerHistoryMapper;
import org.jlobato.gpro.dao.mybatis.mappers.ManagerMapper;
import org.jlobato.gpro.dao.mybatis.mappers.ManagerTeamHistoryMapper;
import org.jlobato.gpro.dao.mybatis.model.Manager;
import org.jlobato.gpro.dao.mybatis.model.ManagerExample;
import org.jlobato.gpro.dao.mybatis.model.ManagerHistory;
import org.jlobato.gpro.dao.mybatis.model.ManagerHistoryExample;
import org.jlobato.gpro.dao.mybatis.model.ManagerTeamHistory;
import org.jlobato.gpro.dao.mybatis.model.ManagerTeamHistoryExample;
import org.jlobato.gpro.dao.mybatis.model.Race;
import org.jlobato.gpro.dao.mybatis.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author JLOBATO
 *
 */
@Repository
@Transactional
public class FachadaManager {
	
    @Autowired
    protected ManagerMapper managerDAO;
    
    @Autowired
    protected ManagerHistoryMapper managerHistoryDAO;
    
    @Autowired
    protected ManagerTeamHistoryMapper managerTeamHistoryDAO;
	
	/**
	 * 
	 * @return
	 */
	public List<Manager> getManagersList() {
		ManagerExample managerExample = new ManagerExample();
		managerExample.setOrderByClause("first_name, last_name");
		
		return managerDAO.selectByExample(managerExample);
	}
	
	/**
	 * 
	 * @param idManager
	 * @return
	 */
	public Manager getManager(Short idManager) {
		Manager result = null;
		if (idManager != null) {
			result = managerDAO.selectByPrimaryKey(idManager);
		}
		return result;
	}
	
	/**
	 * 
	 * @param codManager
	 * @return
	 */
	public Manager getManagerByCode(String codManager) {
		Manager result = null;
		ManagerExample managerExample = new ManagerExample();
		managerExample.createCriteria().andCodeManagerEqualTo(codManager);
		
		List<Manager> managers = managerDAO.selectByExample(managerExample);
		if (!managers.isEmpty()) {
			result = managers.get(0);
		}
		
		return result;
	}
	
	/**
	 * 
	 * @param record
	 * @return
	 */
	public Manager addManager(Manager record) {
		managerDAO.insert(record);
		return record;
	}
	
	/**
	 * 
	 * @param codeManager
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	public Manager addManager(String codeManager, String firstName, String lastName) {
		Manager result = new Manager().withCodeManager(codeManager).withFirstName(firstName).withLastName(lastName);
		return addManager(result);
	}
	
	/**
	 * 
	 * @param codeManager
	 * @param avatar
	 * @return
	 */
	public Manager setManagerAvatar(String codeManager, byte[] avatar) {
		Manager manager = getManagerByCode(codeManager);
		manager.setAvatarImg(avatar);
		managerDAO.updateByPrimaryKeyWithBLOBs(manager);
		return manager;
	}

	/**
	 * 
	 * @param codeManager
	 * @param idCategory
	 * @param idGroup
	 * @param idSeason
	 * @param idTyreBrand
	 */
	public void addManagerHistory(String codeManager, Short idCategory, Short idGroup, Short idSeason, Short idTyreBrand) {
		ManagerHistory record = new ManagerHistory()
				.withIdCategory(idCategory)
				.withIdGroup(idGroup)
				.withIdSeason(idSeason)
				.withIdTyreBrand(idTyreBrand);
		addManagerHistory(getManagerByCode(codeManager), record);
	}

	/**
	 * 
	 * @param manager
	 * @param record
	 */
	public void addManagerHistory(Manager manager, ManagerHistory record) {
		addManagerHistory(record.withIdManager(manager.getIdManager()));
	}
	
	/**
	 * 
	 * @param record
	 */
	public void addManagerHistory(ManagerHistory record) {
		managerHistoryDAO.insert(record);
	}

	/**
	 * 
	 * @param codeManager
	 * @param idSeason
	 * @param idCategory
	 * @param idGroup
	 * @param idTyreBrand
	 * @param position
	 * @param wins
	 * @param cup
	 * @param fastestLaps
	 * @param moneyBalance
	 * @param obr
	 * @param podiums
	 * @param points
	 * @param poles
	 * @param races
	 */
	public void updateManagerHistory(String codeManager,
			Short idSeason,
			Short idCategory,
			Short idGroup,
			Short idTyreBrand,
			Short position,
			Short wins,
			String cup,
			Short fastestLaps,
			Long moneyBalance,
			Short obr,
			Short podiums,
			Short points,
			Short poles,
			Short races) {
		//Buscamos si existe registro ya para ese manager y temporada
		Short idManager = getManagerByCode(codeManager).getIdManager();
		List<ManagerHistory> records = getManagerHistory(idManager, idSeason);
		if (records.isEmpty()) {
			//Insertamos
			ManagerHistory record = new ManagerHistory()
					.withIdManager(idManager)
					.withIdSeason(idSeason)
					.withIdCategory(idCategory)
					.withIdGroup(idGroup)
					.withIdTyreBrand(idTyreBrand)
					.withPosition(position)
					.withWins(wins)
					.withCup(cup)
					.withFastestLaps(fastestLaps)
					.withMoneyBalance(moneyBalance) //Money balance no debería ser short
					.withObr(obr)
					.withPodiums(podiums)
					.withPoints(points)
					.withPoles(poles)
					.withRaces(races);
			managerHistoryDAO.insert(record);
		}
		else {
			//Actualizamos el existente
			records.forEach(record -> {
				record.withIdCategory(idCategory)
					.withIdGroup(idGroup)
					.withIdTyreBrand(idTyreBrand)
					.withPosition(position)
					.withWins(wins)
					.withCup(cup)
					.withFastestLaps(fastestLaps)
					.withMoneyBalance(moneyBalance) //Money balance no debería ser short
					.withObr(obr)
					.withPodiums(podiums)
					.withPoints(points)
					.withPoles(poles)
					.withRaces(races);
				managerHistoryDAO.updateByPrimaryKey(record);
			});
		}

		
	}
	
	/**
	 * 
	 * @param idManager
	 * @param idSeason
	 * @return
	 */
	public List<ManagerHistory> getManagerHistory(Short idManager, Short idSeason) {
		ManagerHistoryExample example = new ManagerHistoryExample();
		example.createCriteria()
				.andIdManagerEqualTo(idManager)
				.andIdSeasonEqualTo(idSeason);
		List<ManagerHistory> records = managerHistoryDAO.selectByExample(example);
		return records;
	}
	
	/**
	 * 
	 * @param record
	 */
	public void updateManagerHistory(ManagerHistory record) {
		managerHistoryDAO.updateByPrimaryKey(record);
	}
	
	/**
	 * 
	 * @param team
	 * @param race
	 */
	public List<ManagerTeamHistory> getManagers(Team team, Race race) {
//		List<Manager> result = null;
		
		ManagerTeamHistoryExample example = new ManagerTeamHistoryExample();
		
		//Criterio 1
		example.createCriteria()
			.andIdTeamEqualTo(team.getIdTeam()) //Que pertenezcan al equipo
			.andIdSeasonStartLessThan(race.getIdSeason()) //Que empezaron en una temporada anterior a la pasada
			.andIdSeasonEndIsNull() //Que siguen en el equipo
			.andIdRaceEndIsNull(); //Que siguen en el equipo
		
		//Criterio 2
		example.or()
			.andIdTeamEqualTo(team.getIdTeam()) //Que pertenezcan al equipo
			.andIdSeasonStartEqualTo(race.getIdSeason()) //Que empezaron en la misma temporada
			.andIdRaceStartLessThanOrEqualTo(race.getIdRace()) //Y en una carrera igual o anterior de la temporada
			.andIdSeasonEndIsNull() //Que siguen en el equipo
			.andIdRaceEndIsNull(); //Que siguen en el equipo
	
		//Criterio 3
		example.or()
			.andIdTeamEqualTo(team.getIdTeam()) //Que pertenezcan al equipo
			.andIdSeasonStartLessThan(race.getIdSeason()) //Que empezaron en una temporada anterior a la pasada
			.andIdSeasonEndIsNotNull() //Que dejaron el equipo
			.andIdRaceEndIsNotNull() //Que dejaron el equipo
			.andIdSeasonEndGreaterThan(race.getIdSeason()); //Pero en una temporada posterior a la solicitada
		
		//Criterio 4
		example.or()
			.andIdTeamEqualTo(team.getIdTeam()) //Que pertenezcan al equipo
			.andIdSeasonStartLessThan(race.getIdSeason()) //Que empezaron en una temporada anterior a la pasada
			.andIdSeasonEndIsNotNull() //Que dejaron el equipo
			.andIdRaceEndIsNotNull() //Que dejaron el equipo
			.andIdSeasonEndEqualTo(race.getIdSeason())  //En la misma temporada a la solicitada
			.andIdRaceEndGreaterThan(race.getIdRace()); //Pero en una carrera posterior a la solicitada
		
		
		//Criterio 5
		example.or()
			.andIdTeamEqualTo(team.getIdTeam()) //Que pertenezcan al equipo
			.andIdSeasonStartEqualTo(race.getIdSeason()) //Que empezaron en la misma temporada
			.andIdRaceStartLessThanOrEqualTo(race.getIdRace()) //Y en una carrera igual o anterior de la temporada
			.andIdSeasonEndIsNotNull() //Que dejaron el equipo
			.andIdRaceEndIsNotNull() //Que dejaron el equipo
			.andIdSeasonEndGreaterThan(race.getIdSeason()); //Pero en una temporada posterior a la solicitada
		
		//Criterio 6
		example.or()
			.andIdTeamEqualTo(team.getIdTeam()) //Que pertenezcan al equipo
			.andIdSeasonStartEqualTo(race.getIdSeason()) //Que empezaron en la misma temporada
			.andIdRaceStartLessThanOrEqualTo(race.getIdRace()) //Y en una carrera igual o anterior de la temporada
			.andIdSeasonEndIsNotNull() //Que dejaron el equipo
			.andIdRaceEndIsNotNull() //Que dejaron el equipo
			.andIdSeasonEndEqualTo(race.getIdSeason())  //En la misma temporada a la solicitada
			.andIdRaceEndGreaterThan(race.getIdRace()); //Pero en una carrera posterior a la solicitada	
		
		List<ManagerTeamHistory> histories = managerTeamHistoryDAO.selectByExample(example);
		
		for (ManagerTeamHistory history : histories) {
			history.getIdManager();
		}
		
		return histories;
	}
}
