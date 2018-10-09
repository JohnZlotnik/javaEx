import com.blueRibbon.ex.requests.CheckInRequestHandler;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Dell on 09/10/2018.
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class requestsTest {


    @Test
    public void CheckInTest(){
        CheckInRequestHandler checkInRequestHandler = new CheckInRequestHandler();
        Assert.assertTrue(checkInRequestHandler.checkIn(1, "1234"));
    }

}
