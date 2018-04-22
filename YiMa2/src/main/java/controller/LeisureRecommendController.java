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
import vo.SessionVo;

@RestController
@RequestMapping("/leisure")
public class LeisureRecommendController {
	
	@Autowired
	private LeisureRecommendService leisureRecommendService;
	@RequestMapping("/add")
	public Object addLeisureRecommend(@Valid LeisureRecommend leisureRecommend,@Valid SessionVo session) throws Exception {
		this.leisureRecommendService.insertLeisureRecommend(leisureRecommend);
		return Const.OK;
	}
	@RequestMapping("/remove_by_clubname")
	public Object removeLeisureRecommend(@Valid String clubName,@Valid SessionVo session) throws Exception {
		this.leisureRecommendService.deleteByClubName(clubName);
		return Const.OK;
	}
	
	@RequestMapping("/remove_by_id")
	public Object removeById(@RequestParam Integer id, @Valid SessionVo session) {
		this.leisureRecommendService.deleteById(id);
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
