package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	@FindBy(name="username") WebElement userName;
	@FindBy(name="password") WebElement password;
	@FindBy(xpath = "//button[text()='Sign In']") WebElement loginbutton;
	
	
	
	
	public void enterUserNameOnUserNameField(String usernamevalue) {
		userName.sendKeys(usernamevalue);
	}
	public void enterPasswordOnPasswordField(String passwordvalue) {
		password.sendKeys(passwordvalue);
	}
	public void loginButtonClick() {
		loginbutton.click();
	}
}



