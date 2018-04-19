package controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import conf.Const;
import model.HorseInNeed;
import model.SessionPojo;
import serviceinterface.HorseInNeedService;
import serviceinterface.SessionService;

@RestController
@RequestMapping("/need")
public class HorseInNeedController {
	@Resource(name = "sessionService")
	private SessionService sessionService;
	@Resource(name = "horseInNeedService")
	HorseInNeedService horseInNeedService;
	@RequestMapping("/add")
	public Object addHorseInNeed(@Valid HorseInNeed horseInNeed, @RequestParam String sessionId) {
		SessionPojo sessionPojo = this.sessionService.get(sessionId);
		horseInNeed.setUsername(sessionPojo.getUsername());
		this.horseInNeedService.addHorseInNeed(horseInNeed);
		return Const.OK;
	}
	@RequestMapping("/delete")
	public Object removeHorseInNeed(@Valid Integer id, @RequestParam String sessionId) {
		this.horseInNeedService.deleteHorseInNeedById(id);
		return Const.OK;
	}
	
	@RequestMapping("/update")
	public Object updateHorseInNeed(HorseInNeed horseInNeed, @RequestParam String sessionId) {
		this.horseInNeedService.updateHorseInNeed(horseInNeed);
		return Const.OK;
	}
	
	@RequestMapping("/all")
	public Object searchHorseInNeed(@RequestParam Integer page) {
		HashMap<String, Object> map = new HashMap<>();
		List<HorseInNeed> list = this.horseInNeedService.searchHorseInNeed(new HorseInNeed(), page, Const.PAGESIZE);
		map.put(Const.LIST, list);
		map.put(Const.MSG, Const.OK);
		return map;
	}
}
