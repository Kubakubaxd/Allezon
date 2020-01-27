package pl.edu.pjwstk.jazapp.webapp.login;

import pl.edu.pjwstk.jazapp.webapp.session.Session;

import javax.inject.Inject;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("*")
public class LoginFilter extends HttpFilter {
    @Inject
    private Session session;

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (session.isLogged() ||
                req.getRequestURI().contains("login.xhtml") ||
                req.getRequestURI().contains("javax.faces.webapp.FacesServlet") ||
                req.getRequestURI().contains("/javax.faces.resource/main.css.xhtml") ||
                req.getRequestURI().contains("/javax.faces.resource/bootstrap.min.css.xhtml") ||
                req.getRequestURI().contains("/javax.faces.resource/login.xhtml") ||
                req.getRequestURI().contains("/register.xhtml") ||
                req.getRequestURI().contains("/api")) {
            System.out.println("REQUESTED URI:" + req.getRequestURI());
            chain.doFilter(req, res);
        } else {
            System.out.println("REQUESTED URI:" + req.getRequestURI());
            res.sendRedirect("login.xhtml");
        }
    }
}






