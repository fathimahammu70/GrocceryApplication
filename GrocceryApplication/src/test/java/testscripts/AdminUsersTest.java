package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constant.Constants;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends Base {
	HomePage home;
	AdminUsersPage adminuser;
	@Test(priority = 1, description = "Verify whether admin is able to add new user")
	public void verifyWhetherAdminIsAbleToAddNewUser() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "loginPage");
		String password = ExcelUtility.getStringData(0, 1, "loginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password);
		home=loginPage.SignInClick();
		
		adminuser=home.clickOnMoreInfoAdminLink();
		
		adminuser.clickOnNewButton();
		FakerUtility fakerUtility = new FakerUtility();
		String newUsername = fakerUtility.createRandomUserName();
		String newPassword = fakerUtility.createFakePassword();
		String userType = ExcelUtility.getStringData(0, 2, "AdminUsersPage");
		adminuser.enterNewUserNameOnUserNameField(newUsername).enterNewPasswordOnPasswordField(newPassword).selectTheUserType(userType).saveButtonClick();
		boolean userAddedAlertDisplayed = adminuser.userAddedAlertMessage();
		Assert.assertTrue(userAddedAlertDisplayed, Constants.ADDNEWUSERERROR);

	}

	@Test(priority = 2, description = "Verify Whether Admin Is Able To Search The Newly AddedUser")
	public void verifyWhetherAdminIsAbleToSearchTheNewlyAddedUser() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "loginPage");
		String password = ExcelUtility.getStringData(0, 1, "loginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password);
		home=loginPage.SignInClick();
		
		adminuser=home.clickOnMoreInfoAdminLink();
		adminuser.searchButtonClick();
		String newUsername = ExcelUtility.getStringData(0, 0, "AdminUsersPage");
		adminuser.enterTheUserNameToSearch(newUsername).searchButtonClickToCheckUserName();
		boolean adminUsersResultTabDisplayed = adminuser.isSearchAdminUsersResultTabDisplayed();
		Assert.assertTrue(adminUsersResultTabDisplayed, Constants.SEARCHNEWUSERERROR);
	}

	@Test(priority = 3, description = "Verify Whether Admin Is Able To Reset The UsersList")
	public void verifyWhetherAdminIsAbleToResetTheUsersList() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "loginPage");
		String password = ExcelUtility.getStringData(0, 1, "loginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password);
		home=loginPage.SignInClick();
		
		home.clickOnMoreInfoAdminLink();
		adminuser.resetButtonClick();
		boolean adminUsersListDisplayed = adminuser.isAdminUsersListDisplayed();
		Assert.assertTrue(adminUsersListDisplayed, Constants.RESETERROR);
	}
}