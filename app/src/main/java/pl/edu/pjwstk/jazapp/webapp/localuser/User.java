package pl.edu.pjwstk.jazapp.webapp.localuser;

public class User {
    private String username;
    private String password;
    private String firstname;
    private String surname;
    private String date;
    private String email;

    public User(String username, String password, String firstname, String surname, String date, String email) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.surname = surname;
        this.date = date;
        this.email = email;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.firstname = "";
        this.surname = "";
        this.date = "";
        this.email = "";
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
