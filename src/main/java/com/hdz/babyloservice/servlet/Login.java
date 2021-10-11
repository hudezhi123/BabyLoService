package com.hdz.babyloservice.servlet;

import com.hdz.babyloservice.service.LoginService;
import com.hdz.babyloservice.util.Constants;
import com.hdz.babyloservice.util.JsonUtils;
import com.hdz.babyloservice.util.StringUtils;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String result = "";
		String appName = request.getParameter(Constants.APP_NAME);
		String type = request.getParameter(Constants.APP_TYPE);
		String appId = request.getParameter(Constants.APP_APPID);
		String userName = request.getParameter(Constants.USER_NAME);
		String password = request.getParameter(Constants.PASSWORD);
		int appType = StringUtils.IsEmpty(type) ? 0 : Integer.parseInt(type);
		try {
			result = LoginService.doAction(appName, appType, appId, userName, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			result = JsonUtils.createBaseJson(0, null, Constants.TIPS_LOGIN_FAIL);
		}
		request.setAttribute("json", result); //
		request.getRequestDispatcher("/page/Login.jsp").forward(request, response);

	}

}
