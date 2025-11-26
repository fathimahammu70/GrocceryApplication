package testscripts;

	import java.io.IOException;

	import org.testng.annotations.Test;

import automationCore.Base;
import pages.LoginPage;
import utilities.ExcelUtility;

	public class LoginTest extends Base {
	 @Test
	public void verifyWhetherUserIsAbleToLoginWithValidcredentials() throws IOException {
		 String usernamevalue=ExcelUtility.getStringData(0, 0, "Loginpage");
		 String passwordvalue=ExcelUtility.getStringData(0, 1, "Loginpage");
		 LoginPage loginPage=new LoginPage(driver);
			loginPage.enterUserNameOnUserNameField(usernamevalue);
			loginPage.enterPasswordOnPasswordField(passwordvalue);
			loginPage.loginButtonClick();
		}
	 @Test
	 public void verifyWhetherUserIsAbleToLoginWithValidUsernameAndInvalidPassword() throws IOException {
		 String usernamevalue=ExcelUtility.getStringData(1, 0, "Loginpage");
		 String passwordvalue=ExcelUtility.getStringData(1, 1, "Loginpage");
		 LoginPage loginPage=new LoginPage(driver);
			loginPage.enterUserNameOnUserNameField(usernamevalue);
			loginPage.enterPasswordOnPasswordField(passwordvalue);
			loginPage.loginButtonClick();
	 }
	 @Test
	 public void verifyWhetherUserIsAbleToLoginWithInvalidUsernameAndValidPassword() throws IOException {
		 String usernamevalue=ExcelUtility.getStringData(2, 0, "Loginpage");
		 String passwordvalue=ExcelUtility.getStringData(2, 1, "Loginpage");
		 LoginPage loginPage=new LoginPage(driver);
			loginPage.enterUserNameOnUserNameField(usernamevalue);
			loginPage.enterPasswordOnPasswordField(passwordvalue);
			loginPage.loginButtonClick();
	 }
	 @Test
		public void verifyWhetherUserIsAbleToLoginWithInvalidUsernameAndInvalidPassword() throws IOException {
		 String usernamevalue=ExcelUtility.getStringData(3, 0, "Loginpage");
		 String passwordvalue=ExcelUtility.getStringData(3, 1, "Loginpage");
		 LoginPage loginPage=new LoginPage(driver);
			loginPage.enterUserNameOnUserNameField(usernamevalue);
			loginPage.enterPasswordOnPasswordField(passwordvalue);
			loginPage.loginButtonClick();
			
		}
	}


