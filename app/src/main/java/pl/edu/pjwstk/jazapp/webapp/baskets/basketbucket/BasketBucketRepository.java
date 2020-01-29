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
    public void add(String basket_owner, int auction_id, int quantityToAdd) {
        if (!basketController.isExist()) basketController.create();
        else basketController.removeIfDateExpired();

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

        basketController.updateDate();
    }

    @Transactional
    public void remove(BasketBucketId basketBucketId) {
        BasketBucketValue basketBucketValue = em.find(BasketBucketValue.class, basketBucketId);
        em.detach(basketBucketValue);
        em.remove(basketBucketValue);
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

    @Transactional
    public void quantityPlus(BasketBucketId basketBucketId) {
        BasketBucketValue basketBucketValue = em.find(BasketBucketValue.class, basketBucketId);
        basketBucketValue.setQuantity(basketBucketValue.getQuantity() + 1);
        em.persist(basketBucketValue);
    }

    @Transactional
    public void quantityMinus(BasketBucketId basketBucketId) {
        BasketBucketValue basketBucketValue = em.find(BasketBucketValue.class, basketBucketId);
        if (basketBucketValue.getQuantity() <= 1) {
            remove(basketBucketId);
        } else {
            basketBucketValue.setQuantity(basketBucketValue.getQuantity() - 1);
            em.persist(basketBucketValue);
        }
    }
}
