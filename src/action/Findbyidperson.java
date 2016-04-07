package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PersonDao;
import entity.Person;

public class Findbyidperson extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("get");
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id;
		Person per = null;
		//HTTP协议响应头 UTF-8  浏览器端
		response.setHeader("Content-type", "text/html;charset=UTF-8"); 
		//这句话的意思，是告诉servlet用UTF-8转码，而不是用默认的ISO8859   服务器端
		response.setCharacterEncoding("UTF-8");  
		PrintWriter out = response.getWriter();
		String id1=request.getParameter("idperson");
		id=Integer.parseInt(id1);
		PersonDao persondao=new PersonDao();
		try {
			 per=persondao.findById(id);
			 System.out.println(per.getDescription());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print(per.getAge());
		out.print("<br>");
		out.print(per.getName());
		out.print("<br>");
		out.print(per.getDescription());
		out.print("<br>");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
