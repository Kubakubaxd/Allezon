package pl.edu.pjwstk.jazapp.webapp.auctiondb.parameter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parameter")
public class ParameterEntity {
    @Id
    private int id;
    private String name;

    public ParameterEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ParameterEntity() { }

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
