package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtilitiy;
import utilities.WaitUtility;

public class AddLocationsPage {
public WebDriver driver;
	
	public AddLocationsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@onclick='click_button(1)']")WebElement newButton;
	@FindBy(xpath = "//select[@name='country_id']")WebElement countryDropdown;
	@FindBy(xpath = "//select[@name='state_id']")WebElement stateDropdown;
	@FindBy(xpath = "//input[@name='location']")WebElement locationInputField;
	@FindBy(xpath = "//input[@name='delivery']")WebElement deliveryChargeInputField;
	@FindBy(xpath = "//button[@type='submit']")WebElement saveButton;
	@FindBy(xpath = "//div[@class='col-sm-12']")WebElement alertMessageField;
	
	public void clickOnNewButton() {
		newButton.click();
	}
	public void selectCountry(String country) {
		PageUtilitiy pageutility = new PageUtilitiy();
		pageutility.selectValueUsingSelectByVisibleText(countryDropdown, country);
	}
	public void selecState(String state) {
		PageUtilitiy pageutility = new PageUtilitiy();
		pageutility.selectValueUsingSelectByVisibleText(stateDropdown, state);
		
		WaitUtility waitutility = new WaitUtility();
		waitutility.WaitForElement(driver, stateDropdown);
	}
	public void inputInLocationInputField(String input) {
		locationInputField.sendKeys(input);
	}
	public void inputInDeliveryChargeField(String input) {
		deliveryChargeInputField.sendKeys(input);;
	}
	public void clickOnSaveButton() {
		saveButton.click();
	}
	public boolean isLocationAdditionSuccessAlertShown() {
		return alertMessageField.isDisplayed();
	}
}
