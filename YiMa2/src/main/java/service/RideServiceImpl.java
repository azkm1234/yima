package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import domain.RideMapper;
import model.Ride;
import serviceinterface.RideService;
@Service(value = "rideService")
public class RideServiceImpl implements RideService{
	@Resource(name = "rideMapper")
	private RideMapper rideMapper;
	@Override
	public List<Ride> searchBySize(int currentPage, int pageSize) throws Exception {
		PageHelper.startPage(currentPage, pageSize);
		return this.rideMapper.selectBySize();
	}

	@Override
	public void insertRide(Ride ride) throws Exception {
		this.rideMapper.insertSelective(ride);
	}

	@Override
	public void deleteByUsername(String username) throws Exception {
		this.rideMapper.deleteByUserName(username);
	}
	
}
