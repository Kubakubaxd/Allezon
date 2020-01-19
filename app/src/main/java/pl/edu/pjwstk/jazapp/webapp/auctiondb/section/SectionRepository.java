package pl.edu.pjwstk.jazapp.webapp.auctiondb.section;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Named
@RequestScoped
public class SectionRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void create(String name) {
        SectionEntity sectionEntity = new SectionEntity(name);
        em.persist(sectionEntity);
    }

    @Transactional
    public void edit(int id, String name) {
        if (isExist(id)) {
            SectionEntity sectionEntity = em.find(SectionEntity.class, id);
            sectionEntity.setName(name);
            em.merge(sectionEntity);
        }
    }

    @Transactional
    public boolean isExist(int id) {
        SectionEntity search = em.find(SectionEntity.class, id);
        return search != null;
    }

    @Transactional
    public List<SectionEntity> getAllSections() {
        return em.createQuery("FROM SectionEntity ", SectionEntity.class).getResultList();
    }
}
