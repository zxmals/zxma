package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BaseDao {
	
	private final	String driver = "com.sybase.jdbc3.jdbc.SybDriver";
	private final String url = "jdbc:sybase:Tds:zxmal:5000/testdb?charset=cp936";
	private final String username = "sa";
	private final String password = "";
	
	public Connection getConn(){
		Connection conn = null;
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}

public static void close(PreparedStatement ps,ResultSet rs,Connection con){
		
		if(ps!=null)
			try {
				ps.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		
		if(rs!=null)
			try {
				rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			
		if(con!=null)
			try {
				con.close();						
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
	}
}
