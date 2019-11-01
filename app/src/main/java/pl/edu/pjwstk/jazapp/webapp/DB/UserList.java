package pl.edu.pjwstk.jazapp.webapp.DB;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    private List<User> userList = new ArrayList<User>();
    public void addUser(User user) {
        userList.add(user);
    }
    public String getPassword(int index) {
        return userList.get(index).getPassword();
    }
    public String getUsername(int index) {
        return userList.get(index).getUsername();
    }
    public int getSize() {
        return userList.size();
    }

    public boolean checkUserPassword(String username, String password) {
        for (User x : userList) {
            if (x.getUsername().equals(username) && (x.getPassword().equals(password))) {
                return true;
            }
        }
        return false;
    }

    public User returnUser(String username) {
        for (User user : userList)
            if (user.getUsername().equals(username))
                return user;
            return null;
    }

    public boolean checkIfUserExist(String username){
        for (User user : userList)
            if (user.getUsername().equals(username))
                return true;
        return false;
    }
}


