package pl.edu.pjwstk.jazapp.webapp.baskets.basket;

import pl.edu.pjwstk.jazapp.webapp.baskets.basketbucket.BasketBucketValue;
import pl.edu.pjwstk.jazapp.webapp.session.SessionAsk;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

@ApplicationScoped
public class BasketRepository {
    @Inject
    SessionAsk session;
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void create(String owner) {
        BasketEntity basket = new BasketEntity(owner, getCurrentDate());
        em.persist(basket);
    }

    private String getCurrentDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        return dtf.format(now);
    }

    @Transactional
    public void updateDate(String owner) {
        var basketEntity = em.find(BasketEntity.class, owner);
        if (basketEntity != null) {
            basketEntity.setCreationdate(getCurrentDate());
            em.persist(basketEntity);
        }
    }

    @Transactional
    public void removeIfDateExpired(String owner) {
        BasketEntity basketEntity = em.find(BasketEntity.class, owner);
        if (checkDate(basketEntity)) remove(owner);
    }

    public void remove(String owner) {
        BasketEntity basketEntity = em.find(BasketEntity.class, owner);
        em.remove(basketEntity);
    }

    private boolean checkDate(BasketEntity basketEntity) {
        int expirationDays = 30;

        var date1 = basketEntity.getCreationdate().split("/");
        int day1 = Integer.parseInt(date1[0]);
        int month1 = Integer.parseInt(date1[1]);
        int year1 = Integer.parseInt(date1[2]);

        var date2 = getCurrentDate().split("/");
        int day2 = Integer.parseInt(date1[0]);
        int month2 = Integer.parseInt(date1[1]);
        int year2 = Integer.parseInt(date1[2]);

        LocalDate dateBefore = LocalDate.of(year1, month1, day1);
        LocalDate dateAfter = LocalDate.of(year2, month2, day2);
        long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);

        return noOfDaysBetween <= expirationDays;
    }

    public BasketEntity find(String owner) {
        var basketEntity = em.find(BasketEntity.class, owner);
        if (basketEntity == null) return new BasketEntity();
        return basketEntity;
    }

    public List<BasketBucketValue> getBasketBuckets(String owner) {
        BasketEntity basketEntity = find(owner);
        return basketEntity.getBasketBucketEntities();
    }

    public boolean isExist(String owner) {
        return em.find(BasketEntity.class, owner) != null;
    }
}