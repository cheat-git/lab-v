import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTML;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/one")
public class one extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("username");
		String pw = request.getParameter("pass");
		String re_pw = request.getParameter("re-pass");
		
		String url = "jdbc:mysql://localhost:3306/mydb";
		String usern = "root";
		String pw1 = "";
		try {
			
			Connection conn = DriverManager.getConnection(url,usern,pw1);
			Statement st = conn.createStatement();
			ResultSet rs;
			
		//	st.executeUpdate("insert into cars(Model,Company,Price,Year) values('800','Maruti',20000,2010)");
			
		//	st.executeUpdate("Delete from cars where Model='ABC' and Year=2010");
			
		// st.executeUpdate("Update cars Set Price=125000 where Price=150000");
			
			rs = st.executeQuery("select * from cars");
			while(rs.next())
			{
				System.out.println(rs.getString("Model")+"\t"+rs.getString("Company")+"\t"+rs.getString("Price")+"\t"+rs.getString("Year"));
			}
			
			
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
        out.println("<html><head><title>Greetings</title></head><body>");
        out.println("<h2>Hello, " + user + "!</h2>");
        out.println("<p>Welcome to our portal.</p>");
        out.println("<a href='registration.html'>HOME</a>");
        out.println("</body></html>");
	}
	

}