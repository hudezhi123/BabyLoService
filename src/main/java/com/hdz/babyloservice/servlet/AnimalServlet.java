package com.hdz.babyloservice.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hdz.babyloservice.service.AnimalService;
import com.hdz.babyloservice.util.Constants;
import com.hdz.babyloservice.util.JsonUtils;

@WebServlet(Constants.ANIMAL_LIST)
public class AnimalServlet extends HttpServlet {
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
        throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp)
        throws ServletException, IOException {
        System.out.println("Animal");
        String json;
        try {
            json = AnimalService.doAction();
        } catch (final SQLException e) {
            json = JsonUtils.createBaseJson(Constants.CODE_FAIL, null, Constants.TIPS_ANIMAL);
        }
        req.setAttribute("json", json);
        req.getRequestDispatcher("/page/Animal.jsp").forward(req, resp);
    }
}
