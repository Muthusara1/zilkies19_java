package io.zilker.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.zilker.fantasy.bean.Player;
import io.zilker.fantasy.delegates.AdminDelegate;

/**
 * Servlet implementation class EndMatchServlet
 */
@WebServlet("/EndMatchServlet")
public class EndMatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EndMatchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int matchId = Integer.parseInt(request.getParameter("match-id"));
		//new AdminOperations().endMatch(matchId);
		request.setAttribute("matchId", matchId);
		ArrayList< Player > teamOne = new AdminDelegate().getTeamOne(matchId);
		request.setAttribute("teamOne", teamOne);
		ArrayList< Player > teamTwo = new AdminDelegate().getTeamTwo(matchId);
		request.setAttribute("teamTwo", teamTwo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/pages/enter-playing-team.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
