package pl.edu.pjwstk.jazapp.webapp.login;

import pl.edu.pjwstk.jazapp.webapp.DB.User;
import pl.edu.pjwstk.jazapp.webapp.register.Register;
import pl.edu.pjwstk.jazapp.webapp.session.Session;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class LoginController {
    @Inject
    private LoginRequest loginRequest;
    @Inject
    private Session session;

    public String getUsername() {
        return session.getUsername();
    }

    public String getEmail(){
        return session.getEmail();
    }

    public String getFirstname(){
        return session.getFirstname();
    }

    public String getSurname(){
        return session.getSurname();
    }

    public String getDate(){
        return session.getDate();
    }

    public String logout() {
        session.setLogged(false);
        return "login.xhtml";
    }

    public String login() {
        User userTest = new User("test", "test");
        Register.userDB.addUser(userTest);

        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        if (Register.userDB.checkUserPassword(username, password)) {
            //System.out.println("Tried to log in using " + loginRequest.getUsername());
            User user = Register.userDB.returnUser(username);
            String email = user.getEmail();
            String firstname = user.getFirstname();
            String surname = user.getSurname();
            String date = user.getDate();

            session.setLogged(true);
            session.setUsername(username);
            session.setEmail(email);
            session.setFirstname(firstname);
            session.setSurname(surname);
            session.setDate(date);

            return "index.xhtml";
        } else {
            System.out.println("Nie udało się " + loginRequest.getUsername());
            return "login";
        }
    }
}

