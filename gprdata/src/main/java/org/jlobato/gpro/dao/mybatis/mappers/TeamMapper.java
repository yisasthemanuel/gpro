package org.jlobato.gpro.dao.mybatis.mappers;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.jlobato.gpro.dao.mybatis.model.Team;
import org.jlobato.gpro.dao.mybatis.model.TeamExample;

public interface TeamMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
     *
     * @mbg.generated Sat May 06 16:20:58 CEST 2017
     */
    long countByExample(TeamExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
     *
     * @mbg.generated Sat May 06 16:20:58 CEST 2017
     */
    int deleteByExample(TeamExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
     *
     * @mbg.generated Sat May 06 16:20:58 CEST 2017
     */
    int deleteByPrimaryKey(Short idTeam);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
     *
     * @mbg.generated Sat May 06 16:20:58 CEST 2017
     */
    int insert(Team record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
     *
     * @mbg.generated Sat May 06 16:20:58 CEST 2017
     */
    int insertSelective(Team record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
     *
     * @mbg.generated Sat May 06 16:20:58 CEST 2017
     */
    List<Team> selectByExample(TeamExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
     *
     * @mbg.generated Sat May 06 16:20:58 CEST 2017
     */
    Team selectByPrimaryKey(Short idTeam);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
     *
     * @mbg.generated Sat May 06 16:20:58 CEST 2017
     */
    int updateByExampleSelective(@Param("record") Team record, @Param("example") TeamExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
     *
     * @mbg.generated Sat May 06 16:20:58 CEST 2017
     */
    int updateByExample(@Param("record") Team record, @Param("example") TeamExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
     *
     * @mbg.generated Sat May 06 16:20:58 CEST 2017
     */
    int updateByPrimaryKeySelective(Team record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
     *
     * @mbg.generated Sat May 06 16:20:58 CEST 2017
     */
    int updateByPrimaryKey(Team record);
}