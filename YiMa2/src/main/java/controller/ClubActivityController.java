package controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import conf.Const;
import model.ClubActivity;
import serviceinterface.ClubActivityService;
import vo.SessionVo;

@RestController
@RequestMapping("/activity")
public class ClubActivityController {
	
	@Resource(name = "clubActivityService")
	ClubActivityService clubActivityService;
	@RequestMapping("/get_by_clubname")
	public Object getClubActivity(@RequestParam String clubname, @RequestParam Integer page) throws Exception {
		HashMap<String, Object> map = new HashMap<>();
		List<ClubActivity> list = 
				this.clubActivityService.searchByClubName(clubname, page, Const.PAGESIZE);
		map.put(Const.LIST, list);
		map.put(Const.SIZE, list.size());
		return map;
	}
	
	@RequestMapping("/delete_by_clubname")
	public Object deleteClubActivity(@RequestParam String clubName, @Valid SessionVo session, BindingResult result) throws Exception {
		this.clubActivityService.deleteByClubName(clubName);
		return Const.OK;
	}
	
	@RequestMapping("delete")
	public Object deleteById(@RequestParam Integer id,  
			@Valid SessionVo session, BindingResult result) throws Exception {
		this.clubActivityService.deleteById(id);
		return Const.OK;
	}
	
	@RequestMapping("/add")
	public Object addClubActivity(@Valid ClubActivity clubActivity, BindingResult result, @Valid SessionVo session) throws Exception {
		this.clubActivityService.insertClubActivity(clubActivity);
		return Const.OK;
	}
}
