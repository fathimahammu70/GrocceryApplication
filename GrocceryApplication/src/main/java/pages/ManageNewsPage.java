package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement searchNewsField;
	@FindBy(xpath = "//a[contains(text(),'Search')]")
	WebElement searchButton;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchResultButton;
	@FindBy(xpath = "//input[@name='un']")
	WebElement searchTile;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	WebElement resetButton;
	@FindBy(xpath = "//table[contains(@class,'table')]")
	WebElement newsTable;
	@FindBy(xpath = "//div[@class='card-body table-responsive p-0']/table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]")
	WebElement newsDisplayedList;
	@FindBy(xpath = "//button[@name='create']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertNewsCreatedSuccecssfully;

	public ManageNewsPage clickNewButton() {
		newButton.click();
		return this;
	}

	public ManageNewsPage enterTheNews(String newsvalue) {
		searchNewsField.sendKeys(newsvalue);
		return this;
	}

	public ManageNewsPage clickSaveButton() {
		saveButton.click();
		return this;
	}

	public ManageNewsPage clickSearchButton() {
		searchButton.click();
		return this;
	}

	public ManageNewsPage enterTitleToSearch(String titlevalue) {
		searchTile.sendKeys(titlevalue);
		return this;
	}

	public ManageNewsPage clickResetButton() {
		resetButton.click();
		return this;
	}

	public String newsDisplayedList() {
		return newsDisplayedList.getText();
	}

	public boolean isNewsListDisplayed() {
		return newsTable.isDisplayed();
	}

	public ManageNewsPage clickSearchResultButton() {
		searchResultButton.click();
		return this;
	}

	public boolean newsCreatedAlert() {
		return alertNewsCreatedSuccecssfully.isDisplayed();

	}

}