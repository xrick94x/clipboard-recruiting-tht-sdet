import amazon.driver.Driver;
import amazon.factories.PageFactory;
import amazon.pages.ElectronicsPage;
import amazon.pages.MenuNavigation;
import amazon.pages.TopNavigation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;

public class TestSandbox extends Driver {

    private static MenuNavigation menuNavigation;
    private static ElectronicsPage electronicsPage;

    @BeforeAll
    static void setupDriver() throws Exception {
        initialiseDriver();
        menuNavigation = new MenuNavigation();
        electronicsPage = new ElectronicsPage();
    }

    @Tag("smokeTest")
    @DisplayName("This test is for demo purpose only to show that the basic code works." +
            "You have to use the best practices that you normally use to design your tests")
    @Test
    void assertSecondHighestTVDetailsIsPresent() {
        driver.get(Driver.HOME_PAGE_URL);
        WebElement element = driver.findElement(By.xpath("//div[@id='nav-main']//div[@class='nav-left']//span"));
        PageFactory.getWaitHelper().waitForElementToBeClickable(element);
        assertEquals(
                "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in",
                driver.getTitle());
        menuNavigation.selectHamBurgerMenu();
        menuNavigation.selectMenuItem("TV, Appliances, Electronics", "Televisions");
        menuNavigation.selectSubMenuItem("Televisions");
        electronicsPage.selectBrand("Samsung");
        electronicsPage.selectSortOption("Price: High to Low");
        electronicsPage.selectTVModel(1);
        electronicsPage.switchToAboutItemWindow();
        electronicsPage.validateAboutThisItemText();
        electronicsPage.printAboutThisItemText();
        electronicsPage.quitBrowser();

    }

}
