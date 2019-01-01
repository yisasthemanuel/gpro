package org.jlobato.gpro.dao.mybatis.mappers;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.jlobato.gpro.dao.mybatis.model.RaceData;
import org.jlobato.gpro.dao.mybatis.model.RaceDataExample;

public interface RaceDataMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table racedata
     *
     * @mbg.generated Sun Dec 09 12:52:58 CET 2018
     */
    long countByExample(RaceDataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table racedata
     *
     * @mbg.generated Sun Dec 09 12:52:58 CET 2018
     */
    int deleteByExample(RaceDataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table racedata
     *
     * @mbg.generated Sun Dec 09 12:52:58 CET 2018
     */
    int deleteByPrimaryKey(Integer idRacedata);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table racedata
     *
     * @mbg.generated Sun Dec 09 12:52:58 CET 2018
     */
    int insert(RaceData record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table racedata
     *
     * @mbg.generated Sun Dec 09 12:52:58 CET 2018
     */
    int insertSelective(RaceData record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table racedata
     *
     * @mbg.generated Sun Dec 09 12:52:58 CET 2018
     */
    List<RaceData> selectByExample(RaceDataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table racedata
     *
     * @mbg.generated Sun Dec 09 12:52:58 CET 2018
     */
    RaceData selectByPrimaryKey(Integer idRacedata);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table racedata
     *
     * @mbg.generated Sun Dec 09 12:52:58 CET 2018
     */
    int updateByExampleSelective(@Param("record") RaceData record, @Param("example") RaceDataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table racedata
     *
     * @mbg.generated Sun Dec 09 12:52:58 CET 2018
     */
    int updateByExample(@Param("record") RaceData record, @Param("example") RaceDataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table racedata
     *
     * @mbg.generated Sun Dec 09 12:52:58 CET 2018
     */
    int updateByPrimaryKeySelective(RaceData record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table racedata
     *
     * @mbg.generated Sun Dec 09 12:52:58 CET 2018
     */
    int updateByPrimaryKey(RaceData record);
}