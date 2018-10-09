import com.blueRibbon.ex.requests.CheckInRequestHandler;
import com.blueRibbon.ex.requests.CoupunRequestHandler;
import com.blueRibbon.ex.requests.TicketAvailableRequestHandler;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Dell on 09/10/2018.
 *
 */
@RunWith(SpringRunner.class)
public class requestsTest {


    @Test
    public void CheckInTest(){
        CheckInRequestHandler checkInRequestHandler = new CheckInRequestHandler();
        Assert.assertTrue(checkInRequestHandler.checkIn(1, "1234"));
    }

    @Test
    public void TicketTest(){
        TicketAvailableRequestHandler ticketAvailableRequestHandler = new TicketAvailableRequestHandler();
        Assert.assertTrue(ticketAvailableRequestHandler.checkIfTicketAvailable(1));
        Assert.assertFalse(ticketAvailableRequestHandler.checkIfTicketAvailable(4));
    }

    @Test
    public void CoupunTest(){
        CoupunRequestHandler coupunRequestHandler = new CoupunRequestHandler();
        Assert.assertTrue(coupunRequestHandler.checkCoupon("12345"));
        Assert.assertFalse(coupunRequestHandler.checkCoupon("1234"));
    }

}
