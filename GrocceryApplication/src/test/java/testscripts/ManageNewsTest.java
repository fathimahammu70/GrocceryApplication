package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import pages.ManageNewsPage;

public class ManageNewsTest extends Base {
	HomePage home;
	ManageNewsPage managenews;

	@Test(description = "verify Whether Admin Is Able To AddNews")
	public void verifyWhetherAdminIsAbleToAddNews() throws IOException {// clickOnMoreInfoLink()
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password);
		home = loginPage.SignInClick();
		managenews = home.clickOnMoreInfomanageNews();
		managenews.clickNewButton();
		String newsvalue = ExcelUtility.getStringData(0, 0, "ManageNewsPage");
		managenews.enterTheNews(newsvalue).clickSaveButton();
		boolean newsCreatedAlert = managenews.newsCreatedAlert();
		Assert.assertTrue(newsCreatedAlert, Constants.ADDNEWSERROR);
	}

	@Test
	public void verifyWhetherAdminIsAbleToSearchNews() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password);
		home = loginPage.SignInClick();
		managenews = home.clickOnMoreInfomanageNews();
		managenews.clickSearchButton();
		String titlevalue = ExcelUtility.getStringData(0, 0, "ManageNewsPage");
		managenews.enterTitleToSearch(titlevalue).clickSearchResultButton();
		String expected = ExcelUtility.getStringData(0, 0, "ManageNewsPage");
		String actual = managenews.newsDisplayedList();
		Assert.assertEquals(actual, expected, Constants.SEARCHNEWSERROR);
	}

	@Test
	public void verifyAdminIsAbleToResetTheNews() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password);
		home = loginPage.SignInClick();
		managenews = home.clickOnMoreInfomanageNews();
		managenews.clickSearchButton();
		String titlevalue = ExcelUtility.getStringData(0, 0, "ManageNewsPage");
		managenews.enterTitleToSearch(titlevalue).clickResetButton();
		boolean newsResetListDisplayed = managenews.isNewsListDisplayed();
		Assert.assertTrue(newsResetListDisplayed, Constants.RESETERROR);

	}
}