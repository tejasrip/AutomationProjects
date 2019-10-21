import com.app.pages.HomePage;
import com.app.pages.OrdersPage;
import com.utils.PropertyUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppHomePageTest extends BaseTest {

    private Logger logger = LogManager.getLogger(this.getClass());

    private HomePage homePage;
    private OrdersPage ordersPage;

    @BeforeTest
    public void setUp() {
        homePage = new HomePage();
    }

    @Test(priority = 1)
    public void validateHomePage() {
        logger.info("==========Validate Home Page of APP start=============");
        Assert.assertEquals(homePage.validateHomePageElements(), true);
        Assert.assertEquals(homePage.isOperatingRoomDrpdwnDisplayed(), true);
    }

    @Test(priority = 2)
    public void navigateToOrdersPage() {
        logger.info("==========Navigate to Orders page =============");
        homePage.navigateToOrdersOfOperatingRoom(PropertyUtils.getProperty("operatingRoom.name"));
    }

    @Test(priority = 3)
    public void selectOrder() {
        logger.info("==========Select Order=============");
        ordersPage.selectOrder(PropertyUtils.getProperty("surgeon.name"), PropertyUtils.getProperty("surgery.time"));
        ordersPage.isSurgeryTimeDisplayed();
        ordersPage.isSurgeonNameDisplayed();
    }

    @AfterTest
    public void tearDown() {

    }
}
