package org.jlobato.gpro.dao.mybatis.model;

import java.io.Serializable;

public class Team implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column team.id_team
     *
     * @mbg.generated Tue Feb 19 12:14:15 CET 2019
     */
    private Short idTeam;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column team.team_name
     *
     * @mbg.generated Tue Feb 19 12:14:15 CET 2019
     */
    private String teamName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column team.code_team
     *
     * @mbg.generated Tue Feb 19 12:14:15 CET 2019
     */
    private String codeTeam;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column team.id_season
     *
     * @mbg.generated Tue Feb 19 12:14:15 CET 2019
     */
    private Short idSeason;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column team.id_race
     *
     * @mbg.generated Tue Feb 19 12:14:15 CET 2019
     */
    private Short idRace;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table team
     *
     * @mbg.generated Tue Feb 19 12:14:15 CET 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column team.id_team
     *
     * @return the value of team.id_team
     *
     * @mbg.generated Tue Feb 19 12:14:15 CET 2019
     */
    public Short getIdTeam() {
        return idTeam;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
     *
     * @mbg.generated Tue Feb 19 12:14:15 CET 2019
     */
    public Team withIdTeam(Short idTeam) {
        this.setIdTeam(idTeam);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column team.id_team
     *
     * @param idTeam the value for team.id_team
     *
     * @mbg.generated Tue Feb 19 12:14:15 CET 2019
     */
    public void setIdTeam(Short idTeam) {
        this.idTeam = idTeam;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column team.team_name
     *
     * @return the value of team.team_name
     *
     * @mbg.generated Tue Feb 19 12:14:15 CET 2019
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
     *
     * @mbg.generated Tue Feb 19 12:14:15 CET 2019
     */
    public Team withTeamName(String teamName) {
        this.setTeamName(teamName);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column team.team_name
     *
     * @param teamName the value for team.team_name
     *
     * @mbg.generated Tue Feb 19 12:14:15 CET 2019
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName == null ? null : teamName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column team.code_team
     *
     * @return the value of team.code_team
     *
     * @mbg.generated Tue Feb 19 12:14:15 CET 2019
     */
    public String getCodeTeam() {
        return codeTeam;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
     *
     * @mbg.generated Tue Feb 19 12:14:15 CET 2019
     */
    public Team withCodeTeam(String codeTeam) {
        this.setCodeTeam(codeTeam);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column team.code_team
     *
     * @param codeTeam the value for team.code_team
     *
     * @mbg.generated Tue Feb 19 12:14:15 CET 2019
     */
    public void setCodeTeam(String codeTeam) {
        this.codeTeam = codeTeam == null ? null : codeTeam.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column team.id_season
     *
     * @return the value of team.id_season
     *
     * @mbg.generated Tue Feb 19 12:14:15 CET 2019
     */
    public Short getIdSeason() {
        return idSeason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
     *
     * @mbg.generated Tue Feb 19 12:14:15 CET 2019
     */
    public Team withIdSeason(Short idSeason) {
        this.setIdSeason(idSeason);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column team.id_season
     *
     * @param idSeason the value for team.id_season
     *
     * @mbg.generated Tue Feb 19 12:14:15 CET 2019
     */
    public void setIdSeason(Short idSeason) {
        this.idSeason = idSeason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column team.id_race
     *
     * @return the value of team.id_race
     *
     * @mbg.generated Tue Feb 19 12:14:15 CET 2019
     */
    public Short getIdRace() {
        return idRace;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
     *
     * @mbg.generated Tue Feb 19 12:14:15 CET 2019
     */
    public Team withIdRace(Short idRace) {
        this.setIdRace(idRace);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column team.id_race
     *
     * @param idRace the value for team.id_race
     *
     * @mbg.generated Tue Feb 19 12:14:15 CET 2019
     */
    public void setIdRace(Short idRace) {
        this.idRace = idRace;
    }
}