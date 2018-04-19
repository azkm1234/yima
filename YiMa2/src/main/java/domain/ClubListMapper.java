package domain;

import java.util.List;

import model.ClubList;

public interface ClubListMapper {
	int deleteByClubName(String clubname);

    int insert(ClubList record);

    int insertSelective(ClubList record);

    List<ClubList> selectBySize();
    
    ClubList selectByPrimaryKey(String clubname);

    int updateByClubNameSelective(ClubList clublist);

    int updateByPrimaryKey(ClubList record);
    
    List<ClubList> selectByUsername(String username);
}