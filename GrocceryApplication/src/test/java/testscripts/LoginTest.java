package testscripts;

	import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.LoginPage;
import utilities.ExcelUtility;

	public class LoginTest extends Base {
	 @Test
	public void verifyWhetherUserIsAbleToLoginWithValidcredentials() throws IOException {
		 String usernamevalue=ExcelUtility.getStringData(10, 0, "Loginpage");
		 String passwordvalue=ExcelUtility.getStringData(0, 1, "Loginpage");
		 LoginPage loginPage=new LoginPage(driver);
			loginPage.enterUserNameOnUserNameField(usernamevalue);
			loginPage.enterPasswordOnPasswordField(passwordvalue);
			loginPage.SignInClick();
			boolean dashboardDisplayed=loginPage.isDashboardDisplayed();
			Assert.assertTrue(dashboardDisplayed, "user was unable to login with valid credentials.");
		}
	 @Test
	 public void verifyWhetherUserIsAbleToLoginWithValidUsernameAndInvalidPassword() throws IOException {
		 String usernamevalue=ExcelUtility.getStringData(1, 0, "Loginpage");
		 String passwordvalue=ExcelUtility.getStringData(1, 1, "Loginpage");
		 LoginPage loginPage=new LoginPage(driver);
			loginPage.enterUserNameOnUserNameField(usernamevalue);
			loginPage.enterPasswordOnPasswordField(passwordvalue);
			loginPage.SignInClick();
			String expected="7rmart supermarke";
			String actual=loginPage.getTheTitle();
			Assert.assertEquals(actual, expected,"user was able to login with invalid password.");
	 }
	 @Test
	 public void verifyWhetherUserIsAbleToLoginWithInvalidUsernameAndValidPassword() throws IOException {
		 String usernamevalue=ExcelUtility.getStringData(2, 0, "Loginpage");
		 String passwordvalue=ExcelUtility.getStringData(2, 1, "Loginpage");
		 LoginPage loginPage=new LoginPage(driver);
			loginPage.enterUserNameOnUserNameField(usernamevalue);
			loginPage.enterPasswordOnPasswordField(passwordvalue);
			loginPage.SignInClick();
			boolean adminusersDisplayed=loginPage.isAdminUsersDisplayed();
			Assert.assertTrue(adminusersDisplayed, "user was unable to login with invalid username");
	 }
	 @Test
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


