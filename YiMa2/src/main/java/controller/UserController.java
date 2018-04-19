package controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import conf.Const;
import model.SessionPojo;
import model.User;
import service.RandomGenerator;
import serviceinterface.SessionService;
import serviceinterface.UserService;
import util.LoginUtil;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Resource(name = "sessionService")
	private SessionService sessionService;
	
	@RequestMapping("/login")
	public Object login(@RequestParam String username,
			@RequestParam(value = "pswmd5") String password) throws Exception {
		Map<String, Object> map = new HashMap<>();
		User user = this.userService.findByUserName(username);
		if(user != null && util.BCrypt.hashpw(password, user.getSalt()).equals(user.getPswmd5())) {
			//��ȡһ��sessionId Ȼ�󷵻ظ�ǰ�ˣ������Ѿ������˵�¼,
			String sid = RandomGenerator.generateSessionId();
			this.sessionService.add(new SessionPojo(sid, username, System.currentTimeMillis()));
			map.put("seesionId", sid);
			return map;
		} else {
			throw new Exception("�û����������벻��!");
		}
	}
	
	@RequestMapping("/regist")
	public Object regist(@RequestParam String username,
			@RequestParam(value = "pswmd5") String password) throws Exception {
		Map<String, Object> map = new HashMap<>();
		if(this.userService.findByUserName(username) != null) {
			throw new Exception("�û����Ѿ�����!");
		} else {
			this.userService.addUser(new User(username, password));
			LoginUtil.addToSymphony(username, password);
			map.put("message", "ע��ɹ�");
			return map;
		}
	}
	@RequestMapping("/login_out")
	public Object login_out(@RequestParam String sessionId) {
		this.sessionService.remove(sessionId);
		return "ok";
	}
	
	@RequestMapping(value="/become_expert")
	public Object becomeExperts(@Valid User user, String sessionId) {
		user.setExpert(true);
		this.userService.updateByUserName(user);
		return Const.OK;
	}
}
