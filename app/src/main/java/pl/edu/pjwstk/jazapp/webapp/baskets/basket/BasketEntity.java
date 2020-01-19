package pl.edu.pjwstk.jazapp.webapp.baskets.basket;

import pl.edu.pjwstk.jazapp.webapp.baskets.basketbucket.BasketBucketId;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "basket")
public class BasketEntity {
    @Id
    private String owner;

    private String creationdate;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "basketEntity", cascade = CascadeType.PERSIST)
    private List<BasketBucketId> basketBucketEntities;

    public BasketEntity() {
    }

    public BasketEntity(String owner, String creationdate) {
        this.owner = owner;
        this.creationdate = creationdate;
    }

    public String getUserpsqla() {
        return owner;
    }

    public void setUserpsqla(String userpsqla) {
        this.owner = userpsqla;
    }

    public String getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(String creationdate) {
        this.creationdate = creationdate;
    }

    public List<BasketBucketId> getBasketBucketEntities() {
        return basketBucketEntities;
    }

    public void setBasketBucketEntities(List<BasketBucketId> basketBucketEntities) {
        this.basketBucketEntities = basketBucketEntities;
    }
}
