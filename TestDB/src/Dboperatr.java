
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.T_DEPART;
import model.T_USER;


public class Dboperatr {

	public static void main(String[] args){		
//		//�������ݵ���T_DEPART
//		insertDepart(new T_DEPART("32010006","320100","06","����6","","6"));//Add 3201004~3201005
//		//�������ݵ���T_DEPART
//		insert(new T_DEPART("32010005","320100","05","����5","","5")); //Add depart: 3201004~3201005
//		//�������ݵ���T_USER
//		insert(new T_USER("320100lar6","320100", "lar6", "������6", "","", "32010003", "", "5", "")); //Add User: 320100lar2~320100lar6
		
//		//���±�T_USER������
//		updateUser("YHBM", "32010003", "320100lar3");
//		//���±�T_DEPART������
//		updateDepart("BMMC", "����4_updatetest", "32010004");
		
//		//ɾ���дӱ�T_DEPART
//		deleteDepart("32010005");
//		//ɾ���дӱ�T_USER
//		deleteUser("320100lar5");
		
//		//4. ��Map�洢�����û����û�����
//		Map<String, Object> map = mapquerytest();
//		//5. ����Map����û�������û�����
//		for(Map.Entry<String, Object> e: map.entrySet()){
//			System.out.println(e.getKey()+"------"+e.getValue());
//		}
		
//		//6.��List �洢�����û�����Ϣ�������û����루T_USER.YHDM�����û�������T_USER.YHXM�������Ŵ��루T_USER.YHBM�����û����ڲ������� (T_DEPART.BMMC)
//		List<T_USER>user = getUser();
//		//7. ����List����û����������û����ڲ�������
//		for(T_USER e:user){
//			System.out.println("����:"+e.getYHXM()+"\t���ڲ���:"+e.getYHBM());
//		}
		
	
//		//8.2016-01-01 00:00:00 �� 1����28����ʱ�䣬���ԡ�yyyy-MM-dd������ʽ���
//		Calendar cal = Calendar.getInstance();
//		cal.set(2016, 0, 1, 0, 0, 0);
//		cal.add(Calendar.MONTH, 1);		
//		cal.add(Calendar.DAY_OF_MONTH, 28);
//		Date date = cal.getTime();
//		System.out.println(ToolUtils.convertRq(date, "yyyy-MM-dd"));
		
		
	}
	/***
	 * �������ݿ�
	 * @return Connection
	 */
	public static Connection getConn(){
		Connection conn = null;
		String driver = "com.sybase.jdbc3.jdbc.SybDriver";
		String url = "jdbc:sybase:Tds:zxmal:5000/testdb?charset=cp936";
		String username = "sa";
		String password = "";
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}	
	/**
	 * ���Ӳ��Ż����û�/add depart or user
	 * @param o ���� Object �����Ķ�������{T_DEPART,T_USER}
	 * @return int ����ִ��״ֵ̬  1:�ɹ�     0:ʧ��
	 */
	public static int insert(Object o){
		int flag = 1;
		String objtype = o.getClass().getSimpleName();
		Connection con = null;
		PreparedStatement ps = null;
		T_DEPART depart = null;
		T_USER user = null;
		String sql = null;
		if("T_DEPART".equals(objtype)){
			depart = (T_DEPART)o;	
			sql = "insert into T_DEPART values('"+depart.getBMDM()+"','"+depart.getDWDM()+"','"+depart.getBMID()+"','"+depart.getBMMC()+"','"+depart.getSFJY()+"',"+Integer.parseInt(depart.getPXH())+")";			
		}
		if("T_USER".equals(objtype)){
			user = (T_USER)o;
			sql = "insert into T_USER values('"+user.getYHDM()+"','"+user.getDWDM()+"','"+user.getYHID()+"','"+user.getYHXM()+"','"+user.getYHKL()+"','"+user.getYHXB()+"','"+user.getYHBM()+"','"+user.getCSRQ()+"',"+Integer.parseInt(user.getPXH())+",'"+user.getSFJY()+"')";
		}
		try{
			con = getConn();
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);
			ps.execute();
			con.commit();
		}catch(Exception e){
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally{
			close(ps, null, con);	
		}
		return flag;
	}
	/**
	 * update/�޸�  ��   dbo.T_USER
	 * @param colname   	Ŀ������
	 * @param value 	Ŀ��ֵ
	 * @param id 	������Ψһ��ʶ��ֵ
	 * @return int ����ִ��״ֵ̬  1:�ɹ�     0:ʧ��
	 */
	public static int updateUser(String colname,String value,String id){
		int flag = 1;		
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "update T_USER set "+colname+" = ? where YHDM = ?";		
		try{
			con = getConn();
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);
			ps.setString(1, value);
			ps.setString(2, id);
			ps.execute();
			con.commit();
		}catch(Exception e){
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally{
			close(ps, null, con);	
		}
		return flag;
	}
	/**
	 * update/�޸�  ��   dbo.T_DEPART
	 * @param colname   	Ŀ������
	 * @param value 	Ŀ��ֵ
	 * @param id 	������Ψһ��ʶ��ֵ
	 * @return int ����ִ��״ֵ̬  1:�ɹ�     0:ʧ��
	 */
	public static int updateDepart(String colname,String value,String id){
		int flag = 1;		
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "update T_DEPART set "+colname+" = ? where BMDM = ?";		
		try{
			con = getConn();
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);			
			ps.setString(1, value);
			ps.setString(2, id);
			ps.execute();
			con.commit();
		}catch(Exception e){
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		finally{
			close(ps, null, con);	
		}
		return flag;
	}
	/**
	 * ɾ���дӱ�T_DEPART
	 * @param id ������Ψһ��ʶ��ֵ
	 * @return int ����ִ��״ֵ̬  1:�ɹ�     0:ʧ��
	 */
	public static int deleteDepart(String id){
		int flag = 1;		
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "delete from T_DEPART where BMDM = ?";		
		try{
			con = getConn();
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);			
			ps.setString(1, id);
			ps.execute();
			con.commit();
		}catch(Exception e){
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		finally{
			close(ps, null, con);	
		}
		return flag;
	}
	/**
	 * ɾ���дӱ�T_USER
	 * @param id ������Ψһ��ʶ��ֵ
	 * @return int ����ִ��״ֵ̬  1:�ɹ�     0:ʧ��
	 */
	public static int deleteUser(String id){
		int flag = 1;		
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "delete from T_USER where YHDM = ?";		
		try{
			con = getConn();
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);			
			ps.setString(1, id);
			ps.execute();
			con.commit();
		}catch(Exception e){
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		finally{
			close(ps, null, con);	
		}
		return flag;
	}
	/**
	 * ��Map�洢�����û����û�����
	 * @return Map<String,Object>
	 */
	public static Map<String, Object> mapquerytest(){
		Map<String, Object> map = new HashMap<String, Object>();
		String sql = "select YHDM,YHXM from T_USER";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				map.put((String)rs.getObject("YHXM"), rs.getObject("YHDM"));				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{		
			
			close(ps, rs, conn);
		}		

		return map;
	}
	
