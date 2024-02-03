package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import pages.AddLocationsPage;
import pages.LoginPage;
import pages.MenuPage;
import utilities.ExcelUtility;

public class AddLocationsTest extends Base{
	@Test(description = "user is able to create a new location")
	private void verifyWetherUserCanAddNewLocation() {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String menu = ExcelUtility.getString(11, 0, "MenuPage");
		
		String locationInput = ExcelUtility.getString(2, 1, "AddLocationsPage");
		String deliveryCharge = ExcelUtility.getInt(3, 1, "AddLocationsPage");
		String country = ExcelUtility.getString(0, 1, "AddLocationsPage");
		String state = ExcelUtility.getString(1, 1, "AddLocationsPage");
		
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
