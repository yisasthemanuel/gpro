package org.jlobato.gpro.dao.mybatis.model;

import java.util.ArrayList;
import java.util.List;

public class ManagerResultExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table manager_result
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table manager_result
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table manager_result
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_result
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    public ManagerResultExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_result
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_result
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_result
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_result
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_result
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_result
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_result
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_result
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_result
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_result
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table manager_result
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdManagerResultIsNull() {
            addCriterion("id_manager_result is null");
            return (Criteria) this;
        }

        public Criteria andIdManagerResultIsNotNull() {
            addCriterion("id_manager_result is not null");
            return (Criteria) this;
        }

        public Criteria andIdManagerResultEqualTo(Integer value) {
            addCriterion("id_manager_result =", value, "idManagerResult");
            return (Criteria) this;
        }

        public Criteria andIdManagerResultNotEqualTo(Integer value) {
            addCriterion("id_manager_result <>", value, "idManagerResult");
            return (Criteria) this;
        }

        public Criteria andIdManagerResultGreaterThan(Integer value) {
            addCriterion("id_manager_result >", value, "idManagerResult");
            return (Criteria) this;
        }

        public Criteria andIdManagerResultGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_manager_result >=", value, "idManagerResult");
            return (Criteria) this;
        }

        public Criteria andIdManagerResultLessThan(Integer value) {
            addCriterion("id_manager_result <", value, "idManagerResult");
            return (Criteria) this;
        }

        public Criteria andIdManagerResultLessThanOrEqualTo(Integer value) {
            addCriterion("id_manager_result <=", value, "idManagerResult");
            return (Criteria) this;
        }

        public Criteria andIdManagerResultIn(List<Integer> values) {
            addCriterion("id_manager_result in", values, "idManagerResult");
            return (Criteria) this;
        }

        public Criteria andIdManagerResultNotIn(List<Integer> values) {
            addCriterion("id_manager_result not in", values, "idManagerResult");
            return (Criteria) this;
        }

        public Criteria andIdManagerResultBetween(Integer value1, Integer value2) {
            addCriterion("id_manager_result between", value1, value2, "idManagerResult");
            return (Criteria) this;
        }

        public Criteria andIdManagerResultNotBetween(Integer value1, Integer value2) {
            addCriterion("id_manager_result not between", value1, value2, "idManagerResult");
            return (Criteria) this;
        }

        public Criteria andIdManagerIsNull() {
            addCriterion("id_manager is null");
            return (Criteria) this;
        }

        public Criteria andIdManagerIsNotNull() {
            addCriterion("id_manager is not null");
            return (Criteria) this;
        }

        public Criteria andIdManagerEqualTo(Short value) {
            addCriterion("id_manager =", value, "idManager");
            return (Criteria) this;
        }

        public Criteria andIdManagerNotEqualTo(Short value) {
            addCriterion("id_manager <>", value, "idManager");
            return (Criteria) this;
        }

        public Criteria andIdManagerGreaterThan(Short value) {
            addCriterion("id_manager >", value, "idManager");
            return (Criteria) this;
        }

        public Criteria andIdManagerGreaterThanOrEqualTo(Short value) {
            addCriterion("id_manager >=", value, "idManager");
            return (Criteria) this;
        }

        public Criteria andIdManagerLessThan(Short value) {
            addCriterion("id_manager <", value, "idManager");
            return (Criteria) this;
        }

        public Criteria andIdManagerLessThanOrEqualTo(Short value) {
            addCriterion("id_manager <=", value, "idManager");
            return (Criteria) this;
        }

        public Criteria andIdManagerIn(List<Short> values) {
            addCriterion("id_manager in", values, "idManager");
            return (Criteria) this;
        }

        public Criteria andIdManagerNotIn(List<Short> values) {
            addCriterion("id_manager not in", values, "idManager");
            return (Criteria) this;
        }

        public Criteria andIdManagerBetween(Short value1, Short value2) {
            addCriterion("id_manager between", value1, value2, "idManager");
            return (Criteria) this;
        }

        public Criteria andIdManagerNotBetween(Short value1, Short value2) {
            addCriterion("id_manager not between", value1, value2, "idManager");
            return (Criteria) this;
        }

        public Criteria andIdSeasonIsNull() {
            addCriterion("id_season is null");
            return (Criteria) this;
        }

        public Criteria andIdSeasonIsNotNull() {
            addCriterion("id_season is not null");
            return (Criteria) this;
        }

        public Criteria andIdSeasonEqualTo(Short value) {
            addCriterion("id_season =", value, "idSeason");
            return (Criteria) this;
        }

        public Criteria andIdSeasonNotEqualTo(Short value) {
            addCriterion("id_season <>", value, "idSeason");
            return (Criteria) this;
        }

        public Criteria andIdSeasonGreaterThan(Short value) {
            addCriterion("id_season >", value, "idSeason");
            return (Criteria) this;
        }

        public Criteria andIdSeasonGreaterThanOrEqualTo(Short value) {
            addCriterion("id_season >=", value, "idSeason");
            return (Criteria) this;
        }

        public Criteria andIdSeasonLessThan(Short value) {
            addCriterion("id_season <", value, "idSeason");
            return (Criteria) this;
        }

        public Criteria andIdSeasonLessThanOrEqualTo(Short value) {
            addCriterion("id_season <=", value, "idSeason");
            return (Criteria) this;
        }

        public Criteria andIdSeasonIn(List<Short> values) {
            addCriterion("id_season in", values, "idSeason");
            return (Criteria) this;
        }

        public Criteria andIdSeasonNotIn(List<Short> values) {
            addCriterion("id_season not in", values, "idSeason");
            return (Criteria) this;
        }

        public Criteria andIdSeasonBetween(Short value1, Short value2) {
            addCriterion("id_season between", value1, value2, "idSeason");
            return (Criteria) this;
        }

        public Criteria andIdSeasonNotBetween(Short value1, Short value2) {
            addCriterion("id_season not between", value1, value2, "idSeason");
            return (Criteria) this;
        }

        public Criteria andIdRaceIsNull() {
            addCriterion("id_race is null");
            return (Criteria) this;
        }

        public Criteria andIdRaceIsNotNull() {
            addCriterion("id_race is not null");
            return (Criteria) this;
        }

        public Criteria andIdRaceEqualTo(Short value) {
            addCriterion("id_race =", value, "idRace");
            return (Criteria) this;
        }

        public Criteria andIdRaceNotEqualTo(Short value) {
            addCriterion("id_race <>", value, "idRace");
            return (Criteria) this;
        }

        public Criteria andIdRaceGreaterThan(Short value) {
            addCriterion("id_race >", value, "idRace");
            return (Criteria) this;
        }

        public Criteria andIdRaceGreaterThanOrEqualTo(Short value) {
            addCriterion("id_race >=", value, "idRace");
            return (Criteria) this;
        }

        public Criteria andIdRaceLessThan(Short value) {
            addCriterion("id_race <", value, "idRace");
            return (Criteria) this;
        }

        public Criteria andIdRaceLessThanOrEqualTo(Short value) {
            addCriterion("id_race <=", value, "idRace");
            return (Criteria) this;
        }

        public Criteria andIdRaceIn(List<Short> values) {
            addCriterion("id_race in", values, "idRace");
            return (Criteria) this;
        }

        public Criteria andIdRaceNotIn(List<Short> values) {
            addCriterion("id_race not in", values, "idRace");
            return (Criteria) this;
        }

        public Criteria andIdRaceBetween(Short value1, Short value2) {
            addCriterion("id_race between", value1, value2, "idRace");
            return (Criteria) this;
        }

        public Criteria andIdRaceNotBetween(Short value1, Short value2) {
            addCriterion("id_race not between", value1, value2, "idRace");
            return (Criteria) this;
        }

        public Criteria andRacePositionIsNull() {
            addCriterion("race_position is null");
            return (Criteria) this;
        }

        public Criteria andRacePositionIsNotNull() {
            addCriterion("race_position is not null");
            return (Criteria) this;
        }

        public Criteria andRacePositionEqualTo(Short value) {
            addCriterion("race_position =", value, "racePosition");
            return (Criteria) this;
        }

        public Criteria andRacePositionNotEqualTo(Short value) {
            addCriterion("race_position <>", value, "racePosition");
            return (Criteria) this;
        }

        public Criteria andRacePositionGreaterThan(Short value) {
            addCriterion("race_position >", value, "racePosition");
            return (Criteria) this;
        }

        public Criteria andRacePositionGreaterThanOrEqualTo(Short value) {
            addCriterion("race_position >=", value, "racePosition");
            return (Criteria) this;
        }

        public Criteria andRacePositionLessThan(Short value) {
            addCriterion("race_position <", value, "racePosition");
            return (Criteria) this;
        }

        public Criteria andRacePositionLessThanOrEqualTo(Short value) {
            addCriterion("race_position <=", value, "racePosition");
            return (Criteria) this;
        }

        public Criteria andRacePositionIn(List<Short> values) {
            addCriterion("race_position in", values, "racePosition");
            return (Criteria) this;
        }

        public Criteria andRacePositionNotIn(List<Short> values) {
            addCriterion("race_position not in", values, "racePosition");
            return (Criteria) this;
        }

        public Criteria andRacePositionBetween(Short value1, Short value2) {
            addCriterion("race_position between", value1, value2, "racePosition");
            return (Criteria) this;
        }

        public Criteria andRacePositionNotBetween(Short value1, Short value2) {
            addCriterion("race_position not between", value1, value2, "racePosition");
            return (Criteria) this;
        }

        public Criteria andGridPositionIsNull() {
            addCriterion("grid_position is null");
            return (Criteria) this;
        }

        public Criteria andGridPositionIsNotNull() {
            addCriterion("grid_position is not null");
            return (Criteria) this;
        }

        public Criteria andGridPositionEqualTo(Short value) {
            addCriterion("grid_position =", value, "gridPosition");
            return (Criteria) this;
        }

        public Criteria andGridPositionNotEqualTo(Short value) {
            addCriterion("grid_position <>", value, "gridPosition");
            return (Criteria) this;
        }

        public Criteria andGridPositionGreaterThan(Short value) {
            addCriterion("grid_position >", value, "gridPosition");
            return (Criteria) this;
        }

        public Criteria andGridPositionGreaterThanOrEqualTo(Short value) {
            addCriterion("grid_position >=", value, "gridPosition");
            return (Criteria) this;
        }

        public Criteria andGridPositionLessThan(Short value) {
            addCriterion("grid_position <", value, "gridPosition");
            return (Criteria) this;
        }

        public Criteria andGridPositionLessThanOrEqualTo(Short value) {
            addCriterion("grid_position <=", value, "gridPosition");
            return (Criteria) this;
        }

        public Criteria andGridPositionIn(List<Short> values) {
            addCriterion("grid_position in", values, "gridPosition");
            return (Criteria) this;
        }

        public Criteria andGridPositionNotIn(List<Short> values) {
            addCriterion("grid_position not in", values, "gridPosition");
            return (Criteria) this;
        }

        public Criteria andGridPositionBetween(Short value1, Short value2) {
            addCriterion("grid_position between", value1, value2, "gridPosition");
            return (Criteria) this;
        }

        public Criteria andGridPositionNotBetween(Short value1, Short value2) {
            addCriterion("grid_position not between", value1, value2, "gridPosition");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table manager_result
     *
     * @mbg.generated do_not_delete_during_merge Fri May 10 13:24:21 CEST 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table manager_result
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}