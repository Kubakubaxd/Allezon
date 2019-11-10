package pl.edu.pjwstk.jazapp.webapp.auction;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class AuctionModel {
    @Inject
    AuctionRepository auctionRepository;
    @Inject
    AuctionRequest auctionRequest;

    public boolean isAuctionExist(int id){
        return auctionRepository.isAuctionExist(id);
    }

}
