package pl.edu.pjwstk.jazapp.webapp.auction_photo;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Named
@RequestScoped
//@ApplicationScoped
public class PhotoRepository {
    @PersistenceContext
    private EntityManager em;


    @Transactional
    public void createPhoto(PhotoEntity photoEntity){
        em.persist(photoEntity);
    }

}
