package Servlets;

import BusinessLayer.DataManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by Влад on 24.10.2016.
 */
@WebServlet("/save")
public class Save extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.process(request, response);
    }


    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setStatus(200);
        DataManager dm = new DataManager();
        String act = request.getParameter("add");
        if (act != null){
            dm.add(request);
//            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//            try {
//                rd.forward(request, response);
//            } catch (ServletException e) {
//                e.printStackTrace();
//            }
            response.sendRedirect("index.jsp");
        }
        act = request.getParameter("edit");
        if (act != null) {
            dm.update(request);
            response.sendRedirect("index.jsp");
        }
    }
}
