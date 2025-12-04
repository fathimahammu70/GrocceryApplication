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
	@FindBy(xpath = "//button[text()='Sign In']") WebElement signInButton;
	@FindBy(xpath="//p[text()='Dashboard']") WebElement dashboard;
	@FindBy(xpath="//b[text()='7rmart supermarket']") WebElement title;
	@FindBy(xpath="//p[text()='Admin Users']")WebElement adminUsers;
	@FindBy(xpath="//p[text()='Sign in to start your session']") WebElement heading;
	
	
	
	
	public void enterUserNameOnUserNameField(String usernamevalue) {
		userName.sendKeys(usernamevalue);
	}
	public void enterPasswordOnPasswordField(String passwordvalue) {
		password.sendKeys(passwordvalue);
	}
	public void SignInClick() {
		signInButton.click();
	}
	public boolean isDashboardDisplayed() {
		return dashboard.isDisplayed();
	}
	public String getTheTitle() {
		return title.getText();
}
	public boolean isAdminUsersDisplayed() {
		return adminUsers.isDisplayed();
}
	public String getTheHeading() {
		return heading.getText();
		
	}
}


