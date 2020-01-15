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
        auctionRepository.create(req.getTitle(), req.getDescription(), req.getSectionId(), req.getPrice(), req.getLink());
        return "myauctionsowner";
    }

    public String edit() {
        auctionRepository.edit(req.getId(), req.getTitle(), req.getDescription(), req.getSectionId(), req.getPrice());
        return "myauctionsowner";
    }

    public String editTitle() {
        auctionRepository.editTitle(req.getId(), req.getTitle());
        return "myauctionsowner";
    }

    public String editDescription() {
        auctionRepository.editDescription(req.getId(), req.getDescription());
        return "myauctionsowner";
    }

    public String editSection() {
        auctionRepository.editSection(req.getId(), req.getSectionId());
        return "myauctionsowner";
    }

    public String editPrice() {
        auctionRepository.editPrice(req.getId(), req.getPrice());
        return "myauctionsowner";
    }
}
