package org.jlobato.gpro.dao.mybatis.model;

import java.io.Serializable;

public class ManagerResult implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager_result.id_manager_result
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
     */
    private Integer idManagerResult;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager_result.id_manager
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
     */
    private Short idManager;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager_result.id_season
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
     */
    private Short idSeason;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager_result.id_race
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
     */
    private Short idRace;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager_result.race_position
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
     */
    private Short racePosition;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager_result.grid_position
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
     */
    private Short gridPosition;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table manager_result
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager_result.id_manager_result
     *
     * @return the value of manager_result.id_manager_result
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
     */
    public Integer getIdManagerResult() {
        return idManagerResult;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_result
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
     */
    public ManagerResult withIdManagerResult(Integer idManagerResult) {
        this.setIdManagerResult(idManagerResult);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager_result.id_manager_result
     *
     * @param idManagerResult the value for manager_result.id_manager_result
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
     */
    public void setIdManagerResult(Integer idManagerResult) {
        this.idManagerResult = idManagerResult;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager_result.id_manager
     *
     * @return the value of manager_result.id_manager
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
     */
    public Short getIdManager() {
        return idManager;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_result
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
     */
    public ManagerResult withIdManager(Short idManager) {
        this.setIdManager(idManager);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager_result.id_manager
     *
     * @param idManager the value for manager_result.id_manager
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
     */
    public void setIdManager(Short idManager) {
        this.idManager = idManager;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager_result.id_season
     *
     * @return the value of manager_result.id_season
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
     */
    public Short getIdSeason() {
        return idSeason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_result
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
     */
    public ManagerResult withIdSeason(Short idSeason) {
        this.setIdSeason(idSeason);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager_result.id_season
     *
     * @param idSeason the value for manager_result.id_season
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
     */
    public void setIdSeason(Short idSeason) {
        this.idSeason = idSeason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager_result.id_race
     *
     * @return the value of manager_result.id_race
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
     */
    public Short getIdRace() {
        return idRace;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_result
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
     */
    public ManagerResult withIdRace(Short idRace) {
        this.setIdRace(idRace);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager_result.id_race
     *
     * @param idRace the value for manager_result.id_race
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
     */
    public void setIdRace(Short idRace) {
        this.idRace = idRace;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager_result.race_position
     *
     * @return the value of manager_result.race_position
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
     */
    public Short getRacePosition() {
        return racePosition;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_result
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
     */
    public ManagerResult withRacePosition(Short racePosition) {
        this.setRacePosition(racePosition);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager_result.race_position
     *
     * @param racePosition the value for manager_result.race_position
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
     */
    public void setRacePosition(Short racePosition) {
        this.racePosition = racePosition;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager_result.grid_position
     *
     * @return the value of manager_result.grid_position
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
     */
    public Short getGridPosition() {
        return gridPosition;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_result
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
     */
    public ManagerResult withGridPosition(Short gridPosition) {
        this.setGridPosition(gridPosition);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager_result.grid_position
     *
     * @param gridPosition the value for manager_result.grid_position
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
     */
    public void setGridPosition(Short gridPosition) {
        this.gridPosition = gridPosition;
    }
}