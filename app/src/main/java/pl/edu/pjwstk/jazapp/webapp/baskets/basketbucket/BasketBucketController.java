package pl.edu.pjwstk.jazapp.webapp.baskets.basketbucket;

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

    void create() {
        repo.create(req.getBasket_id(), req.getAuction_id(), req.getQuantity());
    }

    void createTest() {
        repo.create(req.getBasket_id(), req.getAuction_id(), req.getQuantity());
    }


}
