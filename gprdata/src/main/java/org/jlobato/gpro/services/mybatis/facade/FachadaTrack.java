package org.jlobato.gpro.services.mybatis.facade;

import java.util.List;

import org.jlobato.gpro.dao.mybatis.mappers.TrackMapper;
import org.jlobato.gpro.dao.mybatis.model.Track;
import org.jlobato.gpro.dao.mybatis.model.TrackExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author jlobato
 *
 */
@Service
@Transactional
public class FachadaTrack {
	
    @Autowired
    /**
     * DAO para los circuitos
     */
    protected TrackMapper trackDAO;

    /**
     * Devuelve todos los circuitos ordenados por nombre
     * @return
     */
    public List<Track> getTrackList() {
    	TrackExample example = new TrackExample();
    	example.setOrderByClause("track_name");
    	
    	return trackDAO.selectByExample(example);
    }
    
    /**
     * Busca un circuito por el nombre
     * @param trackName Nombre del circuito
     * @return El registro correspondiente a este circuito, nulo si no existe
     */
    public Track getTrackByName(String trackName) {
    	Track result = null;
    	TrackExample example = new TrackExample();
    	example.createCriteria().andNameTrackEqualTo(trackName);
    	
    	List<Track> trackWithName = trackDAO.selectByExample(example);
    	if (!trackWithName.isEmpty()) {
    		result = trackWithName.get(0);
    	}
    	return result;
    }
    
    /**
     * Busca el ID de un circuito por el nombre
     * @param trackName
     * @return El identificador interno del circuito, -1 si no existe
     */
    public Short getTrackIdByName(String trackName) {
    	Short result = -1;
    	Track track = getTrackByName(trackName);
    	if (track != null) {
    		result = track.getIdTrack();
    	}
    	return result;
    }
    
}
