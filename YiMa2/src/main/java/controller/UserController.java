package controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import conf.Const;
import model.SessionPojo;
import model.User;
import service.RandomGenerator;
import serviceinterface.SessionService;
import serviceinterface.UserService;
import util.LoginUtil;
import vo.SessionVo;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Resource(name = "sessionService")
	private SessionService sessionService;
	
	@RequestMapping(value = "/login", produces = {})
	public Object login(@RequestParam String username,
			@RequestParam(value = "pswmd5") String password) throws Exception {
		Map<String, Object> map = new HashMap<>();
		User user = this.userService.findByUserName(username);
		if(user != null && util.BCrypt.hashpw(password, user.getSalt()).equals(user.getPswmd5())) {
			//获取一个sessionId 然后返回给前端，代表已经进行了登录,
			String sid = RandomGenerator.generateSessionId();
			this.sessionService.add(new SessionPojo(sid, username, System.currentTimeMillis()));
			map.put("seesionId", sid);
			return map;
		} else {
			throw new Exception("用户名或者密码不对!");
		}
	}
	
	@RequestMapping("/regist")
	public Object regist(@RequestParam String username,
			@RequestParam(value = "pswmd5") String password) throws Exception {
		Map<String, Object> map = new HashMap<>();
		if(this.userService.findByUserName(username) != null) {
			throw new Exception("用户名已经存在!");
		} else {
			this.userService.addUser(new User(username, password));
			LoginUtil.addToSymphony(username, password);
			map.put("message", "注册成功");
			return map;
		}
	}
	@RequestMapping("/login_out")
	public Object login_out(@Valid SessionVo session) {
		this.sessionService.remove(session.getSessionId());
		return "ok";
	}
	
	@RequestMapping(value="/become_expert")
	public Object becomeExperts(@Valid User user, BindingResult result, @Valid SessionVo session) {
		user.setExpert(true);
		user.setPswmd5(null);
		this.userService.updateByUserName(user);
		return Const.OK;
	}
}
