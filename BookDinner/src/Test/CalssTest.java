package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CalssTest {
public static void main(String[] args) {
	Connection conn = null;
	Statement s=null;
	  try {
		Class.forName("com.mysql.jdbc.Driver");
	try {
		conn = DriverManager.getConnection("jdbc:mysql:\\localhost:3306/myfood", "root", "root");
	} catch (SQLException e) {
		e.printStackTrace();
	}
	   try {
	   s = conn.createStatement();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	   try {
		System.out.println(conn.isClosed());
	} catch (SQLException e) {
		e.printStackTrace();
	}
	  } catch (ClassNotFoundException e) {
		e.printStackTrace();
	}	
	  finally {// 释放资源
			if (s != null) {
				try {
					((Connection) s).close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
}
}
}
}

