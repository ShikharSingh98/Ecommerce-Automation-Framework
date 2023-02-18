package com.ecommerce.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-firstname")
	private WebElement firstName;

	@FindBy(id = "input-lastname")
	private WebElement lastName;

	@FindBy(id = "input-email")
	private WebElement email;

	@FindBy(id = "input-telephone")
	private WebElement telephone;

	@FindBy(id = "input-password")
	private WebElement password;

	@FindBy(id = "input-confirm")
	private WebElement confirmPassword;

	@FindBy(css = ".radio-inline:nth-child(2)")
	private WebElement newsLetterOption;

	@FindBy(name = "agree")
	private WebElement agreeOption;

	@FindBy(css = "input[value='Continue']")
	private WebElement continueButton;

	@FindBy(css = "div.alert-dismissible")
	private WebElement alertText;

	@FindBy(css = "div.alert-dismissible")
	private WebElement privacyPolicyWarining;

	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarning;

	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarning;

	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarinig;

	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarning;

	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarning;

	public void enterFirstName(String firstNameText) {
		firstName.sendKeys(firstNameText);
	}

	public void enterLastName(String lastNameText) {
		lastName.sendKeys(lastNameText);
	}

	public void enterEmail(String emailText) {
		email.sendKeys(emailText);
	}

	public void enterTelephone(String telephoneText) {
		telephone.sendKeys(telephoneText);
	}

	public void enterPassword(String passwordText) {
		password.sendKeys(passwordText);
	}

	public void enterConfirmPassword(String confirmPasswordText) {
		confirmPassword.sendKeys(confirmPasswordText);
	}

	public void clickOnNewsLetterOption() {
		newsLetterOption.click();
	}

	public void clickOnAgreeOption() {
		agreeOption.click();
	}

	public AccountPage clickOnContinueButton() {
		continueButton.click();
		return new AccountPage(driver);
	}

	public String getAlertText() {
		return alertText.getText();
	}

	public String getPrivacyPolicyWarning() {
		return privacyPolicyWarining.getText();
	}

	public String getFirstNameWarning() {
		return firstNameWarning.getText();
	}

	public String getLastNameWarning() {
		return lastNameWarning.getText();
	}

	public String getEmailWarinig() {
		return emailWarinig.getText();
	}

	public String getTelephoneWarning() {
		return telephoneWarning.getText();
	}

	public String getPasswordWarning() {
		return passwordWarning.getText();
	}

}
