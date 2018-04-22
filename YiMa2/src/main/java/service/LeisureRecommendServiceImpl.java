package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import domain.LeisureRecommendMapper;
import model.LeisureRecommend;
import serviceinterface.LeisureRecommendService;
@Service(value = "leisureRecommendService")
public class LeisureRecommendServiceImpl implements LeisureRecommendService {
	@Resource(name = "leisureRecommendMapper")
	private LeisureRecommendMapper leisureRecommendMapper;
	@Override
	public List<LeisureRecommend> searchBySize(int currentPage, int pageSize) throws Exception {
		PageHelper.startPage(currentPage, pageSize);
		return this.leisureRecommendMapper.selectBySize();
	}

	@Override
	public void insertLeisureRecommend(LeisureRecommend leisureRecommend) throws Exception {
		this.leisureRecommendMapper.insertSelective(leisureRecommend);
	}

	@Override
	public void deleteByClubName(String clubname) throws Exception {
		this.leisureRecommendMapper.deleteByClubName(clubname);
	}

	@Override
	public LeisureRecommend searchByPrimaryKey(int id) throws Exception {
		return this.leisureRecommendMapper.selectByPrimaryKey(id);
	}

	@Override
	public void deleteById(Integer id) {
		this.leisureRecommendMapper.deleteById(id);
	}

}
