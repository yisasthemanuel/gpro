package org.jlobato.gpro.dao.mybatis.model;

import java.io.Serializable;

public class RaceLapData implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column racelapdata.id_racelapdata
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    private Integer idRacelapdata;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column racelapdata.id_racedata
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    private Integer idRacedata;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column racelapdata.lap_no
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    private Short lapNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column racelapdata.lap_time
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    private Integer lapTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column racelapdata.lap_position
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    private Short lapPosition;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column racelapdata.id_tyrecompound
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    private Integer idTyrecompound;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column racelapdata.id_weather
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    private Integer idWeather;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column racelapdata.lap_temp
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    private Short lapTemp;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column racelapdata.lap_humidity
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    private Short lapHumidity;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column racelapdata.lap_events
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    private String lapEvents;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column racelapdata.worn_tyres
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    private Boolean wornTyres;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table racelapdata
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column racelapdata.id_racelapdata
     *
     * @return the value of racelapdata.id_racelapdata
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public Integer getIdRacelapdata() {
        return idRacelapdata;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table racelapdata
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public RaceLapData withIdRacelapdata(Integer idRacelapdata) {
        this.setIdRacelapdata(idRacelapdata);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column racelapdata.id_racelapdata
     *
     * @param idRacelapdata the value for racelapdata.id_racelapdata
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public void setIdRacelapdata(Integer idRacelapdata) {
        this.idRacelapdata = idRacelapdata;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column racelapdata.id_racedata
     *
     * @return the value of racelapdata.id_racedata
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public Integer getIdRacedata() {
        return idRacedata;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table racelapdata
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public RaceLapData withIdRacedata(Integer idRacedata) {
        this.setIdRacedata(idRacedata);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column racelapdata.id_racedata
     *
     * @param idRacedata the value for racelapdata.id_racedata
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public void setIdRacedata(Integer idRacedata) {
        this.idRacedata = idRacedata;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column racelapdata.lap_no
     *
     * @return the value of racelapdata.lap_no
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public Short getLapNo() {
        return lapNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table racelapdata
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public RaceLapData withLapNo(Short lapNo) {
        this.setLapNo(lapNo);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column racelapdata.lap_no
     *
     * @param lapNo the value for racelapdata.lap_no
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public void setLapNo(Short lapNo) {
        this.lapNo = lapNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column racelapdata.lap_time
     *
     * @return the value of racelapdata.lap_time
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public Integer getLapTime() {
        return lapTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table racelapdata
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public RaceLapData withLapTime(Integer lapTime) {
        this.setLapTime(lapTime);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column racelapdata.lap_time
     *
     * @param lapTime the value for racelapdata.lap_time
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public void setLapTime(Integer lapTime) {
        this.lapTime = lapTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column racelapdata.lap_position
     *
     * @return the value of racelapdata.lap_position
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public Short getLapPosition() {
        return lapPosition;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table racelapdata
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public RaceLapData withLapPosition(Short lapPosition) {
        this.setLapPosition(lapPosition);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column racelapdata.lap_position
     *
     * @param lapPosition the value for racelapdata.lap_position
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public void setLapPosition(Short lapPosition) {
        this.lapPosition = lapPosition;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column racelapdata.id_tyrecompound
     *
     * @return the value of racelapdata.id_tyrecompound
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public Integer getIdTyrecompound() {
        return idTyrecompound;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table racelapdata
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public RaceLapData withIdTyrecompound(Integer idTyrecompound) {
        this.setIdTyrecompound(idTyrecompound);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column racelapdata.id_tyrecompound
     *
     * @param idTyrecompound the value for racelapdata.id_tyrecompound
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public void setIdTyrecompound(Integer idTyrecompound) {
        this.idTyrecompound = idTyrecompound;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column racelapdata.id_weather
     *
     * @return the value of racelapdata.id_weather
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public Integer getIdWeather() {
        return idWeather;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table racelapdata
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public RaceLapData withIdWeather(Integer idWeather) {
        this.setIdWeather(idWeather);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column racelapdata.id_weather
     *
     * @param idWeather the value for racelapdata.id_weather
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public void setIdWeather(Integer idWeather) {
        this.idWeather = idWeather;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column racelapdata.lap_temp
     *
     * @return the value of racelapdata.lap_temp
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public Short getLapTemp() {
        return lapTemp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table racelapdata
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public RaceLapData withLapTemp(Short lapTemp) {
        this.setLapTemp(lapTemp);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column racelapdata.lap_temp
     *
     * @param lapTemp the value for racelapdata.lap_temp
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public void setLapTemp(Short lapTemp) {
        this.lapTemp = lapTemp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column racelapdata.lap_humidity
     *
     * @return the value of racelapdata.lap_humidity
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public Short getLapHumidity() {
        return lapHumidity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table racelapdata
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public RaceLapData withLapHumidity(Short lapHumidity) {
        this.setLapHumidity(lapHumidity);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column racelapdata.lap_humidity
     *
     * @param lapHumidity the value for racelapdata.lap_humidity
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public void setLapHumidity(Short lapHumidity) {
        this.lapHumidity = lapHumidity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column racelapdata.lap_events
     *
     * @return the value of racelapdata.lap_events
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public String getLapEvents() {
        return lapEvents;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table racelapdata
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public RaceLapData withLapEvents(String lapEvents) {
        this.setLapEvents(lapEvents);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column racelapdata.lap_events
     *
     * @param lapEvents the value for racelapdata.lap_events
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public void setLapEvents(String lapEvents) {
        this.lapEvents = lapEvents == null ? null : lapEvents.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column racelapdata.worn_tyres
     *
     * @return the value of racelapdata.worn_tyres
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public Boolean getWornTyres() {
        return wornTyres;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table racelapdata
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public RaceLapData withWornTyres(Boolean wornTyres) {
        this.setWornTyres(wornTyres);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column racelapdata.worn_tyres
     *
     * @param wornTyres the value for racelapdata.worn_tyres
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public void setWornTyres(Boolean wornTyres) {
        this.wornTyres = wornTyres;
    }
}