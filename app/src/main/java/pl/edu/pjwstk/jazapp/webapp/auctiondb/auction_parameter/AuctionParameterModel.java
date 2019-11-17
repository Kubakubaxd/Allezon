package pl.edu.pjwstk.jazapp.webapp.auctiondb.auction_parameter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class AuctionParameterModel {
    @Inject
    AuctionParameterRequest request;
    @Inject
    AuctionParameterRepository repository;

    public void create(){
        repository.create(request.getAuction_id(), request.getParameter(),request.getValue());
    }


}
