package pl.edu.pjwstk.jazapp.webapp.baskets.basketbucket;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class BasketBucketId implements Serializable {
    private int basket_id;
    private int auction_id;

    public BasketBucketId() {
    }

    public BasketBucketId(int basket_id, int auction_id) {
        this.basket_id = basket_id;
        this.auction_id = auction_id;
    }

    public int getBasket_id() {
        return basket_id;
    }

    public void setBasket_id(int basket_id) {
        this.basket_id = basket_id;
    }

    public int getAuction_id() {
        return auction_id;
    }

    public void setAuction_id(int auction_id) {
        this.auction_id = auction_id;
    }
}
