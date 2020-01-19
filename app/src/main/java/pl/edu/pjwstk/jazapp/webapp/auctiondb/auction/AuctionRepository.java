package pl.edu.pjwstk.jazapp.webapp.auctiondb.auction;

import pl.edu.pjwstk.jazapp.webapp.auctiondb.auction_parameter.AuctionParameterValue;
import pl.edu.pjwstk.jazapp.webapp.auctiondb.auction_photo.PhotoEntity;
import pl.edu.pjwstk.jazapp.webapp.auctiondb.category.CategoryEntity;
import pl.edu.pjwstk.jazapp.webapp.auctiondb.category.CategoryRepository;
import pl.edu.pjwstk.jazapp.webapp.auctiondb.parameter.ParameterEntity;
import pl.edu.pjwstk.jazapp.webapp.session.SessionAsk;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class AuctionRepository {
    @Inject
    CategoryRepository categoryRepository;
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
    public void create(String title, String description, int section_id, int price) {
        if (categoryRepository.isExist(section_id)) {
            CategoryEntity categoryEntity = em.find(CategoryEntity.class, section_id);
            String owner = sessionAsk.getUsername();
            AuctionEntity auctionEntity = new AuctionEntity(title, description, categoryEntity, price, owner);
            em.persist(auctionEntity);
        }
    }

    @Transactional
    public void create(String title, String description, int section_id, int price, String link) {
        if (categoryRepository.isExist(section_id)) {
            CategoryEntity categoryEntity = em.find(CategoryEntity.class, section_id);
            String owner = sessionAsk.getUsername();


            AuctionEntity auctionEntity = new AuctionEntity(title, description, categoryEntity, price, owner);
            ArrayList<PhotoEntity> lista = new ArrayList<>();
            PhotoEntity photo = new PhotoEntity(link, auctionEntity);
            lista.add(photo);
            auctionEntity.setPhotoEntityList(lista);

            em.persist(auctionEntity);
        }
    }

    @Transactional
    public void edit(int id, String title, String description, int section_id, int price) {
        if (isExist(id) && categoryRepository.isExist(section_id)) {
            AuctionEntity auctionEntity = em.find(AuctionEntity.class, id);
            CategoryEntity categoryEntity = em.find(CategoryEntity.class, section_id);
            auctionEntity.setTitle(title);
            auctionEntity.setDescription(description);
            auctionEntity.setCategory(categoryEntity);
            auctionEntity.setPrice(price);
            em.merge(auctionEntity);
        }
    }

    @Transactional
    public void editTitle(int id, String title) {
        if (isExist(id)) {
            AuctionEntity auctionEntity = em.find(AuctionEntity.class, id);
            auctionEntity.setTitle(title);
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
        if (isExist(id) && categoryRepository.isExist(section_id)) {
            AuctionEntity auctionEntity = em.find(AuctionEntity.class, id);
            CategoryEntity categoryEntity = em.find(CategoryEntity.class, section_id);
            auctionEntity.setCategory(categoryEntity);
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
        return em.createQuery(
                "SELECT c FROM AuctionEntity c WHERE c.owner LIKE ?1"
                , AuctionEntity.class)
                .setParameter(1, ownerVal)
                .getResultList();
    }

    @Transactional
    public List<PhotoEntity> findPhotosByAuctionId(int id) {
        AuctionEntity auctionEntity = em.find(AuctionEntity.class, id);
        List<PhotoEntity> list = auctionEntity.getPhotoEntityList();
        if (list.isEmpty()) {
            PhotoEntity photo = new PhotoEntity("https://www.computerhope.com/jargon/e/error.gif");
            photo.setId(0);
            list.add(photo);
        }
        return list;
    }

    @Transactional
    public boolean isPhotoInAuction(int id) {
        return !em.find(AuctionEntity.class, id).getPhotoEntityList().isEmpty();
    }

    @Transactional
    public boolean isParameterInAuction(int id) {
        return !em.find(AuctionEntity.class, id).getAuctionParameterList().isEmpty();
    }

    public List<AuctionParameterValue> findParametersByAuctionId(int id) {
        AuctionEntity auctionEntity = em.find(AuctionEntity.class, id);
        List<AuctionParameterValue> list = auctionEntity.getAuctionParameterList();
        if (list.isEmpty()) {
            ParameterEntity parameterEntity = new ParameterEntity("EMPTY");
            parameterEntity.setId(0);
            AuctionEntity auctionEntity1 = new AuctionEntity();
            auctionEntity1.setId(0);
            AuctionParameterValue parameter = new AuctionParameterValue(parameterEntity, "EMPTY");
            parameter.setAuctionEntity(auctionEntity1);
            list.add(parameter);
        }
        return list;
    }

    public AuctionEntity findAuctionById(int id) {
        var auction = em.find(AuctionEntity.class, id);
        if (auction == null) auction = new AuctionEntity();
        return auction;
    }
}