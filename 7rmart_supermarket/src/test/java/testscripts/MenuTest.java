package testscripts;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MenuPage;

public class MenuTest extends Base {
	
	@Test
	public void verifyThatWhenClickedOnMenuItemsNavigatesToTheCorrespondingPage() {
		String menu = "Manage Sliders";
		String username = "admin";
		String password = "admin";
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(username);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.clickOnSignInButton();
		
		MenuPage menupage = new MenuPage(driver);
		menupage.clickOnMenuItems(menu);
		
		//give assert
	}
}