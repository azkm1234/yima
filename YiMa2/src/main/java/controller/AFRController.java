package controller;

import java.util.Collection;
import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import conf.Const;
import model.AutionResult;
import model.FineResult;
import model.RecommendResult;
import serviceinterface.ThreeHorseService;

@RestController
public class AFRController {
	@Resource(name = "threeHorseService")
	ThreeHorseService threeHorseService;
	
	@RequestMapping("/aution_horses")
	public Object getAuntionHorse(@RequestParam Integer page) {
		HashMap<String, Object> map = new HashMap<>();
		Collection<AutionResult> list = this.threeHorseService.findAuctionHorse(page, Const.PAGESIZE);
		map.put(Const.SIZE, list.size());
		map.put(Const.SIZE, list);
		return map;
	}
	
	@RequestMapping("/recommend_horses")
	public Object getRecommendHorse(@RequestParam Integer page) {
		HashMap<String, Object> map = new HashMap<>();
		Collection<RecommendResult> list = this.threeHorseService.findRecommendHorse(page, Const.PAGESIZE);
		map.put(Const.SIZE, list.size());
		map.put(Const.SIZE, list);
		return map;
	}
	
	@RequestMapping("/fine_horses")
	public Object getFineHorse(@RequestParam Integer page) {
		HashMap<String, Object> map = new HashMap<>();
		Collection<FineResult> list = this.threeHorseService.findFineHorseOnSale(page, Const.PAGESIZE);
		map.put(Const.SIZE, list.size());
		map.put(Const.SIZE, list);
		return map;
	}
}
