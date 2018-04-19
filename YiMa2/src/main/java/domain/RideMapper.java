package domain;

import java.util.List;

import model.Ride;

public interface RideMapper {
    int deleteByUserName(String username);

    int insert(Ride record);

    int insertSelective(Ride record);

    List<Ride> selectBySize();

    int updateByPrimaryKeySelective(Ride record);

    int updateByPrimaryKey(Ride record);
}