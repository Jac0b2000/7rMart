package testscripts;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MenuPage;
import utilities.ExcelUtility;

public class MenuTest extends Base {
	
	@Test
	public void verifyThatWhenClickedOnMenuItemsNavigatesToTheCorrespondingPage() {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String menu = ExcelUtility.getString(10, 0, "MenuPage");
		String expectedHeader = ExcelUtility.getString(10, 0, "MenuPage");
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(username);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.clickOnSignInButton();
		
		MenuPage menupage = new MenuPage(driver);
		menupage.clickOnMenuItems(menu);
		
		String actualHeader = menupage.getHeaderOfThePage();
		assertEquals(actualHeader, expectedHeader, "User is not able to click on the selected menu");
	}
}