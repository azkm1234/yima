package serviceinterface;

import java.util.List;

import domain.Expert;
import model.User;

public interface UserService {
	
	void addUser(User user);
	User findByUserName(String username);
	void deleteByUserName(String username);
	void updateByUserName(User user);
	List<Expert> getExperts(int currentPage, int pageSize);
}
