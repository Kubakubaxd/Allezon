package pl.edu.pjwstk.jazapp.webapp.auctiondb.auction_parameter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class AuctionParameterId implements Serializable {

    @Column(name = "auction_id")
    private int auction_id;

    @Column(name = "parameter_id")
    private int parameter_id;

    public AuctionParameterId() {
    }

    public AuctionParameterId(int auction_id, int parameter_id) {
        this.auction_id = auction_id;
        this.parameter_id = parameter_id;
    }

    public int getAuction_id() {
        return auction_id;
    }

    public void setAuction_id(int auction_id) {
        this.auction_id = auction_id;
    }

    public int getParameter_id() {
        return parameter_id;
    }

    public void setParameter_id(int parameter_id) {
        this.parameter_id = parameter_id;
    }
}
