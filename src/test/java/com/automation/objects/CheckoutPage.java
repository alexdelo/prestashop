package com.automation.objects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.prestashop.BasePage;
import com.google.common.base.CharMatcher;

import junit.framework.Assert;

public class CheckoutPage extends BasePage {

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String FIRSTNAME = "Automation";
	public String LASTNAME = "Testing";
	public String STREET_ADDRESS = "Sirenelor, 91";
	public String EMAIL = "testaccount2@email.com";
	public String ZIP_CODE = "050855";
	public String CITY = "Bucuresti";
	public String PHONE = "0755467543";

	public String EMAIL_LOGIN = "testaccount@email.com";
	public String PASSWORD_LOGIN = "stevemadden";

	@FindBy(id = "customer_firstname")
	public WebElement firstName;

	@FindBy(id = "customer_lastname")
	public WebElement lastName;

	@FindBy(id = "customer_email")
	public WebElement email;

	@FindBy(id = "customer_conf_email")
	public WebElement confirmEmail;

	@FindBy(id = "delivery_firstname")
	public WebElement deliveryFirstName;

	@FindBy(id = "delivery_lastname")
	public WebElement deliveryLastname;

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

	@FindBy(id = "module_payment_182_0")
	public WebElement payWithRamburs;

	@FindBy(id = "module_payment_211_0")
	public WebElement payWithMobilePay;

	@FindBy(className = "payment_input")
	public List<WebElement> paymentOptions;

	@FindBy(id = "btn_place_order")
	public WebElement placeOrder;

	@FindBy(css = ".button.btn.btn-primary")
	public WebElement confirmPlaceOrder;

	@FindBy(className = "confirm")
	public WebElement orderConfirmation;

	@FindBy(id = "opc_show_login")
	public WebElement signInButton;

	@FindBy(id = "txt_login_email")
	public WebElement loginEmailField;

	@FindBy(id = "txt_login_password")
	public WebElement loginPasswordField;

	@FindBy(id = "btn_login")
	public WebElement submitLoginButton;

	public static WebElement paymentCardNumber;
	public static WebElement paymentCardName;
	public static WebElement paymentExpMonth;
	public static WebElement paymentExpYear;
	public static WebElement paymentCVV2Number;

	@FindBy(css = ".btn.btn-primary.btn-block.btn-large")
	public WebElement submitPayment;

	public void clickSignInButton() {
		wait(2);
		clickElement(signInButton);
	}

	public void signInFromCheckout() {
		fillInValue(loginEmailField, EMAIL_LOGIN);
		fillInValue(loginPasswordField, PASSWORD_LOGIN);
		clickElement(submitLoginButton);
		wait(2);
	}

	public void fillInShippingAddress() {
		waitForElementToBeDisplayed(firstName);
		fillInValue(firstName, FIRSTNAME);
		fillInValue(lastName, LASTNAME);
		fillInValue(email, EMAIL);
		fillInValue(streetAddress, STREET_ADDRESS);
		selectValueFromDropdown(state, "313");
		fillInValue(city, CITY);
		fillInValue(phone, PHONE);
	}

	public void selectRambursPaymentMethod() {
		wait(2);
		clickElement(paymentOptions.get(0));
	}

	public void selectMobilePayPaymentMethod() {
		wait(2);
		clickElement(paymentOptions.get(1));
	}

	public void selectBankWirePaymentMethod() {
		wait(2);
		clickElement(paymentOptions.get(2));
	}
	
	@FindBy(id = "cgv")
	public WebElement termsAndConditions;

	public void checkTermsAndConditions() {
		scrollIntoView(termsAndConditions);
		clickElement(termsAndConditions);
	}
	
	public void fillInPaymentInformationAndSubmit() {
		clickElement(placeOrder);
		fillInValue(paymentCardNumber, "9900004810225098");
		fillInValue(paymentCardName, "Test Test");
		wait(2);
		selectValueFromDropdown(paymentExpMonth, "6");
		selectValueFromDropdown(paymentExpYear, "2020");
		fillInValue(paymentCVV2Number, "111");
		clickElement(submitPayment);
		waitForElementToBeDisplayed(orderConfirmation);
		assertionTrue(orderConfirmation, "FELICITARI! COMANDA TA A FOST PLASATA CU SUCCES!");
	}

	public void placeOrder() {
		clickElement(placeOrder);
		clickElement(confirmPlaceOrder);
		waitForElementToBeDisplayed(orderConfirmation);
		assertionTrue(orderConfirmation, "FELICITARI! COMANDA TA A FOST PLASATA CU SUCCES!");
	}

	@FindBy(css = ".btn-number.cart_quantity_delete")
	public WebElement removeButton;

	@FindBy(css = ".alert.alert-warning")
	public WebElement emptyCartMessage;


	public void removeProduct() {
		clickElement(removeButton);
		wait(2);
		assertionTrue(emptyCartMessage, "Cosul tau de cumparaturi este gol");
	}

	@FindBy(id = "total_product")
	public WebElement productPrice;

	@FindBy(className = "cart_discount_price")
	public WebElement totalDiscount;

	@FindBy(id = "total_price")
	public WebElement totalPrice;

	@FindBy(id = "discount_name")
	public WebElement promoCodeField;

	@FindBy(className = "cart_discount_name")
	public WebElement promoCodeName;
	
	public WebElement submitAddDiscount;
	
	

	public void applyPromoCode() {
		waitForElementToBeDisplayed(promoCodeField);
		fillInValue(promoCodeField, "automationPromoCode");
		clickElement(submitAddDiscount);
		waitForElementToBeDisplayed(promoCodeName);
		assertionTrue(promoCodeName, "automation testing");
		int merchandiseTotal = Integer.parseInt(CharMatcher.digit().retainFrom(productPrice.getText()));
		int orderDiscount = Integer.parseInt(CharMatcher.digit().retainFrom(totalDiscount.getText()));		
		if (merchandiseTotal % 2 == 0) {
			Assert.assertEquals(merchandiseTotal / 2, orderDiscount);
		} else {
			Assert.assertEquals((merchandiseTotal + 1) / 2, orderDiscount);
		}	
	}


}
