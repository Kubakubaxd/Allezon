package pl.edu.pjwstk.jazapp.webapp.baskets.basketbucket;

import pl.edu.pjwstk.jazapp.webapp.session.SessionAsk;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class BasketBucketController {
    @Inject
    BasketBucketRepository repo;
    @Inject
    BasketBucketRequest req;
    @Inject
    SessionAsk session;

    public void add(int auction_id) {
        repo.add(session.getUsername(), auction_id, 1);
    }

    public void quantityPlus(BasketBucketId basketBucketId) {
        repo.quantityPlus(basketBucketId);
    }

    public void quantityMinus(BasketBucketId basketBucketId) {
        repo.quantityMinus(basketBucketId);
    }


    public void remove(BasketBucketId basketBucketId) {
        repo.remove(basketBucketId);
    }
}
