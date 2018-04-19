package domain;

import model.Horse_club;
import model.Horse_clubKey;

public interface Horse_clubMapper {
    int deleteByPrimaryKey(Horse_clubKey key);

    int insert(Horse_club record);

    int insertSelective(Horse_club record);

    Horse_club selectByPrimaryKey(Horse_clubKey key);

    int updateByPrimaryKeySelective(Horse_club record);

    int updateByPrimaryKey(Horse_club record);
}