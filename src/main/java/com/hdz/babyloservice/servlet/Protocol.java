package com.hdz.babyloservice.servlet;

import com.hdz.babyloservice.service.ProtocolService;
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
 * Servlet implementation class Protocol
 */
@WebServlet("/Protocol")
public class Protocol extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Protocol() {
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
		String typeStr = request.getParameter("type");
		String result = "";
		if (!StringUtils.IsEmpty(typeStr)) {
			try {
				result = ProtocolService.doAction(Integer.parseInt(typeStr));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				result = JsonUtils.createBaseJson(0, null, Constants.TIPS_PROTOCOL_FAIL);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				result = JsonUtils.createBaseJson(0, null, Constants.TIPS_PROTOCOL_FAIL);
			}
		}
		request.setAttribute("json", result);
		request.getRequestDispatcher("/page/Protocol.jsp").forward(request, response);

	}

}
