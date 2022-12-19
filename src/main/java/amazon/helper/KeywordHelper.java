package amazon.helper;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class KeywordHelper implements BaseKeyword {

    private WebDriver _driver;

    public KeywordHelper(WebDriver driver) {
        _driver = driver;
    }

    @Override
    public void clickOn(WebElement element) {
        try {
            element.click();
            log.info("Clicked on element");
        } catch (StaleElementReferenceException ex) {
            if (element.isDisplayed()) {
                ((JavascriptExecutor) _driver).executeScript("arguments[0].click();", element);
                log.info("Clicked on element", element.getText());
            } else {
                log.info("Clicked on element");
            }

        }

    }

    @Override
    public void type(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
        log.info("Set values on element", element.getText());
    }

    @Override
    public void typeUsingAction(WebElement element, String value) {
        // TODO Auto-generated method stub

    }

    @Override
    public void moveToElement(WebElement element) {
        // TODO Auto-generated method stub

    }

}
