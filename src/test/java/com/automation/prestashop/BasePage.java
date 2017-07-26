package com.automation.prestashop;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import junit.framework.Assert;


public class BasePage {

	protected WebDriver driver;
	protected WebDriverWait wait;

	@Parameters("url")
	@BeforeMethod
	public void setUp(String url) throws IOException {
		openBrowser();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("http://" + url);
	}

	public void openBrowser() throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Programs\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Parameters("url")
	@AfterMethod
	public void TearDown(ITestResult result, String url) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			TakeScreenshot.takescreenshot(driver, result.getName(), url);
			System.out.println("Failed test: " + result.getName() + " on " + url);
		} 
		driver.quit();
	}

	public void waitForElementToBeDisplayed(WebElement element) {
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(element));

	}
	
	public void waitForElementToDisappear(By locator) {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	public void clickElement(WebElement element) {
		waitForElementToBeDisplayed(element);
		element.click();
	}

	public void fillInValue(WebElement element, String value) {
		waitForElementToBeDisplayed(element);
		element.sendKeys(value);
	}

	public void selectValueFromDropdown(WebElement selectID, String value) {
		waitForElementToBeDisplayed(selectID);
		Select select = new Select(selectID);
		select.selectByValue(value);
	}

	public void assertionTrue(WebElement element, String message) {
		waitForElementToBeDisplayed(element);
		Assert.assertTrue(element.getText().contains(message));
	}
	
	public void wait(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void scrollPageUp() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, -250);");
	}
	
	
}