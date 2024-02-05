package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtilitiy;

public class MenuPage {
	
	public WebDriver driver;
	PageUtilitiy pageutilities;

	public MenuPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[contains(@class,'small')]//child::div[@class='inner']") List<WebElement> menuItems;
	@FindBy(xpath = "//a[@class='small-box-footer']") List<WebElement> menuItemsLink;
	@FindBy(xpath = "//h1") WebElement headerElement;
	//@FindBy(xpath ="//h1[text()='List Orders']")WebElement itemHeading;
	public void clickOnMenuItems(String menuToBeClicked) {
		int menuIndex;
		for (WebElement menuItem : menuItems) {
			menuIndex = menuItems.indexOf(menuItem);
			if(menuIndex!=-1 && menuItem.getText().contains(menuToBeClicked)) {
				menuItemsLink.get(menuIndex).click();
				break;
			}
		}
	}
	//public boolean isCorrespondingPageDisplayed() {
	//	return itemHeading.isDisplayed();
	//}
	public String getHeaderOfThePage() {
		return headerElement.getText();
	}
}