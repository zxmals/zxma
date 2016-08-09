package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.T_USERDao;
import model.T_USER;

public class UpdateUserInf extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2476687891873126155L;

	private T_USERDao userdao = new T_USERDao();
	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		T_USER user = new T_USER(req.getParameter("username"), req.getParameter("userid"), "", req.getParameter("userdepart"), "");
		if (userdao.updateUserinf(user)){
			session.setAttribute("user", userdao.getUser());
			req.setAttribute("udstatus", "更新成功");
		}
		else{
			req.setAttribute("udstatus", "更新失败");
		}
		req.getRequestDispatcher("successlg.jsp").forward(req, resp);
	}

}
