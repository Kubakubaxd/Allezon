package pl.edu.pjwstk.jazapp.webapp.auctiondb.auction;


import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class AuctionRequest {
    private int id;
    private String description;
    private int sectionId;
    private int price;
    private String owner;
    private String photoLink;
    private int parameter;
    private String value;
    private String title;
    private String link;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public String getPhotoLink() {
        return photoLink;
    }
    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }
    public int getParameter() {
        return parameter;
    }

    public void setParameter(int parameter) {
        this.parameter = parameter;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
