package org.jlobato.gpro.dao.mybatis.facade;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.jlobato.gpro.dao.mybatis.mappers.RaceMapper;
import org.jlobato.gpro.dao.mybatis.mappers.SeasonMapper;
import org.jlobato.gpro.dao.mybatis.model.Race;
import org.jlobato.gpro.dao.mybatis.model.RaceExample;
import org.jlobato.gpro.dao.mybatis.model.RaceKey;
import org.jlobato.gpro.dao.mybatis.model.Season;
import org.jlobato.gpro.dao.mybatis.model.SeasonExample;
import org.jlobato.gpro.dao.mybatis.model.SeasonExample.Criteria;
import org.jlobato.gpro.dao.mybatis.model.Track;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
public class FachadaSeason {
	
	private static final String SELECT_TRACKS = "select t.name_track, t.distance_track from race r left join track t on r.id_track = t.id_track where id_season = :season";

	/**
	 * 
	 */
	private static final Logger logger = LoggerFactory.getLogger(FachadaSeason.class);
	
	/**
	 * 
	 */
    @Autowired
    protected SeasonMapper seasonDAO;
    
    /**
     * 
     */
    @Autowired
    protected RaceMapper raceDAO;
    
    /**
     * 
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;

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
     * @param jdbcTemplate
     */
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    	this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setResultsMapCaseInsensitive(true);
    }


    /**
     * 
     * @param seasonNumber
     * @param start
     * @param end
     */
    public void addSeason(int seasonNumber, Date start, Date end) {
    	addSeason((short)seasonNumber, seasonNumber, "S" + seasonNumber, "Season " + seasonNumber, start, end);
    }
    
    /**
     * 
     * @param idSeason
     * @param seasonNumber
     * @param code
     * @param name
     * @param start
     * @param end
     */
    public Season addSeason(short idSeason, int seasonNumber, String code, String name, Date start, Date end) {
    	Season newSeason = new Season();
    	newSeason.setIdSeason(idSeason);
    	newSeason.setSeasonNumber(seasonNumber);
    	newSeason.setCode(code);
    	newSeason.setNameSeason(name);
    	newSeason.setStartDate(start);
    	newSeason.setEndDate(end);
    	
    	addSeason(newSeason);
    	return newSeason;
    }
    
    /**
     * 
     * @param season
     */
    public void addSeason(Season season) {
    	seasonDAO.insert(season);
    }
    
    /**
     * Devuelve la temporada que está activa en la fecha de hoy
     * 
     * @return Temporada activa a día de hoy
     */
    public Season getCurrentSeason() {
    	return getCurrentSeason(new Date());
    }    
    
    /**
     * Devuelve la temporada que está activa en la fecha pasada como parámetro
     * 
     * @param rightNow Fecha para la que se quiere conocer la temporada activa
     * 
     * @return Temporada activa en la fecha pasada
     */
    public Season getCurrentSeason(Date rightNow) {
    	Season result = null;
    	SeasonExample example = new SeasonExample();
    	Criteria criteria = example.createCriteria();
    	criteria.andStartDateLessThanOrEqualTo(rightNow);
    	criteria.andEndDateGreaterThanOrEqualTo(rightNow);    	
    	List<Season> current = seasonDAO.selectByExample(example);
    	if (!current.isEmpty()) {
    		result = current.get(0); 
    	}
    	return result;
    }
    
    /**
     * 
     * @param seasonCode
     * @return
     */
    public Season getSeason(int seasonCode) {
    	Season result = null;
    	SeasonExample example = new SeasonExample();
    	Criteria criteria = example.createCriteria();
    	criteria.andSeasonNumberEqualTo(seasonCode);
    	List<Season> seasons = seasonDAO.selectByExample(example);
    	if (!seasons.isEmpty()) {
    		result = seasons.get(0);
    	}
    	return result;
    }
    
    /**
     * 
     * @param season
     * @return
     */
    public List<Race> getRaces(Season season) {
    	RaceExample example = new RaceExample();
    	org.jlobato.gpro.dao.mybatis.model.RaceExample.Criteria criteria = example.createCriteria();
    	criteria.andIdSeasonEqualTo(season.getIdSeason());
    	example.setOrderByClause("race_date");
    	return raceDAO.selectByExample(example);
    }
    
    /**
     * 
     * @return
     */
    public Race getCurrentRace() {
    	return getCurrentRace(new Date());
    }
    
    /**
     * 
     * @param rightnow
     * @return
     */
    public Race getCurrentRace(Date rightNow) {
    	Race result = null;
    	RaceExample example = new RaceExample();
    	org.jlobato.gpro.dao.mybatis.model.RaceExample.Criteria criteria = example.createCriteria();
    	criteria.andRaceDateLessThan(rightNow);
    	criteria.andIdSeasonEqualTo(getCurrentSeason().getIdSeason());
    	example.setOrderByClause("race_date desc");
    
    	List<Race> current = raceDAO.selectByExample(example);
    	if (!current.isEmpty()) {
    		result = current.get(0); 
    	}
    	return result;
    }
    
    /**
     * 
     * @param season
     * @param track
     * @return
     */
    public Race getRace(Season season, Track track) {
    	Race result = null;
    	RaceExample example = new RaceExample();
    	org.jlobato.gpro.dao.mybatis.model.RaceExample.Criteria criteria = example.createCriteria();
    	criteria.andIdSeasonEqualTo(season.getIdSeason());
    	criteria.andIdTrackEqualTo(track.getIdTrack());
    	List<Race> races = raceDAO.selectByExample(example);
    	if (!races.isEmpty()) {
    		result = races.get(0);
    	}
    	return result;
    }
    
    /**
     * 
     * @param codSeason
     * @param codRace
     * @return
     */
    public Race getRace(int codSeason, int codRace) {
    	Race result = null;
    	RaceExample example = new RaceExample();
    	org.jlobato.gpro.dao.mybatis.model.RaceExample.Criteria criteria = example.createCriteria();
    	criteria.andIdSeasonEqualTo((short)codSeason);
    	criteria.andIdRaceEqualTo((short)codRace);
    	List<Race> races = raceDAO.selectByExample(example);
    	if (!races.isEmpty()) {
    		result = races.get(0);
    	}
    	return result;
    }
    
    /**
     * 
     * @param codRace
     * @return
     */
    public Race getRace(String codRace) {
    	Race result = null;
    	RaceExample example = new RaceExample();
    	org.jlobato.gpro.dao.mybatis.model.RaceExample.Criteria criteria = example.createCriteria();
    	criteria.andCodeRaceEqualTo(codRace);
    	List<Race> races = raceDAO.selectByExample(example);
    	if (!races.isEmpty()) {
    		result = races.get(0);
    	}
    	return result;
    }
    
    /**
     * 
     * @param idrace
     * @return
     */
    public Race getRace(Short idrace) {
    	Race result = null;
    	if (idrace != null) {
    		RaceKey rKey = new RaceKey();
    		rKey.setIdSeason(getCurrentSeason().getIdSeason());
    		rKey.setIdRace(idrace);
    		result = raceDAO.selectByPrimaryKey(rKey);
    	}
    	return result;
    }

    /**
     * 
     * @param season
     * @return
     */
    public List<Map<String, String>> getTracks(Season season) {
        logger.debug("Se recuperan los circuitos de la temporada {}", season.getNameSeason());
        
        List<Map<String, String>> articulos;
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();

        mapSqlParameterSource.addValue("season", season.getIdSeason());

        articulos = namedParameterJdbcTemplate.query(SELECT_TRACKS,
        		mapSqlParameterSource,
        		new RowMapper<Map<String, String>>() {
            		public Map<String, String> mapRow(ResultSet rs, int rowNum) throws SQLException {
            			Map<String, String> tracks = new HashMap<>();
            			tracks.put("track", rs.getString("name_track"));
            			tracks.put("distance", rs.getString("distance_track"));

            			return tracks;
            		}
        });

        return articulos;
    }

    /**
     * 
     * @param currentSeason
     * @param races
     */
	public void updateSeasonCalendar(Season currentSeason, List<Race> races) {
		//Primero vemos si es una temporada nueva, ya que en ese caso nos ahorramos muchas comprobaciones
		boolean isNewSeason = getSeason(currentSeason.getSeasonNumber()) == null;
		
		if (isNewSeason) {
			logger.info("Creando calendario de la temporada {}", currentSeason.getSeasonNumber());
			//Creamos la nueva temporada
			addSeason(currentSeason);
			
			//Recorremos la lista de carreras
			for (Iterator<Race> i = races.iterator(); i.hasNext();) {
				Race race = i.next();
				//Insertamos y listo
				raceDAO.insert(race);
			}
		}
		else {
			//Sabemos que es una temporada existente. Se actualizarán datos
			//TODO Actualización de los datos de una temporada
			logger.info("Actualizando calendario de la temporada {}", currentSeason.getSeasonNumber());
		}
	}
	
	/**
	 * Devuelve todas las temporadas disponibles, ordenadas por el número de temporada
	 * 
	 * @return
	 */
	public List<Season> getAvailableSeasons() {
		List<Season> result = null;
		
		SeasonExample example = new SeasonExample();
		example.createCriteria().getAllCriteria();
		example.setOrderByClause("season_number");
		
		result = seasonDAO.selectByExample(example);
		
		return result;
	}
    
    

}
