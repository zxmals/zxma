package Filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.HttpRetryException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class EncodingFilter implements Filter {

	private String encoding;
	private String ContentType;
	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		Map<String, Object> param = new HashMap<String, Object>();
		HttpServletRequest req = (HttpServletRequest)request;
		response.setContentType(ContentType);
		if("POST".equals(req.getMethod())){
			request.setCharacterEncoding(encoding);
			chain.doFilter(request, response);
		}
		else{
			param = req.getParameterMap();
			if("GET".equals(req.getMethod())){
				for(Map.Entry<String, Object> e:param.entrySet()){
					req.removeAttribute(e.getKey());
					try {
						req.setAttribute(e.getKey(), arraytoString(e.getValue()));
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				chain.doFilter(request, response);
			}
			else{
				chain.doFilter(request, response);
			}
		}
	}

	public String arraytoString(Object o) throws Exception{
		String array[] = (String[])o;
		for(int i=0;i<array.length;i++){
			array[i] = new String(array[i].getBytes("iso-8859-1"),"utf-8");
		}
		String res = Arrays.toString(array);
		res = res.substring(1,res.length()-1);
		return res;
	}
	
	public void init(FilterConfig fconfig) throws ServletException {
		// TODO Auto-generated method stub
		encoding = fconfig.getInitParameter("encoding");
		ContentType = fconfig.getInitParameter("ContentType");
	}

}
