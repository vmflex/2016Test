/**
 * 
 */
package cn.cs.demo.sj01;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Administrator
 *
 */
@WebServlet(name="anno Servlet", 
urlPatterns={"/as.htm"}, 
loadOnStartup=1,
initParams={ @WebInitParam(name="dbusername", value="zhangsan"),
		@WebInitParam(name="dbuserpw", value="123")})
public class AnnoServlet extends HttpServlet {

	private int count = 0;
	public AnnoServlet() {
		System.out.println("AnnoServlet Created !!! " + this.toString());
	}
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String dbusername = config.getInitParameter("dbusername");
		String dbuserpw = config.getInitParameter("dbuserpw");
		if("zhangsan".equals(dbusername) && "123".equals(dbuserpw)) {
			System.out.println("DB Connection set up!");
		}
		
		System.out.println("Init method with config arguments");
	}
	
	@Override
	public void destroy() {
		System.out.println("Anno Servlet is destroyed");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		count++;
		resp.getWriter().println("count = " + count);
		
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("yyyy/MM/dd HH:mm:ss.SSS");
		String dateStr = sdf.format(new Date());
		resp.getWriter().println("Hello My Anno Servlet : " + dateStr);
	}
}
