package amazon.helper;

import org.openqa.selenium.WebElement;

public interface BaseKeyword {

    public void clickOn(WebElement element);

    public void type(WebElement element, String value);

    public void typeUsingAction(WebElement element, String value);

    public void moveToElement(WebElement element);

}
