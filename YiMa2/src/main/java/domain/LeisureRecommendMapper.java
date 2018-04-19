package domain;

import java.util.List;

import model.LeisureRecommend;

public interface LeisureRecommendMapper {
    int deleteByClubName(String clubname);

    int insert(LeisureRecommend record);

    int insertSelective(LeisureRecommend record);

    List<LeisureRecommend> selectBySize();
    
    LeisureRecommend selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LeisureRecommend record);

    int updateByPrimaryKey(LeisureRecommend record);
}