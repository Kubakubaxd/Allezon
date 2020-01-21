package pl.edu.pjwstk.jazapp.webapp.baskets.basket;

import pl.edu.pjwstk.jazapp.webapp.session.SessionAsk;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class BasketRepository {
    @Inject
    SessionAsk session;
    @PersistenceContext
    private EntityManager em;

//    @Transactional
//    public boolean create() {
//        //BasketEntity basket = new BasketEntity(session.getUsername(), )
//    }
}
