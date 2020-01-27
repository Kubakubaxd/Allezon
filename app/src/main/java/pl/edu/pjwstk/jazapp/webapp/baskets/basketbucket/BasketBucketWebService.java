package pl.edu.pjwstk.jazapp.webapp.baskets.basketbucket;

import pl.edu.pjwstk.jazapp.webapp.session.SessionAsk;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@Path("basketbucket")
public class BasketBucketWebService {
    @Inject
    SessionAsk session;
    @Inject
    BasketBucketRepository basketBucketRepository;

    @GET
    public List<BasketBucketValue> find() {
        return basketBucketRepository.findByOwner(session.getUsername());
    }

}
