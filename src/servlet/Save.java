package servlet;

import controller.DataManager;
import models.Car;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Влад on 24.10.2016.
 */
@WebServlet("/save")
public class Save extends BaseHttpServlet {

    private Car getCar(HttpServletRequest request){
        Car car = new Car();
        car.setCarMark(request.getParameter("carMark"));
        car.setCarModel(request.getParameter("carModel"));
        car.setYear(Integer.parseInt(request.getParameter("year")));
        car.setColor(request.getParameter("color"));
        return car;
    }

    private Car getCar(HttpServletRequest request, int id){
        Car car = getCar(request);
        car.setId(id);
        return car;
    }

    protected void process(HttpServletRequest request, HttpServletResponse response){
        response.setStatus(200);
        DataManager dm = new DataManager();
        String act = request.getParameter("add");
        if (act != null){
            Car car = getCar(request);
            dm.add(car);
//            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//            try {
//                rd.forward(request, response);
//            } catch (ServletException e) {
//                e.printStackTrace();
//            }
        }
        act = request.getParameter("edit");
        if (act != null) {
            int id = (int) request.getServletContext().getAttribute("editId");
            Car car = getCar(request, id);
            dm.update(car);
        }

        try {
            response.sendRedirect("index.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
