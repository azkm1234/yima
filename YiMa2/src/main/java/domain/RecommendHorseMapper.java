package domain;

import java.util.List;

import model.RecommendHorse;
import model.RecommendResult;

public interface RecommendHorseMapper {
    int deleteByHorseId(Integer idhorseonsale);

    int insert(RecommendHorse record);

    int insertSelective(RecommendHorse record);

    List<RecommendResult> selectBySize();

    int updateByPrimaryKeySelective(RecommendHorse record);

    int updateByPrimaryKey(RecommendHorse record);
}