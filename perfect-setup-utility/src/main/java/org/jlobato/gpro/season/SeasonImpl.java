package org.jlobato.gpro.season;

public class SeasonImpl implements Season {
	
	private String name;
	private int seasonNumber;
	
	public SeasonImpl(String name, int seasonNumber) {
		super();
		this.name = name;
		this.seasonNumber = seasonNumber;
	}
	
	public SeasonImpl() {
		this(null, 0);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 2359157822575489156L;

	/**
	 * 
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 */
	public int getSeasonNumber() {
		return seasonNumber;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public void setSeasonNumber(int seasonNumber) {
		this.seasonNumber = seasonNumber;
	}

	@Override
	public String toString() {
		return getName();
	}
	
	

}
