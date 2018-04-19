package serviceinterface;

import java.util.List;

import model.HorseInNeed;

public interface HorseInNeedService {
	boolean addHorseInNeed(HorseInNeed horseInNeed);
	boolean deleteHorseInNeedById(Integer id);
	boolean updateHorseInNeed(HorseInNeed horseInNeed);
	List<HorseInNeed> searchHorseInNeed(HorseInNeed horseInNeed, int currentPage, int pageSize);
}
