package servlet;

import controller.DataManager;
import models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Влад on 21.10.2016.
 */

@WebServlet("/list")
public class List extends BaseHttpServlet {

    private void setAttributes(HttpServletRequest request, ArrayList listResult)
    {
        request.setAttribute("listResult", listResult);
    }

    protected void process(HttpServletRequest request, HttpServletResponse response){
        response.setStatus(200);
        User user = (User) request.getSession().getAttribute("user");
        if (user == null)
        {
            user = new User();
            user.setPrivilegeLevel(4);
            user.setLogin("Guest");
            request.getSession().setAttribute("user", user);
        }
        response.setContentType("text/plain");

        DataManager dm = new DataManager();
        ArrayList listResult=dm.getList();
        setAttributes(request, listResult);
        try {
            RequestDispatcher rd = request.getRequestDispatcher("table.jsp");
            rd.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }
}

