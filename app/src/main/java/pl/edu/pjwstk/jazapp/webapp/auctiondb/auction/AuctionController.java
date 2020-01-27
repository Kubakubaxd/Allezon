package pl.edu.pjwstk.jazapp.webapp.auctiondb.auction;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class AuctionController {
    @Inject
    AuctionRepository auctionRepository;
    @Inject
    AuctionRequest req;

    public String create() {
        auctionRepository.create(req.getTitle(), req.getDescription(), req.getCategoryId(), req.getPrice(), req.getLink());
        return "myauctionsowner";
    }
}
