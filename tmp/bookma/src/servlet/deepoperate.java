package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TS_LX;
import dao.ts_lxDao;

public class deepoperate extends HttpServlet {

	private ts_lxDao typedao = new ts_lxDao();
	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String method = req.getParameter("method");
		method = method.trim();
		if("getchildId".equals(method)){
			getchildId(req, resp);
		}
		if("saveorupdate".equals(method)){
			saveorupdate(req, resp);
		}
		if("checkhavechild".equals(method)){
			checkhavechild(req, resp);
		}
	}

	/**
	 * 添加或修改
	 * @param req
	 * @param resp
	 */
	public void saveorupdate(HttpServletRequest req,HttpServletResponse resp){
		TS_LX bookty = new TS_LX(req.getParameter("lbdm"), req.getParameter("flbdm"), 
				req.getParameter("lbmc"), req.getParameter("flbmc"), "320000", 
				req.getParameter("sfjy"), Integer.parseInt(req.getParameter("pxh")));
			try {
				if(typedao.saveorupdate(bookty)){
						resp.getWriter().write("succ");
				}else{
					resp.getWriter().write("fail");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	/**
	 * 生成子类代码
	 * @param req
	 * @param resp
	 */
	public void getchildId(HttpServletRequest req,HttpServletResponse resp){
		try {
			resp.getWriter().write(typedao.getNextpk(req.getParameter("child")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 验证是否存在子类 和删除
	 * @param req
	 * @param resp
	 */
	public void checkhavechild(HttpServletRequest req,HttpServletResponse resp){
		try {
			if(typedao.checkexixt("where FLBDM = '"+req.getParameter("lbdm")+"'")>0){
				resp.getWriter().write("have");
			}else{
				typedao.delete(req.getParameter("lbdm"));
				resp.getWriter().write("delsuc");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
