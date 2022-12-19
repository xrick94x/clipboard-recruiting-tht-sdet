package amazon.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebElement;
import amazon.driver.Driver;
import amazon.factories.PageFactory;
import amazon.helper.BaseKeyword;
import amazon.helper.SeleniumPage;
import amazon.helper.WaitHelper;
import net.jodah.failsafe.internal.util.Assert;

public class ElectronicsPage extends SeleniumPage {

    private BaseKeyword _keywordHelper;
    private WaitHelper _waitHelper;

    private List<WebElement> genericFilterList() {
        return Driver.driver.findElements(By.xpath("//div[@id='s-refinements']//li//span"));
    }

    private List<WebElement> brandRefinementList() {
        return Driver.driver.findElements(By.xpath("//div[@id='brandsRefinements']//li//span"));
    }

    private WebElement sortByButton() {
        return Driver.driver.findElement(By.xpath("//span[@aria-label='Sort by:']"));
    }

    private List<WebElement> sortOptions() {
        return Driver.driver.findElements(By.xpath("//div[@class='a-popover-inner']//a"));
    }

    private List<WebElement> resultsList() {
        return Driver.driver.findElements(By.xpath(
                "//div[contains(@data-component-type,'s-search-result')]//span[contains(@class,'a-price-whole')]"));
    }

    private WebElement defaultSortText() {
        return Driver.driver.findElement(By.xpath("//span[@class='a-dropdown-prompt']"));
    }

    // div[contains(@data-component-type,'s-search-result')]//span[contains(@class,'a-price-whole')]/ancestor::a

    public ElectronicsPage() {
        super(Driver.driver);
        _keywordHelper = PageFactory.getKeyword();
        _waitHelper = PageFactory.getWaitHelper();
    }

    public void selectBrand(String brand) {
        _keywordHelper.clickOn(genericFilterList().stream().filter(x -> x.getText().contains(brand))
                .findAny().get());
        _waitHelper.waitForVisibilityOf(brandRefinementList().stream().filter(x -> x.getText().contains(brand))
                .findAny().get());
        Assert.isTrue(sortByButton().isDisplayed(), "Sort Button exists");
    }

    public void selectSortOption(String option) {
        _keywordHelper.clickOn(sortByButton());
        var optionElement = sortOptions().stream().filter(x -> x.getText().contains(option)).findAny().get();
        _waitHelper.waitForElementToBeClickable(optionElement);
        _keywordHelper.clickOn(optionElement);
        Assert.isTrue(defaultSortText().getText().contains(option), "Option " + option + "is clicked");
    }

    public void selectTVModel(int order) {
        if (order > resultsList().size()) {
            throw new InvalidArgumentException("Order " + order + " is invalid");
        }
        var element = resultsList().get(order);
        var elementToBeClickable = element.findElement(By.xpath("./ancestor::a"));
        _keywordHelper.clickOn(elementToBeClickable);
    }

}
