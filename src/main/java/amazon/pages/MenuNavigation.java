package amazon.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import amazon.driver.Driver;
import amazon.factories.PageFactory;
import amazon.helper.BaseKeyword;
import amazon.helper.SeleniumPage;
import amazon.helper.WaitHelper;

public class MenuNavigation extends SeleniumPage {

    private BaseKeyword _keywordHelper;
    private WaitHelper _waitHelper;

    private List<WebElement> menuItemsList() {
        return Driver.driver.findElements(By.xpath("//a[contains(@data-ref-tag,'nav')]//div"));
    }

    private List<WebElement> submenuItemsList() {
        return Driver.driver.findElements(By.xpath("//div[@id='hmenu-content']//a[@class='hmenu-item']"));
    }

    private List<WebElement> submenuNavigationList() {
        return Driver.driver.findElements(By.xpath("//div[@id='nav-subnav']//span"));
    }

    // div[contains(@data-component-type,'s-search-result')]//span[contains(@class,'a-price-whole')]

    public MenuNavigation() {
        super(Driver.driver);
        _keywordHelper = PageFactory.getKeyword();
        _waitHelper = PageFactory.getWaitHelper();
    }

    private WebElement hamburgerMenu() {
        return Driver.driver.findElement(By.xpath("//div[@id='nav-main']//div[@class='nav-left']//span"));
    }

    public void selectHamBurgerMenu() {
        _keywordHelper.clickOn(hamburgerMenu());
        _waitHelper.waitForVisibilityOf(menuItemsList().get(0));
    }

    public void selectMenuItem(String item, String waitForItem) {
        _keywordHelper.clickOn(menuItemsList().stream().filter(x -> x.getText().contains(item)).findAny().get());
        _waitHelper.waitForElementToBeClickable(
                submenuItemsList().stream().filter(x -> x.getText().contains(waitForItem)).findAny().get());
    }

    public void selectSubMenuItem(String subMenuItem) {
        var list = submenuItemsList();
        _keywordHelper
                .clickOn(list.stream().filter(x -> x.getText().contains(subMenuItem)).findAny().get());
        _waitHelper.waitForVisibilityOf(submenuNavigationList().get(0));
    }

}
