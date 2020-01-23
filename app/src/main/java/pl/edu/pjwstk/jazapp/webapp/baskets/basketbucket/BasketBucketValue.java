package pl.edu.pjwstk.jazapp.webapp.baskets.basketbucket;

import pl.edu.pjwstk.jazapp.webapp.auctiondb.auction.AuctionEntity;
import pl.edu.pjwstk.jazapp.webapp.baskets.basket.BasketEntity;

import javax.persistence.*;

@Entity
@Table(name = "basketbucket")
public class BasketBucketValue {
    @EmbeddedId
    private BasketBucketId basketBucketId;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @MapsId("owner")
    @JoinColumn(name = "basket_owner")
    private BasketEntity basketEntity;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @MapsId("auction_id")
    @JoinColumn(name = "auction_id")
    private AuctionEntity auctionEntity;

    @Column(name = "quantity")
    private int quantity;

    public BasketBucketValue() {
    }

    public BasketBucketValue(BasketBucketId basketBucketId, BasketEntity basketEntity, AuctionEntity auctionEntity, int quantity) {
        this.basketBucketId = basketBucketId;
        this.basketEntity = basketEntity;
        this.auctionEntity = auctionEntity;
        this.quantity = quantity;
    }

    public BasketBucketValue(BasketBucketId basketBucketId, int quantity) {
        this.basketBucketId = basketBucketId;
        this.quantity = quantity;
    }


    public BasketBucketId getBasketBucketId() {
        return basketBucketId;
    }

    public void setBasketBucketId(BasketBucketId basketBucketId) {
        this.basketBucketId = basketBucketId;
    }

    public BasketEntity getBasketEntity() {
        return basketEntity;
    }

    public void setBasketEntity(BasketEntity basketEntity) {
        this.basketEntity = basketEntity;
    }

    public AuctionEntity getAuctionEntity() {
        return auctionEntity;
    }

    public void setAuctionEntity(AuctionEntity auctionEntity) {
        this.auctionEntity = auctionEntity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
