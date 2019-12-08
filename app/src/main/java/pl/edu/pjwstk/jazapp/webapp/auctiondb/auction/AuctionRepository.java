package pl.edu.pjwstk.jazapp.webapp.auctiondb.auction;

import pl.edu.pjwstk.jazapp.webapp.auctiondb.auction_parameter.AuctionParameterValue;
import pl.edu.pjwstk.jazapp.webapp.auctiondb.auction_photo.PhotoEntity;
import pl.edu.pjwstk.jazapp.webapp.auctiondb.section.SectionEntity;
import pl.edu.pjwstk.jazapp.webapp.auctiondb.section.SectionRepository;
import pl.edu.pjwstk.jazapp.webapp.session.SessionAsk;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Named
@RequestScoped
public class AuctionRepository {
    @Inject
    SectionRepository sectionRepository;
    @Inject
    SessionAsk sessionAsk;
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public boolean isExist(int id) {
        AuctionEntity search = em.find(AuctionEntity.class, id);
        return !(search == null);
    }

    @Transactional
    public void create(String description, int section_id, int price) {
        if (sectionRepository.isSectionExist(section_id)) {
            SectionEntity sectionEntity = em.find(SectionEntity.class, section_id);
            String owner = sessionAsk.getUsername();
            AuctionEntity auctionEntity = new AuctionEntity(description, sectionEntity, price, owner);
            em.persist(auctionEntity);
        }
    }

    @Transactional
    public void edit(int id, String description, int section_id, int price) {
        if (isExist(id) && sectionRepository.isSectionExist(section_id)) {
            AuctionEntity auctionEntity = em.find(AuctionEntity.class, id);
            SectionEntity sectionEntity = em.find(SectionEntity.class, section_id);
            auctionEntity.setDescription(description);
            auctionEntity.setSection(sectionEntity);
            auctionEntity.setPrice(price);
            em.merge(auctionEntity);
        }
    }

    @Transactional
    public void editDescription(int id, String description) {
        if (isExist(id)) {
            AuctionEntity auctionEntity = em.find(AuctionEntity.class, id);
            auctionEntity.setDescription(description);
            em.merge(auctionEntity);
        }
    }

    @Transactional
    public void editSection(int id, int section_id) {
        if (isExist(id) && sectionRepository.isSectionExist(section_id)) {
            AuctionEntity auctionEntity = em.find(AuctionEntity.class, id);
            SectionEntity sectionEntity = em.find(SectionEntity.class, section_id);
            auctionEntity.setSection(sectionEntity);
            em.merge(auctionEntity);
        }
    }

    @Transactional
    public void editPrice(int id, int price) {
        if (isExist(id)) {
            AuctionEntity auctionEntity = em.find(AuctionEntity.class, id);
            auctionEntity.setPrice(price);
            em.merge(auctionEntity);
        }
    }

    @Transactional
    public List<AuctionEntity> getAllAuctions() {
        return em.createQuery("FROM AuctionEntity", AuctionEntity.class).getResultList();
    }

    @Transactional
    public List<AuctionEntity> getAllAuctionsByOwner(String ownerVal) {
        // return em.createQuery("FROM AuctionEntity", AuctionEntity.class).setParameter(ownerVal, "owner").getResultList();
        return em.createQuery(
                "SELECT c FROM AuctionEntity c WHERE c.owner LIKE ?1"
                , AuctionEntity.class)
                .setParameter(1, ownerVal)
                .getResultList();
    }

    @Transactional
    public List<PhotoEntity> findPhotosByAuctionId(int id) {
        AuctionEntity auctionEntity = em.find(AuctionEntity.class, id);
        return auctionEntity.getPhotoEntityList();
    }

    @Transactional
    public List<AuctionParameterValue> findParametersByAuctionId(int id) {
        AuctionEntity auctionEntity = em.find(AuctionEntity.class, id);

        return auctionEntity.getAuctionParameterList();
    }
}