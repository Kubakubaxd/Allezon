package pl.edu.pjwstk.jazapp.webapp.auth;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.edu.pjwstk.jazapp.webapp.DB.User;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


@ApplicationScoped
public class UserspsqlRepository {
    @PersistenceContext
    private EntityManager em;

   @Transactional
    public boolean createUser(String username, String password, String firstname, String surname, String email, String birthdate) {
        if (!checkIfExist(username)) {
            var user = new UserspsqlEntity(username, password, firstname, surname, email, birthdate);
            em.persist(user);
            return true;
        }
        else return false;
    }

    public boolean createUser(User user) {
        if (!checkIfExist(user.getUsername())) {
            var userEntity = new UserspsqlEntity(user.getUsername(), user.getPassword(),user.getFirstname(),user.getSurname(), user.getEmail(), user.getDate());
            em.persist(userEntity);
            return true;
        }
        else return false;
    }

    @Transactional
    public boolean createUser(UserspsqlEntity userEntity) {
        var passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(userEntity.getPassword());
        //System.out.println("Hashed password: " + hashedPassword);
        //System.out.println("Compare: " + passwordEncoder.matches(userEntity.getPassword(), hashedPassword));
        userEntity.setPassword(hashedPassword);
        if (!checkIfExist(userEntity.getUsername())) {
            em.persist(userEntity);
            return true;
        }
        else return false;
    }

    @Transactional
    public boolean checkUsernameAndPassword(String username, String password) {
        var passwordEncoder = new BCryptPasswordEncoder();
        if (checkIfExist(username)) {
            UserspsqlEntity userspsqlEntity = em.find(UserspsqlEntity.class, username);
            //if (password.equals(userspsqlEntity.getPassword()))
            if(passwordEncoder.matches(password,userspsqlEntity.getPassword()))
                return true;
            else return false;
        } else return false;
    }

    @Transactional
    public boolean checkIfExist(String username) {
        UserspsqlEntity userspsqlEntity = em.find(UserspsqlEntity.class, username);
        if (userspsqlEntity == null) return false;
        else return true;
    }

    public UserspsqlEntity giveUser(String username){
        return em.find(UserspsqlEntity.class, username);
    }
}
