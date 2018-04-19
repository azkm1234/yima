package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import domain.TransportNeedMapper;
import model.TransportNeed;
import serviceinterface.TransportNeedService;
@Service(value = "transportNeedService")
public class TransportNeedServiceImpl implements TransportNeedService{
	@Resource(name = "transportNeedMapper")
	private TransportNeedMapper transportNeedMapper;
	@Override
	public List<TransportNeed> searchBySize(int currentPage, int pageSize) throws Exception {
		PageHelper.startPage(currentPage, pageSize);
		return this.transportNeedMapper.selectBySize();
	}

	@Override
	public void insertTransportNeed(TransportNeed transportNeed) throws Exception {
		this.transportNeedMapper.insertSelective(transportNeed);
	}

	@Override
	public void deleteByUsername(String username) throws Exception {
		this.transportNeedMapper.deleteByPrimaryKey(username);
	}

}
