package pl.edu.pjwstk.jazapp.webapp.auctiondb.auction_parameter;

import pl.edu.pjwstk.jazapp.webapp.auctiondb.auction.AuctionEntity;
import pl.edu.pjwstk.jazapp.webapp.auctiondb.parameter.ParameterEntity;

import javax.persistence.*;

@Entity
@Table(name = "action_parameter")
public class AuctionParameterValue {

    @EmbeddedId
    @JoinColumn(columnDefinition = "parameter_id")
    private AuctionParameterId auctionParameterId;

    @OneToOne
    @JoinColumn(columnDefinition = "auction_id")
    private AuctionEntity auctionEntity;

    @ManyToOne
    @JoinColumn(columnDefinition = "value")
    private ParameterEntity parameterEntity;

    public AuctionParameterValue(AuctionParameterId auctionParameterId, AuctionEntity auctionEntity, ParameterEntity parameterEntity) {
        this.auctionParameterId = auctionParameterId;
        this.auctionEntity = auctionEntity;
        this.parameterEntity = parameterEntity;
    }

    public AuctionParameterValue() {

    }

    public AuctionParameterId getAuctionParameterId() {
        return auctionParameterId;
    }

    public void setAuctionParameterId(AuctionParameterId auctionParameterId) {
        this.auctionParameterId = auctionParameterId;
    }

    public AuctionEntity getAuctionEntity() {
        return auctionEntity;
    }

    public void setAuctionEntity(AuctionEntity auctionEntity) {
        this.auctionEntity = auctionEntity;
    }

    public ParameterEntity getParameterEntity() {
        return parameterEntity;
    }

    public void setParameterEntity(ParameterEntity parameterEntity) {
        this.parameterEntity = parameterEntity;
    }
}