	/**
	 * ��List �洢�����û�����Ϣ�������û����루T_USER.YHDM�����û�������T_USER.YHXM�������Ŵ��루T_USER.YHBM�����û����ڲ������� (T_DEPART.BMMC)
	 * @return List<T_USER>
	 */
	public static List<T_USER> getUser(){
		List<T_USER> userli = new ArrayList<T_USER>();
		T_USER user = null;
		String sql = "select T_USER.YHDM,T_USER.YHXM,T_USER.YHBM,T_DEPART.BMMC from T_USER,T_DEPART where T_USER.YHBM = T_DEPART.BMDM";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				user = new T_USER(rs.getString("YHDM"), rs.getString("YHXM"), rs.getString("YHBM"), rs.getString("BMMC"));
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
	
	
//	/***
//	 * ���Ӳ���/add depart
//	 * @param depart
//	 * @return
//	 */
//	public static int insertDepart(T_DEPART depart){
//		int flag = 1;
//		Connection con = null;
//		ResultSet rs = null;
//		PreparedStatement ps = null;
//		String sql = "insert into T_DEPART VALUES(?,?,?,?,?,?)";
//		try{
//			con = getConn();
//			con.setAutoCommit(false);
//			ps = con.prepareStatement(sql);
//			ps.setString(1, depart.getBMDM());
//			ps.setString(2, depart.getDWDM());
//			ps.setString(3, depart.getBMID());
//			ps.setString(4, depart.getBMMC());
//			ps.setString(5, depart.getSFJY());
//			ps.setLong(6, Integer.parseInt(depart.getPXH()));
//			ps.execute();
//			con.commit();
//		}catch(Exception e){
//			e.printStackTrace();
//			try {
//				con.rollback();
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			flag = 0;
//		}finally{
//			close(ps, rs, con);
//		}
//		return flag;
//	}
	/**
	 * ��ѯ/select ��ѯ���ݿ����ִ�ı�
	 * @param sql sql��ѯ���
	 * @param param  ���� string[] ��������sql�����ͨ�����ֵ
	 * @return List List<Map<K,V>>
	 */	
	public static List query(String sql,String[] param){		
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		ResultSetMetaData mdata = null;
		Map<String, Object> map = null;
		List<Object> li = new ArrayList<>();
		int colnum = 0;		
		try{
			con = getConn();
			ps = con.prepareStatement(sql);
			if(param!=null)
				for(int i=1;i<param.length;i++)
					ps.setString(i, param[i-1]);
			rs = ps.executeQuery();
			while(rs.next()){
				map = new HashMap<>();
				mdata = rs.getMetaData();
				colnum = mdata.getColumnCount();
				for(int j=1;j<=colnum;j++){
					map.put(mdata.getColumnName(j),rs.getObject(j));
				}
				li.add(map);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			close(ps, rs, con);
		}
		return li;
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
