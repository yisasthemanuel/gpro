package org.jlobato.gpro.dao.mybatis.model;

import java.util.ArrayList;
import java.util.List;

public class TeamExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table team
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table team
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table team
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
     */
    public TeamExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
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
     * This method corresponds to the database table team
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table team
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
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

        public Criteria andTeamNameIsNull() {
            addCriterion("team_name is null");
            return (Criteria) this;
        }

        public Criteria andTeamNameIsNotNull() {
            addCriterion("team_name is not null");
            return (Criteria) this;
        }

        public Criteria andTeamNameEqualTo(String value) {
            addCriterion("team_name =", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameNotEqualTo(String value) {
            addCriterion("team_name <>", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameGreaterThan(String value) {
            addCriterion("team_name >", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameGreaterThanOrEqualTo(String value) {
            addCriterion("team_name >=", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameLessThan(String value) {
            addCriterion("team_name <", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameLessThanOrEqualTo(String value) {
            addCriterion("team_name <=", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameLike(String value) {
            addCriterion("team_name like", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameNotLike(String value) {
            addCriterion("team_name not like", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameIn(List<String> values) {
            addCriterion("team_name in", values, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameNotIn(List<String> values) {
            addCriterion("team_name not in", values, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameBetween(String value1, String value2) {
            addCriterion("team_name between", value1, value2, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameNotBetween(String value1, String value2) {
            addCriterion("team_name not between", value1, value2, "teamName");
            return (Criteria) this;
        }

        public Criteria andCodeTeamIsNull() {
            addCriterion("code_team is null");
            return (Criteria) this;
        }

        public Criteria andCodeTeamIsNotNull() {
            addCriterion("code_team is not null");
            return (Criteria) this;
        }

        public Criteria andCodeTeamEqualTo(String value) {
            addCriterion("code_team =", value, "codeTeam");
            return (Criteria) this;
        }

        public Criteria andCodeTeamNotEqualTo(String value) {
            addCriterion("code_team <>", value, "codeTeam");
            return (Criteria) this;
        }

        public Criteria andCodeTeamGreaterThan(String value) {
            addCriterion("code_team >", value, "codeTeam");
            return (Criteria) this;
        }

        public Criteria andCodeTeamGreaterThanOrEqualTo(String value) {
            addCriterion("code_team >=", value, "codeTeam");
            return (Criteria) this;
        }

        public Criteria andCodeTeamLessThan(String value) {
            addCriterion("code_team <", value, "codeTeam");
            return (Criteria) this;
        }

        public Criteria andCodeTeamLessThanOrEqualTo(String value) {
            addCriterion("code_team <=", value, "codeTeam");
            return (Criteria) this;
        }

        public Criteria andCodeTeamLike(String value) {
            addCriterion("code_team like", value, "codeTeam");
            return (Criteria) this;
        }

        public Criteria andCodeTeamNotLike(String value) {
            addCriterion("code_team not like", value, "codeTeam");
            return (Criteria) this;
        }

        public Criteria andCodeTeamIn(List<String> values) {
            addCriterion("code_team in", values, "codeTeam");
            return (Criteria) this;
        }

        public Criteria andCodeTeamNotIn(List<String> values) {
            addCriterion("code_team not in", values, "codeTeam");
            return (Criteria) this;
        }

        public Criteria andCodeTeamBetween(String value1, String value2) {
            addCriterion("code_team between", value1, value2, "codeTeam");
            return (Criteria) this;
        }

        public Criteria andCodeTeamNotBetween(String value1, String value2) {
            addCriterion("code_team not between", value1, value2, "codeTeam");
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
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table team
     *
     * @mbg.generated do_not_delete_during_merge Sun Nov 04 13:28:46 CET 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table team
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
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