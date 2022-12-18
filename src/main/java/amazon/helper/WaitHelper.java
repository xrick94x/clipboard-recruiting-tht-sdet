package amazon.helper;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {

    public WebDriverWait wait;

    private long timeToWaitInSeconds = 60;

    public WaitHelper(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeToWaitInSeconds));
    }

    public void setTimeToWaitInSeconds(int seconds) {
        this.timeToWaitInSeconds = seconds;
    }

    public boolean waitForVisibilityOf(WebElement element) {
        return wait.until(visibilityOf(element)) != null ? true : false;
    }

    public boolean waitForElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element)) != null ? true : false;
    }

    public boolean waitForInvisibilityOf(WebElement element) {
        return wait.until(ExpectedConditions.invisibilityOf(element)) != null ? true : false;
    }

}
