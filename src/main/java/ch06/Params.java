package ch06;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 로그인화면 
 */
@WebServlet("/ch06/params")
public class Params extends HttpServlet {
	
	private static int DEFAULT_COUNT = 5;
	private static String[] FOOD_LIST = {"짜장면", "짬뽕", "탕수육"};
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Query String 처리 localhost:8080/jw/ch06/params?uid=hong&cnt=5

		System.out.println("Params.doGet() method");
		request.setCharacterEncoding("utf-8"); // 굳이안해도 인코딩 오류 발생 하지 않음

		String uid = request.getParameter("uid");

		// cnt 오류처리
		int cnt = DEFAULT_COUNT; // default 값 설정

		try {
			String cnt_ = request.getParameter("cnt");
			cnt = Integer.parseInt(cnt_);
		} catch (Exception e) {
		}
		for (int i = 1; i <= cnt; i++) // 카운트 횟수만큼 반복해서 출력하라는 의미
			System.out.println(i + ", uid : " + uid);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Params.doPost() method");
		request.setCharacterEncoding("utf-8"); // 한글처리를 위해 인코딩 필수

		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		
		// skill 체크박스는 여러항목이 있으므로 배열로 받아야함
		String[] skills = request.getParameterValues("skill");
		
		String food = request.getParameter("food");
		String data = "uid : " + uid + "\n";
		data += "pwd : " + pwd + "\n";
		for(String skill : skills)
			data += "skill : " + skill + "\n";
		
		data += "food : " + FOOD_LIST[Integer.parseInt(food) - 1] + "\n";
		System.out.println(data);

		
		response.setCharacterEncoding("utf-8"); // 굳이 안해도 인코딩 오류발생하지않음
		response.setContentType("text/html; charset=utf-8"); // 반드시 셋팅필요 
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html>");
		out.print("<html lang=\"ko\">");
		out.print("<head>");
		out.print("	<meta charset=\"UTF-8\">");
		out.print("	<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
		out.print("	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
		out.print("	<title>Document</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("	<h1>Params.doPost() method로 받은 파라메터 </h1>");
		out.print("<hr>");
		
		String[] ulList = data.split("\n");
		out.print("	<ul>");
		for (String li: ulList) 
			out.print("		<li>" + li + "</li>");
		out.print("	</ul>");
		

		out.print("	</body>");
		out.print("</html>");	
	}

}
