package org.jlobato.gpro.dao.mybatis.model;

import java.io.Serializable;
import java.util.Date;

public class Race extends RaceKey implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column race.code_race
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    private String codeRace;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column race.description_race
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    private String descriptionRace;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column race.race_date
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    private Date raceDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column race.id_track
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    private Short idTrack;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table race
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column race.code_race
     *
     * @return the value of race.code_race
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    public String getCodeRace() {
        return codeRace;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table race
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    public Race withCodeRace(String codeRace) {
        this.setCodeRace(codeRace);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column race.code_race
     *
     * @param codeRace the value for race.code_race
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    public void setCodeRace(String codeRace) {
        this.codeRace = codeRace == null ? null : codeRace.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column race.description_race
     *
     * @return the value of race.description_race
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    public String getDescriptionRace() {
        return descriptionRace;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table race
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    public Race withDescriptionRace(String descriptionRace) {
        this.setDescriptionRace(descriptionRace);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column race.description_race
     *
     * @param descriptionRace the value for race.description_race
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    public void setDescriptionRace(String descriptionRace) {
        this.descriptionRace = descriptionRace == null ? null : descriptionRace.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column race.race_date
     *
     * @return the value of race.race_date
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    public Date getRaceDate() {
        return raceDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table race
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    public Race withRaceDate(Date raceDate) {
        this.setRaceDate(raceDate);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column race.race_date
     *
     * @param raceDate the value for race.race_date
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    public void setRaceDate(Date raceDate) {
        this.raceDate = raceDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column race.id_track
     *
     * @return the value of race.id_track
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    public Short getIdTrack() {
        return idTrack;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table race
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    public Race withIdTrack(Short idTrack) {
        this.setIdTrack(idTrack);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column race.id_track
     *
     * @param idTrack the value for race.id_track
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    public void setIdTrack(Short idTrack) {
        this.idTrack = idTrack;
    }
}