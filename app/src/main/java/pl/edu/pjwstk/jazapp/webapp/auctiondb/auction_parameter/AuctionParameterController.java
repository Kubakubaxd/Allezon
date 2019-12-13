package pl.edu.pjwstk.jazapp.webapp.auctiondb.auction_parameter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class AuctionParameterController {
    @Inject
    AuctionParameterRequest request;
    @Inject
    AuctionParameterRepository repository;

    public String create() {
        repository.create(request.getAuction_id(), request.getParameter(), request.getValue());
        return "myauctions";
    }

    public String edit() {
        repository.edit(request.getAuction_id(), request.getParameter(), request.getValue());
        return "myauctions";
    }
}
