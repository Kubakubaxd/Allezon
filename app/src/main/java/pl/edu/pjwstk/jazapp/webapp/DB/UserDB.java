package pl.edu.pjwstk.jazapp.webapp.DB;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class UserDB {
     static public UserList userList = new UserList();

    public void addUser(User user) {
        userList.addUser(user);
    }

    public User returnUser(String user) {
        return userList.returnUser(user);
    }

    public boolean checkIfUserExist(String user){
        return userList.checkIfUserExist(user);
    }

    public boolean checkUserPassword(String username, String password) {
        return userList.checkUserPassword(username, password);
    }
}
