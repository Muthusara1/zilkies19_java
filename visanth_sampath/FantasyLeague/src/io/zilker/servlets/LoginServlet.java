package io.zilker.servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import io.zilker.fantasy.bean.User;
import io.zilker.fantasy.utility.UserValidator;
/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	public boolean checkBlankName(String name) {
		String nameRegex = ".*[a-zA-Z]+.*";
		Pattern pat = Pattern.compile(nameRegex);
		if (name == null)
			return false;
		return pat.matcher(name).matches();
	}
	public boolean checkBlankPassword(String password) {
		if(password=="") {
			return false;
		}
		return true;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("user-name");
		String password = request.getParameter("password");
		out.println("<html><body>");
		
		User newUser = new UserValidator().enterLoginDetails(userName, password);
		
		if(newUser.getUserType()==1) {
			//response.sendRedirect("");
			HttpSession session = request.getSession();
			session.setAttribute("user", newUser);
			session.setAttribute("isLoggedIn", "true");
			request.setAttribute("userObject", newUser);
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/pages/user-home.jsp");
		    rd.forward(request, response);
			//response.sendRedirect("pages/user-home.jsp");
		}
		else if(newUser.getUserType()==2){
			HttpSession session = request.getSession();
			session.setAttribute("admin", newUser);
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/pages/add-match.jsp");
		    rd.forward(request, response);
			//response.sendRedirect("WEB-INF/pages/add-match.jsp");
		}
		else {
			out.print("<script>console.log('Wrong Credentials'); window.location.href='http://127.0.0.1:8080/FantasyLeague/';</script>");
		}
		out.println("</body></html>");
		//doGet(request, response);
	}

}
