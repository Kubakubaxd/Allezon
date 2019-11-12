package pl.edu.pjwstk.jazapp.webapp.auctiondb.auction_photo;

import pl.edu.pjwstk.jazapp.webapp.auctiondb.auction.AuctionModel;

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
        System.out.println("Tworze " + photoRequest.getId() + " + " + photoRequest.getLink() );
            PhotoEntity photoEntity = new PhotoEntity(photoRequest.getId(), photoRequest.getLink());
            photoRepository.createPhoto(photoEntity);
        //}
    }

    public void createPhotoTest(){
        PhotoEntity photoEntity = new PhotoEntity(6,"hehe");
        photoRepository.createPhoto(photoEntity);
    }
}
