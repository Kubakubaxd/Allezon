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
    public boolean isExist(int auction_id, int parameter_id) {
        AuctionParameterId auctionParameterId = new AuctionParameterId(auction_id, parameter_id);
        AuctionParameterId search = em.find(AuctionParameterId.class, auctionParameterId);
        return !(search == null);
    }

    @Transactional
    public void create(int auction_id, int parameter_id, String value) {
        if (!isExist(auction_id, parameter_id)) {
            AuctionEntity auctionEntity = em.find(AuctionEntity.class, auction_id);
            ParameterEntity parameterEntity = em.find(ParameterEntity.class, parameter_id);
            if ((auctionEntity != null) && (parameterEntity != null)) {
                System.out.println("Przeszło! <-------------------------------------------------------------------------------------------------------------------------------------------");
                em.persist(new AuctionParameterValue(auctionEntity, parameterEntity, value));
            }
        }
    }

}
