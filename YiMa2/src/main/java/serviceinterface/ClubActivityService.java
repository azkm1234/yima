package serviceinterface;

import java.util.List;

import model.ClubActivity;

public interface ClubActivityService {
	List<ClubActivity> searchByClubName(String clubName, int currentPage, int pageSize) throws Exception;
	void insertClubActivity(ClubActivity clubActivity) throws Exception;
	void updateClubActivityByClubName(ClubActivity clubActivity) throws Exception;
	void deleteByClubName(String clubName) throws Exception;
	void deleteById(Integer id) throws Exception;
}
