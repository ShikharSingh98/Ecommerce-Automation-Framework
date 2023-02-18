package com.ecommerce.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-email")
	private WebElement emailInput;

	@FindBy(id = "input-password")
	private WebElement passwordInput;

	@FindBy(css = "input[value='Login']")
	private WebElement loginButton;
	
	@FindBy(css="div.alert")
	private WebElement emailPasswordNotMatchingWarning;
	
	public void clickOnLoginButton() {
		loginButton.click();
	}
	
	public AccountPage login(String email,String password) {
		emailInput.sendKeys(email);
		passwordInput.sendKeys(password);
		loginButton.click();
		return new AccountPage(driver);
	}
	
	public String getEmailPasswordNotMatchingWarning() {
		return emailPasswordNotMatchingWarning.getText();
	}
}
