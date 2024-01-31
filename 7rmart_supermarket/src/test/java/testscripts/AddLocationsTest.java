package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import pages.AddLocationsPage;
import pages.LoginPage;
import pages.MenuPage;

public class AddLocationsTest extends Base{
	@Test(description = "user is able to create a new location")
	private void verifyWetherUserCanAddNewLocation() {
		String username = "admin";
		String password = "admin";
		String menu = "Manage Location";
		
		String locationInput = "abcde";
		String deliveryCharge = "1000";
		String country = "United Kingdom";
		String state = "Kent";
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(username);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.clickOnSignInButton();
		
		MenuPage menupage = new MenuPage(driver);
		menupage.clickOnMenuItems(menu);
		
		AddLocationsPage addlocationspage = new AddLocationsPage(driver);
		addlocationspage.clickOnNewButton();
		addlocationspage.selectCountry(country);
		addlocationspage.selecState(state);
		addlocationspage.inputInLocationInputField(locationInput);
		addlocationspage.inputInDeliveryChargeField(deliveryCharge);
		addlocationspage.clickOnSaveButton();
		
		boolean isSuccessAlertDisplayed = addlocationspage.isLocationAdditionSuccessAlertShown();
		assertTrue(isSuccessAlertDisplayed, "User is not able to add a new location");
	}
}
