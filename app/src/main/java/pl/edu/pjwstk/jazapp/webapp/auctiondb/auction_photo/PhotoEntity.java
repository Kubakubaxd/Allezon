package pl.edu.pjwstk.jazapp.webapp.auctiondb.auction_photo;

import pl.edu.pjwstk.jazapp.webapp.auctiondb.auction.AuctionEntity;

import javax.persistence.*;

@Entity
@Table(name = "photo")
public class PhotoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String link;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "auction_id")
    private AuctionEntity auctionEntity;

    public PhotoEntity(String link, AuctionEntity auctionEntity) {
        this.link = link;
        this.auctionEntity = auctionEntity;
    }

    public PhotoEntity(String link) {
        this.link = link;
    }
    public PhotoEntity() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public AuctionEntity getAuctionEntity() {
        return auctionEntity;
    }
    public void setAuctionEntity(AuctionEntity auctionEntity) {
        this.auctionEntity = auctionEntity;
    }
    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }
}
