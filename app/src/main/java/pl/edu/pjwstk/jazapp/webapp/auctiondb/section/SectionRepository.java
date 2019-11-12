package pl.edu.pjwstk.jazapp.webapp.auctiondb.section;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Named
@RequestScoped
//@ApplicationScoped
public class SectionRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void createSection(){
        SectionEntity sectionEntity = new SectionEntity("hehe");
        em.persist(sectionEntity);
    }

    @Transactional
    public void createSection(SectionEntity sectionEntity){
        em.persist(sectionEntity);
    }

    @Transactional
    public boolean isSectionExist(int id){
        SectionEntity search = em.find(SectionEntity.class, id);
        return search != null;
    }



}
