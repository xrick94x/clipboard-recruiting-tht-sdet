package amazon.driver;

import amazon.config.EnvFactory;
import amazon.factories.DriverFactory;
import org.openqa.selenium.WebDriver;
import com.typesafe.config.Config;

public class Driver {

    public static Config config;
    public static String HOME_PAGE_URL;
    // public static DriverFactory driverFactory;
    public static WebDriver driver;

    public static void initialiseDriver() {

        Config config = EnvFactory.getInstance().getConfig();
        HOME_PAGE_URL = config.getString("HOME_PAGE_URL");
        driver = DriverFactory.getSeleniumDriver();
    }

}
