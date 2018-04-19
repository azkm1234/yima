package domain;

import java.util.List;

import model.FineHorseOnSale;
import model.FineResult;

public interface FineHorseOnSaleMapper {
    int deleteByHorseId(Integer idhorseonsale);

    int insert(FineHorseOnSale record);

    int insertSelective(FineHorseOnSale record);

    List<FineResult> selectBySize();

    int updateByPrimaryKeySelective(FineHorseOnSale record);

    int updateByPrimaryKey(FineHorseOnSale record);
}