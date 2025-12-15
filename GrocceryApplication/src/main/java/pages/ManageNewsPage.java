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
	    @FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement newButton;
	    @FindBy(xpath="//textarea[@id='news']") WebElement searchNewsField;
	    @FindBy(xpath ="//a[contains(text(),'Search')]") WebElement searchButton;
	    @FindBy(xpath="//button[@name='Search']") WebElement searchResultButton;
	    @FindBy(xpath="//input[@name='un']")WebElement searchTile;
	    @FindBy(xpath="//a[@class='btn btn-rounded btn-warning']") WebElement  resetButton;
	    @FindBy(xpath = "//table[contains(@class,'table')]") WebElement newsTable;
	    @FindBy(xpath ="//button[@name='create']") WebElement saveButton;
	    @FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alertNewsCreatedSuccecssfully;
	   
	    
	    public void clickNewButton() {
	        newButton.click();
	    }
	    public void enterTheNews(String newsvalue) {
	        searchNewsField.sendKeys(newsvalue);
	    }
	    public void clickSaveButton() {
	    	saveButton.click();
	    }
	    
	    public void clickSearchButton() {
	        searchButton.click();
	    }
	    public void enterTitleToSearch(String titlevalue) {
	    	searchTile.sendKeys(titlevalue);
	    }
	    public void clickResetButton() {
	        resetButton.click();
	    }
	    public boolean isNewsListDisplayed() {
	        return newsTable.isDisplayed();
	    }
	    public void clickSearchResultButton() {
	    	searchResultButton.click();
	    }
	   

	    public boolean newsCreatedAlert() {
	    	return alertNewsCreatedSuccecssfully.isDisplayed();
	    	
	    }

}