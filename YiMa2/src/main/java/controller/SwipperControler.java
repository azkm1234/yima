package controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import conf.Const;
import model.HorseOnSale;
import serviceinterface.SwipperService;

@RestController
public class SwipperControler {
	@Resource(name = "swipperService")
	SwipperService swipperService;
	@RequestMapping(value = "/swippers")
	public @ResponseBody Object getSwipper() {
		HashMap<String, Object> map = new HashMap<>();
		List<HorseOnSale> r = this.swipperService.getSwipper();
		map.put(Const.SIZE, r.size());
		map.put(Const.LIST, r);
		return map;
	}
}
