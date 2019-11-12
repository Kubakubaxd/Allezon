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
    public boolean isExist(AuctionEntity auctionEntity) {
        AuctionEntity search = em.find(AuctionEntity.class, auctionEntity.getId());
        return !(search == null);
    }

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
    public void edit(AuctionEntity auctionEntity){
        em.persist(auctionEntity);
    }

    @Transactional
    public void editDescription(AuctionEntity auctionEntity, String description) {
        auctionEntity.setDescription(description);
        em.persist(auctionEntity);
    }

    @Transactional
    public void editSection(AuctionEntity auctionEntity, int section_id) {
        auctionEntity.setSection_id(section_id);
        em.persist(auctionEntity);
    }

    @Transactional
    public void editPrice(AuctionEntity auctionEntity, int price) {
        auctionEntity.setPrice(price);
        em.persist(auctionEntity);
    }

    @Transactional
    public void createAuctionTest() {
        AuctionEntity auctionEntity = new AuctionEntity("Test", 4, 2);
        em.persist(auctionEntity);
    }

    //    @Transactional
//    public void createAuction() {
//        if(sectionModel.isSectionExist(auctionRequest.getSectionId())) {
//            AuctionEntity auctionEntity = new AuctionEntity(auctionRequest.getDescription(), auctionRequest.getSectionId(), auctionRequest.getPrice());
//            em.persist(auctionEntity);
//        }
//
//    }

}


