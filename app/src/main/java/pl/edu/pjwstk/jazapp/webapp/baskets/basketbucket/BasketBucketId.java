package pl.edu.pjwstk.jazapp.webapp.baskets.basketbucket;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class BasketBucketId implements Serializable {
    private String basket_id;
    private int auction_id;

    public BasketBucketId() {
    }

    public BasketBucketId(String basket_id, int auction_id) {
        this.basket_id = basket_id;
        this.auction_id = auction_id;
    }

    public String getOwner() {
        return basket_id;
    }

    public void setOwner(String owner) {
        this.basket_id = basket_id;
    }

    public int getAuction_id() {
        return auction_id;
    }

    public void setAuction_id(int auction_id) {
        this.auction_id = auction_id;
    }
}
