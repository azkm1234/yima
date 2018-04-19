package serviceinterface;

import java.util.List;

import model.Ride;

public interface RideService {
	List<Ride> searchBySize(int currentPage, int pageSize) throws Exception;
	void insertRide(Ride ride) throws Exception;
	void deleteByUsername(String username) throws Exception;
}
