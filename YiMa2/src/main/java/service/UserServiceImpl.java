package service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import domain.Expert;
import domain.UserMapper;
import model.User;
import serviceinterface.UserService;
import util.BCrypt;

@Service(value = "userService")
public class UserServiceImpl implements UserService {
	
	@Resource(name = "userMapper")
	UserMapper userMapper;
	@Override
	public void addUser(User user) {
		user.setSalt(BCrypt.gensalt());
		user.setExpert(false);
		user.setRegtime(new Date(System.currentTimeMillis()));
		user.setPswmd5(BCrypt.hashpw(user.getPswmd5(), user.getSalt()));
		this.userMapper.insertSelective(user);
	}

	@Override
	public User findByUserName(String username) {
		return this.userMapper.selectByPrimaryKey(username);
	}

	@Override
	public void deleteByUserName(String username) {
		this.userMapper.deleteByPrimaryKey(username);
	}


	@Override
	public List<Expert> getExperts(int currentPage, int pageSize) {
		PageHelper.startPage(currentPage, pageSize);
		List<User> users = this.userMapper.selectExperts();
		List<Expert> experts = new ArrayList<>();
		for (User user : users) {
			Expert expert = new Expert();
			expert.setName(user.getUsername());
			expert.setDesc(user.getDescription());
			expert.setPic(user.getHeadimage());
			experts.add(expert);
		}
		return experts;
	}

	@Override
	public void updateByUserName(User user) {
		this.userMapper.updateByPrimaryKeySelective(user);
	}
}
