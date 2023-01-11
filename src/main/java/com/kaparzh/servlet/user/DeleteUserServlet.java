package com.kaparzh.servlet.user;

import com.kaparzh.service.impl.UserServiceImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/user/delete")
public class DeleteUserServlet extends HttpServlet {

    private final UserServiceImpl userService = UserServiceImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        userService.delete(Integer.valueOf(req.getParameter("id")));
    }
}
