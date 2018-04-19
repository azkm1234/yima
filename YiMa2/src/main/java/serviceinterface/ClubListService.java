package serviceinterface;

import java.util.List;

import model.ClubList;

public interface ClubListService {
	List<ClubList> searchClubList(int currentPage, int pageSize) throws Exception;
	ClubList searchByClubName(String clubname) throws Exception;
	void insertClubList(ClubList clublist) throws Exception;
	void updateByClubName(ClubList clublist) throws Exception;
	
	void deleteByClubName(String clubname) throws Exception;
	
	List<ClubList> searchClubListByUsername(String usename, int currentPage, int pageSize) throws Exception;
}
