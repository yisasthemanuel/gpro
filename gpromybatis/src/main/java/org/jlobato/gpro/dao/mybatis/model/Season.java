package org.jlobato.gpro.dao.mybatis.model;

import java.io.Serializable;
import java.util.Date;

public class Season implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column season.id_season
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    private Short idSeason;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column season.season_number
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    private int seasonNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column season.code
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    private String code;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column season.name_season
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    private String nameSeason;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column season.start_date
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    private Date startDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column season.end_date
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    private Date endDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table season
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column season.id_season
     *
     * @return the value of season.id_season
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    public Short getIdSeason() {
        return idSeason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table season
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    public Season withIdSeason(Short idSeason) {
        this.setIdSeason(idSeason);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column season.id_season
     *
     * @param idSeason the value for season.id_season
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    public void setIdSeason(Short idSeason) {
        this.idSeason = idSeason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column season.season_number
     *
     * @return the value of season.season_number
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    public int getSeasonNumber() {
        return seasonNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table season
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    public Season withSeasonNumber(int seasonNumber) {
        this.setSeasonNumber(seasonNumber);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column season.season_number
     *
     * @param seasonNumber the value for season.season_number
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column season.code
     *
     * @return the value of season.code
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table season
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    public Season withCode(String code) {
        this.setCode(code);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column season.code
     *
     * @param code the value for season.code
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column season.name_season
     *
     * @return the value of season.name_season
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    public String getNameSeason() {
        return nameSeason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table season
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    public Season withNameSeason(String nameSeason) {
        this.setNameSeason(nameSeason);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column season.name_season
     *
     * @param nameSeason the value for season.name_season
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    public void setNameSeason(String nameSeason) {
        this.nameSeason = nameSeason == null ? null : nameSeason.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column season.start_date
     *
     * @return the value of season.start_date
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table season
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    public Season withStartDate(Date startDate) {
        this.setStartDate(startDate);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column season.start_date
     *
     * @param startDate the value for season.start_date
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column season.end_date
     *
     * @return the value of season.end_date
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table season
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    public Season withEndDate(Date endDate) {
        this.setEndDate(endDate);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column season.end_date
     *
     * @param endDate the value for season.end_date
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}