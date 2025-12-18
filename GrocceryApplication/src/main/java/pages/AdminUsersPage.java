package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUsersPage {
	public WebDriver driver;

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),' New')]")
	WebElement newLink;
	@FindBy(id = "username")
	WebElement userName;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(id = "user_type")
	WebElement userType;
	@FindBy(xpath = "//button[@type='submit' and @name='Create']")
	WebElement saveButton;
	@FindBy(xpath = "//a[contains(text(),' Search')]")
	WebElement searchLink;
	@FindBy(id = "un")
	WebElement searchUserName;
	@FindBy(name = "Search")
	WebElement searchButton;
	@FindBy(xpath = "//a[contains(text(),' Reset')]")
	WebElement resetLink;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible' or @class='alert alert-danger alert-dismissible']")
	WebElement userAddAlert;
	@FindBy(xpath = "//h4[text()='Admin Users']")
	WebElement searchAdminUsersResultTab;
	@FindBy(xpath = "//h4[text()='Admin Users']//ancestor::div[@class='card']")
	WebElement adminUsersList;

	public AdminUsersPage clickOnNewButton() {
		newLink.click();
		return this;
	}

	public AdminUsersPage enterNewUserNameOnUserNameField(String newUserNameValue) {
		userName.sendKeys(newUserNameValue);
		return this; 
	}

	public AdminUsersPage enterNewPasswordOnPasswordField(String newPasswordValue) {
		password.sendKeys(newPasswordValue);
		return this;
	}

	public AdminUsersPage selectTheUserType(String userTypeValue) {
		Select select = new Select(userType);
		select.selectByVisibleText(userTypeValue);
		return this;
	}

	public AdminUsersPage saveButtonClick() {
		saveButton.click();
		return this;
	}

	public AdminUsersPage searchButtonClick() {
		searchLink.click();
		return this;
	}

	public AdminUsersPage enterTheUserNameToSearch(String userNameValue) {
		searchUserName.sendKeys(userNameValue);
		return this;
	}

	public AdminUsersPage searchButtonClickToCheckUserName() {
		searchButton.click();
		return this;
	}

	public AdminUsersPage resetButtonClick() {
		resetLink.click();
		return this;
	}

	public boolean userAddedAlertMessage() {
		return userAddAlert.isDisplayed();
	}

	public boolean isSearchAdminUsersResultTabDisplayed() {
		return searchAdminUsersResultTab.isDisplayed();
	}

	public boolean isAdminUsersListDisplayed() {
		return adminUsersList.isDisplayed();
	}

}