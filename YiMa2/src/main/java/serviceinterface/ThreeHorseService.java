package serviceinterface;

import java.util.List;

import model.AuctionHorse;
import model.AutionResult;
import model.FineHorseOnSale;
import model.FineResult;
import model.RecommendHorse;
import model.RecommendResult;

public interface ThreeHorseService {
	/**
	 * AuctionHorse
	 * @param size
	 * @return
	 */
	List<AutionResult> findAuctionHorse(int currenPage, int pageSize); 
	
	List<FineResult> findFineHorseOnSale(int currenPage, int pageSize);
	
	List<RecommendResult> findRecommendHorse(int currenPage, int pageSize);
	
	void update(AuctionHorse horse) throws Exception;
	
	void update(FineHorseOnSale horse) throws Exception;
	
	void update(RecommendHorse horse) throws Exception;
	
	void deleteAuctionHorse(int horseId) throws Exception;
	
	void deleteFineHorse(int horseId) throws Exception;
	
	void deleteRecommendHorse(int horseId) throws Exception;
	
	void addAuctionHorse(AuctionHorse horse);
	void addFineHorse(FineHorseOnSale horse);
	void addRecommendHorse(RecommendHorse horse);
	
}
