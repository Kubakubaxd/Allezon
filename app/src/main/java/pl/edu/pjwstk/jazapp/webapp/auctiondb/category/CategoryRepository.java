package pl.edu.pjwstk.jazapp.webapp.auctiondb.category;

import pl.edu.pjwstk.jazapp.webapp.auctiondb.section.SectionEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Named
@RequestScoped
public class CategoryRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void create(String name, int section_id) {
        SectionEntity sectionEntity = em.find(SectionEntity.class, section_id);
        CategoryEntity categoryEntity = new CategoryEntity(name, sectionEntity);
        em.persist(categoryEntity);
    }

    @Transactional
    public void edit(int id, String name, int section_id) {
        if (isExist(id)) {
            SectionEntity sectionEntity = em.find(SectionEntity.class, section_id);
            CategoryEntity categoryEntity = em.find(CategoryEntity.class, id);
            categoryEntity.setName(name);
            categoryEntity.setSectionEntity(sectionEntity);
            em.merge(categoryEntity);
        }
    }

    @Transactional
    public boolean isExist(int id) {
        CategoryEntity search = em.find(CategoryEntity.class, id);
        return search != null;
    }

    @Transactional
    public List<CategoryEntity> getAllSections() {
        return em.createQuery("FROM CategoryEntity ", CategoryEntity.class).getResultList();
    }
}
