package Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class FiltersLogin implements Filter {
	
	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest req, ServletResponse rep,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub	
		HttpServletRequest reqs = (HttpServletRequest)req;
		HttpSession session = reqs.getSession();
		String servletpath = reqs.getServletPath();
		System.out.println("----------------loginfilter--------"+servletpath+"-------------------------------");
		Object o = session.getAttribute("login_inf");
		if(o!=null||"/login".equals(servletpath)||servletpath.contains(".css")||servletpath.contains(".js")){
			chain.doFilter(req, rep);
			System.out.println("pass.........");
		}
		else{
			reqs.getRequestDispatcher("login.jsp").forward(req, rep);
			System.out.println("rejected..........'");
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
