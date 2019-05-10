package org.jlobato.gpro.dao.mybatis.mappers;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.jlobato.gpro.dao.mybatis.model.ManagerHistory;
import org.jlobato.gpro.dao.mybatis.model.ManagerHistoryExample;

public interface ManagerHistoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_history
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    long countByExample(ManagerHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_history
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    int deleteByExample(ManagerHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_history
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    int deleteByPrimaryKey(Integer idManagerHistory);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_history
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    int insert(ManagerHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_history
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    int insertSelective(ManagerHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_history
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    List<ManagerHistory> selectByExample(ManagerHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_history
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    ManagerHistory selectByPrimaryKey(Integer idManagerHistory);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_history
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    int updateByExampleSelective(@Param("record") ManagerHistory record, @Param("example") ManagerHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_history
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    int updateByExample(@Param("record") ManagerHistory record, @Param("example") ManagerHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_history
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    int updateByPrimaryKeySelective(ManagerHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_history
     *
     * @mbg.generated Fri May 10 13:24:21 CEST 2019
     */
    int updateByPrimaryKey(ManagerHistory record);
}