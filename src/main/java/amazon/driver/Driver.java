package amazon.driver;

import amazon.choices.Tools;
import amazon.config.EnvFactory;
import amazon.factories.DriverFactory;
import amazon.factories.PageFactory;
import org.openqa.selenium.WebDriver;
import com.typesafe.config.Config;

public class Driver {

    public static Config config;
    public static String HOME_PAGE_URL;
    public static WebDriver webDriver;
    public static PageFactory pageFactory;
    public static Tools TOOL;

    public static void initialiseDriver() {

        Config config = EnvFactory.getInstance().getConfig();
        HOME_PAGE_URL = config.getString("HOME_PAGE_URL");
        webDriver = DriverFactory.getDriver();
        pageFactory = PageFactory.getPageFactory(webDriver);
        TOOL = Tools.parse(config.getString("TOOL"));
    }

}
