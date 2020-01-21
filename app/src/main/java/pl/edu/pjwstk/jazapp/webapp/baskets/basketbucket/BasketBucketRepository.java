package pl.edu.pjwstk.jazapp.webapp.baskets.basketbucket;

import pl.edu.pjwstk.jazapp.webapp.auctiondb.auction.AuctionEntity;
import pl.edu.pjwstk.jazapp.webapp.baskets.basket.BasketEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class BasketBucketRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void create(String basket_id, int auction_id, int quantity) {
        //TODO: Sprawdzic czy istnieje jak tak to dodac quantity
        BasketBucketId basketBucketId = new BasketBucketId(basket_id, auction_id);
        BasketEntity basketEntity = em.find(BasketEntity.class, basket_id);
        AuctionEntity auctionEntity = em.find(AuctionEntity.class, auction_id);

        BasketBucketValue bucket = new BasketBucketValue(basketBucketId, basketEntity, auctionEntity, quantity);
        em.persist(bucket);
    }

}
