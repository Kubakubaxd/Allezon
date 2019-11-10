package pl.edu.pjwstk.jazapp.webapp.auction;

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

    //@Transactional
    public boolean isAuctionExist(AuctionEntity auctionEntity) {
        System.out.println("KROK 2 <-------------------------------");
        AuctionEntity search = em.find(AuctionEntity.class, auctionEntity.getId());
        System.out.println("KROK 3 <-------------------------------");
        return !(search == null);
    }

    @Transactional
    void createAuction(AuctionEntity auctionEntity) {
        //if (!isAuctionExist(auctionEntity)) {
            em.persist(auctionEntity);
          //  System.out.println("KROK 5 <-------------------------------");
        //}
    }

    @Transactional
    public void createAuctionTest(){
        AuctionEntity auctionEntity = new AuctionEntity("Test", 2,2);
        em.persist(auctionEntity);
    }

    @Transactional
    public boolean changeDescription(AuctionEntity auctionEntity, String description) {
        if (!isAuctionExist(auctionEntity)) {
            auctionEntity.setDescription(description);
            em.persist(auctionEntity);
            return true;
        } else return false;
    }

    @Transactional
    public boolean changeSection(AuctionEntity auctionEntity, int section_id) {
        if (!isAuctionExist(auctionEntity)) {
            auctionEntity.setSection_id(section_id);
            em.persist(auctionEntity);
            return true;
        } else return false;
    }

    @Transactional
    public boolean changePrice(AuctionEntity auctionEntity, int price) {

        if (!isAuctionExist(auctionEntity)) {
            auctionEntity.setPrice(price);
            em.persist(auctionEntity);
            return true;
        } else return false;
    }

}


