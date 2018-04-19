package domain;

import java.util.List;

import model.TransportNeed;

public interface TransportNeedMapper {
    int deleteByPrimaryKey(String username);

    int insert(TransportNeed record);

    int insertSelective(TransportNeed record);

    List<TransportNeed> selectBySize();

    int updateByPrimaryKeySelective(TransportNeed record);

    int updateByPrimaryKey(TransportNeed record);
}