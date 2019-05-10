package org.jlobato.gpro.dao.mybatis.mappers;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.jlobato.gpro.dao.mybatis.model.Track;
import org.jlobato.gpro.dao.mybatis.model.TrackExample;

public interface TrackMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table track
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    long countByExample(TrackExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table track
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    int deleteByExample(TrackExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table track
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    int deleteByPrimaryKey(Short idTrack);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table track
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    int insert(Track record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table track
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    int insertSelective(Track record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table track
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    List<Track> selectByExample(TrackExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table track
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    Track selectByPrimaryKey(Short idTrack);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table track
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    int updateByExampleSelective(@Param("record") Track record, @Param("example") TrackExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table track
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    int updateByExample(@Param("record") Track record, @Param("example") TrackExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table track
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    int updateByPrimaryKeySelective(Track record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table track
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    int updateByPrimaryKey(Track record);
}