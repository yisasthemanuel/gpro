package org.jlobato.gpro.dao.mybatis.model;

import java.io.Serializable;

public class CupStandingsSnapshotKey implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cupstandingsnapshot.id_season
     *
     * @mbg.generated Sun Dec 09 12:52:57 CET 2018
     */
    private Short idSeason;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cupstandingsnapshot.id_team
     *
     * @mbg.generated Sun Dec 09 12:52:57 CET 2018
     */
    private Short idTeam;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cupstandingsnapshot
     *
     * @mbg.generated Sun Dec 09 12:52:57 CET 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cupstandingsnapshot.id_season
     *
     * @return the value of cupstandingsnapshot.id_season
     *
     * @mbg.generated Sun Dec 09 12:52:57 CET 2018
     */
    public Short getIdSeason() {
        return idSeason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cupstandingsnapshot
     *
     * @mbg.generated Sun Dec 09 12:52:57 CET 2018
     */
    public CupStandingsSnapshotKey withIdSeason(Short idSeason) {
        this.setIdSeason(idSeason);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cupstandingsnapshot.id_season
     *
     * @param idSeason the value for cupstandingsnapshot.id_season
     *
     * @mbg.generated Sun Dec 09 12:52:57 CET 2018
     */
    public void setIdSeason(Short idSeason) {
        this.idSeason = idSeason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cupstandingsnapshot.id_team
     *
     * @return the value of cupstandingsnapshot.id_team
     *
     * @mbg.generated Sun Dec 09 12:52:57 CET 2018
     */
    public Short getIdTeam() {
        return idTeam;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cupstandingsnapshot
     *
     * @mbg.generated Sun Dec 09 12:52:57 CET 2018
     */
    public CupStandingsSnapshotKey withIdTeam(Short idTeam) {
        this.setIdTeam(idTeam);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cupstandingsnapshot.id_team
     *
     * @param idTeam the value for cupstandingsnapshot.id_team
     *
     * @mbg.generated Sun Dec 09 12:52:57 CET 2018
     */
    public void setIdTeam(Short idTeam) {
        this.idTeam = idTeam;
    }
}