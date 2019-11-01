package pl.edu.pjwstk.jazapp.webapp.login;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class LoginController {
    @Inject
    private LoginModel loginModel;

    public String login() {
        if (loginModel.login())
            return "index.xhtml";
        else
            return "login";
    }

    public String logout() {
        if (loginModel.logout()) return "login";
        else return "index.xhtml";
    }
}


