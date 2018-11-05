package org.jlobato.gpro.dao.mybatis.model;

import java.util.ArrayList;
import java.util.List;

public class TyreCompoundExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tyrecompound
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tyrecompound
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tyrecompound
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tyrecompound
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
     */
    public TyreCompoundExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tyrecompound
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tyrecompound
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tyrecompound
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tyrecompound
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tyrecompound
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tyrecompound
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tyrecompound
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
     * This method corresponds to the database table tyrecompound
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
     * This method corresponds to the database table tyrecompound
     *
     * @mbg.generated Sun Nov 04 13:28:46 CET 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tyrecompound
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
     * This class corresponds to the database table tyrecompound
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

        public Criteria andIdTyrecompoundIsNull() {
            addCriterion("id_tyrecompound is null");
            return (Criteria) this;
        }

        public Criteria andIdTyrecompoundIsNotNull() {
            addCriterion("id_tyrecompound is not null");
            return (Criteria) this;
        }

        public Criteria andIdTyrecompoundEqualTo(Integer value) {
            addCriterion("id_tyrecompound =", value, "idTyrecompound");
            return (Criteria) this;
        }

        public Criteria andIdTyrecompoundNotEqualTo(Integer value) {
            addCriterion("id_tyrecompound <>", value, "idTyrecompound");
            return (Criteria) this;
        }

        public Criteria andIdTyrecompoundGreaterThan(Integer value) {
            addCriterion("id_tyrecompound >", value, "idTyrecompound");
            return (Criteria) this;
        }

        public Criteria andIdTyrecompoundGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_tyrecompound >=", value, "idTyrecompound");
            return (Criteria) this;
        }

        public Criteria andIdTyrecompoundLessThan(Integer value) {
            addCriterion("id_tyrecompound <", value, "idTyrecompound");
            return (Criteria) this;
        }

        public Criteria andIdTyrecompoundLessThanOrEqualTo(Integer value) {
            addCriterion("id_tyrecompound <=", value, "idTyrecompound");
            return (Criteria) this;
        }

        public Criteria andIdTyrecompoundIn(List<Integer> values) {
            addCriterion("id_tyrecompound in", values, "idTyrecompound");
            return (Criteria) this;
        }

        public Criteria andIdTyrecompoundNotIn(List<Integer> values) {
            addCriterion("id_tyrecompound not in", values, "idTyrecompound");
            return (Criteria) this;
        }

        public Criteria andIdTyrecompoundBetween(Integer value1, Integer value2) {
            addCriterion("id_tyrecompound between", value1, value2, "idTyrecompound");
            return (Criteria) this;
        }

        public Criteria andIdTyrecompoundNotBetween(Integer value1, Integer value2) {
            addCriterion("id_tyrecompound not between", value1, value2, "idTyrecompound");
            return (Criteria) this;
        }

        public Criteria andCodCompoundIsNull() {
            addCriterion("cod_compound is null");
            return (Criteria) this;
        }

        public Criteria andCodCompoundIsNotNull() {
            addCriterion("cod_compound is not null");
            return (Criteria) this;
        }

        public Criteria andCodCompoundEqualTo(String value) {
            addCriterion("cod_compound =", value, "codCompound");
            return (Criteria) this;
        }

        public Criteria andCodCompoundNotEqualTo(String value) {
            addCriterion("cod_compound <>", value, "codCompound");
            return (Criteria) this;
        }

        public Criteria andCodCompoundGreaterThan(String value) {
            addCriterion("cod_compound >", value, "codCompound");
            return (Criteria) this;
        }

        public Criteria andCodCompoundGreaterThanOrEqualTo(String value) {
            addCriterion("cod_compound >=", value, "codCompound");
            return (Criteria) this;
        }

        public Criteria andCodCompoundLessThan(String value) {
            addCriterion("cod_compound <", value, "codCompound");
            return (Criteria) this;
        }

        public Criteria andCodCompoundLessThanOrEqualTo(String value) {
            addCriterion("cod_compound <=", value, "codCompound");
            return (Criteria) this;
        }

        public Criteria andCodCompoundLike(String value) {
            addCriterion("cod_compound like", value, "codCompound");
            return (Criteria) this;
        }

        public Criteria andCodCompoundNotLike(String value) {
            addCriterion("cod_compound not like", value, "codCompound");
            return (Criteria) this;
        }

        public Criteria andCodCompoundIn(List<String> values) {
            addCriterion("cod_compound in", values, "codCompound");
            return (Criteria) this;
        }

        public Criteria andCodCompoundNotIn(List<String> values) {
            addCriterion("cod_compound not in", values, "codCompound");
            return (Criteria) this;
        }

        public Criteria andCodCompoundBetween(String value1, String value2) {
            addCriterion("cod_compound between", value1, value2, "codCompound");
            return (Criteria) this;
        }

        public Criteria andCodCompoundNotBetween(String value1, String value2) {
            addCriterion("cod_compound not between", value1, value2, "codCompound");
            return (Criteria) this;
        }

        public Criteria andDescriptionCompoundIsNull() {
            addCriterion("description_compound is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionCompoundIsNotNull() {
            addCriterion("description_compound is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionCompoundEqualTo(String value) {
            addCriterion("description_compound =", value, "descriptionCompound");
            return (Criteria) this;
        }

        public Criteria andDescriptionCompoundNotEqualTo(String value) {
            addCriterion("description_compound <>", value, "descriptionCompound");
            return (Criteria) this;
        }

        public Criteria andDescriptionCompoundGreaterThan(String value) {
            addCriterion("description_compound >", value, "descriptionCompound");
            return (Criteria) this;
        }

        public Criteria andDescriptionCompoundGreaterThanOrEqualTo(String value) {
            addCriterion("description_compound >=", value, "descriptionCompound");
            return (Criteria) this;
        }

        public Criteria andDescriptionCompoundLessThan(String value) {
            addCriterion("description_compound <", value, "descriptionCompound");
            return (Criteria) this;
        }

        public Criteria andDescriptionCompoundLessThanOrEqualTo(String value) {
            addCriterion("description_compound <=", value, "descriptionCompound");
            return (Criteria) this;
        }

        public Criteria andDescriptionCompoundLike(String value) {
            addCriterion("description_compound like", value, "descriptionCompound");
            return (Criteria) this;
        }

        public Criteria andDescriptionCompoundNotLike(String value) {
            addCriterion("description_compound not like", value, "descriptionCompound");
            return (Criteria) this;
        }

        public Criteria andDescriptionCompoundIn(List<String> values) {
            addCriterion("description_compound in", values, "descriptionCompound");
            return (Criteria) this;
        }

        public Criteria andDescriptionCompoundNotIn(List<String> values) {
            addCriterion("description_compound not in", values, "descriptionCompound");
            return (Criteria) this;
        }

        public Criteria andDescriptionCompoundBetween(String value1, String value2) {
            addCriterion("description_compound between", value1, value2, "descriptionCompound");
            return (Criteria) this;
        }

        public Criteria andDescriptionCompoundNotBetween(String value1, String value2) {
            addCriterion("description_compound not between", value1, value2, "descriptionCompound");
            return (Criteria) this;
        }

        public Criteria andSortOrderIsNull() {
            addCriterion("sort_order is null");
            return (Criteria) this;
        }

        public Criteria andSortOrderIsNotNull() {
            addCriterion("sort_order is not null");
            return (Criteria) this;
        }

        public Criteria andSortOrderEqualTo(Short value) {
            addCriterion("sort_order =", value, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderNotEqualTo(Short value) {
            addCriterion("sort_order <>", value, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderGreaterThan(Short value) {
            addCriterion("sort_order >", value, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderGreaterThanOrEqualTo(Short value) {
            addCriterion("sort_order >=", value, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderLessThan(Short value) {
            addCriterion("sort_order <", value, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderLessThanOrEqualTo(Short value) {
            addCriterion("sort_order <=", value, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderIn(List<Short> values) {
            addCriterion("sort_order in", values, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderNotIn(List<Short> values) {
            addCriterion("sort_order not in", values, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderBetween(Short value1, Short value2) {
            addCriterion("sort_order between", value1, value2, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderNotBetween(Short value1, Short value2) {
            addCriterion("sort_order not between", value1, value2, "sortOrder");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tyrecompound
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
     * This class corresponds to the database table tyrecompound
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