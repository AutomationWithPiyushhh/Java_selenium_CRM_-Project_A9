package objecgt_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "user_name")
	private WebElement un;
	
	@FindBy(name = "user_password")
	private WebElement pwd;

	@FindBy(id = "submitButton")
	private WebElement loginBtn;

	public WebElement getUn() {
		return un;
	}

	public WebElement getPwd() {
		return pwd;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

//	Business utility
	public void login() {
		getUn().sendKeys("admin"); 	//loginpage
		getPwd().sendKeys("admin"); //loginpage
		getLoginBtn().click(); 		//loginpage
	}
	
}
