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

    public void create() {
        repo.create(req.getBasket_id(), req.getAuction_id(), req.getQuantity());
    }

    public void createWithOnwer(int auction_id) {
        repo.createWithOwner(session.getUsername(), auction_id);
    }
}
