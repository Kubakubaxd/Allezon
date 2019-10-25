package pl.edu.pjwstk.jazapp.webapp.old;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setStatus(200);
        PrintWriter writer = resp.getWriter();
        if (req.getParameter("average") == null) {
            writer.println("Nic nie podano");
        } else {
            String username =  req.getParameter("average");
            writer.println("Srednia wynosi: " + username);
        }
    }
}
