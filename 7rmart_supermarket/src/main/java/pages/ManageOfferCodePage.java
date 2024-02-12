package pages;


import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utilities.FileUploadUtility;
import utilities.GeneralUtility;
import utilities.PageUtilitiy;
import utilities.WaitUtility;

public class ManageOfferCodePage {
	
	public WebDriver driver;


	public ManageOfferCodePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@onclick='click_button(1)']") WebElement newButton;
	@FindBy(xpath = "//input[@id='offer_code']") WebElement offerCodeField;
	@FindBy(xpath = "//input[@value='yes']") WebElement yesRadioButton;
	@FindBy(xpath = "//input[@id='offer_per']") WebElement percentageField;
	@FindBy(xpath = "//input[@id='offer_price']") WebElement amountField;
	@FindBy(xpath = "//input[@id='main_img']") WebElement chooseFileButton;
	@FindBy(xpath = "//button[@name='create']") WebElement saveButton;
	@FindBy(xpath = "//div[contains(@class,'alert')]") WebElement alertElement;
	
	public void clickOnNewButton() {
		newButton.click();
	}
	
	public void enterOfferCodeOnOfferCodeField(String offerCode) {
		offerCodeField.sendKeys(offerCode);
	}
	
	public void clickOnYesRadioButton() {
		yesRadioButton.click();
	}
	
	public void enterPercentageOnPercentageField(String percentage) {
		percentageField.sendKeys(percentage);
	}
	
	public void enterAmountOnAmountField(String amount) {
		amountField.sendKeys(amount);
	}
	
	public void uploadImage() throws AWTException {
		
		WaitUtility waitutility = new WaitUtility();
		waitutility.ExplicitWaitForAnElementToBeClickable(driver, chooseFileButton);
		
		FileUploadUtility fileuploadutility = new FileUploadUtility();
		fileuploadutility.fileUploadUsingSendKeys(chooseFileButton, GeneralUtility.PROMOCODE_IMG);
	}
	
	public void clickOnSaveButton() {
		WaitUtility waitutility = new WaitUtility();
		waitutility.ExplicitWaitForAnElementToBeClickable(driver, saveButton);
		
		PageUtilitiy pageutility = new PageUtilitiy();
		pageutility.javaScriptClick(driver, saveButton);
	}
	
	public String getTextFromAlertMessage() {
		return alertElement.getText();
	}
	
	
}