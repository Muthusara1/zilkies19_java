package com.zilker.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.zilker.beans.Score;
import com.zilker.service.ServiceCrudOperations;

/**
 * Servlet implementation class ViewScorecard
 */
@WebServlet("/ViewScorecard")
public class ViewScorecard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewScorecard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setDateHeader("Expires", 0);
		String runs=request.getParameter("runs");
		String overs=request.getParameter("overs");
		String wickets=request.getParameter("wickets");
		String teamname=request.getParameter("teamname");
		String match=request.getParameter("match");
		ServiceCrudOperations scorecardupdate=new ServiceCrudOperations();
		try {
			int teamId=scorecardupdate.getteamId(teamname);
			com.zilker.beans.Scorecard matchinfo=new com.zilker.beans.Scorecard();
			matchinfo.setmatchNo(Integer.parseInt(match));
			matchinfo.setTeamId(teamId);
			Score stats=new Score();
			stats.setRuns(Integer.parseInt(runs));
			stats.setOvers((Float.parseFloat(overs)));
			stats.setWickets((Integer.parseInt(wickets)));
		    scorecardupdate.updateScorecard(stats,Integer.parseInt(match),teamId);
		} catch (SQLException e1) {
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setDateHeader("Expires", 0);
		String teamName=request.getParameter("teamname");
		String teamNametwo=request.getParameter("teamname2");
		String match=request.getParameter("match");
		ServiceCrudOperations scorecardfetch=new ServiceCrudOperations();
		try {
			int team_id=scorecardfetch.getteamId(teamName);
			int team_id2=scorecardfetch.getteamId(teamNametwo);
			ArrayList score=scorecardfetch.getScore(team_id,match);
			ArrayList score2=scorecardfetch.getScore(team_id2,match);
			score.addAll(score2);
			System.out.println(score);
			String json = new Gson().toJson(score);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
		} catch (SQLException e) {
		}
	}
	}
