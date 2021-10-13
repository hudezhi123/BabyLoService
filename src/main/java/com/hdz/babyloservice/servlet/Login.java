package com.hdz.babyloservice.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hdz.babyloservice.service.LoginService;
import com.hdz.babyloservice.util.Constants;
import com.hdz.babyloservice.util.JsonUtils;
import com.hdz.babyloservice.util.StringUtils;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
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
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
        throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
        throws ServletException, IOException {
        // TODO Auto-generated method stub
        String result = "";
        final String appName = request.getParameter(Constants.APP_NAME);
        final String type = request.getParameter(Constants.APP_TYPE);
        final String appId = request.getParameter(Constants.APP_APPID);
        final String userName = request.getParameter(Constants.USER_NAME);
        final String password = request.getParameter(Constants.PASSWORD);
        final int appType = StringUtils.IsEmpty(type) ? 0 : Integer.parseInt(type);
        try {
            result = LoginService.doAction(appName, appType, appId, userName, password);
        } catch (final SQLException e) {
            result = JsonUtils.createBaseJson(Constants.CODE_FAIL, null, Constants.TIPS_LOGIN_FAIL);
        }
        request.setAttribute("json", result);
        request.getRequestDispatcher("/page/Login.jsp").forward(request, response);
    }

}
