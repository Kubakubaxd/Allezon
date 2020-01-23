package pl.edu.pjwstk.jazapp.webapp.auctiondb.auction;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import pl.edu.pjwstk.jazapp.webapp.auctiondb.auction_parameter.AuctionParameterValue;
import pl.edu.pjwstk.jazapp.webapp.auctiondb.auction_photo.PhotoEntity;
import pl.edu.pjwstk.jazapp.webapp.auctiondb.category.CategoryEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "auction")
public class AuctionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;

    private String description;

    @JoinColumn(name = "category_id")
    @OneToOne
    private CategoryEntity category;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "auctionEntity", cascade = CascadeType.PERSIST)
    private List<PhotoEntity> photoEntityList;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "auctionEntity", cascade = CascadeType.PERSIST)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<AuctionParameterValue> AuctionParameterList;

//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "auctionEntity", cascade = CascadeType.PERSIST)
//    @Fetch(value = FetchMode.SUBSELECT)
//    private List<BasketBucketValue> basketBucketValueList;

    private int price;

    private String owner;

    public AuctionEntity(String title, String description, CategoryEntity category, int price, String owner) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
        this.owner = owner;
    }

    public AuctionEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity section) {
        this.category = section;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<PhotoEntity> getPhotoEntityList() {
        return photoEntityList;
    }
    public void setPhotoEntityList(List<PhotoEntity> photoEntityList) {
        this.photoEntityList = photoEntityList;
    }
    public String firstPhoto() {
        if (!photoEntityList.isEmpty())
            return photoEntityList.get(0).getLink();
        else
            return "https://www.computerhope.com/jargon/e/error.gif";
    }

    public List<AuctionParameterValue> getAuctionParameterList() {
        return AuctionParameterList;
    }
    public void setAuctionParameterList(List<AuctionParameterValue> auctionParameterList) {
        AuctionParameterList = auctionParameterList;
    }

    public boolean isPhoto() {
        return photoEntityList.isEmpty();
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public List<BasketBucketValue> getBasketBucketValueList() {
//        return basketBucketValueList;
//    }

//    public void setBasketBucketValueList(List<BasketBucketValue> basketBucketValueList) {
//        this.basketBucketValueList = basketBucketValueList;
//    }
}
