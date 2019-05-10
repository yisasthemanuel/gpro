package org.jlobato.gpro.dao.mybatis.model;

import java.io.Serializable;

public class ManagerHistory implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager_history.id_manager_history
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    private Integer idManagerHistory;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager_history.id_manager
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    private Short idManager;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager_history.id_season
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    private Short idSeason;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager_history.id_category
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    private Short idCategory;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager_history.id_group
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    private Short idGroup;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager_history.id_tyre_brand
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    private Short idTyreBrand;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table manager_history
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager_history.id_manager_history
     *
     * @return the value of manager_history.id_manager_history
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    public Integer getIdManagerHistory() {
        return idManagerHistory;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_history
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
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
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
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
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    public Short getIdManager() {
        return idManager;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_history
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
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
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
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
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    public Short getIdSeason() {
        return idSeason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_history
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
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
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
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
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    public Short getIdCategory() {
        return idCategory;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_history
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
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
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
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
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    public Short getIdGroup() {
        return idGroup;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_history
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
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
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
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
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    public Short getIdTyreBrand() {
        return idTyreBrand;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_history
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
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
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    public void setIdTyreBrand(Short idTyreBrand) {
        this.idTyreBrand = idTyreBrand;
    }
}