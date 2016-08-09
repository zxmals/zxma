package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.T_USERDao;

public class DeleteUser extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2207111454456314873L;

	private T_USERDao userdao = new  T_USERDao();
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
			String userid = req.getParameter("userid");
			HttpSession session = req.getSession();
			if(userid!=null)
				if(userdao.deleteUser(userid)){
					req.setAttribute("delstatus", "删除成功");
					session.setAttribute("user", userdao.getUser());
				}
				else{
					req.setAttribute("delstatus", "删除失败");
				}
			req.getRequestDispatcher("successlg.jsp").forward(req, resp);
	}

}
