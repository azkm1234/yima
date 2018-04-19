package serviceinterface;

import java.util.List;

import model.LeisureRecommend;

public interface LeisureRecommendService {
	List<LeisureRecommend> searchBySize(int currentPage, int pageSize) throws Exception;
	void insertLeisureRecommend(LeisureRecommend leisureRecommend) throws Exception;
	void deleteByClubName(String clubname) throws Exception;
	LeisureRecommend searchByPrimaryKey(int id) throws Exception;
}
