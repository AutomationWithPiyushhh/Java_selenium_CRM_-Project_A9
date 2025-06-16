package generic_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {
	WebDriver driver;

	public WebDriverUtility(WebDriver driver) {
		this.driver = driver;
	}

	public void hover(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}

	public void select(int index, WebElement element) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	public void select(String value,WebElement element) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	public void select(WebElement element, String VisibleText) {
		Select sel = new Select(element);
		sel.selectByVisibleText(VisibleText);
	}
}
