package domain;

import java.util.List;

import model.Commentlist;

public interface CommentlistMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Commentlist record);

    int insertSelective(Commentlist record);

    Commentlist selectByPrimaryKey(Integer id);
    
    List<Commentlist> selectByPojo(Commentlist comment);

    int updateByPrimaryKeySelective(Commentlist record);

    int updateByPrimaryKey(Commentlist record);
}