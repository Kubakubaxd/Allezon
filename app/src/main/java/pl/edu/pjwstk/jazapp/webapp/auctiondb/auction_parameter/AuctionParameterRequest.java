package pl.edu.pjwstk.jazapp.webapp.auctiondb.auction_parameter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class AuctionParameterRequest {
    private int auction_id;
    private int parameter;
    private String value;

    public int getAuction_id() {
        return auction_id;
    }
    public void setAuction_id(int auction_id) {
        this.auction_id = auction_id;
    }
    public int getParameter() {
        return parameter;
    }
    public void setParameter(int parameter) {
        this.parameter = parameter;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
}
