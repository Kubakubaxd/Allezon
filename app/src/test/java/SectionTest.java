import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import pl.edu.pjwstk.jazapp.webapp.auction.AuctionRepository;
import pl.edu.pjwstk.jazapp.webapp.section.SectionEntity;
import pl.edu.pjwstk.jazapp.webapp.section.SectionRepository;

import javax.persistence.EntityManager;

@RunWith(MockitoJUnitRunner.class)
public class SectionTest {

    @Test
    public void test1(){
        SectionRepository auctionRepository = new SectionRepository();
        SectionEntity sectionEntity = new SectionEntity("XD");

        auctionRepository.createSection();

    }

}
