package ch06;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterMember
 */
@WebServlet("/jw/ch06/RegisterMember")
public class RegisterMember extends HttpServlet {

	private static String[] GENDER = { "남자", "여자" };

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Params.doPost() method");
		request.setCharacterEncoding("utf-8");

		// 아이디, 비밀번호, 비밀번호 확인
		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");

		// 이름, 생년월일, 이메일
		String name = request.getParameter("name");
		String birth = request.getParameter("bYear" + "년 " + "bMonth" + "월 " + "bDay" + "일");
		String email = request.getParameter("email");

		// 성별
		String gender = request.getParameter("gender");

		// 취미
		String[] hobbys = request.getParameterValues("hobby");

		String data = "uid : " + uid + "\n";
		data += "pwd" + pwd + "\n";
		data += "name" + name + "\n";
		data += "birth" + birth + "\n";
		data += "email" + email + "\n";

		data += "gender : " + GENDER[Integer.parseInt(gender)] + "\n";

		for (String hobby : hobbys)
			data += "hobby : " + hobby + "\n";

		System.out.println(data);

	}

}
