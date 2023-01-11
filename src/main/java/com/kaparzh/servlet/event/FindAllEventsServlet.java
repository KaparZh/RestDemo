package com.kaparzh.servlet.event;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kaparzh.model.Event;
import com.kaparzh.service.impl.EventServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/event/list")
public class FindAllEventsServlet extends HttpServlet {

    private final EventServiceImpl eventService = EventServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Event> events = eventService.getAll();
        resp.setContentType("application/json");
        try (PrintWriter writer = resp.getWriter()) {
            String eventsJson = new ObjectMapper().writeValueAsString(events);
            writer.write(eventsJson);
        }
    }
}
