package com.ygy.dal;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;

public class SQLHelper {

	private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String dburl = "jdbc:sqlserver://localhost:1433;DatabaseName=Library";
	private static String user = "admin";
	private static String password = "1234";

	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private SQLHelper() {
	}

	// 获得数据库连接
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(dburl, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库连接出错！");
		}
		return conn;
	}

	// 创建PareparedStatment对象，输入参数存放数组中
	public static PreparedStatement getPreparedStatement(String sql, Object[] objects) throws SQLException {
		PreparedStatement pst = getConnection().prepareStatement(sql);
		for (int i = 0; i < objects.length; i++) {
			pst.setObject(i + 1, objects[i]);
		}

		return pst;
	}

	// 获得查询的结果集对象,输入参数显示列出
	public static ResultSet getResultSet(String sql, Object... objects) {
		ResultSet rs = null;
		try {
			rs = getPreparedStatement(sql, objects).executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	// 关闭数据库连接
	public static void close(Connection conn, PreparedStatement pst, ResultSet rs) {
		try {
			if (rs != null && rs instanceof ResultSet) {
				rs.close();
			}
			if (pst != null && pst instanceof PreparedStatement) {
				pst.close();
			}
			if (conn != null && conn instanceof Connection) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("关闭数据库连接出错");
			e.printStackTrace();

		}
	}
}
