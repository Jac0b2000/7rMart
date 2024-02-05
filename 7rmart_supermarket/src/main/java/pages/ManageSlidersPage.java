package pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUploadUtility;
import utilities.GeneralUtility;
import utilities.WaitUtility;

public class ManageSlidersPage {
	WebDriver driver;
	
	public ManageSlidersPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Slider/add']")WebElement newButton;
	@FindBy(xpath = "//input[@type='file']")WebElement chooseFileButton;
	@FindBy(xpath = "//input[@id='link']")WebElement linkInputField;
	@FindBy(xpath = "//button[@type='submit']")WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")WebElement alertMessageField;
	
	public void clickOnNewButton() {
		newButton.click();
	}
	public void fileUploadButton() throws AWTException {
		WaitUtility waitutility = new WaitUtility();
		waitutility.ExplicitWaitForAnElementToBeClickable(driver, chooseFileButton);
		
		FileUploadUtility fileuploadutility = new FileUploadUtility();
		fileuploadutility.fileUploadUsingSendKeys(chooseFileButton, GeneralUtility.MANAGESLIDER_IMG);
	}
	public void enterWeblink(String link) {
		linkInputField.sendKeys(link);
	}
	public void clickOnSaveButton() {
		WaitUtility waitutility = new WaitUtility();
		waitutility.ExplicitWaitForAnElementToBeClickable(driver, saveButton);
		
		saveButton.click();
	}
	public boolean isSliderCreationSuccesAlertShown() {
		return alertMessageField.isDisplayed();
	}
}
