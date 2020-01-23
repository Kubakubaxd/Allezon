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

    public void create(int auction_id) {
        repo.create(session.getUsername(), auction_id, 1);
    }
}
