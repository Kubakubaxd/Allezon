package pl.edu.pjwstk.jazapp.webapp.auction_edit;

import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

@Named
@RequestScoped
public class AuctionEditRequest {

private int auction_id;

    public String redirect(int auction_id){
        this.auction_id = auction_id;
        return "auction_edit";
    }

    public AuctionEditRequest(int auction_id) {
        this.auction_id = auction_id;
    }

    public AuctionEditRequest() {
    }

    public int getAuction_id() {
        return auction_id;
    }

    public void setAuction_id(int auction_id) {
        this.auction_id = auction_id;
    }
}
