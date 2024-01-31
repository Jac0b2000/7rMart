package testscripts;

import static org.testng.Assert.assertTrue;
import java.awt.AWTException;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ManageSlidersPage;
import pages.MenuPage;
import utilities.ExcelUtility;
import utilities.GeneralUtility;

public class ManageSlidersTest extends Base{
	@Test(description = "user is able to upload an image and a link to the list sliders")
	public void verifyThatUserIsAbleToUploadAnImageAndLinkToListSliders() throws AWTException  {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		
		String menu = ExcelUtility.getString(7, 0, "MenuPage");
		
		String link = GeneralUtility.IMAGEUPLOADFILE;
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(username);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.clickOnSignInButton();
		
		MenuPage menupage = new MenuPage(driver);
		menupage.clickOnMenuItems(menu);
		
		ManageSlidersPage managesliderspage = new ManageSlidersPage(driver);
		managesliderspage.clickOnNewButton();
		managesliderspage.fileUploadButton();
		managesliderspage.enterWeblink(link);
		managesliderspage.clickOnSaveButton();
		
		boolean isSuccessAlertDisplayed = managesliderspage.isSliderCreationSuccesAlertShown();
		assertTrue(isSuccessAlertDisplayed, "User is not able to upload an image or link to the list slider");
	}
}
