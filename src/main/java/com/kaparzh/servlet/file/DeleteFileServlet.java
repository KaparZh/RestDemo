package com.kaparzh.servlet.file;

import com.kaparzh.service.impl.FileServiceImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/file/delete")
public class DeleteFileServlet extends HttpServlet {

    private final FileServiceImpl fileService = FileServiceImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        fileService.delete(Integer.valueOf(req.getParameter("id")));
    }
}
