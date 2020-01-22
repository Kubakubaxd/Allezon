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
    public void create(int basket_id, int auction_id, int quantity) {
        if (isExist(basket_id, auction_id)) {
            BasketBucketId basketBucketId = new BasketBucketId(basket_id, auction_id);
            BasketBucketValue basketBucketValue = em.find(BasketBucketValue.class, basketBucketId);

            int acttualQuantity = basketBucketValue.getQuantity();
            basketBucketValue.setQuantity(acttualQuantity + 1);
            em.persist(basketBucketValue);
        } else {
            BasketBucketId basketBucketId = new BasketBucketId(basket_id, auction_id);
            BasketEntity basketEntity = em.find(BasketEntity.class, basket_id);
            AuctionEntity auctionEntity = em.find(AuctionEntity.class, auction_id);

            BasketBucketValue bucket = new BasketBucketValue(basketBucketId, basketEntity, auctionEntity, quantity);
            em.persist(bucket);
        }
    }

    @Transactional
    public void createWithOwner(String owner, int auction_id) {
        int quantity = 1;
        int basket_id = em.createQuery("SELECT c FROM BasketEntity c WHERE c.userpsqla LIKE :owner")
                .setParameter("owner", owner).getFirstResult();
        BasketBucketId basketBucketId = new BasketBucketId(basket_id, auction_id);
        if (isExistWithOwner(owner)) {
            BasketBucketValue basketBucketValue = em.find(BasketBucketValue.class, basketBucketId);

            int acttualQuantity = basketBucketValue.getQuantity();
            basketBucketValue.setQuantity(acttualQuantity + 1);
            em.persist(basketBucketValue);
        } else {
            BasketEntity basketEntity = em.find(BasketEntity.class, basket_id);
            AuctionEntity auctionEntity = em.find(AuctionEntity.class, auction_id);

            BasketBucketValue bucket = new BasketBucketValue(basketBucketId, basketEntity, auctionEntity, quantity);
            em.persist(bucket);
        }
    }

    public boolean isExist(int basket_id, int auction_id) {
        BasketBucketId basketBucketId = new BasketBucketId(basket_id, auction_id);
        return em.find(BasketBucketId.class, basketBucketId) != null;
    }

    public boolean isExistWithOwner(String owner) {
        return em.find(BasketBucketValue.class, owner) != null;
    }

}
