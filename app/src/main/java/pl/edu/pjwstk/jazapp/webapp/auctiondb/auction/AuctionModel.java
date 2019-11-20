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

    public void create() {
        auctionRepository.create(auctionRequest.getDescription(), auctionRequest.getSectionId(), auctionRequest.getPrice());
    }

    public void edit() {
        auctionRepository.edit(auctionRequest.getId(), auctionRequest.getDescription(), auctionRequest.getSectionId(), auctionRequest.getPrice());
    }

//    public void editDescription() {auctionRepository.editDescription(auctionRequest.getId(), auctionRequest.getDescription());}
//
//    public void editSection() {auctionRepository.editSection(auctionRequest.getId(), auctionRequest.getSectionId());}
//
//    public void editPrice() {auctionRepository.editPrice(auctionRequest.getId(),auctionRequest.getPrice());}
}
