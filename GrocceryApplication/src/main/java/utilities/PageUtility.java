package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {//methods that hlps in pages for its performance 
	public void selectDropdownWithValue(WebElement element, String value) {

		Select object = new Select(element);
		object.selectByValue(value);
	}

	public void selectDropdownByVisibleText(WebElement element, String text) {
		Select textvalue = new Select(element);
		textvalue.selectByVisibleText(text);
	}

	public void selectDropdownByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	public void rightClick(WebElement element, WebDriver driver) {
		Actions action = new Actions(driver);
		action.contextClick(element).build().perform();
	}

	public void mouseHover(WebElement element, WebDriver driver) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}


}