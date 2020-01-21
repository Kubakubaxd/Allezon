package pl.edu.pjwstk.jazapp.webapp.baskets.basket;

import pl.edu.pjwstk.jazapp.webapp.baskets.basketbucket.BasketBucketValue;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "basket")
public class BasketEntity {
    @Id
    private int id;

    private String userpsqla;

    private String creationdate;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "basketEntity", cascade = CascadeType.PERSIST)
    private List<BasketBucketValue> basketBucketEntities;

    public BasketEntity() {
    }

    public BasketEntity(String userpsqla, String creationdate) {
        this.userpsqla = userpsqla;
        this.creationdate = creationdate;
    }

    public String getUserpsqla() {
        return userpsqla;
    }

    public void setUserpsqla(String userpsqla) {
        this.userpsqla = userpsqla;
    }

    public String getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(String creationdate) {
        this.creationdate = creationdate;
    }

    public List<BasketBucketValue> getBasketBucketEntities() {
        return basketBucketEntities;
    }

    public void setBasketBucketEntities(List<BasketBucketValue> basketBucketEntities) {
        this.basketBucketEntities = basketBucketEntities;
    }
}
