package pl.edu.pjwstk.jazapp.webapp.auctiondb.section;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class SectionController {
    @Inject
    SectionRequest sectionRequest;
    @Inject
    SectionRepository sectionRepository;

    public void create() {
        sectionRepository.create(sectionRequest.getName());
    }
    public void edit() {
        sectionRepository.edit(sectionRequest.getId(), sectionRequest.getName());
    }
}
