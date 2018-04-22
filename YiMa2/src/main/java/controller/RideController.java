package controller;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import conf.Const;
import model.Ride;
import serviceinterface.RideService;
import vo.SessionVo;

@RestController
@RequestMapping("/ride")
public class RideController {
	@Autowired
	private RideService rideService;
	
	@RequestMapping("/add")
	public Object addRide(@Valid Ride ride, BindingResult result, @Valid SessionVo session) throws Exception {
		this.rideService.insertRide(ride);;
		return Const.OK;
	}
	
	@RequestMapping("/list")
	public Object getRide(@RequestParam Integer page) throws Exception {
		HashMap<String, Object> map = new HashMap<>();
		List<Ride> list = this.rideService.searchBySize(page, Const.PAGESIZE);
		map.put(Const.LIST, list);
		map.put(Const.SIZE, list.size());
		return map;
	}
	
	@RequestMapping("/remove_by_username")
	public Object deleleRide(@RequestParam String username, @Valid SessionVo session) throws Exception {
		this.rideService.deleteByUsername(username);
		return Const.OK;
	}
}
