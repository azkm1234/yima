package domain;

import java.util.List;

import model.Leisure;

public interface LeisureMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Leisure record);

    int insertSelective(Leisure record);

    List<Leisure> selectByType(String type);

    int updateByPrimaryKeySelective(Leisure record);

    int updateByPrimaryKey(Leisure record);
}