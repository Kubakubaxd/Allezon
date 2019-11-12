import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import pl.edu.pjwstk.jazapp.webapp.auctiondb.section.SectionEntity;
import pl.edu.pjwstk.jazapp.webapp.auctiondb.section.SectionRepository;

@RunWith(MockitoJUnitRunner.class)
public class SectionTest {

    @Test
    public void test1(){
        SectionRepository auctionRepository = new SectionRepository();
        SectionEntity sectionEntity = new SectionEntity("XD");

        auctionRepository.createSection();

    }

}
