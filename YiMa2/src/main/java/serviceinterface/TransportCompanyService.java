package serviceinterface;

import java.util.List;

import model.TransportCompany;
public interface TransportCompanyService {
	List<TransportCompany> searchBySize(int currentPage, int pageSize) throws Exception;
	List<TransportCompany> searchByUsername(String username, int currentPage, int pageSize) throws Exception;
	void insertTransportCompany(TransportCompany transportompany) throws Exception;
	void deleteByUsername(String username) throws Exception;
}
