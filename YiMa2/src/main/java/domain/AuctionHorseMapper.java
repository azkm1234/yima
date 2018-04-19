package domain;

import java.util.List;

import model.AuctionHorse;
import model.AutionResult;

public interface AuctionHorseMapper {
    int deleteByHorseId(Integer idhorseonsale);

    int insert(AuctionHorse record);

    int insertSelective(AuctionHorse record);

    List<AutionResult> selectBySize();

    int updateByPrimaryKeySelective(AuctionHorse record);

    int updateByPrimaryKey(AuctionHorse record);
}