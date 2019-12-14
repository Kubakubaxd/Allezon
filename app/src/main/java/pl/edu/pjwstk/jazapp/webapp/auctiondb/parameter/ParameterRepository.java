package pl.edu.pjwstk.jazapp.webapp.auctiondb.parameter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Named
@RequestScoped
public class ParameterRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public boolean isExist(int id) {
        ParameterEntity search = em.find(ParameterEntity.class, id);
        return !(search == null);
    }

    @Transactional
    public void create(String name) {
        ParameterEntity parameterEntity = new ParameterEntity(name);
        em.persist(parameterEntity);
    }

    @Transactional
    public void edit(ParameterEntity parameter, String name) {
        ParameterEntity parameterEntity = em.find(ParameterEntity.class, parameter.getId());
        parameterEntity.setName(name);
        em.persist(parameterEntity);
    }

    @Transactional
    public List<ParameterEntity> getAllParameters() {
        return em.createQuery("FROM ParameterEntity ", ParameterEntity.class).getResultList();
    }
}
