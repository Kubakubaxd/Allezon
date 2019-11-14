package pl.edu.pjwstk.jazapp.webapp.auctiondb.parameter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class ParameterRequest {
    private int id;
    private String name;
    private int newId;

    public int getNewId() {
        return newId;
    }
    public void setNewId(int newId) {
        this.newId = newId;
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
