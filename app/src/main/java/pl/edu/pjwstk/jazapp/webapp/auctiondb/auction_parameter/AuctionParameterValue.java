package pl.edu.pjwstk.jazapp.webapp.auctiondb.auction_parameter;

import pl.edu.pjwstk.jazapp.webapp.auctiondb.auction.AuctionEntity;
import pl.edu.pjwstk.jazapp.webapp.auctiondb.parameter.ParameterEntity;

import javax.persistence.*;

@Entity
@Table(name = "auction_parameter")
public class AuctionParameterValue {
    @EmbeddedId
    private AuctionParameterId auctionParameterId;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @MapsId("auction_id")
    @JoinColumn(name = "auction_id")
    private AuctionEntity auctionEntity;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @MapsId("parameter_id")
    @JoinColumn(name = "parameter_id")
    private ParameterEntity parameterEntity;

    @Column(name = "value")
    private String value;

    public AuctionParameterValue(AuctionParameterId auctionParameterId, AuctionEntity auctionEntity, ParameterEntity parameterEntity, String value) {
        this.auctionParameterId = auctionParameterId;
        this.auctionEntity = auctionEntity;
        this.parameterEntity = parameterEntity;
        this.value = value;
    }

    public AuctionParameterValue() {
    }
    public AuctionParameterValue(ParameterEntity parameterEntity, String value) {
        this.parameterEntity = parameterEntity;
        this.value = value;
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
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
}