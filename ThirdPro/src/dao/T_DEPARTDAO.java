
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.T_DEPART;

public class T_DEPARTDAO extends BaseDao {

	public List<T_DEPART> getT_DEPART(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<T_DEPART> departli = new ArrayList<T_DEPART>();
		T_DEPART depart = null;
		try {
			conn = getConn();
			ps = conn.prepareStatement("SELECT BMDM,BMMC FROM T_DEPART");
			rs = ps.executeQuery();
			while(rs.next()){
				depart = new T_DEPART(rs.getString(1), rs.getString(2));
				departli.add(depart);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close(ps, rs, conn);
		}
		if(departli.size()!=0)
			return departli;
		else
			return null;
	}
	
	public Map<String, Object> getdepart(){
		Map<String, Object>  depmap = new HashMap<String, Object>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConn();
			ps = conn.prepareStatement("SELECT BMDM,BMMC  FROM T_DEPART");
			rs = ps.executeQuery();
			while(rs.next()){
				depmap.put(rs.getString(1), rs.getObject(2));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close(ps, rs, conn);
		}
		return depmap;
	}
	
	public static void main(String[] args){
		Map<String, Object> map = new T_DEPARTDAO().getdepart();
		for(Map.Entry<String, Object> e:map.entrySet()){
			System.out.println(e.getKey()+"                    "+e.getValue());
		}
	}
}
