package objecgt_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
//	Autohealing
	@FindAll({ 
			@FindBy(name = "user_name2"), 
			@FindBy(css = "input[type='text']") 
			})
	private WebElement un;
}
