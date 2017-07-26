package com.automation.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.prestashop.BasePage;

public class CheckoutPage extends BasePage {
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String FIRSTNAME = "Automation";
	public String LASTNAME = "Testing";
	public String STREET_ADDRESS = "Sirenelor, 91";
	public String EMAIL = "automation@testing.com";
	public String ZIP_CODE = "050855";
	public String CITY = "Bucuresti";
	public String PHONE = "0755467543";
	
	@FindBy(id = "customer_firstname")
	public WebElement firstName;

	@FindBy(id = "customer_lastname")
	public WebElement lastName;
	
	@FindBy(id = "customer_email")
	public WebElement email;

	@FindBy(id = "customer_conf_email")
	public WebElement confirmEmail;
	
	@FindBy(id = "delivery_address1")
	public WebElement streetAddress;
	
	@FindBy(id = "delivery_id_country")
	public WebElement country;
	
	@FindBy(id = "delivery_postcode")
	public WebElement zipCode;
	
	@FindBy(id = "delivery_id_state")
	public WebElement state;
	
	@FindBy(id = "delivery_city")
	public WebElement city;
	
	@FindBy(id = "delivery_phone_mobile")
	public WebElement phone;
	
	@FindBy(id = "btn_save_customer")
	public WebElement saveAddress;
	
	@FindBy(id = "module_payment_68_0")
	public WebElement payWithRamburs;
	
	@FindBy(id = "btn_place_order")
	public WebElement placeOrder;
	
	@FindBy(css = ".button.btn.btn-primary")
	public WebElement confirmPlaceOrder;
	
	@FindBy(className = "page-heading")
	public WebElement orderConfirmation;
	
	
	
	public void fillInShippingAddress() {
		waitForElementToBeDisplayed(firstName);
		fillInValue(firstName, FIRSTNAME);
		fillInValue(lastName, LASTNAME);
		fillInValue(email, EMAIL);
		fillInValue(confirmEmail, EMAIL);
		fillInValue(streetAddress, STREET_ADDRESS);
		fillInValue(zipCode, ZIP_CODE);
		wait(2);
		selectValueFromDropdown(state, "313");
		fillInValue(city, CITY);
		fillInValue(phone, PHONE);
	}
	
	public void selectRambursPaymentMethod() {
		scrollPageUp();
		clickElement(payWithRamburs);
	}
	
	public void placeOrder() {
		clickElement(placeOrder);
		clickElement(confirmPlaceOrder);
		waitForElementToBeDisplayed(orderConfirmation);
		assertionTrue(orderConfirmation, "COMANDA INREGISTRATA");
	}

}
