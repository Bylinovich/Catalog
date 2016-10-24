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

/**
 * Created by Влад on 24.10.2016.
 */
@WebServlet("/edit")
public class Edit extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.process(request, response);
    }

    private void setAttributes(HttpServletRequest request, Car car)
    {
        request.setAttribute("color", car.getColor());
        request.setAttribute("year", car.getYear());
        request.setAttribute("carModel", car.getCarModel());
        request.setAttribute("carMark", car.getCarMark());
        request.setAttribute("value", "Edit");
        request.setAttribute("buttonName", "edit");
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setStatus(200);
        DataManager dm = new DataManager();
        Car car = dm.getRecord(request.getParameter("id"));
        setAttributes(request, car);
        request.getServletContext().setAttribute("editId", car.getId());
        RequestDispatcher rd = request.getRequestDispatcher("record.jsp");
        try {
            rd.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
