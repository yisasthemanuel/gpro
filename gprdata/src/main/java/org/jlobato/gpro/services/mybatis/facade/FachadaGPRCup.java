package org.jlobato.gpro.services.mybatis.facade;

import java.util.List;

import org.jlobato.gpro.dao.mybatis.mappers.CupStandingsSnapshotMapper;
import org.jlobato.gpro.dao.mybatis.mappers.TeamMapper;
import org.jlobato.gpro.dao.mybatis.model.CupStandingsSnapshot;
import org.jlobato.gpro.dao.mybatis.model.CupStandingsSnapshotKey;
import org.jlobato.gpro.dao.mybatis.model.Season;
import org.jlobato.gpro.dao.mybatis.model.Team;
import org.jlobato.gpro.dao.mybatis.model.TeamExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FachadaGPRCup {
	
    @Autowired
    protected CupStandingsSnapshotMapper cupStandingsDAO;
    
    @Autowired
    protected TeamMapper teamsDAO;
    
    /**
     * 
     * @param standings
     */
    public void saveStandings(CupStandingsSnapshot standings) {
    	//Primero vemos si existe para esta temporada un snapshot
    	CupStandingsSnapshot snapshot = cupStandingsDAO.selectByPrimaryKey(standings);
    	
    	if (snapshot != null) {
    		//Como ya existe, hacemos un update
    		cupStandingsDAO.updateByPrimaryKey(standings);
    	}
    	else {
    		//Como no existe hacemos un insert
    		cupStandingsDAO.insert(standings);
    	}
    	
    }
    
    /**
     * 
     * @return
     */
    public Team getDefaultTeam() {
    	Team result = null;
    	TeamExample teamExample = new TeamExample();
    	teamExample.createCriteria().andCodeTeamEqualTo("GPR");
    	List<Team> teams = teamsDAO.selectByExample(teamExample);
    	if (!teams.isEmpty()) {
    		result = teams.get(0); 
    	}
    	return result;
    }
    
    /**
     * 
     * @param season
     * @param team
     * @return
     */
    public CupStandingsSnapshot getStandings(Season season, Team team) {
    	CupStandingsSnapshotKey pKey = new CupStandingsSnapshotKey();
    	pKey.setIdSeason(season.getIdSeason());
    	pKey.setIdTeam(team.getIdTeam());
    	return cupStandingsDAO.selectByPrimaryKey(pKey);
    }

}
