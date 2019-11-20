package pl.edu.pjwstk.jazapp.webapp.auctiondb.auction_photo;

import javax.persistence.*;

@Entity
@Table(name = "photo")
public class PhotoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String link;
    private int auction_id;


    public PhotoEntity(int auction_id, String link) {
        this.auction_id = auction_id;
        this.link = link;
    }

    public PhotoEntity() { }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
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
