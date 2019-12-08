package pl.edu.pjwstk.jazapp.webapp.auth;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


@ApplicationScoped
public class UserspsqlRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public boolean createUser(UserspsqlEntity userEntity) {
        var passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(userEntity.getPassword());
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
            return passwordEncoder.matches(password, userspsqlEntity.getPassword());
        } else return false;
    }

    @Transactional
    public boolean checkIfExist(String username) {
        UserspsqlEntity userspsqlEntity = em.find(UserspsqlEntity.class, username);
        return userspsqlEntity != null;
    }

    public UserspsqlEntity giveUser(String username){
        return em.find(UserspsqlEntity.class, username);
    }
}
