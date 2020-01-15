package pl.edu.pjwstk.jazapp.webapp.auctiondb.basket;

import pl.edu.pjwstk.jazapp.webapp.auctiondb.auction.AuctionEntity;

import javax.persistence.*;

@Entity
@Table(name = "basket")
public class BasketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String userpsqla;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "auction")
    private AuctionEntity auctionEntity;

    public BasketEntity() {
    }

    public String getUserpsqla() {
        return userpsqla;
    }

    public void setUserpsqla(String userpsqla) {
        this.userpsqla = userpsqla;
    }

    public AuctionEntity getAuctionEntity() {
        return auctionEntity;
    }

    public void setAuctionEntity(AuctionEntity auctionEntity) {
        this.auctionEntity = auctionEntity;
    }
}
