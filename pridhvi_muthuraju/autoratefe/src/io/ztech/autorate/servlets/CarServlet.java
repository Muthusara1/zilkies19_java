package io.ztech.autorate.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.ztech.autorate.beans.Rating;
import io.ztech.autorate.beans.Request;
import io.ztech.autorate.beans.Specification;
import io.ztech.autorate.beans.User;
import io.ztech.autorate.constants.AppConstants;
import io.ztech.autorate.delegates.AddRatingDelegate;
import io.ztech.autorate.delegates.FetchDetailsDelegate;

/**
 * Servlet implementation class CarServlet
 */
@WebServlet("/CarServlet")
public class CarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FetchDetailsDelegate fetchdetailsDelegate = new FetchDetailsDelegate();
	public static final Logger logger = Logger.getLogger(CarServlet.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CarServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @throws IOException
	 * @throws ServletException
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Request requestBean = new Request();
		requestBean.setCarId(Integer.parseInt(request.getParameter("id")));
		Specification carBean = null;
		try {
			carBean = fetchdetailsDelegate.getCar(requestBean);
		} catch (Exception e) {
			logger.info(AppConstants.ERROR_DATA);
		}

		HashMap<String, Rating> ratings = null;
		try {
			ratings = fetchdetailsDelegate.displayRating(carBean);
		} catch (Exception e) {
			logger.info(AppConstants.ERROR_DATA);e.printStackTrace();
		}

		Rating rating = null;
		if (request.getSession().getAttribute("status") != null) {
			AddRatingDelegate addRatingDelegate = new AddRatingDelegate();
			User user = new User();
			user.setUsername(request.getSession().getAttribute("username").toString());
			try {
				if (addRatingDelegate.isRating(carBean, user)) {
					rating = fetchdetailsDelegate.getRating(carBean, user);
				}
			} catch (Exception e) {
				logger.info(AppConstants.ERROR_DATA);e.printStackTrace();
			}
		}
		request.setAttribute("carBean", carBean);
		request.setAttribute("ratings", ratings);
		if (request.getSession().getAttribute("status") != null)
			request.setAttribute("rating", rating);
		request.getRequestDispatcher("WEB-INF/pages/car.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
