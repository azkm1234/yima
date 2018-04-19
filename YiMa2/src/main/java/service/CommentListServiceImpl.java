package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import domain.CommentlistMapper;
import model.Commentlist;
import serviceinterface.CommentListService;
@Service(value = "commentListService")
public class CommentListServiceImpl implements CommentListService {
	@Resource(name = "commentlistMapper")
	private CommentlistMapper commentlistMapper;
	@Override
	public boolean addComment(Commentlist commment) {
		this.commentlistMapper.insertSelective(commment);
		return true;
	}

	@Override
	public boolean updateComment(Commentlist comment) {
		this.commentlistMapper.updateByPrimaryKeySelective(comment);
		return true;
	}

	@Override
	public List<Commentlist> serarchComment(Commentlist comment) {
		return this.commentlistMapper.selectByPojo(comment);
	}

	@Override
	public boolean deleteCommentById(int id) {
		this.commentlistMapper.deleteByPrimaryKey(id);
		return true;
	}
	
}
