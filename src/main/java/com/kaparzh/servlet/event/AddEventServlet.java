package com.kaparzh.servlet.event;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kaparzh.model.Event;
import com.kaparzh.service.impl.EventServiceImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/event/add")
public class AddEventServlet extends HttpServlet {

    private final EventServiceImpl eventService = EventServiceImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer userId = Integer.valueOf(req.getParameter("userId"));
        Integer fileId = Integer.valueOf(req.getParameter("fileId"));

        Event event = eventService.create(userId, fileId);
        String eventJson = new ObjectMapper().writeValueAsString(event);
        resp.setContentType("application/json");
        try (PrintWriter writer = resp.getWriter()) {
            writer.write(eventJson);
        }
    }
}
