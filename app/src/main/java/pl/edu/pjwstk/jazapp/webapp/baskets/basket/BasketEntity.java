package pl.edu.pjwstk.jazapp.webapp.baskets.basket;

import pl.edu.pjwstk.jazapp.webapp.baskets.basketbucket.BasketBucketValue;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "basket")
public class BasketEntity {
    @Id
    private String owner;

    private String creationdate;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "basketEntity", cascade = CascadeType.PERSIST)
    private List<BasketBucketValue> basketBucketEntities;

    public BasketEntity() {
    }

    public BasketEntity(String owner, String creationdate) {
        this.owner = owner;
        this.creationdate = creationdate;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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
