package controller;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import conf.Const;
import model.LeisureRecommend;
import serviceinterface.LeisureRecommendService;

@RestController
@RequestMapping("/leisure")
public class LeisureRecommendController {
	
	@Autowired
	private LeisureRecommendService leisureRecommendService;
	@RequestMapping("/add")
	public Object addLeisureRecommend(@Valid LeisureRecommend leisureRecommend,@RequestParam String sessionId) throws Exception {
		this.leisureRecommendService.insertLeisureRecommend(leisureRecommend);
		return Const.OK;
	}
	@RequestMapping("/removeByClubName")
	public Object addLeisureRecommend(@Valid String clubName,@RequestParam String sessionId) throws Exception {
		this.leisureRecommendService.deleteByClubName(clubName);
		return Const.OK;
	}
	@RequestMapping("/get")
	public Object getLeisureRecommend(@RequestParam Integer page) throws Exception {
		HashMap<String, Object> map = new HashMap<>();
		List<LeisureRecommend> list = this.leisureRecommendService.searchBySize(page, Const.PAGESIZE);
		map.put(Const.LIST, list);
		map.put(Const.SIZE, list.size());
		return map;
	}
	
	
}
