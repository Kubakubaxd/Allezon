package pl.edu.pjwstk.jazapp.webapp.auction_photo;

import javax.persistence.*;

@Entity
@Table(name = "auction_photo")
public class PhotoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String link;

    public PhotoEntity(String name) {
        this.link = name;
    }

    public PhotoEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String name) {
        this.link = name;
    }
}
