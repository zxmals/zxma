package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.spi.DirStateFactory.Result;

import TreeStore.GenerateTree;
import model.TS_LX;

public class ts_lxDao extends BaseDao {

	public Map<String, Object> getTree() {
		System.out.println("********************************** ----getTree");
		Map<String, Object> tree = new HashMap<String, Object>();
		List<TS_LX> booktype = new ArrayList<TS_LX>();
		List<TS_LX> tmpli = null;
		TS_LX type = null;
		String sql = "select LBDM,LBMC,PXH,SFJY FROM TS_LX WHERE LBDM LIKE '32000000%'  ORDER BY PXH";
		String sqld = "select LBDM,LBMC,PXH,SFJY FROM TS_LX WHERE FLBDM = ?  ORDER BY PXH ";
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				type = new TS_LX(rs.getString(1), rs.getString(2),
						Integer.parseInt(rs.getString(3)), rs.getString(4));
				booktype.add(type);
			}
			tree.put("first", booktype);
			for (int i = 0; i < booktype.size(); i++) {
				close(ps, rs, null);
				ps = conn.prepareStatement(sqld);
				ps.setString(1, booktype.get(i).getLbdm());
				rs = ps.executeQuery();
				tmpli = new ArrayList<TS_LX>();
				while (rs.next()) {
					type = new TS_LX(rs.getString(1), rs.getString(2),
							Integer.parseInt(rs.getString(3)), rs.getString(4));
					tmpli.add(type);
				}
				tree.put(booktype.get(i).getLbdm(), tmpli);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(ps, rs, conn);
		}
		return tree;
	}

	public String getNextpk(String childstr) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select  max(LBDM) FROM TS_LX WHERE LBDM LIKE '" + childstr + "%' ";
		String last_lbdm = null;
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				last_lbdm = rs.getString(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(ps, rs, conn);
		}
		if(last_lbdm!=null)
			return (1 + Long.parseLong(last_lbdm.trim())) + "";
		else
			return childstr+"01";
	}

	public int checkexixt(String backsql){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int num = 0;
		String sql = "SELECT COUNT(*) FROM TS_LX  "+backsql;
		try {
			con = getConn();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				num = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close(ps, rs, con);
		}
		return num;
	}
	
	public boolean saveorupdate(TS_LX type){
		boolean flag = true;
		Connection con = null;
		PreparedStatement ps = null;
		String save = "insert into TS_LX(FLBDM,FLBMC,LBDM,LBMC,PXH,SFJY,FYDM) VALUES (?,?,?,?,?,?,'320000')";
		String update = "update TS_LX  set  LBMC=?,PXH=?,SFJY=? WHERE  LBDM=?";
		int num = 0;
		try {
			num = checkexixt("where LBDM='"+type.getLbdm()+"'");
			con = getConn();
			con.setAutoCommit(false);
			if(num==0){
				ps = con.prepareStatement(save);
				ps.setString(1, type.getFlbdm().trim());
				ps.setString(2, type.getFlbmc().trim());
				ps.setString(3, type.getLbdm().trim());
				ps.setString(4, type.getLbmc().trim());
				ps.setInt(5, type.getPxh());
				ps.setString(6, type.getSfjy().trim());
				ps.execute();
			}else{
				ps = con.prepareStatement(update);
				ps.setString(1, type.getLbmc().trim());
				ps.setInt(2, type.getPxh());
				ps.setString(3, type.getSfjy().trim());
				ps.setString(4, type.getLbdm().trim());
				ps.executeUpdate();
			}
			con.commit();
			GenerateTree.setTree(new ts_lxDao().getTree());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			flag = false;
		}finally{
			close(ps, null, con);
		}
		return flag;
	}
	
	public boolean delete(String id){
		boolean flag = true;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "delete from TS_LX WHERE LBDM=?";
		try {
			con = getConn();
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.execute();
			con.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally{
			close(ps, null, con);
		}
		GenerateTree.setTree(new ts_lxDao().getTree());
		return flag;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Map<String, Object> map = new ts_lxDao().getTree();
		// List<TS_LX> li = (List)map.get("first");
		// List<TS_LX> tmp = null;
		// for(int i=0;i<li.size();i++){
		// System.out.println(li.get(i).getLbdm());
		// tmp = (List)map.get(li.get(i).getLbdm());
		// for(int j=0;j<tmp.size();j++){
		// System.out.println("         "+tmp.get(j).getLbdm());
		// }
		// }

		System.out.println(new ts_lxDao().getNextpk("32000001"));
	}

}
