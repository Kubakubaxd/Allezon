package pl.edu.pjwstk.jazapp.webapp.baskets.basket;

import pl.edu.pjwstk.jazapp.webapp.session.SessionAsk;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ApplicationScoped
public class BasketRepository {
    @Inject
    SessionAsk session;
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void create() {
        BasketEntity basket = new BasketEntity(session.getUsername(), getCurrentDate());
        em.persist(basket);
    }

    private String getCurrentDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        return dtf.format(now);
    }
}
