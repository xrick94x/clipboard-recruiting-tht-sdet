package amazon.factories;

import amazon.choices.Tools;
import com.typesafe.config.Config;
import amazon.config.EnvFactory;
import amazon.driver.Driver;
import amazon.helper.BaseKeyword;
import amazon.helper.BasePage;
import amazon.helper.KeywordHelper;
import amazon.helper.SeleniumPage;
import amazon.helper.WaitHelper;

public class PageFactory {
  private static Config config = EnvFactory.getInstance().getConfig();
  private static final Tools TOOL = Tools.parse(config.getString("TOOL"));

  private PageFactory(DriverFactory driver) {
    getWebPage();
    getKeyword();
    getWaitHelper();
  }

  public static PageFactory getPageFactory(DriverFactory driver) {
    return new PageFactory(driver);
  }

  public static BasePage getWebPage() {
    switch (TOOL) {
      case SELENIUM:
        return new SeleniumPage(Driver.driver);
      default:
        throw new IllegalStateException(String.format("%s is not a valid TOOL choice. Pick your TOOL from %s.",
            TOOL, java.util.Arrays.asList(Tools.values())));
    }
  }

  public static BaseKeyword getKeyword() {
    switch (TOOL) {
      case SELENIUM:
        return new KeywordHelper(Driver.driver);
      default:
        throw new IllegalStateException(String.format("%s is not a valid TOOL choice. Pick your TOOL from %s.",
            TOOL, java.util.Arrays.asList(Tools.values())));
    }
  }

  public static WaitHelper getWaitHelper() {
    switch (TOOL) {
      case SELENIUM:
        return new WaitHelper(Driver.driver);
      default:
        throw new IllegalStateException(String.format("%s is not a valid TOOL choice. Pick your TOOL from %s.",
            TOOL, java.util.Arrays.asList(Tools.values())));
    }
  }

}
