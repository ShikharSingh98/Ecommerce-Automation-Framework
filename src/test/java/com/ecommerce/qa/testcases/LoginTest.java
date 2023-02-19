package com.ecommerce.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ecommerce.qa.base.Base;
import com.ecommerce.qa.pages.AccountPage;
import com.ecommerce.qa.pages.HomePage;
import com.ecommerce.qa.pages.LoginPage;
import com.ecommerce.qa.utils.Utilities;

public class LoginTest extends Base {

	public WebDriver driver;
	LoginPage loginPage;

	public LoginTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));
		HomePage homePage = new HomePage(driver);
		loginPage = homePage.navigateToLoginPage();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1, dataProvider = "supplyTestData")
	public void verifyLoginWithValidCredentials(String email, String password) {
		AccountPage accountPage = loginPage.login(email, password);
		Assert.assertTrue(accountPage.getDisplayStatusOfEditYourAccountInformationOption(),
				"Edit your account information is not displayed");
	}

	@DataProvider
	public Object[][] supplyTestData() throws IOException {
		return Utilities.getTestDataFromExcelFiles("Login");
	}

	@Test(priority = 2)
	public void verifyLoginWithInValidCredentials() {
		loginPage.login(Utilities.generateEmailWithTimeStamp(), dataProp.getProperty("invalidPassword"));
		Assert.assertEquals(loginPage.getEmailPasswordNotMatchingWarning(),
				dataProp.getProperty("emailPasswordNoMatchWarning"), "Warning message not displayed correctly");
	}

	@Test(priority = 3)
	public void verifyLoginWithInvalidEmailAndValidPassword() {
		loginPage.login(Utilities.generateEmailWithTimeStamp(), dataProp.getProperty("password"));
		Assert.assertEquals(loginPage.getEmailPasswordNotMatchingWarning(),
				dataProp.getProperty("emailPasswordNoMatchWarning"), "Warning message not displayed correctly");
	}

	@Test(priority = 4)
	public void verifyLoginWithValidEmailAndInvalidPassword() {
		loginPage.login(dataProp.getProperty("existingEmail"), dataProp.getProperty("invalidPassword"));
		Assert.assertEquals(loginPage.getEmailPasswordNotMatchingWarning(),
				dataProp.getProperty("emailPasswordNoMatchWarning"), "Warning message not displayed correctly");
	}

	@Test(priority = 5)
	public void verifyLoginWithoutProvidingCredentials() {
		loginPage.clickOnLoginButton();
		Assert.assertEquals(loginPage.getEmailPasswordNotMatchingWarning(),
				dataProp.getProperty("emailPasswordNoMatchWarning"), "Warning message not displayed correctly");
	}

}
