package pl.edu.pjwstk.jazapp.webapp.auctiondb.parameter;

import javax.persistence.*;

@Entity
@Table(name = "parameter")
public class ParameterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    public ParameterEntity(String name) {
        this.name = name;
    }
    public ParameterEntity() {
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
