package domain;

import java.util.List;

import model.ClubActivity;

public interface ClubActivityMapper {
    int deleteByClubName(String clubname);
    
    int deleteById(Integer id);
    
    int insert(ClubActivity record);

    int insertSelective(ClubActivity record);

    List<ClubActivity> selectByClubName(String clubname);

    int updateByClubNameSelective(ClubActivity record);

    int updateByPrimaryKey(ClubActivity record);
}