package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtilitiy;

public class AdminUsersPage {
	public WebDriver driver;
	
	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")WebElement newButton;
	@FindBy(xpath = "//input[@id='username']")WebElement usernameInputField;
	@FindBy(xpath = "//input[@id='password']")WebElement passwordInputField;
	@FindBy(xpath = "//select[@name='user_type']")WebElement userTypeDropdown;
	@FindBy(xpath = "//button[@name='Create']")WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")WebElement alertMessegeField;
	
	public void clickOnNewButton() {
		newButton.click();
	}
	public void enterUsername(String username) {
		usernameInputField.sendKeys(username);
	}
	public void enterPassword(String password) {
		passwordInputField.sendKeys(password);
	}
	public void selectUserType(String userType) {
		PageUtilitiy pageutility = new PageUtilitiy();
		pageutility.selectValueUsingSelectByVisibleText(userTypeDropdown, userType);
	}
	public void clickOnSaveButton() {
		saveButton.click();
	}
	public boolean isUserCreationSuccessAlertShown() {
		return alertMessegeField.isDisplayed();
	}
	//
}
