import amazon.driver.Driver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;

public class TestSandbox extends Driver {

    @BeforeAll
    static void setupDriver() {
        initialiseDriver();
    }

    @Tag("smokeTest")
    @DisplayName("This test is for demo purpose only to show that the basic code works." +
            "You have to use the best practices that you normally use to design your tests")
    @Test
    void assertThatHomePageTitleIsCorrect() {
        webDriver.get(Driver.HOME_PAGE_URL);
        WebElement element = webDriver.findElement(By.xpath("//div[@id='nav-main']//div[@class='nav-left']//span"));
        pageFactory.waitHelper.waitForElementToBeClickable(element);
        assertEquals(
                "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in",
                webDriver.getTitle());
        pageFactory.webPage.refreshPage();
        pageFactory.webPage.quitBrowser();

    }

}
