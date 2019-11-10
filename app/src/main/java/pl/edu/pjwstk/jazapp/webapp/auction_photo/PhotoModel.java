package pl.edu.pjwstk.jazapp.webapp.auction_photo;

import pl.edu.pjwstk.jazapp.webapp.auction.AuctionModel;
import pl.edu.pjwstk.jazapp.webapp.auction.AuctionRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class PhotoModel {
    @Inject
    PhotoRequest photoRequest;
    @Inject
    PhotoRepository photoRepository;
    @Inject
    AuctionModel auctionModel;

    public void createPhoto(){
        //if(auctionModel.isAuctionExist(photoRequest.getId())) {
            PhotoEntity photoEntity = new PhotoEntity(photoRequest.getId(), photoRequest.getLink());
            photoRepository.createPhoto(photoEntity);
        //}
    }

    public void createPhotoTest(){
        PhotoEntity photoEntity = new PhotoEntity(9,"hehe");
        photoRepository.createPhoto(photoEntity);
    }
}
