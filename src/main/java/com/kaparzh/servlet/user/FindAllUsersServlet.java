package com.kaparzh.servlet.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kaparzh.model.User;
import com.kaparzh.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/user/list")
public class FindAllUsersServlet extends HttpServlet {

    private final UserServiceImpl userService = UserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = userService.getAll();
        String usersJson = new ObjectMapper().writeValueAsString(users);
        resp.setContentType("application/json");
        try (PrintWriter writer = resp.getWriter()) {
            writer.write(usersJson);
        }
    }
}
