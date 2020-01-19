package pl.edu.pjwstk.jazapp.webapp.auctiondb.category;

import pl.edu.pjwstk.jazapp.webapp.auctiondb.section.SectionEntity;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "section_id")
    private SectionEntity sectionEntity;

    public CategoryEntity(String name, SectionEntity sectionEntity) {
        this.name = name;
        this.sectionEntity = sectionEntity;
    }

    public CategoryEntity() {

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

    public SectionEntity getSectionEntity() {
        return sectionEntity;
    }

    public void setSectionEntity(SectionEntity sectionEntity) {
        this.sectionEntity = sectionEntity;
    }
}
