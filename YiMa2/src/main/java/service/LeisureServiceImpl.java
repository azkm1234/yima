package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import domain.LeisureMapper;
import model.Leisure;
import serviceinterface.LeisureService;
@Service(value = "leisureService")
public class LeisureServiceImpl implements LeisureService {
	@Resource(name = "leisureMapper")
	private LeisureMapper leisureMapper;
	@Override
	public List<Leisure> searchByType(String type, int currentPage, int pageSize) throws Exception {
		PageHelper.startPage(currentPage, pageSize);
		return this.leisureMapper.selectByType(type);
	}

	@Override
	public void insertLeisure(Leisure leisure) throws Exception {
		this.leisureMapper.insertSelective(leisure);
	}

	@Override
	public void updateByPrimaryKey(Leisure leisure) throws Exception {
		this.leisureMapper.updateByPrimaryKey(leisure);
	}

	@Override
	public void deleteByPrimaryKey(int id) throws Exception {
		// TODO Auto-generated method stub
		this.leisureMapper.deleteByPrimaryKey(id);
	}

}
