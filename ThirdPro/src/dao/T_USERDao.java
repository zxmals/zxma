package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
						Integer.parseInt(rs.getString("PXH")), 
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
		String sql = "select T_USER.YHXM,T_USER.YHID,T_USER.YHKL,T_USER.YHBM,T_DEPART.BMMC from T_USER,T_DEPART where T_USER.YHBM = T_DEPART.BMDM";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				user = new T_USER(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
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
	
	public boolean updateUserinf(T_USER user){
		boolean flag = true;
		String sql = "update T_USER set  YHXM = ? ,YHBM = ? WHERE YHID = ? ";
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = getConn();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getYHXM());
			ps.setString(2, user.getYHBM());
			ps.setString(3, user.getYHID());
			ps.execute();
			conn.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			flag = false;
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally{
			close(ps, null, conn);
		}
		return flag;
	}
	
	public boolean deleteUser(String userid){
		String sql = "delete from T_USER WHERE YHID = ?";
		boolean flag = true;
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConn();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			ps.execute();
			conn.commit();
		} catch (Exception e) {
			// TODO: handle exception
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			flag = false;
		}finally{
			close(ps, null, conn);
		}
		return flag;
	}
	
	public boolean addUser(T_USER user){
		boolean flag = true;
		String sql = "insert into T_USER(YHID,YHKL,YHXM,YHXB,YHBM,CSRQ,PXH,SFJY,YHDM) VALUES(?,?,?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConn();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getYHID());
			ps.setString(2, user.getYHKL());
			ps.setString(3, user.getYHXM());
			ps.setString(4, user.getYHXB());
			ps.setString(5, user.getYHBM());
			ps.setString(6, user.getCSRQ());
			ps.setInt(7, user.getPXH());
			ps.setString(8, user.getSFJY());
			ps.setString(9, user.getYHID());
			ps.execute();
			conn.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			flag = false;
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally{
			close(ps, null, conn);
		}
		return flag;
	}
}
