package controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import conf.Const;
import model.ClubActivity;
import serviceinterface.ClubActivityService;

@RestController
@RequestMapping("/activity")
public class ClubActivityController {
	
	@Resource(name = "clubActivityService")
	ClubActivityService clubActivityService;
	@RequestMapping("/getByClubName")
	public Object getClubActivity(@RequestParam String clubName, @RequestParam Integer page) throws Exception {
		HashMap<String, Object> map = new HashMap<>();
		List<ClubActivity> list = 
				this.clubActivityService.searchByClubName(clubName, page, Const.PAGESIZE);
		map.put(Const.LIST, list);
		map.put(Const.MSG, Const.OK);
		return map;
	}
	
	@RequestMapping("/delete")
	public Object deleteClubActivity(@RequestParam String clubName, @RequestParam String sessionId) throws Exception {
		this.clubActivityService.deleteByClubName(clubName);
		return Const.OK;
	}
	
	@RequestMapping("/add")
	public Object addClubActivity(@Valid ClubActivity clubActivity, @RequestParam String sessionId) throws Exception {
		this.clubActivityService.insertClubActivity(clubActivity);
		return Const.OK;
	}
}
