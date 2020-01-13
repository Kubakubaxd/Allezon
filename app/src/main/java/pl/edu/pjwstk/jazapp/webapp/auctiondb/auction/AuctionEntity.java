package pl.edu.pjwstk.jazapp.webapp.auctiondb.auction;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import pl.edu.pjwstk.jazapp.webapp.auctiondb.auction_parameter.AuctionParameterValue;
import pl.edu.pjwstk.jazapp.webapp.auctiondb.auction_photo.PhotoEntity;
import pl.edu.pjwstk.jazapp.webapp.auctiondb.section.SectionEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "auction")
public class AuctionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String description;

    @JoinColumn(name = "section_id")
    @OneToOne
    private SectionEntity section;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "auctionEntity", cascade = CascadeType.PERSIST)
    private List<PhotoEntity> photoEntityList;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "auctionEntity", cascade = CascadeType.PERSIST)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<AuctionParameterValue> AuctionParameterList;

    private int price;

    private String owner;

    public AuctionEntity(String description, SectionEntity section, int price, String owner) {
        this.description = description;
        this.section = section;
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
    public SectionEntity getSection() {
        return section;
    }
    public void setSection(SectionEntity section) {
        this.section = section;
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
}
