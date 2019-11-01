package pl.edu.pjwstk.jazapp.webapp.register;

import pl.edu.pjwstk.jazapp.webapp.DB.User;
import pl.edu.pjwstk.jazapp.webapp.DB.UserDB;
import pl.edu.pjwstk.jazapp.webapp.auth.UserspsqlEntity;
import pl.edu.pjwstk.jazapp.webapp.auth.UserspsqlRepository;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class Register implements Serializable {
    @Inject
    private UserDB userDB;
    @Inject
    private UserspsqlRepository userspsqlRepository;

    private String firstname;
    private String surname;
    private String username;
    private String password;
    private String repassword;
    private String email;
    private String date;
    private boolean repasswordWrong;
    private boolean usernameWrong;

    private boolean register() {
        if(!checkRePassword(password, repassword)){
            repasswordWrong = true;
            return false;
        }

        if (!userspsqlRepository.checkIfExist(username)){
            System.out.println("Zakładam konto lokalne");
            UserspsqlEntity newUser = new UserspsqlEntity(getUsername(),getPassword(),getFirstname(),getSurname(),getEmail(),getDate());
            userspsqlRepository.createUser(newUser);
            repasswordWrong = false;
            usernameWrong = false;
            return true;
        }
        else if(!userDB.checkIfUserExist(username) ) {
            System.out.println("Zakładam konto w bazie");
            User newUser = new User(getUsername(), getPassword(), getFirstname(), getSurname(), getDate(), getEmail());
            userDB.addUser(newUser);
            repasswordWrong = false;
            usernameWrong = false;
            return true;
        }
        else{
            System.out.println("Upsi taki użytkownik jest już");
            usernameWrong = true;
            return false;
        }
    }

    public String redirect() {
        if (register()) return "login.xhtml";
        else return "register.xhtml";
    }

    private boolean checkRePassword (String password, String rePassword){
        return password.equals(rePassword);
    }
    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }
    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public String getRepassword() {return repassword; }
    public void setRepassword(String repassword) {this.repassword = repassword; }
    public boolean getRepasswordWrong(){
        return repasswordWrong;
    }
    public boolean getUsernameWrong(){
        return usernameWrong;
    }
    public void setRepasswordWrong(boolean repasswordWrong){
        this.repasswordWrong = repasswordWrong;
    }
}