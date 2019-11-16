package org.jlobato.gpro.dao.mybatis.mappers;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.jlobato.gpro.dao.mybatis.model.CupStandingsSnapshot;
import org.jlobato.gpro.dao.mybatis.model.CupStandingsSnapshotExample;
import org.jlobato.gpro.dao.mybatis.model.CupStandingsSnapshotKey;

public interface CupStandingsSnapshotMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cupstandingsnapshot
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    long countByExample(CupStandingsSnapshotExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cupstandingsnapshot
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    int deleteByExample(CupStandingsSnapshotExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cupstandingsnapshot
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    int deleteByPrimaryKey(CupStandingsSnapshotKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cupstandingsnapshot
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    int insert(CupStandingsSnapshot record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cupstandingsnapshot
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    int insertSelective(CupStandingsSnapshot record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cupstandingsnapshot
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    List<CupStandingsSnapshot> selectByExample(CupStandingsSnapshotExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cupstandingsnapshot
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    CupStandingsSnapshot selectByPrimaryKey(CupStandingsSnapshotKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cupstandingsnapshot
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    int updateByExampleSelective(@Param("record") CupStandingsSnapshot record, @Param("example") CupStandingsSnapshotExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cupstandingsnapshot
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    int updateByExample(@Param("record") CupStandingsSnapshot record, @Param("example") CupStandingsSnapshotExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cupstandingsnapshot
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    int updateByPrimaryKeySelective(CupStandingsSnapshot record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cupstandingsnapshot
     *
     * @mbg.generated Mon Jul 15 17:21:27 CEST 2019
     */
    int updateByPrimaryKey(CupStandingsSnapshot record);
}