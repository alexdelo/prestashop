package com.automation.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.prestashop.BasePage;
import com.automation.prestashop.GenerateRandomString;

public class MyAccountPage extends BasePage {
	
	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String EMAIL_CREATE_ACCOUNT = GenerateRandomString.randomEmail();
	public String FIRSTNAME = "Alex";
	public String LASTNAME = "Deloreanu";
	public String PASSWORD = "stevemadden";
	public String BIRTHDAY_VALUE = "3";
	public String BIRTHMONTH_VALUE = "3";
	public String BIRTHYEAR_VALUE = "1990";
	public String ACCOUNT_CREATION_CONF_MESSAGE = "Contul tau a fost creat";
	
	public String EMAIL_LOGIN = "automation@testing.com";
	public String PASSWORD_LOGIN = "stevemadden";
	
	@FindBy(id = "email_create")
	public WebElement emailAddressField;
	
	@FindBy(id = "SubmitCreate")
	public WebElement submitCreateAccountButton;
	
	@FindBy(id = "id_gender1")
	public WebElement gender;
	
	@FindBy(id = "customer_firstname")
	public WebElement customerFirstName;

	@FindBy(id = "customer_lastname")
	public WebElement customerLastName;

	@FindBy(id = "passwd")
	public WebElement customerPassword;
	
	@FindBy(id = "uniform-days")
	public WebElement customerBirthDay;
	
	@FindBy(id = "months")
	public WebElement customerBirthMonth;
	
	@FindBy(id = "years")
	public WebElement customerBirthYear;
	
	@FindBy(id = "submitAccount")
	public WebElement submitAccountCreation;
	
	@FindBy(className = "alert-success")
	public WebElement accountCreationConfirmationMessage;
	
	@FindBy(id = "email")
	public WebElement emailLogin;
	
	@FindBy(id = "SubmitLogin")
	public WebElement submitLoginButton;
	
	@FindBy(css = ".info-account")
	public WebElement loginConfirmation;
	
	
	
	
	public void fillInCredentialsToLogin() {
		fillInValue(emailLogin, EMAIL_LOGIN);
		fillInValue(customerPassword, PASSWORD_LOGIN);
		clickElement(submitLoginButton);
		assertionTrue(loginConfirmation, "Welcome to your account");
	}
	
	public void fillInEmailAddressToCreateAccount() {
		fillInValue(emailAddressField, EMAIL_CREATE_ACCOUNT);
		clickElement(submitCreateAccountButton);
	}
	
	public void fillInDetailsToCreateAccountAndSubmit() {
		fillInValue(customerFirstName, FIRSTNAME);
		fillInValue(customerLastName, LASTNAME);
		fillInValue(customerPassword, PASSWORD);
		clickElement(submitAccountCreation);
		assertionTrue(accountCreationConfirmationMessage, ACCOUNT_CREATION_CONF_MESSAGE);
	}
}
