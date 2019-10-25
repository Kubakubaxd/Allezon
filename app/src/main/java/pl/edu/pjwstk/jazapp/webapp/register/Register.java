package pl.edu.pjwstk.jazapp.webapp.register;

import pl.edu.pjwstk.jazapp.webapp.DB.User;
import pl.edu.pjwstk.jazapp.webapp.DB.UserDB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean

@SessionScoped
public class Register implements Serializable {

    public static UserDB userDB = new UserDB();
    private String firstname;
    private String surname;
    private String username;
    private String password;
    private String email;
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private boolean register() {
        User newUser = new User(getUsername(), getPassword(), getFirstname(), getSurname(), getDate(), getEmail());
        userDB.addUser(newUser);
        return true;
    }

    public String redirect() {
        if (register()) return "login.xhtml";
        else return "register.xhtml";
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}