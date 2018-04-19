package controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import conf.Const;
import domain.SearchHorseOption;
import model.HorseOnSale;
import model.HorseOptions;
import model.SessionPojo;
import serviceinterface.HorseOnSaleService;
import serviceinterface.SessionService;

@RestController
@RequestMapping("/sale_horse")
public class HorseOnSaleController {
	@Autowired
	private SessionService sessionService;
	@Autowired
	HorseOnSaleService horseOnSaleService;
	
	@RequestMapping("/add")
	public Object addHorseOnSale(@Valid HorseOnSale horseOnSale, @RequestParam String sessionId) {
		if (horseOnSale.getAge() == null || horseOnSale.getAge() < 0) {
			horseOnSale.setAge(0);
		}
		if (horseOnSale.getHeight() == null || horseOnSale.getHeight() < 0) {
			horseOnSale.setHeight(null);
		}
		horseOnSale.setTime(new Date());
		SessionPojo sessionPojo = this.sessionService.get(sessionId);
		horseOnSale.setUsername(sessionPojo.getUsername());
		this.horseOnSaleService.addOnSaleHorse(horseOnSale);
		return Const.OK;
	}
	@RequestMapping("/all")
	public Object getAllHorseOnSale(@RequestParam Integer page) {
		HashMap<String, Object> map = new HashMap<>();
		List<HorseOnSale> lists = this.horseOnSaleService.selectHorseOnSaleByOption(new HorseOptions(),page);
		map.put(Const.SIZE, lists.size());
		map.put(Const.LIST, lists);
		return map;
	}
	@RequestMapping("/remove")
	public Object removeHorseOnSale(@RequestParam Integer id, @RequestParam String sessionId) {
		this.horseOnSaleService.deleteHorseOnSaleById(id);
		return Const.OK;
	}
	@RequestMapping("/update")
	public Object updateHorseOnSale(@Valid HorseOnSale horseOnSale, @RequestParam String sessionId) {
		this.horseOnSaleService.updateSaleHorseById(horseOnSale);
		return Const.OK;
	}
	
	@RequestMapping(value="/search")
	@ResponseBody
	public Object getHorses(@RequestBody SearchHorseOption options, @RequestParam(defaultValue="1") Integer page) {
		HashMap<String, Object> map = new HashMap<>();
		options.setPageSize(Const.PAGESIZE);
		options.setCurrentPage(page);
		List<HorseOnSale> list = horseOnSaleService.selectHorseBySearchHorseOptions(options);
		map.put(Const.LIST, list);
		map.put(Const.SIZE, list.size());
		return map;
	}
	
}
