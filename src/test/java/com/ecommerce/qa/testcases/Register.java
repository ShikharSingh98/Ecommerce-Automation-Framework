package com.ecommerce.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ecommerce.qa.base.Base;
import com.ecommerce.qa.pages.AccountPage;
import com.ecommerce.qa.pages.HomePage;
import com.ecommerce.qa.pages.RegisterPage;
import com.ecommerce.qa.utils.Utilities;

public class Register extends Base {
	public WebDriver driver;
	RegisterPage registerPage;
	AccountPage accountPage;

	public Register() {
		super();
	}

	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));
		HomePage homePage = new HomePage(driver);
		registerPage = homePage.navigateToRegisterPage();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void verifyRegisteringAccountWithMandatoryFields() {
		registerPage.enterFirstName(dataProp.getProperty("firstName"));
		registerPage.enterLastName(dataProp.getProperty("lastName"));
		registerPage.enterEmail(Utilities.generateEmailWithTimeStamp());
		registerPage.enterTelephone(dataProp.getProperty("telephone"));
		registerPage.enterPassword(dataProp.getProperty("password"));
		registerPage.enterConfirmPassword(dataProp.getProperty("password"));
		registerPage.clickOnAgreeOption();
		accountPage = registerPage.clickOnContinueButton();

		Assert.assertEquals(accountPage.getHeadingText(), dataProp.getProperty("accountSuccessfullyHeading"),
				"Account Success Heading text is not displayed correctly");
	}

	@Test(priority = 2)
	public void verifyRegisteringAccountWithAllFields() {
		registerPage.enterFirstName(dataProp.getProperty("firstName"));
		registerPage.enterLastName(dataProp.getProperty("lastName"));
		registerPage.enterEmail(Utilities.generateEmailWithTimeStamp());
		registerPage.enterTelephone(dataProp.getProperty("telephone"));
		registerPage.enterPassword(dataProp.getProperty("password"));
		registerPage.enterConfirmPassword(dataProp.getProperty("password"));
		registerPage.clickOnNewsLetterOption();
		registerPage.clickOnAgreeOption();
		accountPage = registerPage.clickOnContinueButton();

		Assert.assertEquals(accountPage.getHeadingText(), dataProp.getProperty("accountSuccessfullyHeading"),
				"Account Success Heading text is not displayed correctly");
	}

	@Test(priority = 3)
	public void verifyRegisteringAccountWithExistingEmailAddress() {
		registerPage.enterFirstName(dataProp.getProperty("firstName"));
		registerPage.enterLastName(dataProp.getProperty("lastName"));
		registerPage.enterEmail(dataProp.getProperty("existingEmail"));
		registerPage.enterTelephone(dataProp.getProperty("telephone"));
		registerPage.enterPassword(dataProp.getProperty("password"));
		registerPage.enterConfirmPassword(dataProp.getProperty("password"));
		registerPage.clickOnNewsLetterOption();
		registerPage.clickOnAgreeOption();
		registerPage.clickOnContinueButton();
		Assert.assertEquals(registerPage.getAlertText(), dataProp.getProperty("duplicateEmailWarning"),
				"Warning alert text regarding duplicate email is not displayed correctly");
	}

	@Test(priority = 4)
	public void verifyRegisteringAccountWithoutFillingAnyDetails() {
		registerPage.clickOnContinueButton();
		Assert.assertEquals(registerPage.getPrivacyPolicyWarning(), dataProp.getProperty("privacyPolicyWarning"),
				"Privacy Policy Warning not displayed correctly");
		Assert.assertEquals(registerPage.getFirstNameWarning(), dataProp.getProperty("firstNameWarning"),
				"First Name Warning not displayed correctly");
		Assert.assertEquals(registerPage.getLastNameWarning(), dataProp.getProperty("lastNameWarning"),
				"Last Name Warning not displayed correctly");
		Assert.assertEquals(registerPage.getEmailWarinig(), dataProp.getProperty("emailWarinig"),
				"Email Warning not displayed correctly");
		Assert.assertEquals(registerPage.getTelephoneWarning(), dataProp.getProperty("telephoneWarning"),
				"Telephone Warning not displayed correctly");
		Assert.assertEquals(registerPage.getPasswordWarning(), dataProp.getProperty("passwordWarning"),
				"Password Warning not displayed correctly");
	}
}
