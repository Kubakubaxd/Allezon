package pl.edu.pjwstk.jazapp.webapp.login;

import pl.edu.pjwstk.jazapp.webapp.auth.UserspsqlEntity;
import pl.edu.pjwstk.jazapp.webapp.auth.UserspsqlRepository;
import pl.edu.pjwstk.jazapp.webapp.localuser.User;
import pl.edu.pjwstk.jazapp.webapp.localuser.UserDB;
import pl.edu.pjwstk.jazapp.webapp.session.Session;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class LoginModel {
    @Inject
    private Session session;
    @Inject
    private UserDB userDB;
    @Inject
    private UserspsqlRepository userspsqlRepository;

    private boolean loginWrong = false;
    public boolean getLoginWrong() {
        return loginWrong;
    }

    public boolean logout() {
        session.setLogged(false);
        return true;
    }

    public boolean login(String username, String password) {
        if (userspsqlRepository.checkUsernameAndPassword(username, password)) {
            UserspsqlEntity user = userspsqlRepository.giveUser(username);
            String email = user.getEmail();
            String firstname = user.getFirstname();
            String surname = user.getSurname();
            String date = user.getBirthdate();
            boolean admin = user.isAdmin();

            session.setLogged(true);
            session.setUsername(username);
            session.setEmail(email);
            session.setFirstname(firstname);
            session.setSurname(surname);
            session.setDate(date);
            session.setAdmin(admin);
            return true;
        } else if (userDB.checkUserPassword(username, password)) {
            User user = userDB.returnUser(username);
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

            loginWrong = false;
            return true;
        } else {
            loginWrong = true;
            return false;
        }
    }

    boolean isAdmin(String username) {
        return userspsqlRepository.giveUser(username).isAdmin();
    }
}

