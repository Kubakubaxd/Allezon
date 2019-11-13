package pl.edu.pjwstk.jazapp.webapp.auctiondb.auction_photo;

import javax.persistence.*;

@Entity
@Table(name = "photo")
public class PhotoEntity {
    @Id
    private int auction_id;
    private String link;

    public PhotoEntity(int auction_id, String link) {
        this.auction_id = auction_id;
        this.link = link;
    }

    public PhotoEntity() { }


    public int getAuction_id() {
        return auction_id;
    }
    public void setAuction_id(int auction_id) {
        this.auction_id = auction_id;
    }
    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }
}
