/**
 * 
 */
package cn.cs.demo.velocity;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.Template;
import org.apache.velocity.context.Context;
import org.apache.velocity.tools.view.VelocityViewServlet;



/**
 * @author Administrator
 *
 */
@WebServlet(name="my first vm", 
	urlPatterns={"/myvm"},
	initParams={
		@WebInitParam(name="org.apache.velocity.properties", value="myvelocity.properties")
	}
)
public class MyVelocityServlet extends VelocityViewServlet {

	@Override
	protected void setContentType(HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
	}
	
	@Override
	protected Template handleRequest(HttpServletRequest request,
			HttpServletResponse response, Context ctx) {
		ctx.put("username", "zhangsan");
		ctx.put("password", "123");
		String action = request.getParameter("action");
		if("login".equals(action)) {
			return this.getTemplate("c/login.html");
		}
		System.out.println(this.getLog());
		
		return getTemplate("demo.html");
	}
}
