package domain;

import java.util.List;

import model.TransportCompany;

public interface TransportCompanyMapper {
    int deleteByUserName(String username);

    int insert(TransportCompany record);

    int insertSelective(TransportCompany record);

    List<TransportCompany> selectBySize();
    
    List<TransportCompany> selectByUsername(String username);

    int updateByPrimaryKeySelective(TransportCompany record);

    int updateByPrimaryKey(TransportCompany record);
}