package com.kaparzh.servlet.file;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kaparzh.model.File;
import com.kaparzh.service.impl.FileServiceImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/file/get")
public class GetFileByIdServlet extends HttpServlet {

    private final FileServiceImpl fileService = FileServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        File file = fileService.getById(Integer.valueOf(req.getParameter("id")));
        String jsonFile = new ObjectMapper().writeValueAsString(file);
        resp.setContentType("application/json");
        try (PrintWriter writer = resp.getWriter()) {
            writer.write(jsonFile);
        }
    }
}
