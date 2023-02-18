package com.ecommerce.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	WebDriver driver;
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="HP LP3065")
	private WebElement product;
	
	@FindBy(xpath="(//div[@id='content']/p)[2]")
	private WebElement productNotFoundAlert;
	
	
	public boolean isProductDisplayed() {
		return product.isDisplayed();
	}
	
	public String getProductNotFoundAlertText() {
		return productNotFoundAlert.getText();
	}
	
}
