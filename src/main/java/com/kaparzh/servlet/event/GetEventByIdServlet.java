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

@WebServlet("/event/get")
public class GetEventByIdServlet extends HttpServlet {

    private final EventServiceImpl eventService = EventServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Event event = eventService.getById(Integer.valueOf(req.getParameter("id")));
        resp.setContentType("application/json");
        try (PrintWriter writer = resp.getWriter()) {
            String eventJson = new ObjectMapper().writeValueAsString(event);
            writer.write(eventJson);
        }
    }
}
