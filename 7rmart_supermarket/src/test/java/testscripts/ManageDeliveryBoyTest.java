package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageDeliveryBoyPage;
import pages.MenuPage;
import retry.Retry;
import utilities.ExcelUtility;

public class ManageDeliveryBoyTest extends Base {
		
	@Test(retryAnalyzer = Retry.class, description = "Verify wether the user can find corresponding delivery boy details by entering credentials of that delivery boy", groups = {"smoke"})
	public void verifyWhenUserSearchDeliveryBoyUsingCredentialsItDisplaysDetailsOfCorrespondingDeliveryBoy() {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String name = ExcelUtility.getString(1, 0, "ManageDeliveryBoyPage");
		String email = ExcelUtility.getString(1, 1, "ManageDeliveryBoyPage");
		String phoneNumber = ExcelUtility.getInt(1, 2, "ManageDeliveryBoyPage");
		
		String menu = ExcelUtility.getString(8, 0, "MenuPage");
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(username);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.clickOnSignInButton();
		
		MenuPage menupage = new MenuPage(driver);
		menupage.clickOnMenuItems(menu);
		
		ManageDeliveryBoyPage managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		managedeliveryboypage.clickOnSearchButton();
		managedeliveryboypage.enterNameonNameField(name);
		managedeliveryboypage.enterEmailonEmailField(email);
		managedeliveryboypage.enterPhoneNumberonPhoneNumberField(phoneNumber);
		managedeliveryboypage.clickOnFinalSearchButton();
		
		boolean isTableDisplayed = managedeliveryboypage.isTableDisplayedWithSearchResult();
		assertTrue(isTableDisplayed, "When User Search DeliveryBoy UsingCredentials Details Of Corresponding DeliveryBoy is not Displayed");
	}
		
}

