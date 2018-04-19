package serviceinterface;

import java.util.List;

import model.Commentlist;

public interface CommentListService {
	boolean addComment(Commentlist commment);
	boolean updateComment(Commentlist comment);
	List<Commentlist> serarchComment(Commentlist comment);
	boolean deleteCommentById(int id);
}
