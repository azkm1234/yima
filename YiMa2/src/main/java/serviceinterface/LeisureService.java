package serviceinterface;

import java.util.List;

import model.Leisure;

public interface LeisureService {
	List<Leisure> searchByType(String type, int currentPage, int pageSize) throws Exception;
	void insertLeisure(Leisure leisure) throws Exception;
	void updateByPrimaryKey(Leisure leisure) throws Exception;
	void deleteByPrimaryKey(int id) throws Exception;
}
