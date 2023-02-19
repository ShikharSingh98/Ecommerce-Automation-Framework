package com.ecommerce.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ecommerce.qa.base.Base;
import com.ecommerce.qa.pages.HomePage;
import com.ecommerce.qa.pages.SearchPage;

public class Search extends Base {

	public WebDriver driver;
	HomePage homePage;
	SearchPage searchPage;

	public Search() {
		super();
	}

	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));
		homePage = new HomePage(driver);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void verifySearchWithValidProduct() {
		homePage.enterProduct(dataProp.getProperty("validProduct"));
		searchPage = homePage.clickOnSearchButton();
		Assert.assertTrue(searchPage.isProductDisplayed(), "Valid product HP is not displayed");
	}

	@Test(priority = 2)
	public void verifySearchWithInvalidProduct() {
		homePage.enterProduct(dataProp.getProperty("invalidProduct"));
		searchPage = homePage.clickOnSearchButton();
		Assert.assertEquals(searchPage.getProductNotFoundAlertText(), dataProp.getProperty("searchText"),
				"Invalid search product text is not displayed");
	}

	@Test(priority = 3)
	public void verifySearchWithoutAnyProduct() {
		searchPage = homePage.clickOnSearchButton();
		Assert.assertEquals(searchPage.getProductNotFoundAlertText(), dataProp.getProperty("searchText"),
				"Invalid search product text is not displayed");
	}

}
