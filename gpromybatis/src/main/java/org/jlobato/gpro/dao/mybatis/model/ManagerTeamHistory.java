package org.jlobato.gpro.dao.mybatis.model;

import java.io.Serializable;

public class ManagerTeamHistory implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager_team_history.id_manager_team_history
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    private Integer idManagerTeamHistory;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager_team_history.id_manager
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    private Short idManager;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager_team_history.id_season_start
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    private Short idSeasonStart;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager_team_history.id_race_start
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    private Short idRaceStart;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager_team_history.id_season_end
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    private Short idSeasonEnd;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager_team_history.id_race_end
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    private Short idRaceEnd;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager_team_history.id_team
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    private Short idTeam;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table manager_team_history
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager_team_history.id_manager_team_history
     *
     * @return the value of manager_team_history.id_manager_team_history
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    public Integer getIdManagerTeamHistory() {
        return idManagerTeamHistory;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_team_history
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    public ManagerTeamHistory withIdManagerTeamHistory(Integer idManagerTeamHistory) {
        this.setIdManagerTeamHistory(idManagerTeamHistory);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager_team_history.id_manager_team_history
     *
     * @param idManagerTeamHistory the value for manager_team_history.id_manager_team_history
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    public void setIdManagerTeamHistory(Integer idManagerTeamHistory) {
        this.idManagerTeamHistory = idManagerTeamHistory;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager_team_history.id_manager
     *
     * @return the value of manager_team_history.id_manager
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    public Short getIdManager() {
        return idManager;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_team_history
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    public ManagerTeamHistory withIdManager(Short idManager) {
        this.setIdManager(idManager);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager_team_history.id_manager
     *
     * @param idManager the value for manager_team_history.id_manager
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    public void setIdManager(Short idManager) {
        this.idManager = idManager;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager_team_history.id_season_start
     *
     * @return the value of manager_team_history.id_season_start
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    public Short getIdSeasonStart() {
        return idSeasonStart;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_team_history
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    public ManagerTeamHistory withIdSeasonStart(Short idSeasonStart) {
        this.setIdSeasonStart(idSeasonStart);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager_team_history.id_season_start
     *
     * @param idSeasonStart the value for manager_team_history.id_season_start
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    public void setIdSeasonStart(Short idSeasonStart) {
        this.idSeasonStart = idSeasonStart;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager_team_history.id_race_start
     *
     * @return the value of manager_team_history.id_race_start
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    public Short getIdRaceStart() {
        return idRaceStart;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_team_history
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    public ManagerTeamHistory withIdRaceStart(Short idRaceStart) {
        this.setIdRaceStart(idRaceStart);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager_team_history.id_race_start
     *
     * @param idRaceStart the value for manager_team_history.id_race_start
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    public void setIdRaceStart(Short idRaceStart) {
        this.idRaceStart = idRaceStart;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager_team_history.id_season_end
     *
     * @return the value of manager_team_history.id_season_end
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    public Short getIdSeasonEnd() {
        return idSeasonEnd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_team_history
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    public ManagerTeamHistory withIdSeasonEnd(Short idSeasonEnd) {
        this.setIdSeasonEnd(idSeasonEnd);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager_team_history.id_season_end
     *
     * @param idSeasonEnd the value for manager_team_history.id_season_end
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    public void setIdSeasonEnd(Short idSeasonEnd) {
        this.idSeasonEnd = idSeasonEnd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager_team_history.id_race_end
     *
     * @return the value of manager_team_history.id_race_end
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    public Short getIdRaceEnd() {
        return idRaceEnd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_team_history
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    public ManagerTeamHistory withIdRaceEnd(Short idRaceEnd) {
        this.setIdRaceEnd(idRaceEnd);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager_team_history.id_race_end
     *
     * @param idRaceEnd the value for manager_team_history.id_race_end
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    public void setIdRaceEnd(Short idRaceEnd) {
        this.idRaceEnd = idRaceEnd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager_team_history.id_team
     *
     * @return the value of manager_team_history.id_team
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    public Short getIdTeam() {
        return idTeam;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_team_history
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    public ManagerTeamHistory withIdTeam(Short idTeam) {
        this.setIdTeam(idTeam);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager_team_history.id_team
     *
     * @param idTeam the value for manager_team_history.id_team
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    public void setIdTeam(Short idTeam) {
        this.idTeam = idTeam;
    }
}