package domain;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import model.HorseOnSale;
import model.Swipper;
import model.SwipperExample;

public interface SwipperMapper {
    long countByExample(SwipperExample example);

    int deleteByExample(SwipperExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Swipper record);

    int insertSelective(Swipper record);

    List<Swipper> selectByExample(SwipperExample example);
    List<HorseOnSale> select3Counts();

    Swipper selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Swipper record, @Param("example") SwipperExample example);

    int updateByExample(@Param("record") Swipper record, @Param("example") SwipperExample example);

    int updateByPrimaryKeySelective(Swipper record);

    int updateByPrimaryKey(Swipper record);
}