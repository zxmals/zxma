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
import javax.servlet.ServletRequestWrapper;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncodingFilter implements Filter {

	private String encoding;
	private String ContentType;
	private Map<String, Object> param = new HashMap<String, Object>();
	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest)request;
		//指定 转向页面的编码 contentType
		response.setContentType(ContentType);
		if("POST".equals(req.getMethod())){
			request.setCharacterEncoding(encoding);
			chain.doFilter(request, response);
		}
		else{
			param = req.getParameterMap();
			if("GET".equals(req.getMethod())){
				for(Map.Entry<String, Object> e:param.entrySet()){
					try {
						e.setValue(arraytoString(e.getValue()));
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}					
				}
				/*替换掉原有的map*/
				// error-log not ServletRequestWrapper
				class AnoRequest extends HttpServletRequestWrapper{
					public AnoRequest(HttpServletRequest request) {
						super(request);
						// TODO Auto-generated constructor stub
					}
					@Override
					public String getParameter(String name) {
						// TODO Auto-generated method stub
						if(param.isEmpty())
							return null;
						else
							return (String)param.get(name);
					}
				}
				//制定 新写的request的子类（实际上只为了制定getParameter()）
				chain.doFilter(new AnoRequest(req), response);
			}
			else{
				chain.doFilter(request, response);
			}
		}
	}

	/**
	 * 转码
	 * @param o 源生码 String[] 字符串数据组结构
	 * @return  utf-8 码
	 * @throws Exception
	 */
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
