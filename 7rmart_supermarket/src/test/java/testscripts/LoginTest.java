package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import retry.Retry;
import utilities.ExcelUtility;
import utilities.RandomUtilty;

public class LoginTest extends Base {
	RandomUtilty randomutility;
	@Test(priority = 1, retryAnalyzer = Retry.class, description ="Verify wether the user is able to login with valid credentials", groups = {"regression"})
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
	@Test(priority = 2, retryAnalyzer = Retry.class, description ="Verify wether the user is not able to login with valid username but invalid password", groups = {"regression"})
	public void VerifyWhetherUserCanLoginUsingValidUsernameButInvalidPassword() {
		randomutility = new RandomUtilty();
		String userName = ExcelUtility.getString(1, 0, "LoginPage");
		String passWord = randomutility.password();
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(userName);
		loginpage.enterPasswordOnPasswordField(passWord);
		loginpage.clickOnSignInButton();
		
		boolean isAlertPopupDisplayed = loginpage.isAlertPopupDisplayed();
		assertTrue(isAlertPopupDisplayed, "User is able to login with valid username But Invalid Password");
	}
	@Test(priority = 3, retryAnalyzer = Retry.class, description ="Verify wether the user is not able to login with invalid username but valid password")
	public void VerifyWhetherUserCanLoginUsingInvalidUsernameButValidPassword() {
		randomutility = new RandomUtilty();
		String userName = randomutility.username();
		String passWord = ExcelUtility.getString(1, 1, "LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(userName);
		loginpage.enterPasswordOnPasswordField(passWord);
		loginpage.clickOnSignInButton();
		
		boolean isAlertPopupDisplayed = loginpage.isAlertPopupDisplayed();
		assertTrue(isAlertPopupDisplayed, "User is able to login with invalid username But valid Password");
	}
	@Test(retryAnalyzer = Retry.class, dataProvider="LoginProvider", description ="Verify wether the user is not able to login with both invalid credentials")
	public void VerifyWhetherUserCanLoginUsingBothInvalidCredentials(String userName, String passWord) {

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(userName);
		loginpage.enterPasswordOnPasswordField(passWord);
		loginpage.clickOnSignInButton();
		
		boolean isAlertPopupDisplayed = loginpage.isAlertPopupDisplayed();
		assertTrue(isAlertPopupDisplayed, "User is able to login with invalid username But valid Password");
	}
	@DataProvider(name = "LoginProvider")
	public Object[][] getDataFromTestData() {
		return new Object[][] { { ExcelUtility.getString(3, 0, "LoginPage"), ExcelUtility.getString(3, 1, "LoginPage") },

		};
}
}
