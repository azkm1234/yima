package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import domain.TransportCompanyMapper;
import model.TransportCompany;
import serviceinterface.TransportCompanyService;
@Service(value = "transportCompanyService")
public class TransportCompanyServiceImpl implements TransportCompanyService{
	@Resource(name = "transportCompanyMapper")
	private TransportCompanyMapper transportCompanyMapper;
	@Override
	public List<TransportCompany> searchBySize(int currentPage, int pageSize) throws Exception {
		PageHelper.startPage(currentPage, pageSize);
		return this.transportCompanyMapper.selectBySize();
	}

	@Override
	public void insertTransportCompany(TransportCompany transportompany) throws Exception {
		this.transportCompanyMapper.insertSelective(transportompany);
	}

	@Override
	public void deleteByUsername(String username) throws Exception {
		this.transportCompanyMapper.deleteByUserName(username);
	}

	@Override
	public List<TransportCompany> searchByUsername(String username, int currentPage, int pageSize) throws Exception {
		PageHelper.startPage(currentPage, pageSize);
		return this.transportCompanyMapper.selectByUsername(username);
	}

}
