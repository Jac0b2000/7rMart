package testscripts;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	@Test(description ="user is able to login with valid credentials")
	public void verifyWhetherUserCanLoginUsingBothValidCredentials() {
		String userName = ExcelUtility.getString(1, 0, "LoginPage");
		String passWord = ExcelUtility.getString(1, 1, "LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(userName);
		loginpage.enterPasswordOnPasswordField(passWord);
		loginpage.clickOnSignInButton();
		
		boolean isHomePageDisplayed = loginpage.isSettingsButtonAvailable();
		assertTrue(isHomePageDisplayed, "User is unable to login with both valid credentials");
	}
	@Test
	public void VerifyWhetherUserCanLoginUsingValidUsernameButInvalidPassword() {
		String userName = ExcelUtility.getString(3, 0, "LoginPage");
		String passWord = ExcelUtility.getString(3, 1, "LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(userName);
		loginpage.enterPasswordOnPasswordField(passWord);
		loginpage.clickOnSignInButton();
		
		boolean isAlertPopupDisplayed = loginpage.isAlertPopupDisplayed();
		assertTrue(isAlertPopupDisplayed, "User is able to login with valid username But Invalid Password");
	}	

}
