package pl.edu.pjwstk.jazapp.webapp.auctiondb.auctiontest;

import pl.edu.pjwstk.jazapp.webapp.auctiondb.auctiontest.AuctionRequestTest;
import pl.edu.pjwstk.jazapp.webapp.auctiondb.auctiontest.AuctionRepositoryTest;
import pl.edu.pjwstk.jazapp.webapp.auctiondb.auctiontest.AuctionRepositoryTest;


import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class AuctionModelTest {
    @Inject
    AuctionRepositoryTest auctionRepositoryTest;
    @Inject
    AuctionRequestTest auctionRequest;

    public void create(){
        auctionRepositoryTest.create(auctionRequest.getDescription(), auctionRequest.getSectionId(),auctionRequest.getPrice());
    }

//    public String getDescription(){
//        AuctionRepositoryTest repository = new em
//    }

//    public void edit() {auctionRepository.edit(auctionRequest.getAuctionEntity(), auctionRequest.getId());}
//
//    public void editDescription() {auctionRepository.editDescription(auctionRequest.getId(), auctionRequest.getDescription());}
//
//    public void editSection() {auctionRepository.editSection(auctionRequest.getId(), auctionRequest.getSectionId());}
//
//    public void editPrice() {auctionRepository.editPrice(auctionRequest.getId(),auctionRequest.getPrice());}
}
