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

@WebServlet("/file/update")
public class UpdateFileServlet extends HttpServlet {

    private final FileServiceImpl fileService = FileServiceImpl.getInstance();

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        File file = fileService.update(
                Integer.valueOf(req.getParameter("id")),
                req.getParameter("name"),
                req.getParameter("filepath")
        );
        String jsonFile = new ObjectMapper().writeValueAsString(file);
        resp.setContentType("application/json");
        try (PrintWriter writer = resp.getWriter()) {
            writer.write(jsonFile);
        }
    }
}
