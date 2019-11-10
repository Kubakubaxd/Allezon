package pl.edu.pjwstk.jazapp.webapp.auction;

import pl.edu.pjwstk.jazapp.webapp.section.SectionModel;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Named
@RequestScoped
public class AuctionRepository {
    @PersistenceContext
    private EntityManager em;
    @Inject
    SectionModel sectionModel;
    @Inject
    AuctionRequest auctionRequest;

    @Transactional
    public boolean isAuctionExist(AuctionEntity auctionEntity) {
        System.out.println("KROK 2 <-------------------------------");
        AuctionEntity search = em.find(AuctionEntity.class, auctionEntity.getId());
        System.out.println("KROK 3 <-------------------------------");
        return !(search == null);
    }

    @Transactional
    public void createAuction() {
        if(sectionModel.isSectionExist(auctionRequest.getSectionId())) {
            AuctionEntity auctionEntity = new AuctionEntity(auctionRequest.getDescription(), auctionRequest.getSectionId(), auctionRequest.getPrice());
            em.persist(auctionEntity);
        }

    }

    @Transactional
    public void createAuctionTest(){
        AuctionEntity auctionEntity = new AuctionEntity("Test", 4,2);
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


