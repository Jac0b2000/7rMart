package testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageOrdersPage;
import pages.MenuPage;
import utilities.ExcelUtility;
import retry.Retry;

public class ManageOrdersTest extends Base {
	
	@Test(retryAnalyzer = Retry.class, description = "Verify that the user can see the order details in the manage order page")
	public void verifyThatTheUserCanSeeTheOrderDetailsInTheManageOrdersPage() throws IOException {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		
		String menuToBeSelected = ExcelUtility.getString(10, 0, "MenuPage");
		
		String orderId = ExcelUtility.getInt(1, 0, "ManageOrdersPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSignInButton();
		
		MenuPage menupage = new MenuPage(driver);
		menupage.clickOnMenuItems(menuToBeSelected);
		
		ManageOrdersPage manageorderspage = new ManageOrdersPage(driver);
		manageorderspage.clickOnViewButton(orderId);
		
		assertTrue(manageorderspage.isOrderIdMatching(orderId), "User is not able to see the order details in the manage order page");	
	}
}