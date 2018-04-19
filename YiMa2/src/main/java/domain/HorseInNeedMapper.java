package domain;

import java.util.List;

import model.HorseInNeed;

public interface HorseInNeedMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HorseInNeed record);

    int insertSelective(HorseInNeed record);

    HorseInNeed selectByPrimaryKey(Integer id);
    
    List<HorseInNeed> selectByPojo(HorseInNeed record);

    int updateByPrimaryKeySelective(HorseInNeed record);

    int updateByPrimaryKey(HorseInNeed record);
}