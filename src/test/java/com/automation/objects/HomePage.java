package com.automation.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.prestashop.BasePage;
import com.automation.prestashop.GenerateRandomString;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	final String loginButtonLocator = ".header_item.login";
	final String emailAddressFieldLocator = "email_create";
	final String submitCreateAccountLocator = "SubmitCreate";
	final String genderLocator = "id_gender1";
	final String customerFirstNameLocator = "customer_firstname";
	final String customerLastNameLocator = "customer_lastname";
	final String customerPasswordLocator = "passwd";
	final String customerBirthDayLocator = "uniform-days";
	final String customerBirthDaySelectLocator = "days";
	final String customerBirthMonthLocator = "months";
	final String customerBirthYearLocator = "years";
	final String submitAccountCreationLocator = "submitAccount";
	final String accountCreationConfirmationMessageLocator = "alert-success";
	
	public String EMAIL_CREATE_ACCOUNT = GenerateRandomString.randomEmail();
	public String FIRSTNAME = "Alex";
	public String LASTNAME = "Deloreanu";
	public String PASSWORD = "stevemadden";
	public String BIRTHDAY_VALUE = "3";
	public String BIRTHMONTH_VALUE = "3";
	public String BIRTHYEAR_VALUE = "1990";
	public String ACCOUNT_CREATION_CONF_MESSAGE = "Contul tau a fost creat";
	
	
	@FindBy(css  = loginButtonLocator)
	public WebElement loginButton;
	
	@FindBy(id = emailAddressFieldLocator)
	public WebElement emailAddressField;
	
	@FindBy(id = submitCreateAccountLocator)
	public WebElement submitCreateAccountButton;
	
	@FindBy(id = genderLocator)
	public WebElement gender;
	
	@FindBy(id = customerFirstNameLocator)
	public WebElement customerFirstName;

	@FindBy(id = customerLastNameLocator)
	public WebElement customerLastName;

	@FindBy(id = customerPasswordLocator)
	public WebElement customerPassword;
	
	@FindBy(id = customerBirthDayLocator)
	public WebElement customerBirthDay;
	
	@FindBy(id = customerBirthDaySelectLocator)
	public WebElement customerBirthDaySelect;
	
	@FindBy(id = customerBirthMonthLocator)
	public WebElement customerBirthMonth;
	
	@FindBy(id = customerBirthYearLocator)
	public WebElement customerBirthYear;
	
	@FindBy(id = submitAccountCreationLocator)
	public WebElement submitAccountCreation;
	
	@FindBy(className = accountCreationConfirmationMessageLocator)
	public WebElement accountCreationConfirmationMessage;
}
