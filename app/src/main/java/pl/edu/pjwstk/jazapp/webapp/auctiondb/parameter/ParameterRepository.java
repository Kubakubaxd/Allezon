package pl.edu.pjwstk.jazapp.webapp.auctiondb.parameter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named
@RequestScoped
public class ParameterRepository {
    @PersistenceContext
    private EntityManager em;

    public boolean isExist(int id) {
        ParameterEntity search = em.find(ParameterEntity.class, id);
        return !(search == null);
    }

    public void create(String name) {
        ParameterEntity parameterEntity = new ParameterEntity(name);
        em.persist(parameterEntity);
    }

    public void editName(int id, String name) {
        if (isExist(id)) {
            ParameterEntity parameterEntity = em.find(ParameterEntity.class, id);
            parameterEntity.setName(name);
            em.persist(parameterEntity);
        }
    }

    public void editId(int id, int newId){
        if (isExist(id)) {
            ParameterEntity parameterEntity = em.find(ParameterEntity.class, id);
            parameterEntity.setId(newId);
            em.persist(parameterEntity);
        }
    }
}
