package pl.edu.pjwstk.jazapp.webapp.auctiondb.auction;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
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

    public void edit() {auctionRepository.edit(auctionRequest.getAuctionEntity(), auctionRequest.getId());}

    public void editDescription() {auctionRepository.editDescription(auctionRequest.getId(), auctionRequest.getDescription());}

    public void editSection() {auctionRepository.editSection(auctionRequest.getId(), auctionRequest.getSectionId());}

    public void editPrice() {auctionRepository.editPrice(auctionRequest.getId(),auctionRequest.getPrice());}
}
