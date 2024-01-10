import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calculator
 */
@WebServlet("/Calculator")
public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		int first = Integer.parseInt(req.getParameter("first"));
		int second = Integer.parseInt(req.getParameter("second"));
		String operations = req.getParameter("operations");
		int ans = 0;
		switch(operations) {
		case "PLUS": ans = first + second;
		             out.println("<h1>"+ans+"</h1>");
		             break;
		case "MINUS": ans = first - second;
        out.println("<h1>"+ans+"</h1>");
        break;
		case "MULT": ans = first * second;
        out.println("<h1>"+ans+"</h1>");
        break;
		case "DIV": ans = first / second;
        out.println("<h1>"+ans+"</h1>");
        break;
		default: out.println("<h1>Enter valid input</h1>");
		}
	}

}