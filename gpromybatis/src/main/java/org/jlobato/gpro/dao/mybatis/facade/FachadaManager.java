package org.jlobato.gpro.dao.mybatis.facade;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
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
     */
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /**
     * 
     * @param namedParameterJdbcTemplate
     */
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
    	this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

	
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
		
		return managerHistoryDAO.selectByExample(example);
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
	public List<Manager> getManagersOld(Team team, Race race) {
		List<Manager> result = new ArrayList<>();
		
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
			Short idManager = history.getIdManager();
			Manager theManager = managerDAO.selectByPrimaryKey(idManager);
			result.add(theManager);
		}
		return result;
	}
	
    /**
     * 
     * @param season
     * @return
     */
    public List<Manager> getManagers(Team team, Race race) {
        
    	
    	
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();

        mapSqlParameterSource.addValue("team", team.getIdTeam());
        mapSqlParameterSource.addValue("season", race.getIdSeason());
        mapSqlParameterSource.addValue("race", race.getIdRace());

        return namedParameterJdbcTemplate.query(
        		SELECT_MANAGERS_RESULTS,
        		mapSqlParameterSource,
        		new RowMapper<Manager>() {
        			public Manager mapRow(ResultSet rs, int rowNum) throws SQLException {
        				return managerDAO.selectByPrimaryKey(rs.getShort("id_manager"));
        			}
        		});
    }
	
	
	private static final String SELECT_MANAGERS_RESULTS = "select " + 
	"mh.id_manager, " + 
	"mh.id_category, " + 
	"case " + 
	"when mh.id_group is null then 1 " + 
	"else mh.id_group end as m_group, " + 
	"mh.position, " + 
	"m.code_manager, " + 
	"m.first_name, " + 
	"m.last_name " + 
	"from " + 
	"( " + 
	"select " + 
	"mth.id_manager " + 
	"from " + 
	"manager_team_history mth " + 
	"where " + 
	"(mth.id_team = :team " + 
	"and mth.id_season_start < :season " + 
	"and mth.id_season_end is null " + 
	"and mth.id_race_end is null ) " + 
	"or( mth.id_team = :team " + 
	"and mth.id_season_start = :season " + 
	"and mth.id_race_start <= :race " + 
	"and mth.id_season_end is null " + 
	"and mth.id_race_end is null ) " + 
	"or( mth.id_team = :team " + 
	"and mth.id_season_start < :season " + 
	"and mth.id_season_end is not null " + 
	"and mth.id_race_end is not null " + 
	"and mth.id_season_end > :season ) " + 
	"or( mth.id_team = :team " + 
	"and mth.id_season_start < :season " + 
	"and mth.id_season_end is not null " + 
	"and mth.id_race_end is not null " + 
	"and mth.id_season_end = :season " + 
	"and mth.id_race_end > :race ) " + 
	"or( mth.id_team = :team " + 
	"and mth.id_season_start = :season " + 
	"and mth.id_race_start <= :race " + 
	"and mth.id_season_end is not null " + 
	"and mth.id_race_end is not null " + 
	"and mth.id_season_end > :season ) " + 
	"or( mth.id_team = :team " + 
	"and mth.id_season_start = :season " + 
	"and mth.id_race_start <= :race " + 
	"and mth.id_season_end is not null " + 
	"and mth.id_race_end is not null " + 
	"and mth.id_season_end = :season " + 
	"and mth.id_race_end > :race) ) mth, " + 
	"manager_history mh, " + 
	"manager m " + 
	"where " + 
	"mh.id_manager = mth.id_manager " + 
	"and mh.id_season = :season " + 
	"and m.id_manager = mh.id_manager " + 
	"order by " + 
	"mh.id_category, " + 
	"m_group, " + 
	"mh.\"position\" ";
}
