package domain;

public class SqlVo {
    private String sql;
    
    public SqlVo() {
		
	}
    public SqlVo(String sql) {
		this.sql = sql;
	}
    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

}
