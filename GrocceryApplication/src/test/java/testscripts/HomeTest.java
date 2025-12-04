package testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import automationCore.Base;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
 
public class HomeTest extends Base{

		
		@Test
		public void verifyWhetherUserIsAbleToSuccessfullyLogout() throws IOException {
			String usernamevalue=ExcelUtility.getStringData(0, 0, "Loginpage");
			String passwordvalue=ExcelUtility.getStringData(0, 1, "Loginpage");
			LoginPage loginPage =new LoginPage(driver);
			loginPage.enterUserNameOnUserNameField(usernamevalue);
			loginPage.enterPasswordOnPasswordField(passwordvalue);
			loginPage.SignInClick();
			HomePage homepg = new HomePage(driver);
			homepg.adminButtonClick();
			homepg.logoutButtonClick();
			
		}

	}

