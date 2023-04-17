package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {
	Actions actions;
	WebDriverWait wait;
	Select select;
	
	public void actionsSendKeys(WebElement element, String text) {
		actions = new Actions(Driver.getDriver());
		actions.sendKeys(element, text).build().perform();
	}
	
	public void waitUntilElementVisible(WebElement element) {
		wait = new WebDriverWait(Driver.getDriver(), 5);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void selectDropDownByValue(WebElement element, String value) {
		select = new Select(element);
		select.selectByValue(value);
	}
}
