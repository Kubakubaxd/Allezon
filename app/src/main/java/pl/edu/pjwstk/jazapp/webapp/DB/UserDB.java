package pl.edu.pjwstk.jazapp.webapp.DB;

import java.util.ArrayList;
import java.util.List;

public class UserDB {
    private List<User> database = new ArrayList<User>();

    public void addUser(User user) {
        database.add(user);
    }

    public String getPassword(int index) {
        return database.get(index).getPassword();
    }

    public String getUsername(int index) {
        return database.get(index).getUsername();
    }

    public int getSize() {
        return database.size();
    }

    public boolean checkUserPassword(String username, String password) {
        for (User x : database) {
            // FIXME powinno być equals
            if (x.getUsername().compareTo(username) == 0) {
                // FIXME zagniezdzenie nie potrzebne
                if (x.getPassword().compareTo(password) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public User returnUser(String username) {
        for (User user : database)
            if (user.getUsername().compareTo(username) == 0)
                return user;
        // FIXME to jest zla praktyka, warto sprawdzic czy uzytkownik istnieje! (nie wplywa na ocene)
        User userError = new User("error","error","error","error","err", "err");
        return userError;
    }
}


