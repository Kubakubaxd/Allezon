package pl.edu.pjwstk.jazapp.webapp.auctiondb.section;

import pl.edu.pjwstk.jazapp.webapp.auctiondb.category.CategoryEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "section")
public class SectionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "sectionEntity", cascade = CascadeType.PERSIST)
    private List<CategoryEntity> categoryEntityList;


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

    public List<CategoryEntity> getCategoryEntityList() {
        return categoryEntityList;
    }

    public void setCategoryEntityList(List<CategoryEntity> categoryEntityList) {
        this.categoryEntityList = categoryEntityList;
    }
}
