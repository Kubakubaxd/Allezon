package pl.edu.pjwstk.jazapp.webapp.auction;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
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
    boolean createAuction(AuctionEntity auctionEntity) {
        if (!isAuctionExist(auctionEntity)) {
            System.out.println("KROK 4 <-------------------------------");
            AuctionEntity test = new AuctionEntity("test" , 1 ,1 );
            em.persist(test);
            System.out.println("KROK 5 <-------------------------------");
            return true;
        } else return false;
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


