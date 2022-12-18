package amazon.factories;

import amazon.choices.Tools;
import org.openqa.selenium.WebDriver;
import com.typesafe.config.Config;
import amazon.config.EnvFactory;
import amazon.helper.BaseKeyword;
import amazon.helper.BasePage;
import amazon.helper.KeywordHelper;
import amazon.helper.SeleniumPage;
import amazon.helper.WaitHelper;

public class PageFactory {
  private static Config config = EnvFactory.getInstance().getConfig();
  private static final Tools TOOL = Tools.parse(config.getString("TOOL"));
  private static WebDriver _driver;
  public WaitHelper waitHelper;
  public BasePage webPage;
  public BaseKeyword keyword;

  private PageFactory(WebDriver driver) {
    _driver = driver;
    webPage = getWebPage();
    keyword = getKeyword();
    waitHelper = new WaitHelper(_driver);
  }

  public static PageFactory getPageFactory(WebDriver driver) {
    return new PageFactory(driver);
  }

  private static BasePage getWebPage() {
    switch (TOOL) {
      case SELENIUM:
        return new SeleniumPage(_driver);
      default:
        throw new IllegalStateException(String.format("%s is not a valid TOOL choice. Pick your TOOL from %s.",
            TOOL, java.util.Arrays.asList(Tools.values())));
    }
  }

  private static BaseKeyword getKeyword() {
    switch (TOOL) {
      case SELENIUM:
        return new KeywordHelper(_driver);
      default:
        throw new IllegalStateException(String.format("%s is not a valid TOOL choice. Pick your TOOL from %s.",
            TOOL, java.util.Arrays.asList(Tools.values())));
    }
  }

}
