import com.framework.appium.DriverFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    @BeforeTest
    public void beforeTest() {

    }

    @AfterClass
    public void quitDriver() {
        try {
            DriverFactory.quitDriver();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
