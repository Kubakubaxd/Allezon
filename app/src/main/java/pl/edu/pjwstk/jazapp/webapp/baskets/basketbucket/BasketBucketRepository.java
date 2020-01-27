package pl.edu.pjwstk.jazapp.webapp.baskets.basketbucket;

import pl.edu.pjwstk.jazapp.webapp.auctiondb.auction.AuctionEntity;
import pl.edu.pjwstk.jazapp.webapp.baskets.basket.BasketController;
import pl.edu.pjwstk.jazapp.webapp.baskets.basket.BasketEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class BasketBucketRepository {
    @PersistenceContext
    private EntityManager em;
    @Inject
    BasketController basketController;

    @Transactional
    public void create(String basket_owner, int auction_id, int quantityToAdd) {
        BasketEntity basketEntity = em.find(BasketEntity.class, basket_owner);
        AuctionEntity auctionEntity = em.find(AuctionEntity.class, auction_id);
        BasketBucketId basketBucketId = new BasketBucketId(basket_owner, auction_id);

        if (isExist(basketBucketId)) {
            BasketBucketValue basketBucketValue = em.find(BasketBucketValue.class, basketBucketId);
            int quantityCurrent = basketBucketValue.getQuantity();
            basketBucketValue.setQuantity(quantityCurrent + quantityToAdd);
            em.persist(basketBucketValue);
        } else {
            BasketBucketValue basketBucketValue = new BasketBucketValue(basketBucketId, basketEntity, auctionEntity, quantityToAdd);
            em.persist(basketBucketValue);
        }
    }

    public List<BasketBucketValue> findByOwner(String owner) {
        BasketEntity basketEntity = basketController.find(owner);
        if (basketEntity == null) {
            return null;
        }
        List<BasketBucketValue> basketEntities = basketEntity.getBasketBucketEntities();
        if (basketEntities.isEmpty()) return null;
        else return basketEntities;
    }

    public boolean isExist(BasketBucketId basketBucketId) {
        return em.find(BasketBucketValue.class, basketBucketId) != null;
    }
}
