package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.T_USER;
import dao.T_DEPARTDAO;
import dao.T_USERDao;

public class Login extends HttpServlet {
	private T_USERDao userdao = new T_USERDao();
	private T_DEPARTDAO departdao = new T_DEPARTDAO();
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
	@Override
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
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse rep)
			throws ServletException, IOException {
//		req.setCharacterEncoding("utf-8");
		String u_name = (String)req.getParameter("userid").trim();
		String u_pwd = (String)req.getParameter("password").trim();
		RequestDispatcher dispatcher = null;
//		rep.setContentType("text/html;charset=utf-8");
		HttpSession session = req.getSession();
		System.out.println("account:"+u_name+"\t pwd:"+u_pwd);
		T_USER user = userdao.findByUsername(u_name);
		if(user!=null){
			if(u_pwd.equals(user.getYHKL())){
				System.out.println("login success");
				session.setAttribute("login_inf", user);
				session.setAttribute("user", userdao.getUser());
				session.setAttribute("depart", departdao.getT_DEPART());
				dispatcher = req.getRequestDispatcher("successlg.jsp");
				dispatcher.forward(req, rep);
			}
			else{
				System.out.println("密码不匹配");
				req.setAttribute("lgstatus", "密码不匹配！");
				dispatcher = req.getRequestDispatcher("login.jsp");
				dispatcher.forward(req, rep);
			}
		}
		else{
			System.out.println("用户未找到");
			req.setAttribute("lgstatus", "用户未找到！");
			dispatcher = req.getRequestDispatcher("login.jsp");
			dispatcher.forward(req, rep);
		}
	}

}
