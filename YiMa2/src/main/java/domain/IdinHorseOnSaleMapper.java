package domain;

import model.IdinHorseOnSale;

public interface IdinHorseOnSaleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IdinHorseOnSale record);

    int insertSelective(IdinHorseOnSale record);

    IdinHorseOnSale selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IdinHorseOnSale record);

    int updateByPrimaryKey(IdinHorseOnSale record);
}