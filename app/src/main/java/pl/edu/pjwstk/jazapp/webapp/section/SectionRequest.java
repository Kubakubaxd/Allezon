package pl.edu.pjwstk.jazapp.webapp.section;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@RequestScoped
public class SectionRequest {
    @Inject
    private SectionRepository sectionRepository;

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

    private int id;
    private String name;
}
