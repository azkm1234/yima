package controller;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import conf.Const;
import model.Ride;
import serviceinterface.RideService;

@RestController
@RequestMapping("/ride")
public class RideController {
	@Autowired
	private RideService rideService;
	
	@RequestMapping("/add")
	public Object addRide(@Valid Ride ride, @RequestParam String sessionId) throws Exception {
		this.rideService.insertRide(ride);;
		return Const.OK;
	}
	
	@RequestMapping("/get")
	public Object getRide(@RequestParam Integer page) throws Exception {
		HashMap<String, Object> map = new HashMap<>();
		List<Ride> list = this.rideService.searchBySize(page, Const.PAGESIZE);
		map.put(Const.SIZE, list.size());
		map.put(Const.LIST, list);
		return map;
	}
	
	@RequestMapping("/removeByUserName")
	public Object deleleRide(@RequestParam String userName, @RequestParam String sessionId) throws Exception {
		this.rideService.deleteByUsername(userName);
		return Const.OK;
	}
}
