package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationCore.Base;
import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	HomePage home;
	@Test(priority = 1, description = "Verify user can login with valid credentials", groups = { "smoke" })
	public void verifyWhetherUserIsAbleToLoginWithValidcredentials(String usernamevalue, String passwordvalue) throws IOException {
		/*String usernamevalue = ExcelUtility.getStringData(0, 0, "Loginpage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "Loginpage");*/
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		home=loginPage.SignInClick();
		boolean dashboardDisplayed = loginPage.isDashboardDisplayed();
		Assert.assertTrue(dashboardDisplayed, Constants.VALIDCREDENTIALSERROR);
	}

	@Test(priority = 2, description = "Verify user is able to login with valid username and invalid password")
	public void verifyWhetherUserIsAbleToLoginWithValidUsernameAndInvalidPassword(String usernamevalue, String passwordvalue) throws IOException {
		/*String usernamevalue = ExcelUtility.getStringData(1, 0, "Loginpage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "Loginpage");*/
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue).SignInClick();
		String expected = "7rmart supermarket";
		String actual = loginPage.getTheTitle();
		Assert.assertEquals(actual, expected, Constants.VALIDUSERNAMEANDINVALIDPASSWORD);
	}

	@Test(priority = 3, description = "Verify user is able to login with invalid username and valid password")
	public void verifyWhetherUserIsAbleToLoginWithInvalidUsernameAndValidPassword(String usernamevalue, String passwordvalue) throws IOException {
		/*String usernamevalue = ExcelUtility.getStringData(2, 0, "Loginpage");
		String passwordvalue = ExcelUtility.getStringData(2, 1, "Loginpage");*/
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue).SignInClick();
		String expected = "Sign in to start your session";
		String actual = loginPage.getTheHeading();
		Assert.assertEquals(actual, expected, Constants.INVALIDUSERNAMEANDVALIDPASSWORD);
	}

	@Test(priority = 4, description = "Verify user is able to login with invalid credentials", groups = {
			"smoke" }, dataProvider = "loginProvider")
	public void verifyWhetherUserIsAbleToLoginWithInvalidUsernameAndInvalidPassword(String usernamevalue,
			String passwordvalue) throws IOException {
		/*
		 * String usernamevalue=ExcelUtility.getStringData(3, 0, "Loginpage"); String
		 * passwordvalue=ExcelUtility.getStringData(3, 1, "Loginpage");
		 */
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue).SignInClick();
		String expected = "Sign in to start your session";
		String actual = loginPage.getTheHeading();
		Assert.assertEquals(actual, expected, Constants.INVALIDCREDENTIALSERROR);
	}

	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {

		return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },
				// new Object[] {ExcelUtility.getStringData(3,
				// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
		};
	}
}
