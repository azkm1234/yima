package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import domain.SwipperMapper;
import model.HorseOnSale;
import serviceinterface.SwipperService;

@Service("swipperService")
public class SwipperServiceImpl implements SwipperService {
	
	@Autowired
	private SwipperMapper swipperMapper;
	@Override
	public List<HorseOnSale> getSwipper() {
		PageHelper.startPage(1, 3);
		return this.swipperMapper.select3Counts();
	}

}
