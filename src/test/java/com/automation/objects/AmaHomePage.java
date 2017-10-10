package com.automation.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.prestashop.BasePage;

public class AmaHomePage extends BasePage {
	
	public AmaHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id  = "user_infoblock-top")
	public WebElement loginButton;
	
	@FindBy(css = ".header_item.logout")
	public WebElement logoutButton;
	
	@FindBy(id = "st_advanced_ma11")
	public WebElement categories;
	
	public void goToMyAccountPage() {
		clickElement(loginButton.findElements(By.tagName("a")).get(0));
	}
	
	public void logout() {
		clickElement(logoutButton);
		assertionTrue(loginButton, "AUTENTIFICARE");
	}
	
	public void goToCategoryPage() {
		clickElement(categories);
	}
}
