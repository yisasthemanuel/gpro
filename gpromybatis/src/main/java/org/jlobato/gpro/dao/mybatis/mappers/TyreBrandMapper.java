package org.jlobato.gpro.dao.mybatis.mappers;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.jlobato.gpro.dao.mybatis.model.TyreBrand;
import org.jlobato.gpro.dao.mybatis.model.TyreBrandExample;
import org.jlobato.gpro.dao.mybatis.model.TyreBrandWithBLOBs;

public interface TyreBrandMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tyre_brand
     *
     * @mbg.generated Mon Mar 23 08:07:08 CET 2020
     */
    long countByExample(TyreBrandExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tyre_brand
     *
     * @mbg.generated Mon Mar 23 08:07:08 CET 2020
     */
    int deleteByExample(TyreBrandExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tyre_brand
     *
     * @mbg.generated Mon Mar 23 08:07:08 CET 2020
     */
    int deleteByPrimaryKey(Short idTyreBrand);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tyre_brand
     *
     * @mbg.generated Mon Mar 23 08:07:08 CET 2020
     */
    int insert(TyreBrandWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tyre_brand
     *
     * @mbg.generated Mon Mar 23 08:07:08 CET 2020
     */
    int insertSelective(TyreBrandWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tyre_brand
     *
     * @mbg.generated Mon Mar 23 08:07:08 CET 2020
     */
    List<TyreBrandWithBLOBs> selectByExampleWithBLOBs(TyreBrandExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tyre_brand
     *
     * @mbg.generated Mon Mar 23 08:07:08 CET 2020
     */
    List<TyreBrand> selectByExample(TyreBrandExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tyre_brand
     *
     * @mbg.generated Mon Mar 23 08:07:08 CET 2020
     */
    TyreBrandWithBLOBs selectByPrimaryKey(Short idTyreBrand);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tyre_brand
     *
     * @mbg.generated Mon Mar 23 08:07:08 CET 2020
     */
    int updateByExampleSelective(@Param("record") TyreBrandWithBLOBs record, @Param("example") TyreBrandExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tyre_brand
     *
     * @mbg.generated Mon Mar 23 08:07:08 CET 2020
     */
    int updateByExampleWithBLOBs(@Param("record") TyreBrandWithBLOBs record, @Param("example") TyreBrandExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tyre_brand
     *
     * @mbg.generated Mon Mar 23 08:07:08 CET 2020
     */
    int updateByExample(@Param("record") TyreBrand record, @Param("example") TyreBrandExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tyre_brand
     *
     * @mbg.generated Mon Mar 23 08:07:08 CET 2020
     */
    int updateByPrimaryKeySelective(TyreBrandWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tyre_brand
     *
     * @mbg.generated Mon Mar 23 08:07:08 CET 2020
     */
    int updateByPrimaryKeyWithBLOBs(TyreBrandWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tyre_brand
     *
     * @mbg.generated Mon Mar 23 08:07:08 CET 2020
     */
    int updateByPrimaryKey(TyreBrand record);
}