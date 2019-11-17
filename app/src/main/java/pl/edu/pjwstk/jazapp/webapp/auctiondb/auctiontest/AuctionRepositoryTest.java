package pl.edu.pjwstk.jazapp.webapp.auctiondb.auctiontest;

import pl.edu.pjwstk.jazapp.webapp.auctiondb.auction.AuctionEntityTest;
import pl.edu.pjwstk.jazapp.webapp.auctiondb.section.SectionEntity;
import pl.edu.pjwstk.jazapp.webapp.auctiondb.section.SectionRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Named
@RequestScoped
public class AuctionRepositoryTest {
    @Inject
    SectionRepository sectionRepository;
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public boolean isExist(int id) {
        AuctionEntityTest search = em.find(AuctionEntityTest.class, id);
        return !(search == null);
    }

    @Transactional
    public void create(String description, int section_id, int price) {
        if (sectionRepository.isSectionExist(section_id)) {
            SectionEntity sectionEntity = em.find(SectionEntity.class, section_id);
            AuctionEntityTest auctionEntity = new AuctionEntityTest(description, sectionEntity, price);

            em.persist(auctionEntity);
        }
    }

    @Transactional
    public String getDescription() throws NoSuchFieldException {
        AuctionEntityTest entity = em.find(AuctionEntityTest.class, 25);
        Field field = AuctionEntityTest.class.getField("price");

        System.out.println("DESCRIPTION: " + field.toString() );
        return field.toString();
    }



//    @Transactional
//    public void edit(AuctionEntity auctionEntity, int id) {
//        auctionEntity.setId(id);
//        em.persist(auctionEntity);
//    }
//
//    @Transactional
//    public void editDescription(int id, String description) {
//        if (isExist(id)) {
//            AuctionEntity auctionEntity = em.find(AuctionEntity.class, id);
//            auctionEntity.setDescription(description);
//            em.persist(auctionEntity);
//        }
//    }
//
//    @Transactional
//    public void editSection(int id, int section_id) {
//        if (isExist(id)) {
//            AuctionEntity auctionEntity = em.find(AuctionEntity.class, id);
//            auctionEntity.setSection_id(section_id);
//            em.persist(auctionEntity);
//        }
//    }
//
//    @Transactional
//    public void editPrice(int id, int price) {
//        if (isExist(id)) {
//            AuctionEntity auctionEntity = em.find(AuctionEntity.class, id);
//            auctionEntity.setPrice(price);
//            em.persist(auctionEntity);
//        }
//    }
//
//    @Transactional
//    public void createAuctionTest() {
//        AuctionEntity auctionEntity = new AuctionEntity("Test", 4, 2);
//        em.persist(auctionEntity);
//    }
}


