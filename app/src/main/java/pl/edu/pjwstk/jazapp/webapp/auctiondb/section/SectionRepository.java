package pl.edu.pjwstk.jazapp.webapp.auctiondb.section;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

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

    @Transactional
    public List<SectionEntity> getAllSections(){
        return em.createQuery("FROM SectionEntity ", SectionEntity.class).getResultList();
    }



}
