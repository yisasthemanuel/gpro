package org.jlobato.gpro.dao.mybatis.mappers;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.jlobato.gpro.dao.mybatis.model.Season;
import org.jlobato.gpro.dao.mybatis.model.SeasonExample;

public interface SeasonMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table season
     *
     * @mbg.generated Sun Dec 09 12:52:57 CET 2018
     */
    long countByExample(SeasonExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table season
     *
     * @mbg.generated Sun Dec 09 12:52:57 CET 2018
     */
    int deleteByExample(SeasonExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table season
     *
     * @mbg.generated Sun Dec 09 12:52:57 CET 2018
     */
    int deleteByPrimaryKey(Short idSeason);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table season
     *
     * @mbg.generated Sun Dec 09 12:52:57 CET 2018
     */
    int insert(Season record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table season
     *
     * @mbg.generated Sun Dec 09 12:52:57 CET 2018
     */
    int insertSelective(Season record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table season
     *
     * @mbg.generated Sun Dec 09 12:52:57 CET 2018
     */
    List<Season> selectByExample(SeasonExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table season
     *
     * @mbg.generated Sun Dec 09 12:52:57 CET 2018
     */
    Season selectByPrimaryKey(Short idSeason);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table season
     *
     * @mbg.generated Sun Dec 09 12:52:57 CET 2018
     */
    int updateByExampleSelective(@Param("record") Season record, @Param("example") SeasonExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table season
     *
     * @mbg.generated Sun Dec 09 12:52:57 CET 2018
     */
    int updateByExample(@Param("record") Season record, @Param("example") SeasonExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table season
     *
     * @mbg.generated Sun Dec 09 12:52:57 CET 2018
     */
    int updateByPrimaryKeySelective(Season record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table season
     *
     * @mbg.generated Sun Dec 09 12:52:57 CET 2018
     */
    int updateByPrimaryKey(Season record);
}