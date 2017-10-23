package com.automation.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.prestashop.BasePage;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id  = "user_infoblock-top")
	public WebElement loginButton;
	
	@FindBy(css = ".hidden-xs.logout-link")
	public WebElement logoutButton;
	
	@FindBy(css = ".nav.navbar-nav")
	public WebElement superCategories;
	
	@FindBy(css = ".menu-content")
	public WebElement categories;
	
	
	public void goToMyAccountPage() {
		clickElement(loginButton.findElements(By.tagName("a")).get(0));
	}
	
	public void logout() {
		clickElement(logoutButton);
		assertionTrue(loginButton, "CONTUL MEU");
	}
	
	public void goToCategoryPage() {
		hoverOverElement(superCategories.findElements(By.tagName("a")).get(1));
		clickElement(categories.findElements(By.tagName("a")).get(1));
	}
}
