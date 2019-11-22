package pl.edu.pjwstk.jazapp.webapp.auctiondb.auction_photo;

import pl.edu.pjwstk.jazapp.webapp.auctiondb.auction.AuctionEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Named
@RequestScoped
public class PhotoRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void create(PhotoEntity photoEntity) {
        em.persist(photoEntity);
    }

    @Transactional
    public void create(int auction_id, String link) {
        AuctionEntity auctionEntity = em.find(AuctionEntity.class, auction_id);
        PhotoEntity photoEntity =  new PhotoEntity(link, auctionEntity);
        em.persist(photoEntity);
    }

    @Transactional
    public boolean isExist(int auction_id) {
        PhotoEntity search = em.find(PhotoEntity.class, auction_id);
        return !(search == null);
    }

    @Transactional
    public void editLink(String link, int auction_id) {
        if (isExist(auction_id)) {
            PhotoEntity photoEntity = em.find(PhotoEntity.class, auction_id);
            photoEntity.setLink(link);
            em.persist(photoEntity);
        }
    }

//    @Transactional
//    public void editAuction_Id(int new_id, int auction_id) {
//        if (isExist(auction_id)) {
//            PhotoEntity photoEntity = em.find(PhotoEntity.class, auction_id);
//
//            photoEntity.getAuctionEntity()
//            em.persist(photoEntity);
//        }
//    }


//    public List<PhotoEntity> getPhotosList(int idOfAuction){
//        return em.createQuery("SELECT c FROM PhotoEntity c WHERE c.auctionEntity.id = :idauction", PhotoEntity.class).setParameter("idauction", idOfAuction).getResultList();
//    }
}
