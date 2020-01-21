package pl.edu.pjwstk.jazapp.webapp.baskets.basketbucket;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class BasketBucketRequest {
    private int quantity;
    private String basket_id;
    private int auction_id;

    public String getBasket_id() {
        return basket_id;
    }

    public void setBasket_id(String basket_id) {
        this.basket_id = basket_id;
    }

    public int getAuction_id() {
        return auction_id;
    }

    public void setAuction_id(int auction_id) {
        this.auction_id = auction_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
