package pl.edu.pjwstk.jazapp.webapp.baskets.basket;

import pl.edu.pjwstk.jazapp.webapp.baskets.basketbucket.BasketBucketValue;
import pl.edu.pjwstk.jazapp.webapp.session.SessionAsk;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class BasketController {
    @Inject
    BasketRepository repo;
    @Inject
    SessionAsk session;

    public void create() {
        repo.create();
    }

    public BasketEntity find(String owner) {
        return repo.find(owner);
    }

    public List<BasketBucketValue> getBasketBucketsBySessionOwner() {
        return repo.getBasketBuckets(session.getUsername());
    }
}
