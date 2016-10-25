package servlet;

import controller.DataManager;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Влад on 24.10.2016.
 */
@WebServlet("/save")
public class Save extends BaseHttpServlet {

    protected void process(HttpServletRequest request, HttpServletResponse response){
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
        }
        act = request.getParameter("edit");
        if (act != null) {
            dm.update(request);
        }
        try {
            response.sendRedirect("index.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
