package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.T_USER;

public class T_USERDao extends BaseDao{

	public T_USER findByUsername(String username){
		String sql = "SELECT * FROM T_USER WHERE YHXM=?";
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		T_USER user = null;
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if(rs.next()){
				user = new T_USER(
						rs.getString("YHDM"),
						rs.getString("DWDM"), 
						rs.getString("YHID"), 
						rs.getString("YHXM"), 
						rs.getString("YHKL"), 
						rs.getString("YHXB"), 
						rs.getString("YHBM"), 
						rs.getString("CSRQ"), 
						rs.getString("PXH"), 
						rs.getString("SFJY"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close(ps, rs, conn);
		}
		return user;
	}
	
	public  List<T_USER> getUser(){
		List<T_USER> userli = new ArrayList<T_USER>();
		T_USER user = null;
		String sql = "select T_USER.YHXM,T_USER.YHKL,T_USER.YHBM,T_DEPART.BMMC from T_USER,T_DEPART where T_USER.YHBM = T_DEPART.BMDM";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				user = new T_USER(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), "");
				userli.add(user);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(ps, rs, conn);
		}
		if(userli.size()!=0)
			return userli;
		else
			return null;
	}
}
