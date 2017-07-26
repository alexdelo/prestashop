package com.automation.objects;

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
	
	@FindBy(css  = ".header_item.login")
	public WebElement loginButton;
	
	@FindBy(css = ".header_item.logout")
	public WebElement logoutButton;
	
	@FindBy(id = "st_advanced_ma11")
	public WebElement categories;
	
	public void goToMyAccountPage() {
		clickElement(loginButton);
	}
	
	public void logout() {
		clickElement(logoutButton);
		assertionTrue(loginButton, "AUTENTIFICARE");
	}
	
	public void goToCategoryPage() {
		clickElement(categories);
	}
}
