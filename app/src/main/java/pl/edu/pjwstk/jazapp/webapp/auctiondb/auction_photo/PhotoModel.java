package pl.edu.pjwstk.jazapp.webapp.auctiondb.auction_photo;

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

    public String create() {
        photoRepository.create(photoRequest.getId(), photoRequest.getLink());
        return "myauctionsowner";
    }

    //public void editAuction_Id(){photoRepository.editAuction_Id(photoRequest.getId(), photoRequest.getId());}

    public String editLink() {
        photoRepository.editLink(photoRequest.getLink(), photoRequest.getId());
        return "myauctionsowner";
    }

}
