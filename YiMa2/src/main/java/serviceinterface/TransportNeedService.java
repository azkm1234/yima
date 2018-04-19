package serviceinterface;

import java.util.List;

import model.TransportNeed;

public interface TransportNeedService {
	List<TransportNeed> searchBySize(int currentPage, int pageSize) throws Exception;
	void insertTransportNeed(TransportNeed transportNeed) throws Exception;
	void deleteByUsername(String username) throws Exception;
}
