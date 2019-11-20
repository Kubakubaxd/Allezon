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
}
