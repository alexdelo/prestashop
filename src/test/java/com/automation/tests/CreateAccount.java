package com.automation.tests;

import org.testng.annotations.Test;

import com.automation.objects.HomePage;
import com.automation.prestashop.BasePage;

public class CreateAccount extends BasePage {

	HomePage home;
	
	@Test
	public void createNewAccount() {
		home = new HomePage(driver);
		clickElement(home.loginButton);
		fillInValue(home.emailAddressField, home.EMAIL_CREATE_ACCOUNT);
		clickElement(home.submitCreateAccountButton);
		clickElement(home.gender);
		fillInValue(home.customerFirstName, home.FIRSTNAME);
		fillInValue(home.customerLastName, home.LASTNAME);
		fillInValue(home.customerPassword, home.PASSWORD);
		selectValueFromDropdown(home.customerBirthDay, home.BIRTHDAY_VALUE);
		selectValueFromDropdown(home.customerBirthMonth, home.BIRTHMONTH_VALUE);
		selectValueFromDropdown(home.customerBirthYear, home.BIRTHYEAR_VALUE);
		clickElement(home.submitAccountCreation);
		assertionTrue(home.accountCreationConfirmationMessage, home.ACCOUNT_CREATION_CONF_MESSAGE);
	}
}
