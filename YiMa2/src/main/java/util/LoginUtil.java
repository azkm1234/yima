package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class LoginUtil {
	public static void addToSymphony(String username, String password) throws ClassNotFoundException, SQLException {
		 password = MD5.getMD5Str(password);
		 Connection conn = MDBManager.getConnection();
	     String sql1 = "INSERT INTO symphony_user VALUES (?, '1', 'sym@b3log.org', ?, ?, 'sxb', 'sxb', '', '', 'sxb', '2', 'http://10.108.156.48:8080/symphony/upload/3f6f3907af9e4b509d8642c1fea8601b_YQoHfyfeutq0571029.jpg', '0', '', '', '', '', 'adminRole', '4', '0', '6', '0', '429', '82', '0', '0', '1497946333191', '1497961604056', '1498791229368', '0:0:0:0:0:0:0:1', '0', '1497948441783', '20170620', '20170620', '20170620', '20170620', '0', '0', 'classic', 'mobile', '', '', '', '1494923420139', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '15', '0', '0', '1494917215282', '1', 'zh_CN', 'Asia/Shanghai', '0')";
	     String sql2 = "select * from symphony_user where oid = ?";
	     String oid = null;
	     ResultSet set;
	     do {
	    	 oid = getRandomString(18);
	    	 PreparedStatement stmt = conn.prepareStatement(sql2);
		     stmt.setString(1, oid);
		     set = stmt.executeQuery();
	     } while (set.next());
	     
	     PreparedStatement statement = conn.prepareStatement(sql1);
	     statement.setString(1, oid);
	     statement.setString(2, username);
	     statement.setString(3, password);
	     int result = statement.executeUpdate();
	     if (result != -1) {
	    	 System.out.println("插入数据成功");
	     }
	     conn.close();
	}
	public static String getRandomString(int length) { //length表示生成字符串的长度
	    String base = "abcdefghijklmnopqrstuvwxyz0123456789";   
	    Random random = new Random();   
	    StringBuffer sb = new StringBuffer();   
	    for (int i = 0; i < length; i++) {   
	        int number = random.nextInt(base.length());   
	        sb.append(base.charAt(number));   
	    }   
	    return sb.toString();   
	 }  
}
