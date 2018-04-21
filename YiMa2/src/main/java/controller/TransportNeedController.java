package controller;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import conf.Const;
import model.TransportNeed;
import serviceinterface.TransportNeedService;
import vo.SessionVo;

@RestController
@RequestMapping("/transport_need")
public class TransportNeedController {
	
	@Autowired
	private TransportNeedService transportNeedService;
	@RequestMapping("/list")
	public Object getTransportNeed(@RequestParam Integer page) throws Exception {
		List<TransportNeed> list = this.transportNeedService.searchBySize(page, Const.PAGESIZE);
		HashMap<String, Object> map = new HashMap<>();
		map.put(Const.SIZE, list.size());
		map.put(Const.LIST, list);
		return map;
	}
	
	@RequestMapping("/deleteByUserName")
	public Object deleteTransportNeedByUserName(@RequestParam String userName,
			@Valid SessionVo session) throws Exception {
		this.transportNeedService.deleteByUsername(userName);
		return Const.OK;
	}
	
	@RequestMapping("/add")
	public Object addTransportNeed(@Valid TransportNeed transportNeed,
			@Valid SessionVo session) throws Exception {
		this.transportNeedService.insertTransportNeed(transportNeed);
		return Const.OK;
	}
}
