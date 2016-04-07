package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;

import dao.PersonDao;
import entity.Person;

public class Showallperson extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	{

	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		Map<Integer,Person> persons = null;
		//HTTPЭ����Ӧͷ UTF-8  �������
		response.setHeader("Content-type", "text/html;charset=UTF-8"); 
		//��仰����˼���Ǹ���servlet��UTF-8ת�룬��������Ĭ�ϵ�ISO8859   ��������
		response.setCharacterEncoding("UTF-8");  
		PrintWriter out = response.getWriter();
		PersonDao persondao=new PersonDao();
		try {
			persons=persondao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		for (Person  person: persons.values()){
			out.print("id:" +person.getId());
			out.print("<br>");
			out.print("age:" +person.getAge());
			out.print("<br>");
			out.print("name: "+person.getName());
			out.print("<br>");
			out.print("Description:  "+person.getDescription());
		    out.print("<hr>");
		}
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}



