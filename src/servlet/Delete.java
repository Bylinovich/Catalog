package servlet;

import controller.DataManager;
import models.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Влад on 24.10.2016.
 */
@WebServlet("/delete")
public class Delete extends BaseHttpServlet {
    protected void process(HttpServletRequest request, HttpServletResponse response) {
        User us = (User) request.getSession().getAttribute("user");
        if (us.getPrivilegeLevel()>0)
        {
            try {
                response.sendError(404);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
        response.setStatus(200);
        DataManager dm = new DataManager();
        String id = request.getParameter("id");
        dm.delete(id);
        try {
            response.sendRedirect("index.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}