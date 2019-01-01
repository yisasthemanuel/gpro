package org.jlobato.gpro.dao.mybatis.mappers;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.jlobato.gpro.dao.mybatis.model.Race;
import org.jlobato.gpro.dao.mybatis.model.RaceExample;
import org.jlobato.gpro.dao.mybatis.model.RaceKey;

public interface RaceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table race
     *
     * @mbg.generated Sun Dec 09 12:52:57 CET 2018
     */
    long countByExample(RaceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table race
     *
     * @mbg.generated Sun Dec 09 12:52:57 CET 2018
     */
    int deleteByExample(RaceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table race
     *
     * @mbg.generated Sun Dec 09 12:52:57 CET 2018
     */
    int deleteByPrimaryKey(RaceKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table race
     *
     * @mbg.generated Sun Dec 09 12:52:57 CET 2018
     */
    int insert(Race record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table race
     *
     * @mbg.generated Sun Dec 09 12:52:57 CET 2018
     */
    int insertSelective(Race record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table race
     *
     * @mbg.generated Sun Dec 09 12:52:57 CET 2018
     */
    List<Race> selectByExample(RaceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table race
     *
     * @mbg.generated Sun Dec 09 12:52:57 CET 2018
     */
    Race selectByPrimaryKey(RaceKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table race
     *
     * @mbg.generated Sun Dec 09 12:52:57 CET 2018
     */
    int updateByExampleSelective(@Param("record") Race record, @Param("example") RaceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table race
     *
     * @mbg.generated Sun Dec 09 12:52:57 CET 2018
     */
    int updateByExample(@Param("record") Race record, @Param("example") RaceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table race
     *
     * @mbg.generated Sun Dec 09 12:52:57 CET 2018
     */
    int updateByPrimaryKeySelective(Race record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table race
     *
     * @mbg.generated Sun Dec 09 12:52:57 CET 2018
     */
    int updateByPrimaryKey(Race record);
}