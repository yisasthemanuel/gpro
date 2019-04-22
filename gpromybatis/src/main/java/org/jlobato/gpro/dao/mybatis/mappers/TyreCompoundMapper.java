package org.jlobato.gpro.dao.mybatis.mappers;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.jlobato.gpro.dao.mybatis.model.TyreCompound;
import org.jlobato.gpro.dao.mybatis.model.TyreCompoundExample;

public interface TyreCompoundMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tyrecompound
     *
     * @mbg.generated Tue Feb 19 12:14:15 CET 2019
     */
    long countByExample(TyreCompoundExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tyrecompound
     *
     * @mbg.generated Tue Feb 19 12:14:15 CET 2019
     */
    int deleteByExample(TyreCompoundExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tyrecompound
     *
     * @mbg.generated Tue Feb 19 12:14:15 CET 2019
     */
    int deleteByPrimaryKey(Integer idTyrecompound);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tyrecompound
     *
     * @mbg.generated Tue Feb 19 12:14:15 CET 2019
     */
    int insert(TyreCompound record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tyrecompound
     *
     * @mbg.generated Tue Feb 19 12:14:15 CET 2019
     */
    int insertSelective(TyreCompound record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tyrecompound
     *
     * @mbg.generated Tue Feb 19 12:14:15 CET 2019
     */
    List<TyreCompound> selectByExample(TyreCompoundExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tyrecompound
     *
     * @mbg.generated Tue Feb 19 12:14:15 CET 2019
     */
    TyreCompound selectByPrimaryKey(Integer idTyrecompound);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tyrecompound
     *
     * @mbg.generated Tue Feb 19 12:14:15 CET 2019
     */
    int updateByExampleSelective(@Param("record") TyreCompound record, @Param("example") TyreCompoundExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tyrecompound
     *
     * @mbg.generated Tue Feb 19 12:14:15 CET 2019
     */
    int updateByExample(@Param("record") TyreCompound record, @Param("example") TyreCompoundExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tyrecompound
     *
     * @mbg.generated Tue Feb 19 12:14:15 CET 2019
     */
    int updateByPrimaryKeySelective(TyreCompound record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tyrecompound
     *
     * @mbg.generated Tue Feb 19 12:14:15 CET 2019
     */
    int updateByPrimaryKey(TyreCompound record);
}