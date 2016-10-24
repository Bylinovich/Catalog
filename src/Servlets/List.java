package Servlets;

import BusinessLayer.DataManager;
import Model.Car;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Влад on 21.10.2016.
 */

@WebServlet("/list")
public class List extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.process(request, response);
    }

    private void setAttributes(HttpServletRequest request, ArrayList listResult)
    {
        request.setAttribute("listResult", listResult);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setStatus(200);

        response.setContentType("text/plain");

        DataManager dm = new DataManager();
        ArrayList listResult=dm.getList();
        setAttributes(request, listResult);
        try {
            RequestDispatcher rd = request.getRequestDispatcher("table.jsp");
            rd.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }

    }
}

