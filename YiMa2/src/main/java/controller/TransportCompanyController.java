
package controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import conf.Const;
import model.SessionPojo;
import model.TransportCompany;
import serviceinterface.SessionService;
import serviceinterface.TransportCompanyService;
import vo.SessionVo;

@RestController
@RequestMapping("/company")
public class TransportCompanyController {
	@Autowired
	private TransportCompanyService transportCompanyService;
	@Resource(name = "sessionService")
	private SessionService sessionService;
	
	@RequestMapping("/add")
	public Object addCompany(@Valid TransportCompany transportCompany, BindingResult result,
			@Valid SessionVo session) throws Exception {
		this.transportCompanyService.insertTransportCompany(transportCompany);
		return Const.OK;
	}
	
	@RequestMapping("/list")
	public Object getTransportCompany(@RequestParam Integer page) throws Exception {
		HashMap<String, Object> map = new HashMap<>();
		List<TransportCompany> list = 
				this.transportCompanyService.searchBySize(page, Const.PAGESIZE);
		map.put(Const.SIZE, list.size());
		map.put(Const.LIST, list);
		return map;
	}
	
	@RequestMapping("/delete_by_username")
	public Object deleteTransportCompany(@RequestParam String userName,
			@Valid SessionVo session) throws Exception {
		this.transportCompanyService.deleteByUsername(userName);
		return Const.OK;
	}
	
	@RequestMapping(value="/upload")
	public Object addMyTransport(@Valid TransportCompany tp, BindingResult result, @Valid SessionVo session) throws Exception {
		HashMap<String, Object> map = new HashMap<>();
		SessionPojo sessionPojo = this.sessionService.get(session.getSessionId());
		tp.setUsername(sessionPojo.getUsername());
		this.transportCompanyService.insertTransportCompany(tp);
		return Const.OK;
	}
}
