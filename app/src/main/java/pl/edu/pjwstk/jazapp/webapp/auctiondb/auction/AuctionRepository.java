package pl.edu.pjwstk.jazapp.webapp.auctiondb.auction;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Named
@RequestScoped
public class AuctionRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public boolean isExist(int id) {
        AuctionEntity search = em.find(AuctionEntity.class, id);
        return !(search == null);
    }

    @Transactional
    public void create(AuctionEntity auctionEntity) {
        em.persist(auctionEntity);
    }

    @Transactional
    public void edit(AuctionEntity auctionEntity, int id) {
        auctionEntity.setId(id);
        em.persist(auctionEntity);
    }

    @Transactional
    public void editDescription(int id, String description) {
        if (isExist(id)) {
            AuctionEntity auctionEntity = em.find(AuctionEntity.class, id);
            auctionEntity.setDescription(description);
            em.persist(auctionEntity);
        }
    }

    @Transactional
    public void editSection(int id, int section_id) {
        if (isExist(id)) {
            AuctionEntity auctionEntity = em.find(AuctionEntity.class, id);
            auctionEntity.setSection_id(section_id);
            em.persist(auctionEntity);
        }
    }

    @Transactional
    public void editPrice(int id, int price) {
        if (isExist(id)) {
            AuctionEntity auctionEntity = em.find(AuctionEntity.class, id);
            auctionEntity.setPrice(price);
            em.persist(auctionEntity);
        }
    }

    @Transactional
    public void createAuctionTest() {
        AuctionEntity auctionEntity = new AuctionEntity("Test", 4, 2);
        em.persist(auctionEntity);
    }
}


