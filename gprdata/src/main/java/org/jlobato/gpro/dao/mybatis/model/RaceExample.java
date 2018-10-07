package org.jlobato.gpro.dao.mybatis.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RaceExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table race
     *
     * @mbg.generated Sat May 06 16:20:58 CEST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table race
     *
     * @mbg.generated Sat May 06 16:20:58 CEST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table race
     *
     * @mbg.generated Sat May 06 16:20:58 CEST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table race
     *
     * @mbg.generated Sat May 06 16:20:58 CEST 2017
     */
    public RaceExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table race
     *
     * @mbg.generated Sat May 06 16:20:58 CEST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table race
     *
     * @mbg.generated Sat May 06 16:20:58 CEST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table race
     *
     * @mbg.generated Sat May 06 16:20:58 CEST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table race
     *
     * @mbg.generated Sat May 06 16:20:58 CEST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table race
     *
     * @mbg.generated Sat May 06 16:20:58 CEST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table race
     *
     * @mbg.generated Sat May 06 16:20:58 CEST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table race
     *
     * @mbg.generated Sat May 06 16:20:58 CEST 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table race
     *
     * @mbg.generated Sat May 06 16:20:58 CEST 2017
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
     * This method corresponds to the database table race
     *
     * @mbg.generated Sat May 06 16:20:58 CEST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table race
     *
     * @mbg.generated Sat May 06 16:20:58 CEST 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table race
     *
     * @mbg.generated Sat May 06 16:20:58 CEST 2017
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andCodeRaceIsNull() {
            addCriterion("code_race is null");
            return (Criteria) this;
        }

        public Criteria andCodeRaceIsNotNull() {
            addCriterion("code_race is not null");
            return (Criteria) this;
        }

        public Criteria andCodeRaceEqualTo(String value) {
            addCriterion("code_race =", value, "codeRace");
            return (Criteria) this;
        }

        public Criteria andCodeRaceNotEqualTo(String value) {
            addCriterion("code_race <>", value, "codeRace");
            return (Criteria) this;
        }

        public Criteria andCodeRaceGreaterThan(String value) {
            addCriterion("code_race >", value, "codeRace");
            return (Criteria) this;
        }

        public Criteria andCodeRaceGreaterThanOrEqualTo(String value) {
            addCriterion("code_race >=", value, "codeRace");
            return (Criteria) this;
        }

        public Criteria andCodeRaceLessThan(String value) {
            addCriterion("code_race <", value, "codeRace");
            return (Criteria) this;
        }

        public Criteria andCodeRaceLessThanOrEqualTo(String value) {
            addCriterion("code_race <=", value, "codeRace");
            return (Criteria) this;
        }

        public Criteria andCodeRaceLike(String value) {
            addCriterion("code_race like", value, "codeRace");
            return (Criteria) this;
        }

        public Criteria andCodeRaceNotLike(String value) {
            addCriterion("code_race not like", value, "codeRace");
            return (Criteria) this;
        }

        public Criteria andCodeRaceIn(List<String> values) {
            addCriterion("code_race in", values, "codeRace");
            return (Criteria) this;
        }

        public Criteria andCodeRaceNotIn(List<String> values) {
            addCriterion("code_race not in", values, "codeRace");
            return (Criteria) this;
        }

        public Criteria andCodeRaceBetween(String value1, String value2) {
            addCriterion("code_race between", value1, value2, "codeRace");
            return (Criteria) this;
        }

        public Criteria andCodeRaceNotBetween(String value1, String value2) {
            addCriterion("code_race not between", value1, value2, "codeRace");
            return (Criteria) this;
        }

        public Criteria andDescriptionRaceIsNull() {
            addCriterion("description_race is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionRaceIsNotNull() {
            addCriterion("description_race is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionRaceEqualTo(String value) {
            addCriterion("description_race =", value, "descriptionRace");
            return (Criteria) this;
        }

        public Criteria andDescriptionRaceNotEqualTo(String value) {
            addCriterion("description_race <>", value, "descriptionRace");
            return (Criteria) this;
        }

        public Criteria andDescriptionRaceGreaterThan(String value) {
            addCriterion("description_race >", value, "descriptionRace");
            return (Criteria) this;
        }

        public Criteria andDescriptionRaceGreaterThanOrEqualTo(String value) {
            addCriterion("description_race >=", value, "descriptionRace");
            return (Criteria) this;
        }

        public Criteria andDescriptionRaceLessThan(String value) {
            addCriterion("description_race <", value, "descriptionRace");
            return (Criteria) this;
        }

        public Criteria andDescriptionRaceLessThanOrEqualTo(String value) {
            addCriterion("description_race <=", value, "descriptionRace");
            return (Criteria) this;
        }

        public Criteria andDescriptionRaceLike(String value) {
            addCriterion("description_race like", value, "descriptionRace");
            return (Criteria) this;
        }

        public Criteria andDescriptionRaceNotLike(String value) {
            addCriterion("description_race not like", value, "descriptionRace");
            return (Criteria) this;
        }

        public Criteria andDescriptionRaceIn(List<String> values) {
            addCriterion("description_race in", values, "descriptionRace");
            return (Criteria) this;
        }

        public Criteria andDescriptionRaceNotIn(List<String> values) {
            addCriterion("description_race not in", values, "descriptionRace");
            return (Criteria) this;
        }

        public Criteria andDescriptionRaceBetween(String value1, String value2) {
            addCriterion("description_race between", value1, value2, "descriptionRace");
            return (Criteria) this;
        }

        public Criteria andDescriptionRaceNotBetween(String value1, String value2) {
            addCriterion("description_race not between", value1, value2, "descriptionRace");
            return (Criteria) this;
        }

        public Criteria andRaceDateIsNull() {
            addCriterion("race_date is null");
            return (Criteria) this;
        }

        public Criteria andRaceDateIsNotNull() {
            addCriterion("race_date is not null");
            return (Criteria) this;
        }

        public Criteria andRaceDateEqualTo(Date value) {
            addCriterionForJDBCDate("race_date =", value, "raceDate");
            return (Criteria) this;
        }

        public Criteria andRaceDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("race_date <>", value, "raceDate");
            return (Criteria) this;
        }

        public Criteria andRaceDateGreaterThan(Date value) {
            addCriterionForJDBCDate("race_date >", value, "raceDate");
            return (Criteria) this;
        }

        public Criteria andRaceDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("race_date >=", value, "raceDate");
            return (Criteria) this;
        }

        public Criteria andRaceDateLessThan(Date value) {
            addCriterionForJDBCDate("race_date <", value, "raceDate");
            return (Criteria) this;
        }

        public Criteria andRaceDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("race_date <=", value, "raceDate");
            return (Criteria) this;
        }

        public Criteria andRaceDateIn(List<Date> values) {
            addCriterionForJDBCDate("race_date in", values, "raceDate");
            return (Criteria) this;
        }

        public Criteria andRaceDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("race_date not in", values, "raceDate");
            return (Criteria) this;
        }

        public Criteria andRaceDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("race_date between", value1, value2, "raceDate");
            return (Criteria) this;
        }

        public Criteria andRaceDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("race_date not between", value1, value2, "raceDate");
            return (Criteria) this;
        }

        public Criteria andIdTrackIsNull() {
            addCriterion("id_track is null");
            return (Criteria) this;
        }

        public Criteria andIdTrackIsNotNull() {
            addCriterion("id_track is not null");
            return (Criteria) this;
        }

        public Criteria andIdTrackEqualTo(Short value) {
            addCriterion("id_track =", value, "idTrack");
            return (Criteria) this;
        }

        public Criteria andIdTrackNotEqualTo(Short value) {
            addCriterion("id_track <>", value, "idTrack");
            return (Criteria) this;
        }

        public Criteria andIdTrackGreaterThan(Short value) {
            addCriterion("id_track >", value, "idTrack");
            return (Criteria) this;
        }

        public Criteria andIdTrackGreaterThanOrEqualTo(Short value) {
            addCriterion("id_track >=", value, "idTrack");
            return (Criteria) this;
        }

        public Criteria andIdTrackLessThan(Short value) {
            addCriterion("id_track <", value, "idTrack");
            return (Criteria) this;
        }

        public Criteria andIdTrackLessThanOrEqualTo(Short value) {
            addCriterion("id_track <=", value, "idTrack");
            return (Criteria) this;
        }

        public Criteria andIdTrackIn(List<Short> values) {
            addCriterion("id_track in", values, "idTrack");
            return (Criteria) this;
        }

        public Criteria andIdTrackNotIn(List<Short> values) {
            addCriterion("id_track not in", values, "idTrack");
            return (Criteria) this;
        }

        public Criteria andIdTrackBetween(Short value1, Short value2) {
            addCriterion("id_track between", value1, value2, "idTrack");
            return (Criteria) this;
        }

        public Criteria andIdTrackNotBetween(Short value1, Short value2) {
            addCriterion("id_track not between", value1, value2, "idTrack");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table race
     *
     * @mbg.generated do_not_delete_during_merge Sat May 06 16:20:58 CEST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table race
     *
     * @mbg.generated Sat May 06 16:20:58 CEST 2017
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