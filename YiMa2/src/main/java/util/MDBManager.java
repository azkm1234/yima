package util;

import java.beans.PropertyVetoException;
import java.sql.Connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class MDBManager {
	private static final MDBManager instance=new MDBManager();
	private static final ComboPooledDataSource cpd = new ComboPooledDataSource(true);
	static {
		cpd.setDataSourceName("bbsDataSource");
		cpd.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/b3log_symphony");
		try {
			cpd.setDriverClass("com.mysql.jdbc.Driver");
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		cpd.setUser("root");
		cpd.setPassword("123456");
		cpd.setMaxPoolSize(10);
		cpd.setMinPoolSize(5);
	}
	private MDBManager() {
		
	}
	public static MDBManager getInstance() {
		return instance;
	}
	public static Connection getConnection() {
		try {
			return cpd.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
