package pl.edu.pjwstk.jazapp.webapp.auctiondb.section;

import javax.persistence.*;

@Entity
@Table(name = "section")
public class SectionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    public SectionEntity(String name) {
        this.name = name;
    }

    public SectionEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
