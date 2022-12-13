package ch08;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextInfo
 */
@WebServlet("/ch08/info")
public class ContextInfo extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//  context = ctx 동일한 메소드가 됨(표현방식이 다를뿐)
		ServletContext context = request.getServletContext();
		ServletContext ctx = getServletContext();
		
		System.out.println("MajorVersion : " + ctx.getMajorVersion());
		System.out.println("RealPath : " + ctx.getRealPath("/ch08/info"));
		System.out.println("ServerInfo : " + ctx.getServerInfo());
		System.out.println("ServletContextName : " + ctx.getServletContextName());
		
		
		//web.xml에 등록 되어있는 초기 설정값 
		String menu = ctx.getInitParameter("menu");
		System.out.println("menu" + menu);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
