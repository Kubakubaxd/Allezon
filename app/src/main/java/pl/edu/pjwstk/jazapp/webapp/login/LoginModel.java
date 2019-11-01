package pl.edu.pjwstk.jazapp.webapp.login;

import pl.edu.pjwstk.jazapp.webapp.DB.User;
import pl.edu.pjwstk.jazapp.webapp.DB.UserDB;
import pl.edu.pjwstk.jazapp.webapp.auth.UserspsqlEntity;
import pl.edu.pjwstk.jazapp.webapp.auth.UserspsqlRepository;
import pl.edu.pjwstk.jazapp.webapp.session.Session;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class LoginModel {
    @Inject
    private LoginRequest loginRequest;
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

    public boolean login() {
        //Test login
//        User userTest = new User("test", "test");
//        userDB.addUser(userTest);

        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        //userspsqlRepository.createUser("test1","test","test","test","test","test");
        System.out.println("BAZA DANYCH MÓWI: " + userspsqlRepository.checkUsernameAndPassword(username, password));

        if (userspsqlRepository.checkUsernameAndPassword(username, password)) {
            UserspsqlEntity user = userspsqlRepository.giveUser(username);
            String email = user.getEmail();
            String firstname = user.getFirstname();
            String surname = user.getSurname();
            String date = user.getBirthdate();

            session.setLogged(true);
            session.setUsername(username);
            session.setEmail(email);
            session.setFirstname(firstname);
            session.setSurname(surname);
            session.setDate(date);
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
}

