package amazon.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import amazon.helper.BasePage;

public class TopNavigation extends BasePage {

    @FindBy(how = How.XPATH, using = "//div[@id='nav-main']//div[@class='nav-left']//span")
    private WebElement hamburgerMenu;

    @FindBy(how = How.XPATH, using = "//a[contains(@data-ref-tag,'nav')]")
    private List<WebElement> menuItemsList;

    @FindBy(how = How.XPATH, using = "//a[@class='hmenu-item']")
    private List<WebElement> submenuItemsList;

    // div[contains(@data-component-type,'s-search-result')]//span[contains(@class,'a-price-whole')]

}
