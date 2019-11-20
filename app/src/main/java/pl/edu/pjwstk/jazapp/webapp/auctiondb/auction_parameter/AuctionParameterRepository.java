package pl.edu.pjwstk.jazapp.webapp.auctiondb.auction_parameter;

import pl.edu.pjwstk.jazapp.webapp.auctiondb.auction.AuctionEntity;
import pl.edu.pjwstk.jazapp.webapp.auctiondb.parameter.ParameterEntity;

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
        AuctionEntity auctionEntity = em.find(AuctionEntity.class, auction_id);
        ParameterEntity parameterEntity = em.find(ParameterEntity.class, parameter_id);

        AuctionParameterValue entity = new AuctionParameterValue(auctionEntity,parameterEntity,value);
        em.persist(entity);
    }

    @Transactional
    public void created(int auction_id, int parameter_id, String value){
        AuctionParameterValue entity = new AuctionParameterValue();
        em.persist(entity);
    }

}
