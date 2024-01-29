package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends Base {
	@Test(description ="user is able to login with valid credentials")
	public void verifyWhetherUserCanLoginUsingBothValidCredentials() {
		String userName = "admin";
		String passWord = "admin";
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(userName);
		loginpage.enterPasswordOnPasswordField(passWord);
		loginpage.clickOnSignInButton();
		
		boolean isHomePageDisplayed = loginpage.isSettingsButtonAvailable();
		assertTrue(isHomePageDisplayed, "User is unable to login with both valid credentials");
	}

}
