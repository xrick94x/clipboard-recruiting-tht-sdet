package amazon.helper;

import org.openqa.selenium.WebDriver;

public class SeleniumPage extends BasePage {

    private WebDriver _driver;

    public SeleniumPage(WebDriver driver) {
        _driver = driver;
    }

    @Override
    public void refreshPage() {
        this._driver.navigate().refresh();
    }

    @Override
    public void goBack() {
        this._driver.navigate().back();
    }

    @Override
    public void goForward() {
        this._driver.navigate().forward();
    }

    @Override
    public void quitBrowser() {
        this._driver.quit();
    }

    public void switchToWindow(String windowHandle) {
        this._driver.switchTo().window(windowHandle);
    }

}
