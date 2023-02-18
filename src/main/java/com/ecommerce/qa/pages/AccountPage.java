package com.ecommerce.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

	WebDriver driver;
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText="Edit your account information")
	private WebElement editYourAccountInformationOption; 
	
	@FindBy(css = "#content h1")
	private WebElement headingText;
	
	public boolean getDisplayStatusOfEditYourAccountInformationOption() {
		return editYourAccountInformationOption.isDisplayed();
	}
	
	public String getHeadingText() {
		return headingText.getText();
	}
}
