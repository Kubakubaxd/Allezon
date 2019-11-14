package pl.edu.pjwstk.jazapp.webapp.auctiondb.auction_parameter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class AuctionParameterId implements Serializable {
    @Column(columnDefinition = "auction_id")
    private int auction_id;

    @Column(columnDefinition = "parameter_id")
    private int parameter_id;

    @Column(columnDefinition = "value")
    private String value;

    public AuctionParameterId(int auction_id, int parameter_id, String value) {
        this.auction_id = auction_id;
        this.parameter_id = parameter_id;
        this.value = value;
    }

    public AuctionParameterId() {

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
