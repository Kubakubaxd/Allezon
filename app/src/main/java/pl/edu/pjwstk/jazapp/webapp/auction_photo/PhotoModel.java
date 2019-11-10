package pl.edu.pjwstk.jazapp.webapp.auction_photo;

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

    public void createPhoto(){
        PhotoEntity photoEntity = new PhotoEntity(photoRequest.getId(),photoRequest.getLink());
        photoRepository.createPhoto(photoEntity);
    }
}
