package service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import domain.HorseInNeedMapper;
import model.HorseInNeed;
import serviceinterface.HorseInNeedService;
@Service(value = "horseInNeedService")
public class HorseInNeedServiceImpl implements HorseInNeedService {
	@Resource(name = "horseInNeedMapper")
	HorseInNeedMapper horseInNeedMapper;
	@Override
	public boolean addHorseInNeed(HorseInNeed horseInNeed) {
		if (horseInNeed != null) {
			horseInNeed.setTime(new Date());
			this.horseInNeedMapper.insertSelective(horseInNeed);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteHorseInNeedById(Integer id) {
		if (id != null) {
			this.horseInNeedMapper.deleteByPrimaryKey(id);
			return false;
		}
		return true;
	}

	@Override
	public boolean updateHorseInNeed(HorseInNeed horseInNeed) {
		if (horseInNeed != null) {
			horseInNeed.setTime(new Date());
			this.horseInNeedMapper.updateByPrimaryKey(horseInNeed);
			return true;
		}
		return false;
	}

	@Override
	public List<HorseInNeed> searchHorseInNeed(HorseInNeed horseInNeed, int currentPage, int pageSize) {
		if (horseInNeed != null) {
			PageHelper.startPage(currentPage, pageSize);
			return this.horseInNeedMapper.selectByPojo(horseInNeed);
		}
		return null;
	}

}
