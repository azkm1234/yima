package domain;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import model.HorseOnSale;
import model.HorseOnSaleExample;

public interface HorseOnSaleMapper {
    long countByExample(HorseOnSaleExample example);

    int deleteByExample(HorseOnSaleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HorseOnSale record);

    int insertSelective(HorseOnSale record);

    List<HorseOnSale> selectByExample(HorseOnSaleExample example);
    
    List<HorseOnSale> selectByRawSQL(SqlVo sqlvo);

    HorseOnSale selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HorseOnSale record, @Param("example") HorseOnSaleExample example);

    int updateByExample(@Param("record") HorseOnSale record, @Param("example") HorseOnSaleExample example);

    int updateByPrimaryKeySelective(HorseOnSale record);

    int updateByPrimaryKey(HorseOnSale record);
}