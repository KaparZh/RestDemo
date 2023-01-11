package com.kaparzh.servlet.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kaparzh.model.User;
import com.kaparzh.service.impl.UserServiceImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user/add")
public class AddUserServlet extends HttpServlet {

    private final UserServiceImpl userService = UserServiceImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = userService.create(req.getParameter("name"));
        String userJson = new ObjectMapper().writeValueAsString(user);
        resp.setContentType("application/json");
        try (PrintWriter writer = resp.getWriter()) {
            writer.write(userJson);
        }
    }
}
