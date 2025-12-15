package testscripts;

	import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.LoginPage;
import utilities.ExcelUtility;

	public class LoginTest extends Base {
	 @Test(priority = 1,description = "Verify user can login with valid credentials",groups = {"smoke"})
	public void verifyWhetherUserIsAbleToLoginWithValidcredentials() throws IOException {
		 String usernamevalue=ExcelUtility.getStringData(0, 0, "Loginpage");
		 String passwordvalue=ExcelUtility.getStringData(0, 1, "Loginpage");
		 LoginPage loginPage=new LoginPage(driver);
			loginPage.enterUserNameOnUserNameField(usernamevalue);
			loginPage.enterPasswordOnPasswordField(passwordvalue);
			loginPage.SignInClick();
			boolean dashboardDisplayed=loginPage.isDashboardDisplayed();
			Assert.assertTrue(dashboardDisplayed, "user was unable to login with valid credentials.");
		}
	 @Test(priority = 2,description = "Verify user is able to login with valid username and invalid password")
	 public void verifyWhetherUserIsAbleToLoginWithValidUsernameAndInvalidPassword() throws IOException {
		 String usernamevalue=ExcelUtility.getStringData(1, 0, "Loginpage");
		 String passwordvalue=ExcelUtility.getStringData(1, 1, "Loginpage");
		 LoginPage loginPage=new LoginPage(driver);
			loginPage.enterUserNameOnUserNameField(usernamevalue);
			loginPage.enterPasswordOnPasswordField(passwordvalue);
			loginPage.SignInClick();
			String expected="7rmart supermarket";
			String actual=loginPage.getTheTitle();
			Assert.assertEquals(actual, expected,"user was able to login with invalid password.");
	 }
	 @Test(priority = 4,description = "Verify user is able to login with invalid username and valid password")
	 public void verifyWhetherUserIsAbleToLoginWithInvalidUsernameAndValidPassword() throws IOException {
		 String usernamevalue=ExcelUtility.getStringData(2, 0, "Loginpage");
		 String passwordvalue=ExcelUtility.getStringData(2, 1, "Loginpage");
		 LoginPage loginPage=new LoginPage(driver);
			loginPage.enterUserNameOnUserNameField(usernamevalue);
			loginPage.enterPasswordOnPasswordField(passwordvalue);
			loginPage.SignInClick();
			String expected = "Sign in to start your session";
		    String actual = loginPage.getTheHeading();
			Assert.assertEquals(actual, expected, "user was unable to login with invalid username");
	 }
	 @Test(priority = 4,description = "Verify user is able to login with invalid credentials",groups = {"smoke"})
		public void verifyWhetherUserIsAbleToLoginWithInvalidUsernameAndInvalidPassword() throws IOException {
		 String usernamevalue=ExcelUtility.getStringData(3, 0, "Loginpage");
		 String passwordvalue=ExcelUtility.getStringData(3, 1, "Loginpage");
		 LoginPage loginPage=new LoginPage(driver);
			loginPage.enterUserNameOnUserNameField(usernamevalue);
			loginPage.enterPasswordOnPasswordField(passwordvalue);
			loginPage.SignInClick();
			String expected="Sign in to start your session";
			String actual=loginPage.getTheHeading();
			Assert.assertEquals(actual, expected,"user was unable to login");
		}
	}


