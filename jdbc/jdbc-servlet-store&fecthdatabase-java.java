import java.io.IOException;
import java.sql.*;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		res.setContentType("text/html");
//		String usn = req.getParameter("usn");
//		String name = req.getParameter("name");
//		PrintWriter out = res.getWriter();
//		out.println("<h1>"+usn+"</h1>");
//		out.println("<h3>"+name+"</h3>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String usn = req.getParameter("usn");
		String name = req.getParameter("name");
		System.out.println(usn);
		out.println("<h1>"+usn+"</h1>");
		out.println("<h3>"+name+"</h3>");
		
       try {
       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "");
       Statement st = con.createStatement();
       PreparedStatement pt=con.prepareStatement("insert into student values(?,?)") ;
       pt.setString(1, usn);
       pt.setString(2,name);
       int r=pt.executeUpdate();
       ResultSet rs = st.executeQuery("select * from student");
       while(rs.next()) {
    	   out.println("<h1>"+rs.getString("usn")+"</h1>");
       }
       }
       catch(Exception e) {
    	   System.out.println(e);
       }
      
       
	}

}