package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BaseDao {
	
	private static final	String Driver = "com.sybase.jdbc3.jdbc.SybDriver"; //driver class location
	private static final String url = "jdbc:sybase:Tds:zxmal:5000/bookmanage?charset=cp936";
	private static final String username = "sa";
	private static final String password = "";
	/*
	 * getConnection
	 */
	public Connection getConn(){
		Connection conn = null;
		try{
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, username, password);
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
/*
 * close connection||statement||result-set
 */
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
