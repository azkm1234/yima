package serviceinterface;

import java.util.List;

import domain.SearchHorseOption;
import model.HorseOnSale;
import model.HorseOptions;



public interface HorseOnSaleService {
	/**
	 * 
	 * @param horseOnSale
	 * @return true is add successfully<tr>
	 *
	 */
	public boolean addOnSaleHorse(HorseOnSale horseOnSale);
	
	public boolean deleteHorseOnSaleById(int id);
	
	public boolean updateSaleHorseById(HorseOnSale horseOnSale);
	
	public boolean updateSaleHorseByIdSelective(HorseOnSale horseOnSale);
	
	public List<HorseOnSale> selectHorseOnSaleByOption(HorseOptions horseOptions, int currentPage);
	
	public List<HorseOnSale> selectHorseONSaleByUsername(String username, int start, int pageSize);
	
	public List<HorseOnSale> selectHorseBySearchHorseOptions(SearchHorseOption options);
}
