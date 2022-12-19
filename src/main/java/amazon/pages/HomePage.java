package amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import amazon.helper.BasePage;

public class HomePage extends BasePage {

    @FindBy(how = How.XPATH, using = "//div[@id='nav-main']//div[@class='nav-left']//span")
    private WebElement dashboardNavigation;

    public void clickMenu() {

    }

}
