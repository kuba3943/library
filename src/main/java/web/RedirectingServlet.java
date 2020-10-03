package web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/red")
public class RedirectingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getParameter("details")!=null){
            req.getRequestDispatcher("/detailsServlet").forward(req,resp);
        } else {
            req.getRequestDispatcher("/deleteServlet").forward(req,resp);
        }
    }
}
