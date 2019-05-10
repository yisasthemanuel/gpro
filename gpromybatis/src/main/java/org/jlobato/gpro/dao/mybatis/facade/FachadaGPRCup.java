package org.jlobato.gpro.dao.mybatis.facade;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jlobato.gpro.dao.mybatis.mappers.CupStandingsSnapshotMapper;
import org.jlobato.gpro.dao.mybatis.mappers.TeamMapper;
import org.jlobato.gpro.dao.mybatis.model.CupStandingsSnapshot;
import org.jlobato.gpro.dao.mybatis.model.CupStandingsSnapshotKey;
import org.jlobato.gpro.dao.mybatis.model.Season;
import org.jlobato.gpro.dao.mybatis.model.Team;
import org.jlobato.gpro.dao.mybatis.model.TeamExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class FachadaGPRCup {
	
	private static final transient Logger logger = LoggerFactory.getLogger(FachadaGPRCup.class);
	
    @Autowired
    protected CupStandingsSnapshotMapper cupStandingsDAO;
    
    @Autowired
    protected TeamMapper teamsDAO;
    
    /**
     * 
     */
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    
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
     * @return
     */
    public Short getFirstEditionSeason() {
    	//TODO - Mejorarlo para que no se pida cada vez que se navega ya que es un dato que no varía
    	Short result = null;
    	
        List<Short> results = null;
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();

        results = namedParameterJdbcTemplate.query(MINSEASON_QUERY, mapSqlParameterSource, new RowMapper<Short>() {
        	public Short mapRow(ResultSet rs, int rowNum) throws SQLException {
        		return rs.getShort("FIRST_EDITION");
        	}
        });
        
        if (!results.isEmpty()) {
        	result = results.get(0);
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
    
    /**
     * 
     * @param season
     * @return
     */
    public List<Map<String, Object>> getStatistics(Season season) {
    	return getStatistics(season.getIdSeason());
    }
    
    /**
     * 
     * @param season
     * @return
     */
    public List<Map<String, Object>> getStatistics(short season) {
        logger.debug("Se recuperan las estadísticas de la copa celebrada en la temporada " + season);
        
        List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();

        mapSqlParameterSource.addValue("season", season);

        results = namedParameterJdbcTemplate.query(STATS_QUERY, mapSqlParameterSource, new GenericStringRowMapper());
    
    	return results;
    }
    
    /**
     * 
     * @param season
     * @return
     */
    public List<Map<String, Object>> getSeeding(Season season) {
    	return getSeeding(season.getIdSeason());
    }
    
    
    /**
     * 
     * @param season
     * @return
     */
    private List<Map<String, Object>> getSeeding(short season) {
        logger.debug("Se recuperan la semilla para los emparejamientos de la copa celebrada en la temporada " + season);
        
        List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();

        mapSqlParameterSource.addValue("season", season);

        results = namedParameterJdbcTemplate.query(SEED_QUERY, mapSqlParameterSource, new GenericStringRowMapper());
    
    	return results;
	}

	/**
     * 
     * @author jmplobato
     *
     */
    private class GenericStringRowMapper implements RowMapper<Map<String, Object>> {

		@Override
		public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
        	ResultSetMetaData meta = rs.getMetaData();
        	Map<String, Object> result = new HashMap<String, Object>();
        	int columnCount = meta.getColumnCount();
        	for (int i = 1; i <= columnCount; i++) {
        		String columnName = meta.getColumnName(i);
        		result.put(columnName, rs.getObject(columnName));
        		
        	}
        	return result;
		}
    	
    }
    
    /**
     * 
     */
    private static final String MINSEASON_QUERY = "select min(id_season) as FIRST_EDITION from cupstandingsnapshot";
    
    //TODO Mejorar la consulta. Limitar a la carrera número 1 es un chapú   
    /**
     * 
     */
    private static final String SEED_QUERY = "select " + 
    		"m.first_name, " + 
    		"( " + 
    		"select " + 
    		"case when mr1.race_position is null then 'DNS' else cast(mr1.race_position as varchar) end " + 
    		"from " + 
    		"manager_result mr1 " + 
    		"where " + 
    		"mr1.id_manager = m.id_manager " + 
    		"and mr1.id_season = mr.id_season " + 
    		"and mr1.id_race = 1) as r1, " + 
    		"( " + 
    		"select " + 
    		"case when mr2.race_position is null then 'DNS' else cast(mr2.race_position as varchar) end " + 
    		"from " + 
    		"manager_result mr2 " + 
    		"where " + 
    		"mr2.id_manager = m.id_manager " + 
    		"and mr2.id_season = mr.id_season " + 
    		"and mr2.id_race = 2) as r2, " + 
    		"( " + 
    		"select " + 
    		"avg(case when mr3.race_position is null then 41 else mr3.race_position end) " + 
    		"from " + 
    		"manager_result mr3 " + 
    		"where " + 
    		"mr3.id_manager = m.id_manager " + 
    		"and mr3.id_season = mr.id_season " + 
    		"and (mr3.id_race = 2 " + 
    		"or mr3.id_race = 1)) as r3 " + 
    		"from " + 
    		"manager_result mr, " + 
    		"manager m " + 
    		"where " + 
    		"mr.id_season = :season " + 
    		"and mr.id_race = 1 " + 
    		"and mr.id_manager = m.id_manager " + 
    		"order by " + 
    		"r3 ";
       
    
    /**
     * 
     */
    private static final String STATS_QUERY = "select\n" + 
    		"manager,\n" + 
    		"sum( winner ) winner,\n" + 
    		"sum( finalist ) finalist,\n" + 
    		"sum( semifinalist ) semifinalist,\n" + 
    		"sum( knockout ) knockout,\n" + 
    		"sum( participation ) participation,\n" + 
    		"sum( rounds_won ) rounds_won,\n" + 
    		"sum( rounds_played ) rounds_played,\n" + 
    		"sum( score_f1 + score_f2 + score_sf1 + score_sf2 + score_sf3 + score_sf4 + score_qf1 + score_qf2 + score_qf3 + score_qf4 + score_qf5 + score_qf6 + score_qf7 + score_qf8 ) points_earned\n" + 
    		"from\n" + 
    		"(\n" + 
    		"select\n" + 
    		"s.id_season,\n" + 
    		"m.first_name || ' ' || m.last_name as manager,\n" + 
    		"m.id_manager,\n" + 
    		"case when (h.id_season_start = s.id_season) and (h.id_race_start < 3)  then 1\n" + 
    		"when (h.id_season_start <> s.id_season) then 1\n" + 
    		"else 0 end  as participation,\n" + 
    		"case\n" + 
    		"when m.id_manager = cs.id_manager_winner then 1\n" + 
    		"else 0\n" + 
    		"end as winner,\n" + 
    		"case\n" + 
    		"when(\n" + 
    		"m.id_manager = cs.id_manager_fi1\n" + 
    		")\n" + 
    		"or(\n" + 
    		"m.id_manager = cs.id_manager_fi2\n" + 
    		") then 1\n" + 
    		"else 0\n" + 
    		"end as finalist,\n" + 
    		"case\n" + 
    		"when(\n" + 
    		"m.id_manager = cs.id_manager_sf1\n" + 
    		")\n" + 
    		"or(\n" + 
    		"m.id_manager = cs.id_manager_sf2\n" + 
    		")\n" + 
    		"or(\n" + 
    		"m.id_manager = cs.id_manager_sf3\n" + 
    		")\n" + 
    		"or(\n" + 
    		"m.id_manager = cs.id_manager_sf4\n" + 
    		") then 1\n" + 
    		"else 0\n" + 
    		"end as semifinalist,\n" + 
    		"case\n" + 
    		"when(\n" + 
    		"m.id_manager = cs.id_manager_qf1\n" + 
    		")\n" + 
    		"or(\n" + 
    		"m.id_manager = cs.id_manager_qf2\n" + 
    		")\n" + 
    		"or(\n" + 
    		"m.id_manager = cs.id_manager_qf3\n" + 
    		")\n" + 
    		"or(\n" + 
    		"m.id_manager = cs.id_manager_qf4\n" + 
    		")\n" + 
    		"or(\n" + 
    		"m.id_manager = cs.id_manager_qf5\n" + 
    		")\n" + 
    		"or(\n" + 
    		"m.id_manager = cs.id_manager_qf6\n" + 
    		")\n" + 
    		"or(\n" + 
    		"m.id_manager = cs.id_manager_qf7\n" + 
    		")\n" + 
    		"or(\n" + 
    		"m.id_manager = cs.id_manager_qf8\n" + 
    		") then 1\n" + 
    		"else 0\n" + 
    		"end as knockout,\n" + 
    		"case\n" + 
    		"when(\n" + 
    		"m.id_manager = cs.id_manager_winner\n" + 
    		")\n" + 
    		"or(\n" + 
    		"m.id_manager = cs.id_manager_fi1\n" + 
    		")\n" + 
    		"or(\n" + 
    		"m.id_manager = cs.id_manager_fi2\n" + 
    		") then 3\n" + 
    		"when(\n" + 
    		"m.id_manager = cs.id_manager_sf1\n" + 
    		")\n" + 
    		"or(\n" + 
    		"m.id_manager = cs.id_manager_sf2\n" + 
    		")\n" + 
    		"or(\n" + 
    		"m.id_manager = cs.id_manager_sf3\n" + 
    		")\n" + 
    		"or(\n" + 
    		"m.id_manager = cs.id_manager_sf4\n" + 
    		") then 2\n" + 
    		"when(\n" + 
    		"m.id_manager = cs.id_manager_qf1\n" + 
    		")\n" + 
    		"or(\n" + 
    		"m.id_manager = cs.id_manager_qf2\n" + 
    		")\n" + 
    		"or(\n" + 
    		"m.id_manager = cs.id_manager_qf3\n" + 
    		")\n" + 
    		"or(\n" + 
    		"m.id_manager = cs.id_manager_qf4\n" + 
    		")\n" + 
    		"or(\n" + 
    		"m.id_manager = cs.id_manager_qf5\n" + 
    		")\n" + 
    		"or(\n" + 
    		"m.id_manager = cs.id_manager_qf6\n" + 
    		")\n" + 
    		"or(\n" + 
    		"m.id_manager = cs.id_manager_qf7\n" + 
    		")\n" + 
    		"or(\n" + 
    		"m.id_manager = cs.id_manager_qf8\n" + 
    		") then 1\n" + 
    		"else 0\n" + 
    		"end as rounds_played,\n" + 
    		"case\n" + 
    		"when m.id_manager = cs.id_manager_winner then 3\n" + 
    		"when(\n" + 
    		"m.id_manager = cs.id_manager_fi1\n" + 
    		")\n" + 
    		"or(\n" + 
    		"m.id_manager = cs.id_manager_fi2\n" + 
    		") then 2\n" + 
    		"when(\n" + 
    		"m.id_manager = cs.id_manager_sf1\n" + 
    		")\n" + 
    		"or(\n" + 
    		"m.id_manager = cs.id_manager_sf2\n" + 
    		")\n" + 
    		"or(\n" + 
    		"m.id_manager = cs.id_manager_sf3\n" + 
    		")\n" + 
    		"or(\n" + 
    		"m.id_manager = cs.id_manager_sf4\n" + 
    		") then 1\n" + 
    		"else 0\n" + 
    		"end as rounds_won,\n" + 
    		"case\n" + 
    		"when(\n" + 
    		"m.id_manager = cs.id_manager_fi1\n" + 
    		") then case\n" + 
    		"when cs.score_manager_fi1 is null then 0\n" + 
    		"else cs.score_manager_fi1\n" + 
    		"end\n" + 
    		"else 0\n" + 
    		"end as score_f1,\n" + 
    		"case\n" + 
    		"when(\n" + 
    		"m.id_manager = cs.id_manager_fi2\n" + 
    		") then case\n" + 
    		"when cs.score_manager_fi2 is null then 0\n" + 
    		"else cs.score_manager_fi2\n" + 
    		"end\n" + 
    		"else 0\n" + 
    		"end as score_f2,\n" + 
    		"case\n" + 
    		"when(\n" + 
    		"m.id_manager = cs.id_manager_sf1\n" + 
    		") then case\n" + 
    		"when cs.score_manager_sf1 is null then 0\n" + 
    		"else cs.score_manager_sf1\n" + 
    		"end\n" + 
    		"else 0\n" + 
    		"end as score_sf1,\n" + 
    		"case\n" + 
    		"when(\n" + 
    		"m.id_manager = cs.id_manager_sf2\n" + 
    		") then case\n" + 
    		"when cs.score_manager_sf2 is null then 0\n" + 
    		"else cs.score_manager_sf2\n" + 
    		"end\n" + 
    		"else 0\n" + 
    		"end as score_sf2,\n" + 
    		"case\n" + 
    		"when(\n" + 
    		"m.id_manager = cs.id_manager_sf3\n" + 
    		") then case\n" + 
    		"when cs.score_manager_sf3 is null then 0\n" + 
    		"else cs.score_manager_sf3\n" + 
    		"end\n" + 
    		"else 0\n" + 
    		"end as score_sf3,\n" + 
    		"case\n" + 
    		"when(\n" + 
    		"m.id_manager = cs.id_manager_sf4\n" + 
    		") then case\n" + 
    		"when cs.score_manager_sf4 is null then 0\n" + 
    		"else cs.score_manager_sf4\n" + 
    		"end\n" + 
    		"else 0\n" + 
    		"end as score_sf4,\n" + 
    		"case\n" + 
    		"when(\n" + 
    		"m.id_manager = cs.id_manager_qf1\n" + 
    		") then case\n" + 
    		"when cs.score_manager_qf1 is null then 0\n" + 
    		"else cs.score_manager_qf1\n" + 
    		"end\n" + 
    		"else 0\n" + 
    		"end as score_qf1,\n" + 
    		"case\n" + 
    		"when(\n" + 
    		"m.id_manager = cs.id_manager_qf2\n" + 
    		") then case\n" + 
    		"when cs.score_manager_qf2 is null then 0\n" + 
    		"else cs.score_manager_qf2\n" + 
    		"end\n" + 
    		"else 0\n" + 
    		"end as score_qf2,\n" + 
    		"case\n" + 
    		"when(\n" + 
    		"m.id_manager = cs.id_manager_qf3\n" + 
    		") then case\n" + 
    		"when cs.score_manager_qf3 is null then 0\n" + 
    		"else cs.score_manager_qf3\n" + 
    		"end\n" + 
    		"else 0\n" + 
    		"end as score_qf3,\n" + 
    		"case\n" + 
    		"when(\n" + 
    		"m.id_manager = cs.id_manager_qf4\n" + 
    		") then case\n" + 
    		"when cs.score_manager_qf4 is null then 0\n" + 
    		"else cs.score_manager_qf4\n" + 
    		"end\n" + 
    		"else 0\n" + 
    		"end as score_qf4,\n" + 
    		"case\n" + 
    		"when(\n" + 
    		"m.id_manager = cs.id_manager_qf5\n" + 
    		") then case\n" + 
    		"when cs.score_manager_qf5 is null then 0\n" + 
    		"else cs.score_manager_qf5\n" + 
    		"end\n" + 
    		"else 0\n" + 
    		"end as score_qf5,\n" + 
    		"case\n" + 
    		"when(\n" + 
    		"m.id_manager = cs.id_manager_qf6\n" + 
    		") then case\n" + 
    		"when cs.score_manager_qf6 is null then 0\n" + 
    		"else cs.score_manager_qf6\n" + 
    		"end\n" + 
    		"else 0\n" + 
    		"end as score_qf6,\n" + 
    		"case\n" + 
    		"when(\n" + 
    		"m.id_manager = cs.id_manager_qf7\n" + 
    		") then case\n" + 
    		"when cs.score_manager_qf7 is null then 0\n" + 
    		"else cs.score_manager_qf7\n" + 
    		"end\n" + 
    		"else 0\n" + 
    		"end as score_qf7,\n" + 
    		"case\n" + 
    		"when(\n" + 
    		"m.id_manager = cs.id_manager_qf8\n" + 
    		") then case\n" + 
    		"when cs.score_manager_qf8 is null then 0\n" + 
    		"else cs.score_manager_qf8\n" + 
    		"end\n" + 
    		"else 0\n" + 
    		"end as score_qf8,\n" + 
    		"h.id_season_start,\n" + 
    		"h.id_race_start,\n" + 
    		"h.id_season_end,\n" + 
    		"h.id_race_end\n" + 
    		"from\n" + 
    		"manager_team_history h\n" + 
    		"inner join manager m on\n" + 
    		"h.id_manager = m.id_manager,\n" + 
    		"season s\n" + 
    		"left join cupstandingsnapshot cs on\n" + 
    		"s.id_season = cs.id_season\n" + 
    		"where\n" + 
    		"h.id_team = cs.id_team\n" + 
    		"and h.id_season_start <= s.id_season\n" + 
    		"and s.id_season <= :season\n" + 
    		"and(\n" + 
    		"h.id_race_start <= case\n" + 
    		"when(\n" + 
    		"null is null\n" + 
    		")\n" + 
    		"or(\n" + 
    		"h.id_season_start < s.id_season\n" + 
    		") then h.id_race_start\n" + 
    		"else null\n" + 
    		"end\n" + 
    		")\n" + 
    		"and case\n" + 
    		"when h.id_season_end is null then 1000\n" + 
    		"else h.id_season_end\n" + 
    		"end > s.id_season\n" + 
    		"and case\n" + 
    		"when h.id_season_end is null then 100\n" + 
    		"else h.id_race_end\n" + 
    		"end > case\n" + 
    		"when(\n" + 
    		"null is null\n" + 
    		")\n" + 
    		"or(\n" + 
    		"h.id_season_end > s.id_season\n" + 
    		") then 0\n" + 
    		"else null\n" + 
    		"end\n" + 
    		") stats\n" + 
    		"group by\n" + 
    		"manager\n" + 
    		"order by\n" + 
    		"2 desc,\n" + 
    		"3 desc,\n" + 
    		"4 desc,\n" + 
    		"5 desc,\n" + 
    		"6 desc\n";

}
