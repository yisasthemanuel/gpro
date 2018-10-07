package org.jlobato.gpro.track;

public class TrackImpl implements Track {

	public TrackImpl(String name, String downforce, String overtaking,
			String wear, String fuelConsumption, String tyreCompoundDelta) {
		super();
		this.name = name;
		this.downforce = downforce;
		this.overtaking = overtaking;
		this.wear = wear;
		this.fuelConsumption = fuelConsumption;
		this.tyreCompoundDelta = tyreCompoundDelta;
	}
	
	public TrackImpl() {
		this(null, null, null, null, null, null);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -4813752643128381554L;

	/**
	 * 
	 */
	private String name;

	/**
	 * 
	 */
	private String downforce;

	/**
	 * 
	 */
	private String overtaking;

	/**
	 * 
	 */
	private String wear;

	/**
	 * 
	 */
	private String fuelConsumption;

	/**
	 * 
	 */
	private String tyreCompoundDelta;

	public String getName() {
		return name;
	}

	public String getDownforce() {
		return downforce;
	}

	public String getOvertaking() {
		return overtaking;
	}

	public String getWear() {
		return wear;
	}

	public String getFuelConsumption() {
		return fuelConsumption;
	}

	public String getTyreCompoundDelta() {
		return tyreCompoundDelta;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDownforce(String downforce) {
		this.downforce = downforce;
	}

	public void setOvertaking(String overtaking) {
		this.overtaking = overtaking;
	}

	public void setWear(String wear) {
		this.wear = wear;
	}

	public void setFuelConsumption(String fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}

	public void setTyreCompoundDelta(String tyreCompoundDelta) {
		this.tyreCompoundDelta = tyreCompoundDelta;
	}

}
