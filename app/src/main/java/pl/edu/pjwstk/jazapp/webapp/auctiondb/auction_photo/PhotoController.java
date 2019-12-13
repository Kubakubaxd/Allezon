package pl.edu.pjwstk.jazapp.webapp.auctiondb.auction_photo;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class PhotoController {
    @Inject
    PhotoRequest photoRequest;
    @Inject
    PhotoRepository photoRepository;

    public String create() {
        photoRepository.create(photoRequest.getId(), photoRequest.getLink());
        return "myauctionsowner";
    }

    public void remove(int id) {
        photoRepository.remove(id);
    }

    public String editLink() {
        photoRepository.editLink(photoRequest.getLink(), photoRequest.getId());
        return "myauctionsowner";
    }

}
