package pl.edu.pjwstk.jazapp.webapp.baskets.basket;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class BasketController {
    @Inject
    BasketRepository repo;
//        @Inject
//        AuctionRequest req;

    public void create() {
        repo.create();
        //return "myauctionsowner";
    }
}
