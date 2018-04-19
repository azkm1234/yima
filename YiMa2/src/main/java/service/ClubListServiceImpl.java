package service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import domain.ClubListMapper;
import model.ClubList;
import serviceinterface.ClubListService;
@Service(value = "clubListService")
public class ClubListServiceImpl implements ClubListService{
	@Resource(name = "clubListMapper")
	private ClubListMapper clubListMapper;
	@Override
	public List<ClubList> searchClubList(int currentPage, int pageSize) throws Exception {
		PageHelper.startPage(currentPage, pageSize);
		return this.clubListMapper.selectBySize();
	}

	@Override
	public void insertClubList(ClubList clublist) throws Exception {
		clublist.setUploadtime(new Date());
		this.clubListMapper.insertSelective(clublist);
	}

	@Override
	public void updateByClubName(ClubList clublist) throws Exception {
		this.clubListMapper.updateByClubNameSelective(clublist);
	}

	@Override
	public void deleteByClubName(String clubname) throws Exception {
		this.clubListMapper.deleteByClubName(clubname);
	}

	@Override
	public ClubList searchByClubName(String clubname) throws Exception {
		return this.clubListMapper.selectByPrimaryKey(clubname);
	}

	@Override
	public List<ClubList> searchClubListByUsername(String username, int currentPage, int pageSize) throws Exception {
		PageHelper.startPage(currentPage, pageSize);
		return this.clubListMapper.selectByUsername(username);
	}
	
}
