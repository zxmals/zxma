package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.T_USER;
import dao.T_USERDao;

public class AddUser extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4366241892609595796L;

	private T_USERDao userdao = new T_USERDao();
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
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
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
		int  pxh = 0;
		if(!("".equals(req.getParameter("PXH"))))
			pxh = Integer.parseInt(req.getParameter("PXH"));
		T_USER user = new T_USER("", "", req.getParameter("YHID"), req.getParameter("YHXM"), 
				req.getParameter("YHKL"), req.getParameter("YHXB"), req.getParameter("YHBM"), 
				req.getParameter("CSRQ"), pxh, req.getParameter("SFJY"));
		HttpSession session = req.getSession();
		if(userdao.addUser(user)){
			session.setAttribute("user", userdao.getUser());
			req.setAttribute("addstatus", "添加成功");
		}
		else
			req.setAttribute("addstatus", "添加失败,该ID已被注册，请更换ID");
		req.getRequestDispatcher("AddUser.jsp").forward(req, resp);
	}

}
