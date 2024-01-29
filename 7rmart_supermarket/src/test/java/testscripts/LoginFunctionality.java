package testscripts;

import static org.testng.Assert.assertTrue;


import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LoginFunctionality extends Base {
	
	@Test
	public void toVerifyWhetherUserCanLoginUsingBothValidCredentials() {
		String userName = "admin";
		String passWord = "admin";
		WebElement usernameInput = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		usernameInput.sendKeys(userName);
		WebElement passwordInput = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		passwordInput.sendKeys(passWord);
		WebElement signInButton = driver.findElement(By.xpath("//button[@type='submit']"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(signInButton));
		
		signInButton.click();
		
		WebElement settingsButton = driver.findElement(By.xpath("//a[@class=' nav-link']//i[@class='nav-icon sidebar-item-icon fa fa-cog']"));
		boolean isSettingsButtonDisplayed = settingsButton.isDisplayed();
		
		assertTrue(isSettingsButtonDisplayed, "User is unable to login with both valid credentials");
	}
	
	@Test
	public void toVerifyWhetherUserCanLoginUsingValidUsernameButInvalidPassword() {
		String userName = "admin";
		String passWord = "12345";
		WebElement usernameInput = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		usernameInput.sendKeys(userName);
		WebElement passwordInput = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		passwordInput.sendKeys(passWord);
		WebElement signInButton = driver.findElement(By.xpath("//button[@type='submit']"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(signInButton));
		
		signInButton.click();
		
		
		WebElement alertPopup = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
		boolean isAlertPopupDisplayed = alertPopup.isDisplayed();
		
		assertTrue(isAlertPopupDisplayed, "User is able to login with valid username and invalid password");
		
	}
	
	@Test
	public void toVerifyWhetherUserCanLoginUsingInvalidUsernameButValidPassword() {
		String userName = "abcde";
		String passWord = "admin";
		WebElement usernameInput = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		usernameInput.sendKeys(userName);
		WebElement passwordInput = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		passwordInput.sendKeys(passWord);
		WebElement signInButton = driver.findElement(By.xpath("//button[@type='submit']"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(signInButton));
		
		signInButton.click();
		
		WebElement alertPopup = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
		boolean isAlertPopupDisplayed = alertPopup.isDisplayed();
		
		assertTrue(isAlertPopupDisplayed, "User is able to login with invalid username and valid password");
	}
	
	@Test
	public void toVerifyWhetherUserCanLoginUsingBothInvalidCredentials() {
		String userName = "abcde";
		String passWord = "12345";
		WebElement usernameInput = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		usernameInput.sendKeys(userName);
		WebElement passwordInput = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		passwordInput.sendKeys(passWord);
		WebElement signInButton = driver.findElement(By.xpath("//button[@type='submit']"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(signInButton));
		
		signInButton.click();
		
		WebElement alertPopup = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
		boolean isAlertPopupDisplayed = alertPopup.isDisplayed();
		
		assertTrue(isAlertPopupDisplayed, "User is able to login with both invalid credentials");
	}

}
