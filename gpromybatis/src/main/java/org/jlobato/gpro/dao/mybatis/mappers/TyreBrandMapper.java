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
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    long countByExample(TyreBrandExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tyre_brand
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    int deleteByExample(TyreBrandExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tyre_brand
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    int deleteByPrimaryKey(Short idTyreBrand);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tyre_brand
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    int insert(TyreBrandWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tyre_brand
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    int insertSelective(TyreBrandWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tyre_brand
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    List<TyreBrandWithBLOBs> selectByExampleWithBLOBs(TyreBrandExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tyre_brand
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    List<TyreBrand> selectByExample(TyreBrandExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tyre_brand
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    TyreBrandWithBLOBs selectByPrimaryKey(Short idTyreBrand);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tyre_brand
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    int updateByExampleSelective(@Param("record") TyreBrandWithBLOBs record, @Param("example") TyreBrandExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tyre_brand
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    int updateByExampleWithBLOBs(@Param("record") TyreBrandWithBLOBs record, @Param("example") TyreBrandExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tyre_brand
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    int updateByExample(@Param("record") TyreBrand record, @Param("example") TyreBrandExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tyre_brand
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    int updateByPrimaryKeySelective(TyreBrandWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tyre_brand
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    int updateByPrimaryKeyWithBLOBs(TyreBrandWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tyre_brand
     *
     * @mbg.generated Sat May 11 19:47:05 CEST 2019
     */
    int updateByPrimaryKey(TyreBrand record);
}