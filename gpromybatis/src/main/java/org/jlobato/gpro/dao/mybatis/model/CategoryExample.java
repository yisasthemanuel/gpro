package org.jlobato.gpro.dao.mybatis.model;

import java.util.ArrayList;
import java.util.List;

public class CategoryExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table category
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table category
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table category
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public CategoryExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
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
     * This method corresponds to the database table category
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table category
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
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

        public Criteria andIdCategoryIsNull() {
            addCriterion("id_category is null");
            return (Criteria) this;
        }

        public Criteria andIdCategoryIsNotNull() {
            addCriterion("id_category is not null");
            return (Criteria) this;
        }

        public Criteria andIdCategoryEqualTo(Short value) {
            addCriterion("id_category =", value, "idCategory");
            return (Criteria) this;
        }

        public Criteria andIdCategoryNotEqualTo(Short value) {
            addCriterion("id_category <>", value, "idCategory");
            return (Criteria) this;
        }

        public Criteria andIdCategoryGreaterThan(Short value) {
            addCriterion("id_category >", value, "idCategory");
            return (Criteria) this;
        }

        public Criteria andIdCategoryGreaterThanOrEqualTo(Short value) {
            addCriterion("id_category >=", value, "idCategory");
            return (Criteria) this;
        }

        public Criteria andIdCategoryLessThan(Short value) {
            addCriterion("id_category <", value, "idCategory");
            return (Criteria) this;
        }

        public Criteria andIdCategoryLessThanOrEqualTo(Short value) {
            addCriterion("id_category <=", value, "idCategory");
            return (Criteria) this;
        }

        public Criteria andIdCategoryIn(List<Short> values) {
            addCriterion("id_category in", values, "idCategory");
            return (Criteria) this;
        }

        public Criteria andIdCategoryNotIn(List<Short> values) {
            addCriterion("id_category not in", values, "idCategory");
            return (Criteria) this;
        }

        public Criteria andIdCategoryBetween(Short value1, Short value2) {
            addCriterion("id_category between", value1, value2, "idCategory");
            return (Criteria) this;
        }

        public Criteria andIdCategoryNotBetween(Short value1, Short value2) {
            addCriterion("id_category not between", value1, value2, "idCategory");
            return (Criteria) this;
        }

        public Criteria andCodeCategoryIsNull() {
            addCriterion("code_category is null");
            return (Criteria) this;
        }

        public Criteria andCodeCategoryIsNotNull() {
            addCriterion("code_category is not null");
            return (Criteria) this;
        }

        public Criteria andCodeCategoryEqualTo(String value) {
            addCriterion("code_category =", value, "codeCategory");
            return (Criteria) this;
        }

        public Criteria andCodeCategoryNotEqualTo(String value) {
            addCriterion("code_category <>", value, "codeCategory");
            return (Criteria) this;
        }

        public Criteria andCodeCategoryGreaterThan(String value) {
            addCriterion("code_category >", value, "codeCategory");
            return (Criteria) this;
        }

        public Criteria andCodeCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("code_category >=", value, "codeCategory");
            return (Criteria) this;
        }

        public Criteria andCodeCategoryLessThan(String value) {
            addCriterion("code_category <", value, "codeCategory");
            return (Criteria) this;
        }

        public Criteria andCodeCategoryLessThanOrEqualTo(String value) {
            addCriterion("code_category <=", value, "codeCategory");
            return (Criteria) this;
        }

        public Criteria andCodeCategoryLike(String value) {
            addCriterion("code_category like", value, "codeCategory");
            return (Criteria) this;
        }

        public Criteria andCodeCategoryNotLike(String value) {
            addCriterion("code_category not like", value, "codeCategory");
            return (Criteria) this;
        }

        public Criteria andCodeCategoryIn(List<String> values) {
            addCriterion("code_category in", values, "codeCategory");
            return (Criteria) this;
        }

        public Criteria andCodeCategoryNotIn(List<String> values) {
            addCriterion("code_category not in", values, "codeCategory");
            return (Criteria) this;
        }

        public Criteria andCodeCategoryBetween(String value1, String value2) {
            addCriterion("code_category between", value1, value2, "codeCategory");
            return (Criteria) this;
        }

        public Criteria andCodeCategoryNotBetween(String value1, String value2) {
            addCriterion("code_category not between", value1, value2, "codeCategory");
            return (Criteria) this;
        }

        public Criteria andDescriptionCategoryIsNull() {
            addCriterion("description_category is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionCategoryIsNotNull() {
            addCriterion("description_category is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionCategoryEqualTo(String value) {
            addCriterion("description_category =", value, "descriptionCategory");
            return (Criteria) this;
        }

        public Criteria andDescriptionCategoryNotEqualTo(String value) {
            addCriterion("description_category <>", value, "descriptionCategory");
            return (Criteria) this;
        }

        public Criteria andDescriptionCategoryGreaterThan(String value) {
            addCriterion("description_category >", value, "descriptionCategory");
            return (Criteria) this;
        }

        public Criteria andDescriptionCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("description_category >=", value, "descriptionCategory");
            return (Criteria) this;
        }

        public Criteria andDescriptionCategoryLessThan(String value) {
            addCriterion("description_category <", value, "descriptionCategory");
            return (Criteria) this;
        }

        public Criteria andDescriptionCategoryLessThanOrEqualTo(String value) {
            addCriterion("description_category <=", value, "descriptionCategory");
            return (Criteria) this;
        }

        public Criteria andDescriptionCategoryLike(String value) {
            addCriterion("description_category like", value, "descriptionCategory");
            return (Criteria) this;
        }

        public Criteria andDescriptionCategoryNotLike(String value) {
            addCriterion("description_category not like", value, "descriptionCategory");
            return (Criteria) this;
        }

        public Criteria andDescriptionCategoryIn(List<String> values) {
            addCriterion("description_category in", values, "descriptionCategory");
            return (Criteria) this;
        }

        public Criteria andDescriptionCategoryNotIn(List<String> values) {
            addCriterion("description_category not in", values, "descriptionCategory");
            return (Criteria) this;
        }

        public Criteria andDescriptionCategoryBetween(String value1, String value2) {
            addCriterion("description_category between", value1, value2, "descriptionCategory");
            return (Criteria) this;
        }

        public Criteria andDescriptionCategoryNotBetween(String value1, String value2) {
            addCriterion("description_category not between", value1, value2, "descriptionCategory");
            return (Criteria) this;
        }

        public Criteria andLvlCategoryIsNull() {
            addCriterion("lvl_category is null");
            return (Criteria) this;
        }

        public Criteria andLvlCategoryIsNotNull() {
            addCriterion("lvl_category is not null");
            return (Criteria) this;
        }

        public Criteria andLvlCategoryEqualTo(Short value) {
            addCriterion("lvl_category =", value, "lvlCategory");
            return (Criteria) this;
        }

        public Criteria andLvlCategoryNotEqualTo(Short value) {
            addCriterion("lvl_category <>", value, "lvlCategory");
            return (Criteria) this;
        }

        public Criteria andLvlCategoryGreaterThan(Short value) {
            addCriterion("lvl_category >", value, "lvlCategory");
            return (Criteria) this;
        }

        public Criteria andLvlCategoryGreaterThanOrEqualTo(Short value) {
            addCriterion("lvl_category >=", value, "lvlCategory");
            return (Criteria) this;
        }

        public Criteria andLvlCategoryLessThan(Short value) {
            addCriterion("lvl_category <", value, "lvlCategory");
            return (Criteria) this;
        }

        public Criteria andLvlCategoryLessThanOrEqualTo(Short value) {
            addCriterion("lvl_category <=", value, "lvlCategory");
            return (Criteria) this;
        }

        public Criteria andLvlCategoryIn(List<Short> values) {
            addCriterion("lvl_category in", values, "lvlCategory");
            return (Criteria) this;
        }

        public Criteria andLvlCategoryNotIn(List<Short> values) {
            addCriterion("lvl_category not in", values, "lvlCategory");
            return (Criteria) this;
        }

        public Criteria andLvlCategoryBetween(Short value1, Short value2) {
            addCriterion("lvl_category between", value1, value2, "lvlCategory");
            return (Criteria) this;
        }

        public Criteria andLvlCategoryNotBetween(Short value1, Short value2) {
            addCriterion("lvl_category not between", value1, value2, "lvlCategory");
            return (Criteria) this;
        }

        public Criteria andCodeAltCategoryIsNull() {
            addCriterion("code_alt_category is null");
            return (Criteria) this;
        }

        public Criteria andCodeAltCategoryIsNotNull() {
            addCriterion("code_alt_category is not null");
            return (Criteria) this;
        }

        public Criteria andCodeAltCategoryEqualTo(String value) {
            addCriterion("code_alt_category =", value, "codeAltCategory");
            return (Criteria) this;
        }

        public Criteria andCodeAltCategoryNotEqualTo(String value) {
            addCriterion("code_alt_category <>", value, "codeAltCategory");
            return (Criteria) this;
        }

        public Criteria andCodeAltCategoryGreaterThan(String value) {
            addCriterion("code_alt_category >", value, "codeAltCategory");
            return (Criteria) this;
        }

        public Criteria andCodeAltCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("code_alt_category >=", value, "codeAltCategory");
            return (Criteria) this;
        }

        public Criteria andCodeAltCategoryLessThan(String value) {
            addCriterion("code_alt_category <", value, "codeAltCategory");
            return (Criteria) this;
        }

        public Criteria andCodeAltCategoryLessThanOrEqualTo(String value) {
            addCriterion("code_alt_category <=", value, "codeAltCategory");
            return (Criteria) this;
        }

        public Criteria andCodeAltCategoryLike(String value) {
            addCriterion("code_alt_category like", value, "codeAltCategory");
            return (Criteria) this;
        }

        public Criteria andCodeAltCategoryNotLike(String value) {
            addCriterion("code_alt_category not like", value, "codeAltCategory");
            return (Criteria) this;
        }

        public Criteria andCodeAltCategoryIn(List<String> values) {
            addCriterion("code_alt_category in", values, "codeAltCategory");
            return (Criteria) this;
        }

        public Criteria andCodeAltCategoryNotIn(List<String> values) {
            addCriterion("code_alt_category not in", values, "codeAltCategory");
            return (Criteria) this;
        }

        public Criteria andCodeAltCategoryBetween(String value1, String value2) {
            addCriterion("code_alt_category between", value1, value2, "codeAltCategory");
            return (Criteria) this;
        }

        public Criteria andCodeAltCategoryNotBetween(String value1, String value2) {
            addCriterion("code_alt_category not between", value1, value2, "codeAltCategory");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table category
     *
     * @mbg.generated do_not_delete_during_merge Mon Jul 15 17:21:27 CEST 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table category
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
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