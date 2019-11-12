package pl.edu.pjwstk.jazapp.webapp.auctiondb.section;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class SectionModel {
    @Inject
    SectionRequest sectionRequest;
    @Inject
    SectionRepository sectionRepository;

    public void createSection(){
        SectionEntity sectionEntity = new SectionEntity(sectionRequest.getName());
        sectionRepository.createSection(sectionEntity);
    }

    public boolean isSectionExist(int id){
        return sectionRepository.isSectionExist(id);
    }
}
