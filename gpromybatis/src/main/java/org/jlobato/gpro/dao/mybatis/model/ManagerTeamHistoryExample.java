package org.jlobato.gpro.dao.mybatis.model;

import java.util.ArrayList;
import java.util.List;

public class ManagerTeamHistoryExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table manager_team_history
     *
     * @mbg.generated Sat Mar 28 10:44:39 CET 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table manager_team_history
     *
     * @mbg.generated Sat Mar 28 10:44:39 CET 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table manager_team_history
     *
     * @mbg.generated Sat Mar 28 10:44:39 CET 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_team_history
     *
     * @mbg.generated Sat Mar 28 10:44:39 CET 2020
     */
    public ManagerTeamHistoryExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_team_history
     *
     * @mbg.generated Sat Mar 28 10:44:39 CET 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_team_history
     *
     * @mbg.generated Sat Mar 28 10:44:39 CET 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_team_history
     *
     * @mbg.generated Sat Mar 28 10:44:39 CET 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_team_history
     *
     * @mbg.generated Sat Mar 28 10:44:39 CET 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_team_history
     *
     * @mbg.generated Sat Mar 28 10:44:39 CET 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_team_history
     *
     * @mbg.generated Sat Mar 28 10:44:39 CET 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_team_history
     *
     * @mbg.generated Sat Mar 28 10:44:39 CET 2020
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_team_history
     *
     * @mbg.generated Sat Mar 28 10:44:39 CET 2020
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
     * This method corresponds to the database table manager_team_history
     *
     * @mbg.generated Sat Mar 28 10:44:39 CET 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_team_history
     *
     * @mbg.generated Sat Mar 28 10:44:39 CET 2020
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table manager_team_history
     *
     * @mbg.generated Sat Mar 28 10:44:39 CET 2020
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

        public Criteria andIdManagerTeamHistoryIsNull() {
            addCriterion("id_manager_team_history is null");
            return (Criteria) this;
        }

        public Criteria andIdManagerTeamHistoryIsNotNull() {
            addCriterion("id_manager_team_history is not null");
            return (Criteria) this;
        }

        public Criteria andIdManagerTeamHistoryEqualTo(Integer value) {
            addCriterion("id_manager_team_history =", value, "idManagerTeamHistory");
            return (Criteria) this;
        }

        public Criteria andIdManagerTeamHistoryNotEqualTo(Integer value) {
            addCriterion("id_manager_team_history <>", value, "idManagerTeamHistory");
            return (Criteria) this;
        }

        public Criteria andIdManagerTeamHistoryGreaterThan(Integer value) {
            addCriterion("id_manager_team_history >", value, "idManagerTeamHistory");
            return (Criteria) this;
        }

        public Criteria andIdManagerTeamHistoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_manager_team_history >=", value, "idManagerTeamHistory");
            return (Criteria) this;
        }

        public Criteria andIdManagerTeamHistoryLessThan(Integer value) {
            addCriterion("id_manager_team_history <", value, "idManagerTeamHistory");
            return (Criteria) this;
        }

        public Criteria andIdManagerTeamHistoryLessThanOrEqualTo(Integer value) {
            addCriterion("id_manager_team_history <=", value, "idManagerTeamHistory");
            return (Criteria) this;
        }

        public Criteria andIdManagerTeamHistoryIn(List<Integer> values) {
            addCriterion("id_manager_team_history in", values, "idManagerTeamHistory");
            return (Criteria) this;
        }

        public Criteria andIdManagerTeamHistoryNotIn(List<Integer> values) {
            addCriterion("id_manager_team_history not in", values, "idManagerTeamHistory");
            return (Criteria) this;
        }

        public Criteria andIdManagerTeamHistoryBetween(Integer value1, Integer value2) {
            addCriterion("id_manager_team_history between", value1, value2, "idManagerTeamHistory");
            return (Criteria) this;
        }

        public Criteria andIdManagerTeamHistoryNotBetween(Integer value1, Integer value2) {
            addCriterion("id_manager_team_history not between", value1, value2, "idManagerTeamHistory");
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

        public Criteria andIdSeasonStartIsNull() {
            addCriterion("id_season_start is null");
            return (Criteria) this;
        }

        public Criteria andIdSeasonStartIsNotNull() {
            addCriterion("id_season_start is not null");
            return (Criteria) this;
        }

        public Criteria andIdSeasonStartEqualTo(Short value) {
            addCriterion("id_season_start =", value, "idSeasonStart");
            return (Criteria) this;
        }

        public Criteria andIdSeasonStartNotEqualTo(Short value) {
            addCriterion("id_season_start <>", value, "idSeasonStart");
            return (Criteria) this;
        }

        public Criteria andIdSeasonStartGreaterThan(Short value) {
            addCriterion("id_season_start >", value, "idSeasonStart");
            return (Criteria) this;
        }

        public Criteria andIdSeasonStartGreaterThanOrEqualTo(Short value) {
            addCriterion("id_season_start >=", value, "idSeasonStart");
            return (Criteria) this;
        }

        public Criteria andIdSeasonStartLessThan(Short value) {
            addCriterion("id_season_start <", value, "idSeasonStart");
            return (Criteria) this;
        }

        public Criteria andIdSeasonStartLessThanOrEqualTo(Short value) {
            addCriterion("id_season_start <=", value, "idSeasonStart");
            return (Criteria) this;
        }

        public Criteria andIdSeasonStartIn(List<Short> values) {
            addCriterion("id_season_start in", values, "idSeasonStart");
            return (Criteria) this;
        }

        public Criteria andIdSeasonStartNotIn(List<Short> values) {
            addCriterion("id_season_start not in", values, "idSeasonStart");
            return (Criteria) this;
        }

        public Criteria andIdSeasonStartBetween(Short value1, Short value2) {
            addCriterion("id_season_start between", value1, value2, "idSeasonStart");
            return (Criteria) this;
        }

        public Criteria andIdSeasonStartNotBetween(Short value1, Short value2) {
            addCriterion("id_season_start not between", value1, value2, "idSeasonStart");
            return (Criteria) this;
        }

        public Criteria andIdRaceStartIsNull() {
            addCriterion("id_race_start is null");
            return (Criteria) this;
        }

        public Criteria andIdRaceStartIsNotNull() {
            addCriterion("id_race_start is not null");
            return (Criteria) this;
        }

        public Criteria andIdRaceStartEqualTo(Short value) {
            addCriterion("id_race_start =", value, "idRaceStart");
            return (Criteria) this;
        }

        public Criteria andIdRaceStartNotEqualTo(Short value) {
            addCriterion("id_race_start <>", value, "idRaceStart");
            return (Criteria) this;
        }

        public Criteria andIdRaceStartGreaterThan(Short value) {
            addCriterion("id_race_start >", value, "idRaceStart");
            return (Criteria) this;
        }

        public Criteria andIdRaceStartGreaterThanOrEqualTo(Short value) {
            addCriterion("id_race_start >=", value, "idRaceStart");
            return (Criteria) this;
        }

        public Criteria andIdRaceStartLessThan(Short value) {
            addCriterion("id_race_start <", value, "idRaceStart");
            return (Criteria) this;
        }

        public Criteria andIdRaceStartLessThanOrEqualTo(Short value) {
            addCriterion("id_race_start <=", value, "idRaceStart");
            return (Criteria) this;
        }

        public Criteria andIdRaceStartIn(List<Short> values) {
            addCriterion("id_race_start in", values, "idRaceStart");
            return (Criteria) this;
        }

        public Criteria andIdRaceStartNotIn(List<Short> values) {
            addCriterion("id_race_start not in", values, "idRaceStart");
            return (Criteria) this;
        }

        public Criteria andIdRaceStartBetween(Short value1, Short value2) {
            addCriterion("id_race_start between", value1, value2, "idRaceStart");
            return (Criteria) this;
        }

        public Criteria andIdRaceStartNotBetween(Short value1, Short value2) {
            addCriterion("id_race_start not between", value1, value2, "idRaceStart");
            return (Criteria) this;
        }

        public Criteria andIdSeasonEndIsNull() {
            addCriterion("id_season_end is null");
            return (Criteria) this;
        }

        public Criteria andIdSeasonEndIsNotNull() {
            addCriterion("id_season_end is not null");
            return (Criteria) this;
        }

        public Criteria andIdSeasonEndEqualTo(Short value) {
            addCriterion("id_season_end =", value, "idSeasonEnd");
            return (Criteria) this;
        }

        public Criteria andIdSeasonEndNotEqualTo(Short value) {
            addCriterion("id_season_end <>", value, "idSeasonEnd");
            return (Criteria) this;
        }

        public Criteria andIdSeasonEndGreaterThan(Short value) {
            addCriterion("id_season_end >", value, "idSeasonEnd");
            return (Criteria) this;
        }

        public Criteria andIdSeasonEndGreaterThanOrEqualTo(Short value) {
            addCriterion("id_season_end >=", value, "idSeasonEnd");
            return (Criteria) this;
        }

        public Criteria andIdSeasonEndLessThan(Short value) {
            addCriterion("id_season_end <", value, "idSeasonEnd");
            return (Criteria) this;
        }

        public Criteria andIdSeasonEndLessThanOrEqualTo(Short value) {
            addCriterion("id_season_end <=", value, "idSeasonEnd");
            return (Criteria) this;
        }

        public Criteria andIdSeasonEndIn(List<Short> values) {
            addCriterion("id_season_end in", values, "idSeasonEnd");
            return (Criteria) this;
        }

        public Criteria andIdSeasonEndNotIn(List<Short> values) {
            addCriterion("id_season_end not in", values, "idSeasonEnd");
            return (Criteria) this;
        }

        public Criteria andIdSeasonEndBetween(Short value1, Short value2) {
            addCriterion("id_season_end between", value1, value2, "idSeasonEnd");
            return (Criteria) this;
        }

        public Criteria andIdSeasonEndNotBetween(Short value1, Short value2) {
            addCriterion("id_season_end not between", value1, value2, "idSeasonEnd");
            return (Criteria) this;
        }

        public Criteria andIdRaceEndIsNull() {
            addCriterion("id_race_end is null");
            return (Criteria) this;
        }

        public Criteria andIdRaceEndIsNotNull() {
            addCriterion("id_race_end is not null");
            return (Criteria) this;
        }

        public Criteria andIdRaceEndEqualTo(Short value) {
            addCriterion("id_race_end =", value, "idRaceEnd");
            return (Criteria) this;
        }

        public Criteria andIdRaceEndNotEqualTo(Short value) {
            addCriterion("id_race_end <>", value, "idRaceEnd");
            return (Criteria) this;
        }

        public Criteria andIdRaceEndGreaterThan(Short value) {
            addCriterion("id_race_end >", value, "idRaceEnd");
            return (Criteria) this;
        }

        public Criteria andIdRaceEndGreaterThanOrEqualTo(Short value) {
            addCriterion("id_race_end >=", value, "idRaceEnd");
            return (Criteria) this;
        }

        public Criteria andIdRaceEndLessThan(Short value) {
            addCriterion("id_race_end <", value, "idRaceEnd");
            return (Criteria) this;
        }

        public Criteria andIdRaceEndLessThanOrEqualTo(Short value) {
            addCriterion("id_race_end <=", value, "idRaceEnd");
            return (Criteria) this;
        }

        public Criteria andIdRaceEndIn(List<Short> values) {
            addCriterion("id_race_end in", values, "idRaceEnd");
            return (Criteria) this;
        }

        public Criteria andIdRaceEndNotIn(List<Short> values) {
            addCriterion("id_race_end not in", values, "idRaceEnd");
            return (Criteria) this;
        }

        public Criteria andIdRaceEndBetween(Short value1, Short value2) {
            addCriterion("id_race_end between", value1, value2, "idRaceEnd");
            return (Criteria) this;
        }

        public Criteria andIdRaceEndNotBetween(Short value1, Short value2) {
            addCriterion("id_race_end not between", value1, value2, "idRaceEnd");
            return (Criteria) this;
        }

        public Criteria andIdTeamIsNull() {
            addCriterion("id_team is null");
            return (Criteria) this;
        }

        public Criteria andIdTeamIsNotNull() {
            addCriterion("id_team is not null");
            return (Criteria) this;
        }

        public Criteria andIdTeamEqualTo(Short value) {
            addCriterion("id_team =", value, "idTeam");
            return (Criteria) this;
        }

        public Criteria andIdTeamNotEqualTo(Short value) {
            addCriterion("id_team <>", value, "idTeam");
            return (Criteria) this;
        }

        public Criteria andIdTeamGreaterThan(Short value) {
            addCriterion("id_team >", value, "idTeam");
            return (Criteria) this;
        }

        public Criteria andIdTeamGreaterThanOrEqualTo(Short value) {
            addCriterion("id_team >=", value, "idTeam");
            return (Criteria) this;
        }

        public Criteria andIdTeamLessThan(Short value) {
            addCriterion("id_team <", value, "idTeam");
            return (Criteria) this;
        }

        public Criteria andIdTeamLessThanOrEqualTo(Short value) {
            addCriterion("id_team <=", value, "idTeam");
            return (Criteria) this;
        }

        public Criteria andIdTeamIn(List<Short> values) {
            addCriterion("id_team in", values, "idTeam");
            return (Criteria) this;
        }

        public Criteria andIdTeamNotIn(List<Short> values) {
            addCriterion("id_team not in", values, "idTeam");
            return (Criteria) this;
        }

        public Criteria andIdTeamBetween(Short value1, Short value2) {
            addCriterion("id_team between", value1, value2, "idTeam");
            return (Criteria) this;
        }

        public Criteria andIdTeamNotBetween(Short value1, Short value2) {
            addCriterion("id_team not between", value1, value2, "idTeam");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table manager_team_history
     *
     * @mbg.generated do_not_delete_during_merge Sat Mar 28 10:44:39 CET 2020
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table manager_team_history
     *
     * @mbg.generated Sat Mar 28 10:44:39 CET 2020
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