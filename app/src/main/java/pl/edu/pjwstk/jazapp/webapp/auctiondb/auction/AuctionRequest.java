package pl.edu.pjwstk.jazapp.webapp.auctiondb.auction;


import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.inject.Named;

@Named
@RequestScoped
public class AuctionRequest {
    private int id;
    private String description;
    private int sectionId;
    private int  price;

    public AuctionEntity getAuctionEntity (){
        return new AuctionEntity(description,sectionId,price);
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
    public int getSectionId() {
        return sectionId;
    }
    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}
