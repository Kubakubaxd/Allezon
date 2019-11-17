package pl.edu.pjwstk.jazapp.webapp.auctiondb.auctiontest;

import pl.edu.pjwstk.jazapp.webapp.auctiondb.section.SectionEntity;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "auction")
public class AuctionEntityTest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String description;

    @JoinColumn(name="section_id")
    @OneToOne
    private SectionEntity section;

    private int price;

    public AuctionEntityTest(String description, SectionEntity section, int price) {
        this.description = description;
        this.section = section;
        this.price = price;
    }

    public AuctionEntityTest() {

    }


}
