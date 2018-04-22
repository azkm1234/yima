package controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import conf.Const;
import model.ClubList;
import serviceinterface.ClubListService;
import vo.SessionVo;

@RestController
@RequestMapping("/club")
public class ClubListController {
	@Resource(name = "clubListService")
	ClubListService clubListService;
	@RequestMapping("/all")
	public Object getAllClubs(@RequestParam Integer page) throws Exception {
		List<ClubList> list = this.clubListService.searchClubList(page, Const.PAGESIZE);
		HashMap<String, Object> map = new HashMap<>();
		map.put(Const.LIST, list);
		map.put(Const.SIZE, list.size());
		return map;
	}
	
	@RequestMapping("/delete_by_clubname")
	public Object deleteClubList(@RequestParam String clubname, @Valid SessionVo session) throws Exception {
		this.clubListService.deleteByClubName(clubname);
		return Const.OK;
	}
	
	@RequestMapping("/update")
	public Object updateClubList(ClubList clublist, @Valid SessionVo session, BindingResult result) throws Exception {
		this.clubListService.updateByClubName(clublist);
		return Const.OK;
	}
	
	@RequestMapping("/add")
	public Object addClubList(@Valid ClubList clublist, BindingResult result, @Valid SessionVo session) throws Exception {
		clublist.setUploadtime(new Date());
		this.clubListService.insertClubList(clublist);
		return Const.OK;
	}
	
	@RequestMapping("/getByName")
	public Object getByName(@RequestParam String clubname) throws Exception {
		HashMap<String, Object> map = new HashMap<>();
		ClubList list = this.clubListService.searchByClubName(clubname);
		map.put(Const.LIST, list);
		map.put(Const.MSG, Const.OK);
		return map;
	}
}
