package pl.edu.pjwstk.jazapp.webapp.auctiondb.auction;

import javax.persistence.*;

@Entity
@Table(name = "auction")
public class AuctionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String description;
    private int section_id;
    private int price;

    public AuctionEntity(String description, int section_id, int price) {
        this.description = description;
        this.section_id = section_id;
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
    public int getSection_id() {
        return section_id;
    }
    public void setSection_id(int section_id) {
        this.section_id = section_id;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}
