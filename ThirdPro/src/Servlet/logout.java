package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class logout extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5742123228925640112L;

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * unused
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
	public void doPost(HttpServletRequest req, HttpServletResponse rep)
			throws ServletException, IOException {
		rep.setContentType("text/html;charset=utf-8");
		req.getSession().invalidate();
		req.getRequestDispatcher("login.jsp").forward(req, rep);
		System.out.println("log-out");
	}

}
