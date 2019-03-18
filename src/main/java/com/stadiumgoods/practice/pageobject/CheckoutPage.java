package com.stadiumgoods.practice.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {

    WebDriver driver;

    @FindBy(xpath = "//label[@for='login:guest']")
    WebElement guestCheckout;
    @FindBy(xpath = "//input[@id='login:register']")
    WebElement registerAccount;
    @FindBy (xpath = "//button[@id='onepage-guest-register-button']")
    WebElement continueButton;

    @FindBy(xpath = "//input[@id='login-email']")
    WebElement loginEmail;
    @FindBy(xpath = "//input[@id='login-password']")
    WebElement loginPassword;
    @FindBy(xpath = "//div[@class='buttons-set login-container']//button[@type='submit']")
    WebElement loginButton;

    @FindBy (xpath = "//input[@id='shipping:email']")
    WebElement shippingEmail;
    @FindBy (xpath = "//input[@id='shipping:firstname']")
    WebElement firstName;
    @FindBy (xpath = "//input[@id='shipping:lastname']")
    WebElement lastName;
    @FindBy (xpath = "//input[@id='shipping:customer_password']")
    WebElement password;
    @FindBy (xpath = "//input[@id='shipping:confirm_password']")
    WebElement confirmPassword;
    @FindBy (xpath = "//input[@id='shipping:street1']")
    WebElement address;
    @FindBy (xpath = "//input[@id='shipping:city']")
    WebElement city;
    @FindBy (xpath = "//select[@id='shipping:region_id']")
    WebElement state;
    @FindBy (xpath = "//input[@id='shipping:postcode']")
    WebElement zip;
    @FindBy (xpath = "//input[@id='shipping:telephone']")
    WebElement phone;
    @FindBy (xpath = "//div[@id='shipping-buttons-container']//button[@title='Save and Continue']")
    WebElement saveAndContinue;



    @FindBy(xpath = "//label[@for='s_method_fedex_GROUND_HOME_DELIVERY']")
    WebElement groundShipping;
    @FindBy(id = "s_method_fedex_FEDEX_2_DAY")
    WebElement twoDayShipping;
    @FindBy (xpath = "//div[@id='shipping-method-buttons-container']//button[@title='Save and Continue']")
    WebElement saveAndContinueMethod;

    @FindBy(id= "p_method_creditcard")
    WebElement creditCard;
    @FindBy(xpath = "//input[@id='creditcard_cc_number']")
    WebElement creditCardNumber;
    @FindBy(xpath = "//select[@id='creditcard_expiration']")
    WebElement creditCardExpirationDate;
    @FindBy(xpath = "//select[@id='creditcard_expiration_yr']")
    WebElement creditCardYear;
    @FindBy(xpath = "//input[@id='creditcard_cc_cid']")
    WebElement creditCardCC;
    @FindBy(xpath = "//input[@placeholder='Billing Zip']")
    WebElement creditCardZip;
    @FindBy(xpath = "//div[@id='review-buttons-container']//button[@type='button']")
    WebElement placeMyOrder;

    @FindBy(xpath = "//h1[contains(text(),'Thank You!')]")
    WebElement confirmation;


    public CheckoutPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickGuestCheckOut(){
        guestCheckout.click();
        continueButton.click();
    }
    public void clickRegisterAccount(){
        registerAccount.click();
        continueButton.click();
    }

    public void logIn(String customerEmail, String customerPassword){
        loginEmail.sendKeys(customerEmail);
        loginPassword.sendKeys(customerPassword);
        loginButton.click();
    }
    public void enterShippingInformation(){
        saveAndContinue.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void enterShippingInformation(String customerShippingEmail, String customerFirstName, String customerLastName, String customerAddress,
                                 String customerCity, String customerState, String customerZip, String customerPhone){
        shippingEmail.sendKeys(customerShippingEmail);
        firstName.sendKeys(customerFirstName);
        lastName.sendKeys(customerLastName);
        address.sendKeys(customerAddress);
        city.sendKeys(customerCity);
        Select stateSelect = new Select(state);
        stateSelect.selectByVisibleText(customerState);
        zip.sendKeys(customerZip);
        phone.sendKeys(customerPhone);
        saveAndContinue.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void enterShippingInformation(String customerShippingEmail, String customerFirstName, String customerLastName, String customerAddress,
                                         String customerCity, String customerState, String customerZip, String customerPhone,String customerPassword){
        shippingEmail.sendKeys(customerShippingEmail);
        firstName.sendKeys(customerFirstName);
        lastName.sendKeys(customerLastName);
        password.sendKeys(customerPassword);
        confirmPassword.sendKeys(customerPassword);
        address.sendKeys(customerAddress);
        city.sendKeys(customerCity);
        Select stateSelect = new Select(state);
        stateSelect.selectByVisibleText(customerState);
        zip.sendKeys(customerZip);
        phone.sendKeys(customerPhone);
        saveAndContinue.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void enterShippingOptions(){
        saveAndContinueMethod.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void enterCreditCardInfo(){
        creditCard.click();
        creditCardNumber.sendKeys("4242424242424242");
        Select stateExpirationDate = new Select(creditCardExpirationDate);
        stateExpirationDate.selectByIndex(2);
        Select stateYear = new Select(creditCardYear);
        stateYear.selectByIndex(2);
        creditCardCC.sendKeys("111");
        creditCardZip.sendKeys("11111");
    }

    public void clickPlaceMyOrder(){
        placeMyOrder.click();
    }

    public String getConfirmationText(){
        return confirmation.getText();
    }


}
