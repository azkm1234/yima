package domain;

import model.Buyhorse;

public interface BuyhorseMapper {
    int deleteByPrimaryKey(String username);

    int insert(Buyhorse record);

    int insertSelective(Buyhorse record);

    Buyhorse selectByPrimaryKey(String username);

    int updateByPrimaryKeySelective(Buyhorse record);

    int updateByPrimaryKey(Buyhorse record);
}