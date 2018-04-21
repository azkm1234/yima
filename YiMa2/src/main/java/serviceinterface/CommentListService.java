package serviceinterface;

import java.util.List;

import model.Commentlist;

public interface CommentListService {
	boolean addComment(Commentlist commment);
	boolean updateComment(Commentlist comment);
	List<Commentlist> serarchComment(Commentlist comment, int page, int pageSize);
	boolean deleteCommentById(int id);
}
