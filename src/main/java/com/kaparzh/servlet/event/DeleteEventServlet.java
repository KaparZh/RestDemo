package com.kaparzh.servlet.event;

import com.kaparzh.service.impl.EventServiceImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/event/delete")
public class DeleteEventServlet extends HttpServlet {

    private final EventServiceImpl eventService = EventServiceImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        eventService.delete(Integer.valueOf(req.getParameter("id")));
    }
}
