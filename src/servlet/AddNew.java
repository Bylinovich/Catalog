package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Влад on 23.10.2016.
 */
@WebServlet("/addNew")
public class AddNew extends BaseHttpServlet {

    private void setAttributes(HttpServletRequest request)
    {
        request.setAttribute("value", "ADD");
        request.setAttribute("buttonName", "add");
    }

    protected void process(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(200);
        setAttributes(request);
        RequestDispatcher rd = request.getRequestDispatcher("record.jsp");
        try {
            rd.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }
}
