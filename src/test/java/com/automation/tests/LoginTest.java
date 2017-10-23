package com.automation.tests;

import org.testng.annotations.Test;

import com.automation.objects.HomePage;
import com.automation.objects.MyAccountPage;
import com.automation.prestashop.BasePage;

public class LoginTest extends BasePage {

	HomePage home;
	MyAccountPage account;
	
	@Test
	public void login() {
		home = new HomePage(driver);
		home.goToMyAccountPage();
		account = new MyAccountPage(driver);
		account.fillInCredentialsToLogin();
		home.logout();
	}

}
