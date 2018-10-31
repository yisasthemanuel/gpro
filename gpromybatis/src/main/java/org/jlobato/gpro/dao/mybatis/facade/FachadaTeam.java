package org.jlobato.gpro.dao.mybatis.facade;

import java.util.List;

import org.jlobato.gpro.dao.mybatis.mappers.TeamMapper;
import org.jlobato.gpro.dao.mybatis.model.Team;
import org.jlobato.gpro.dao.mybatis.model.TeamExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Fachada para acceder a los servicios de persistencia relacionados con los equipos de GPRO
 * 
 * @author JLOBATO
 *
 */
@Service
@Transactional
public class FachadaTeam {

	/**
	 * 
	 */
	private static final transient Logger logger = LoggerFactory.getLogger(FachadaTeam.class);
	
    @Autowired
    protected TeamMapper teamDAO;
    
    /**
     * Devuelve el equipo por defecto: Gulf Porsche Racing
     * 
     * @return
     */
    public Team getDefaultTeam() {
    	logger.debug("Obteniendo el equipo por defecto");
    	Team result = null;
    	
    	TeamExample example = new TeamExample();
    	example.createCriteria().andCodeTeamEqualTo("GPR");
    	
    	List<Team> teams = teamDAO.selectByExample(example);
    	if (!teams.isEmpty()) {
    		result = teams.get(0);
    	}
    	logger.debug("Equipo por defecto devuelto: " + result.getTeamName());    	
    	return result;
    }
    
    /**
     * 
     * @param userId
     * @return
     */
    public List<Team> getAvailableTeams(String userId) {
    	return null;
    }
}
