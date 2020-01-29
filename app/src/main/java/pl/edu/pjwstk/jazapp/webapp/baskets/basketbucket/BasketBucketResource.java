package pl.edu.pjwstk.jazapp.webapp.baskets.basketbucket;

import pl.edu.pjwstk.jazapp.webapp.baskets.basket.BasketRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/basket")
public class BasketBucketResource {
    BasketRepository repo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/find")
    public Response getBasketBucketValueByOwner(String owner) {
        owner = "admin";
        System.out.println("wchodzi ----------------------------" + owner);
        var basketBucket = repo.find(owner);
        var basketBucketValues = basketBucket.getBasketBucketEntities();
        System.out.println("wychodzi ----------------------------");
        if (basketBucketValues.isEmpty() || basketBucketValues == null) {
            System.out.println("cosik nie poszlo ----------------------------");
            return Response
                    .status(Response.Status.OK)
                    .entity("pusto")
                    .build();
        } else {
            System.out.println("cosik ----------------------------");
            return Response
                    .status(Response.Status.OK)
                    .entity(basketBucketValues)
                    .build();
        }
    }

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/ok")
//    public Response getBasketBucketValueByOwner1() {
//
//        List<BasketBucketValue> basketBucketValues = repo.findByOwner("admin");
//        if(basketBucketValues!= null) System.out.println("nie null" + "---------------------------------");
//        else System.out.println("null jak chuj" + "-------------------------------------");
//            return Response
//                    .status(Response.Status.OK)
//                    .entity(basketBucketValues)
//                    .build();
//
//    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/ok")
    public Response getOkResponse() {
        String message = "This is a text response";
        return Response
                .status(Response.Status.OK)
                .entity(message)
                .build();
    }
}
