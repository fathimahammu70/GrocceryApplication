package testscripts;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import pages.ManageNewsPage;

public class ManageNewsTest extends Base {
	@Test
	public void verifyWhetherAdminIsAbleToAddNews() throws IOException {//clickOnMoreInfoLink()
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(username);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.SignInClick();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMoreInfomanageNews();
		ManageNewsPage managenews=new ManageNewsPage(driver);
		managenews.clickNewButton();
		String newsvalue=ExcelUtility.getStringData(0, 0, "ManageNewsPage");
		managenews.enterTheNews(newsvalue);
		managenews.clickSaveButton();
		boolean newsCreatedAlert = managenews.newsCreatedAlert();
		Assert.assertTrue(newsCreatedAlert, "not possible to create news");			
}
	@Test
	public void verifyWhetherAdminIsAbleToSearchNews() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(username);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.SignInClick();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMoreInfomanageNews();
		ManageNewsPage managenews=new ManageNewsPage(driver);
		managenews.clickSearchButton();
		String titlevalue=ExcelUtility.getStringData(0, 0, "ManageNewsPage");
		managenews.enterTitleToSearch(titlevalue);
		managenews.clickSearchResultButton();
	
	}
	
	
}