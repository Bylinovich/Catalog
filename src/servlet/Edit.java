package servlet;

import controller.DataManager;
import models.Car;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Влад on 24.10.2016.
 */
@WebServlet("/edit")
public class Edit extends BaseHttpServlet {

    private void setAttributes(HttpServletRequest request, Car car)
    {
        request.setAttribute("color", car.getColor());
        request.setAttribute("year", car.getYear());
        request.setAttribute("carModel", car.getCarModel());
        request.setAttribute("carMark", car.getCarMark());
        request.setAttribute("value", "Edit");
        request.setAttribute("buttonName", "edit");
    }

    protected void process(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(200);
        DataManager dm = new DataManager();
        Car car = dm.getRecord(request.getParameter("id"));
        setAttributes(request, car);
        request.getServletContext().setAttribute("editId", car.getId());
        RequestDispatcher rd = request.getRequestDispatcher("record.jsp");
        try {
            rd.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
