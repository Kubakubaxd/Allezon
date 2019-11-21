package pl.edu.pjwstk.jazapp.webapp.auctiondb.auction;

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

    private int price;

    @JoinColumn(columnDefinition = "auction_id")
    @OneToMany
    private List<PhotoEntity> photoEntityList;


    public AuctionEntity(String description, SectionEntity section, int price) {
        this.description = description;
        this.section = section;
        this.price = price;
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
}
