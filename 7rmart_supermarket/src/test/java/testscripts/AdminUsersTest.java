package testscripts;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import pages.AdminUsersPage;
import pages.LoginPage;
import pages.MenuPage;

public class AdminUsersTest extends Base{
	@Test(description = "user is able to create a new admin user")
	public void verifyThatANewAdminUserCanBeAddedToAdminUsersTable() {
		String username = "admin";
		String password = "admin";
		String menu = "Admin Users";
		
		String newUsername ="aaaaa";
		String newPassword ="12345";
		String userType= "Partner";

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
