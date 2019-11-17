package pl.edu.pjwstk.jazapp.webapp.auctiondb.auction_parameter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Named
@RequestScoped
public class AuctionParameterRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public boolean isExist(int id){
        AuctionParameterId search = em.find(AuctionParameterId.class, id);
        return !(search == null);
    }

    @Transactional
    public void create(AuctionParameterId entity) {em.persist(entity);}

    @Transactional
    public void create(int auction_id, int parameter_id, String value){
        AuctionParameterId entity = new AuctionParameterId(auction_id,parameter_id, value);
        em.persist(entity);
    }

    @Transactional
    public void created(int auction_id, int parameter_id, String value){
        AuctionParameterValue entity = new AuctionParameterValue();
        em.persist(entity);
    }

}
