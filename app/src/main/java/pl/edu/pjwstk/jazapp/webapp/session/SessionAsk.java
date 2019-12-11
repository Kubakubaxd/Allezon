package pl.edu.pjwstk.jazapp.webapp.session;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class SessionAsk {
    @Inject
    private Session session;

//    private String username;
//    private String firstname;
//    private String surname;
//    private String email;
//    private String birthdate;
//    private boolean admin;

    public String getUsername() {
        return session.getUsername();
    }

    public String getFirstname() {
        return session.getFirstname();
    }

    public String getSurname() {
        return session.getSurname();
    }

    public String getEmail() {
        return session.getEmail();
    }

    public String getBirthdate() {
        return session.getDate();
    }

    public boolean isAdmin() {
        return session.isAdmin();
    }
}
