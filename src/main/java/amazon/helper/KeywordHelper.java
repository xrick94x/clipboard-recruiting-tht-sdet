package amazon.helper;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class KeywordHelper implements BaseKeyword {

    private WebDriver _driver;

    public KeywordHelper(WebDriver driver) {
        _driver = driver;
    }

    @Override
    public void clickOn(WebElement element) {
        try {
            element.click();
        } catch (StaleElementReferenceException | ElementClickInterceptedException ex) {
        }

    }

    @Override
    public void type(WebElement element, String value) {

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
