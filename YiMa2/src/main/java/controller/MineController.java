package controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import conf.Const;
import model.SessionPojo;
import serviceinterface.ClubListService;
import serviceinterface.HorseOnSaleService;
import serviceinterface.SessionService;
import serviceinterface.TransportCompanyService;
import vo.SessionVo;

@RestController
@RequestMapping("/mine")
public class MineController {
	@Resource (name = "horseOnSaleService")
	HorseOnSaleService horseOnSaleService;
	@Resource(name = "clubListService")
	ClubListService clubListService;
	@Resource(name = "transportCompanyService")
	TransportCompanyService transportCompanyService;
	@Resource(name = "sessionService")
	private SessionService sessionService;
	
	@RequestMapping("/horse_on_sale")
	public Object getMyHorseOnSale(@RequestParam Integer page,@Valid SessionVo session) throws Exception {
		HashMap<String, Object> map = new HashMap<>();
		SessionPojo sessionPojo = this.sessionService.get(session.getSessionId());
		if (sessionPojo == null) {
			throw new Exception("����û�е�¼��");
		}
		List<?> list = horseOnSaleService.selectHorseONSaleByUsername(sessionPojo.getUsername(), page, Const.PAGESIZE);
		map.put(Const.LIST, list);
		map.put(Const.SIZE, list.size());
		return map;
	}
	
	@RequestMapping("/clubs")
	public Object getMyClubs(@RequestParam Integer page,@Valid SessionVo session) throws Exception {
		HashMap<String, Object> map = new HashMap<>();
		SessionPojo sessionPojo = this.sessionService.get(session.getSessionId());
		List<?> list = clubListService.searchClubListByUsername(sessionPojo.getUsername(), page, Const.PAGESIZE);
		map.put(Const.LIST, list);
		map.put(Const.SIZE, list.size());
		return map;
	}
	
	@RequestMapping("/transports")
	public Object getMyTransports(@RequestParam Integer page, @Valid SessionVo session) throws Exception {
		HashMap<String, Object> map = new HashMap<>();
		SessionPojo sessionPojo = this.sessionService.get(session.getSessionId());
		List<?> list = transportCompanyService.searchByUsername(sessionPojo.getUsername(), page, Const.PAGESIZE);
		map.put(Const.LIST, list);
		map.put(Const.SIZE, list.size());
		return map;
	}
}
