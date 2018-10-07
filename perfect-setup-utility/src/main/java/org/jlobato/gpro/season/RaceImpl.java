package org.jlobato.gpro.season;

import java.util.Date;

import org.jlobato.gpro.track.Track;

public class RaceImpl implements Race {
	
	/**
	 * 
	 */
	private Season season;
	
	/**
	 * 
	 */
	private Track track;
	
	/**
	 * 
	 */
	private int raceNumber;
	
	/**
	 * 
	 */
	private Date date;

	/**
	 * 
	 */
	private static final long serialVersionUID = 11358996960658943L;
	
	public RaceImpl(Season season, Track track, int raceNumber, Date date) {
		super();
		this.season = season;
		this.track = track;
		this.raceNumber = raceNumber;
		this.date = date;
	}
	
	/**
	 * 
	 */
	public RaceImpl() {
		this(null, null, 0, null);
	}

	/**
	 * 
	 */
	public Season getSeason() {
		return season;
	}

	/**
	 * 
	 */
	public Track getTrack() {
		return track;
	}

	/**
	 * 
	 */
	public int getRaceNumber() {
		return raceNumber;
	}

	/**
	 * 
	 */
	public Date getDate() {
		return date;
	}
	
	public void setSeason(Season season) {
		this.season = season;
	}

	public void setTrack(Track track) {
		this.track = track;
	}

	public void setRaceNumber(int raceNumber) {
		this.raceNumber = raceNumber;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
