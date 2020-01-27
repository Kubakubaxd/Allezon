package pl.edu.pjwstk.jazapp.webapp.baskets.basket;

import pl.edu.pjwstk.jazapp.webapp.baskets.basketbucket.BasketBucketValue;
import pl.edu.pjwstk.jazapp.webapp.session.SessionAsk;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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

    //TODO: updateCurrentDate()
    //TODO: Kiedy tworzę koszyk?

    public BasketEntity find(String owner) {
        var basketEntity = em.find(BasketEntity.class, owner);
        if (basketEntity == null) return new BasketEntity();
        return basketEntity;
    }

    public List<BasketBucketValue> getBasketBuckets(String owner) {
        BasketEntity basketEntity = find(owner);
        return basketEntity.getBasketBucketEntities();
    }
}

