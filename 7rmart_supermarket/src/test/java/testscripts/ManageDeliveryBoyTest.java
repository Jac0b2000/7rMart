package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageDeliveryBoyPage;
import pages.MenuPage;

public class ManageDeliveryBoyTest extends Base {
		
	@Test
	public void verifyWhenUserSearchDeliveryBoyUsingCredentialsItDisplaysDetailsOfCorrespondingDeliveryBoy() {
		String username = "admin";
		String password = "admin";
		String name = "Rahul";
		String email = "Reinhold@gmail.com";
		String phoneNumber = "7510982684";
		
		String menu = "Manage Delivery Boy";
		
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

