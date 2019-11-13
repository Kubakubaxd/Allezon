package pl.edu.pjwstk.jazapp.webapp.auctiondb.auction_photo;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@RequestScoped
public class PhotoRequest {
    private int id;
    private String link;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }
    public PhotoEntity getPhotoEntity () { return new PhotoEntity(id,link); }
}
