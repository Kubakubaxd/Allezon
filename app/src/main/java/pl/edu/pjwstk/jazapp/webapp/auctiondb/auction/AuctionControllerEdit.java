package pl.edu.pjwstk.jazapp.webapp.auctiondb.auction;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;

@Named
@RequestScoped
public class AuctionControllerEdit {
    @Inject
    AuctionRepository auctionRepository;
    AuctionRequest req;

    public AuctionRequest getAuctionRequest() {
        if (req == null) {
            req = createAuctionRequest();
        }
        return req;
    }

    private AuctionRequest createAuctionRequest() {
        Map<String, String> params = FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap();
        String auctionIdString = params.get("auctionid");
        if (auctionIdString == null) {
            return new AuctionRequest();
        } else {
            int auctionId = Integer.parseInt(auctionIdString);
            AuctionEntity aE = auctionRepository.findAuctionById(auctionId);
            AuctionRequest auctionRequest = new AuctionRequest(
                    aE.getId(), aE.getTitle(), aE.getDescription(), aE.getCategory().getId(),
                    aE.getPrice(), aE.firstPhoto());
            return auctionRequest;
        }
    }

    public String edit() {
        auctionRepository.edit(getAuctionRequest().getId(), getAuctionRequest().getTitle(), getAuctionRequest().getDescription(), getAuctionRequest().getCategoryId(), getAuctionRequest().getPrice());
        return "myauctionsowner";
    }
}
