package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	public WebDriver driver;
		public LoginPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
	@FindBy(xpath="//input[@placeholder='Username']") private WebElement usernameField;
	@FindBy(xpath="//input[@placeholder='Password']") private WebElement passwordField;
	@FindBy(xpath="//button[@type='submit']") private WebElement signInButton;
	@FindBy(xpath="//a[@class=' nav-link']//i[@class='nav-icon sidebar-item-icon fa fa-cog']") private WebElement settingsButton;
	@FindBy(xpath ="//div[@class='alert alert-danger alert-dismissible']") private WebElement alertPopup;
	
	public void enterUsernameOnUsernameField(String username) {
		usernameField.sendKeys(username);
	}
	public void enterPasswordOnPasswordField(String password) {
		passwordField.sendKeys(password);
	}
	public void clickOnSignInButton() {
		signInButton.click();
	}
	public boolean isSettingsButtonAvailable() {
		return settingsButton.isDisplayed();
	}
	public boolean isAlertPopupDisplayed() {
		return alertPopup.isDisplayed();
	}
}
	
	

