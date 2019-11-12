package pl.edu.pjwstk.jazapp.webapp.auctiondb.auction;

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

    public void create(){
            auctionRepository.create(auctionRequest.getAuctionEntity());
    }

//    public boolean edit(){
//        if(auctionRepository.isExist(auctionRequest.getId())){
//
//        }
//    }

}
