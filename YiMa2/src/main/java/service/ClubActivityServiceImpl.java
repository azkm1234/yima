package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import domain.ClubActivityMapper;
import model.ClubActivity;
import serviceinterface.ClubActivityService;
@Service(value = "clubActivityService")
public class ClubActivityServiceImpl implements ClubActivityService{
	@Resource(name = "clubActivityMapper")
	private ClubActivityMapper clubActivityMapper;
	@Override
	public List<ClubActivity> searchByClubName(String clubName, int currentPage, int pageSize) throws Exception {
		PageHelper.startPage(currentPage, pageSize);
		return this.clubActivityMapper.selectByClubName(clubName);
	}

	@Override
	public void insertClubActivity(ClubActivity clubActivity) throws Exception {
		this.clubActivityMapper.insertSelective(clubActivity);
	}

	@Override
	public void updateClubActivityByClubName(ClubActivity clubActivity) throws Exception {
		this.clubActivityMapper.updateByClubNameSelective(clubActivity);
	}

	@Override
	public void deleteByClubName(String clubName) throws Exception {
		this.clubActivityMapper.deleteByClubName(clubName);
	}

}
