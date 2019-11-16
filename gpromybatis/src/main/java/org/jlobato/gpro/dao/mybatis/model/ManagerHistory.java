package org.jlobato.gpro.dao.mybatis.model;

import java.io.Serializable;

public class ManagerHistory implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager_history.id_manager_history
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    private Integer idManagerHistory;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager_history.id_manager
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    private Short idManager;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager_history.id_season
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    private Short idSeason;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager_history.id_category
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    private Short idCategory;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager_history.id_group
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    private Short idGroup;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager_history.id_tyre_brand
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    private Short idTyreBrand;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager_history.position
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    private Short position;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager_history.wins
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    private Short wins;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager_history.podiums
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    private Short podiums;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager_history.poles
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    private Short poles;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager_history.fastest_laps
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    private Short fastestLaps;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager_history.points
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    private Short points;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager_history.races
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    private Short races;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager_history.cup
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    private String cup;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager_history.obr
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    private Short obr;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager_history.money_balance
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    private Long moneyBalance;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table manager_history
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager_history.id_manager_history
     *
     * @return the value of manager_history.id_manager_history
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public Integer getIdManagerHistory() {
        return idManagerHistory;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_history
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public ManagerHistory withIdManagerHistory(Integer idManagerHistory) {
        this.setIdManagerHistory(idManagerHistory);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager_history.id_manager_history
     *
     * @param idManagerHistory the value for manager_history.id_manager_history
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public void setIdManagerHistory(Integer idManagerHistory) {
        this.idManagerHistory = idManagerHistory;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager_history.id_manager
     *
     * @return the value of manager_history.id_manager
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public Short getIdManager() {
        return idManager;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_history
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public ManagerHistory withIdManager(Short idManager) {
        this.setIdManager(idManager);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager_history.id_manager
     *
     * @param idManager the value for manager_history.id_manager
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public void setIdManager(Short idManager) {
        this.idManager = idManager;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager_history.id_season
     *
     * @return the value of manager_history.id_season
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public Short getIdSeason() {
        return idSeason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_history
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public ManagerHistory withIdSeason(Short idSeason) {
        this.setIdSeason(idSeason);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager_history.id_season
     *
     * @param idSeason the value for manager_history.id_season
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public void setIdSeason(Short idSeason) {
        this.idSeason = idSeason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager_history.id_category
     *
     * @return the value of manager_history.id_category
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public Short getIdCategory() {
        return idCategory;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_history
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public ManagerHistory withIdCategory(Short idCategory) {
        this.setIdCategory(idCategory);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager_history.id_category
     *
     * @param idCategory the value for manager_history.id_category
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public void setIdCategory(Short idCategory) {
        this.idCategory = idCategory;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager_history.id_group
     *
     * @return the value of manager_history.id_group
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public Short getIdGroup() {
        return idGroup;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_history
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public ManagerHistory withIdGroup(Short idGroup) {
        this.setIdGroup(idGroup);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager_history.id_group
     *
     * @param idGroup the value for manager_history.id_group
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public void setIdGroup(Short idGroup) {
        this.idGroup = idGroup;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager_history.id_tyre_brand
     *
     * @return the value of manager_history.id_tyre_brand
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public Short getIdTyreBrand() {
        return idTyreBrand;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_history
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public ManagerHistory withIdTyreBrand(Short idTyreBrand) {
        this.setIdTyreBrand(idTyreBrand);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager_history.id_tyre_brand
     *
     * @param idTyreBrand the value for manager_history.id_tyre_brand
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public void setIdTyreBrand(Short idTyreBrand) {
        this.idTyreBrand = idTyreBrand;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager_history.position
     *
     * @return the value of manager_history.position
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public Short getPosition() {
        return position;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_history
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public ManagerHistory withPosition(Short position) {
        this.setPosition(position);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager_history.position
     *
     * @param position the value for manager_history.position
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public void setPosition(Short position) {
        this.position = position;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager_history.wins
     *
     * @return the value of manager_history.wins
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public Short getWins() {
        return wins;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_history
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public ManagerHistory withWins(Short wins) {
        this.setWins(wins);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager_history.wins
     *
     * @param wins the value for manager_history.wins
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public void setWins(Short wins) {
        this.wins = wins;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager_history.podiums
     *
     * @return the value of manager_history.podiums
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public Short getPodiums() {
        return podiums;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_history
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public ManagerHistory withPodiums(Short podiums) {
        this.setPodiums(podiums);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager_history.podiums
     *
     * @param podiums the value for manager_history.podiums
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public void setPodiums(Short podiums) {
        this.podiums = podiums;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager_history.poles
     *
     * @return the value of manager_history.poles
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public Short getPoles() {
        return poles;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_history
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public ManagerHistory withPoles(Short poles) {
        this.setPoles(poles);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager_history.poles
     *
     * @param poles the value for manager_history.poles
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public void setPoles(Short poles) {
        this.poles = poles;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager_history.fastest_laps
     *
     * @return the value of manager_history.fastest_laps
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public Short getFastestLaps() {
        return fastestLaps;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_history
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public ManagerHistory withFastestLaps(Short fastestLaps) {
        this.setFastestLaps(fastestLaps);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager_history.fastest_laps
     *
     * @param fastestLaps the value for manager_history.fastest_laps
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public void setFastestLaps(Short fastestLaps) {
        this.fastestLaps = fastestLaps;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager_history.points
     *
     * @return the value of manager_history.points
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public Short getPoints() {
        return points;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_history
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public ManagerHistory withPoints(Short points) {
        this.setPoints(points);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager_history.points
     *
     * @param points the value for manager_history.points
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public void setPoints(Short points) {
        this.points = points;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager_history.races
     *
     * @return the value of manager_history.races
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public Short getRaces() {
        return races;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_history
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public ManagerHistory withRaces(Short races) {
        this.setRaces(races);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager_history.races
     *
     * @param races the value for manager_history.races
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public void setRaces(Short races) {
        this.races = races;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager_history.cup
     *
     * @return the value of manager_history.cup
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public String getCup() {
        return cup;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_history
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public ManagerHistory withCup(String cup) {
        this.setCup(cup);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager_history.cup
     *
     * @param cup the value for manager_history.cup
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public void setCup(String cup) {
        this.cup = cup == null ? null : cup.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager_history.obr
     *
     * @return the value of manager_history.obr
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public Short getObr() {
        return obr;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_history
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public ManagerHistory withObr(Short obr) {
        this.setObr(obr);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager_history.obr
     *
     * @param obr the value for manager_history.obr
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public void setObr(Short obr) {
        this.obr = obr;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager_history.money_balance
     *
     * @return the value of manager_history.money_balance
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public Long getMoneyBalance() {
        return moneyBalance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_history
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public ManagerHistory withMoneyBalance(Long moneyBalance) {
        this.setMoneyBalance(moneyBalance);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager_history.money_balance
     *
     * @param moneyBalance the value for manager_history.money_balance
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public void setMoneyBalance(Long moneyBalance) {
        this.moneyBalance = moneyBalance;
    }
}