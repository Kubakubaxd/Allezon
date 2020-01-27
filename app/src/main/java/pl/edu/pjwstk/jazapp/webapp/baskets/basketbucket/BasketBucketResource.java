package pl.edu.pjwstk.jazapp.webapp.baskets.basketbucket;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationScoped
public class BasketBucketResource {
    BasketBucketRepository repo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("api/{owner}")
    public List<BasketBucketValue> getBasketBucketValueByOwner(String owner) {
        return repo.findByOwner(owner);
    }


}
