package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {

	public static void main(String[] args) {
		  String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		  String dburl = "jdbc:sqlserver://localhost:1433;DatabaseName=TestDB";
		  String user = "sa";
		  String password = "123456";



			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

	
		// 获得数据库连接
			Connection conn=null;
			try {
				conn = DriverManager.getConnection(dburl, user, password);
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("数据库连接出错！");
			}
		}

	}

