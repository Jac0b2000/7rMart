package testscripts;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import pages.AdminUsersPage;
import pages.LoginPage;
import pages.MenuPage;
import utilities.ExcelUtility;
import utilities.RandomUtilty;

public class AdminUsersTest extends Base{
	@Test(description = "user is able to create a new admin user")
	public void verifyThatANewAdminUserCanBeAddedToAdminUsersTable() {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String menu = ExcelUtility.getString(2, 0, "MenuPage");
		
		RandomUtilty randomutilty = new RandomUtilty();
		String newUsername = randomutilty.username();
		String newPassword = randomutilty.password();
		String userType = ExcelUtility.getString(3, 0, "AdminUsersPage") ;

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(username);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.clickOnSignInButton();
		
		MenuPage menupage = new MenuPage(driver);
		menupage.clickOnMenuItems(menu);
		
		AdminUsersPage adminuserspage = new AdminUsersPage(driver);
		adminuserspage.clickOnNewButton();
		adminuserspage.enterUsername(newUsername);
		adminuserspage.enterPassword(newPassword);
		adminuserspage.selectUserType(userType);
		adminuserspage.clickOnSaveButton();
		
		boolean isSuccessAlertDisplayed = adminuserspage.isUserCreationSuccessAlertShown();
		assertTrue(isSuccessAlertDisplayed, "User is not able to create a new admin user");
	}
}
