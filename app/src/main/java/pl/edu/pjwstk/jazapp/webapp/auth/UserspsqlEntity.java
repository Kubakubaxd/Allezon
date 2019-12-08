package pl.edu.pjwstk.jazapp.webapp.auth;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userspsqla")

public class UserspsqlEntity {
    @Id
    private String username;
    private String password;
    private String firstname;
    private String surname;
    private String email;
    private String birthdate;
    private boolean admin;

    public UserspsqlEntity(String username, String password, String firstname, String surname, String email, String birthdate, boolean admin) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.birthdate = birthdate;
        this.admin = admin;
    }


    public UserspsqlEntity() {
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
