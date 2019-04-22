package org.jlobato.gpro.dao.mybatis.mappers;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.jlobato.gpro.dao.mybatis.model.RaceLapData;
import org.jlobato.gpro.dao.mybatis.model.RaceLapDataExample;

public interface RaceLapDataMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table racelapdata
     *
     * @mbg.generated Tue Feb 19 12:14:15 CET 2019
     */
    long countByExample(RaceLapDataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table racelapdata
     *
     * @mbg.generated Tue Feb 19 12:14:15 CET 2019
     */
    int deleteByExample(RaceLapDataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table racelapdata
     *
     * @mbg.generated Tue Feb 19 12:14:15 CET 2019
     */
    int deleteByPrimaryKey(Integer idRacelapdata);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table racelapdata
     *
     * @mbg.generated Tue Feb 19 12:14:15 CET 2019
     */
    int insert(RaceLapData record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table racelapdata
     *
     * @mbg.generated Tue Feb 19 12:14:15 CET 2019
     */
    int insertSelective(RaceLapData record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table racelapdata
     *
     * @mbg.generated Tue Feb 19 12:14:15 CET 2019
     */
    List<RaceLapData> selectByExample(RaceLapDataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table racelapdata
     *
     * @mbg.generated Tue Feb 19 12:14:15 CET 2019
     */
    RaceLapData selectByPrimaryKey(Integer idRacelapdata);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table racelapdata
     *
     * @mbg.generated Tue Feb 19 12:14:15 CET 2019
     */
    int updateByExampleSelective(@Param("record") RaceLapData record, @Param("example") RaceLapDataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table racelapdata
     *
     * @mbg.generated Tue Feb 19 12:14:15 CET 2019
     */
    int updateByExample(@Param("record") RaceLapData record, @Param("example") RaceLapDataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table racelapdata
     *
     * @mbg.generated Tue Feb 19 12:14:15 CET 2019
     */
    int updateByPrimaryKeySelective(RaceLapData record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table racelapdata
     *
     * @mbg.generated Tue Feb 19 12:14:15 CET 2019
     */
    int updateByPrimaryKey(RaceLapData record);
}