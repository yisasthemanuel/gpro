package org.jlobato.gpro.dao.mybatis.mappers;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.jlobato.gpro.dao.mybatis.model.TechProblem;
import org.jlobato.gpro.dao.mybatis.model.TechProblemExample;

public interface TechProblemMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table techproblem
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    long countByExample(TechProblemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table techproblem
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    int deleteByExample(TechProblemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table techproblem
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    int deleteByPrimaryKey(Integer idTechproblem);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table techproblem
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    int insert(TechProblem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table techproblem
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    int insertSelective(TechProblem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table techproblem
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    List<TechProblem> selectByExample(TechProblemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table techproblem
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    TechProblem selectByPrimaryKey(Integer idTechproblem);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table techproblem
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    int updateByExampleSelective(@Param("record") TechProblem record, @Param("example") TechProblemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table techproblem
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    int updateByExample(@Param("record") TechProblem record, @Param("example") TechProblemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table techproblem
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    int updateByPrimaryKeySelective(TechProblem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table techproblem
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    int updateByPrimaryKey(TechProblem record);
}