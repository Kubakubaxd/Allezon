package pl.edu.pjwstk.jazapp.webapp.baskets.basketbucket;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class BasketBucketId implements Serializable {
    private String owner;
    private int auction_id;

    public BasketBucketId() {
    }

    public BasketBucketId(String owner, int auction_id) {
        this.owner = owner;
        this.auction_id = auction_id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getAuction_id() {
        return auction_id;
    }

    public void setAuction_id(int auction_id) {
        this.auction_id = auction_id;
    }
}
