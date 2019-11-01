package pl.edu.pjwstk.jazapp.webapp.login;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.servlet.http.HttpServlet;
import java.io.Serializable;

@Named
@RequestScoped

public class LoginRequest extends HttpServlet implements Serializable {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}






















/*
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginRequest")

public class LoginRequest extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setStatus(200);
        var writer = resp.getWriter();

        String userusername = req.getParameter("userusername");
        String password = req.getParameter("login");


        if (userusername != null && password != null ) {
            try {


                writer.println(userusername + password);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }


    }

}
*/