package com.stadiumgoods.practice.testscripts;

import com.stadiumgoods.practice.testbase.BaseClass;
import com.stadiumgoods.practice.utility.Screenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GuestCheckout extends BaseClass {


    @Test
    public void guestCheckout() throws Exception{
        checkoutPage.clickGuestCheckOut();
        checkoutPage.enterShippingInformation("testguestCheckout@gmail.com","guestCheckout","Doe","838 Dean St","Brooklyn",
                                                "New York","11210","7774443333");
        checkoutPage.enterShippingOptions();
        checkoutPage.enterCreditCardInfo();
        checkoutPage.clickPlaceMyOrder();
        Assert.assertEquals("Thank You!",checkoutPage.getConfirmationText());
        Screenshot.takeScreenshot(driver);
    }


    @Test
    public void registerCheckout() throws Exception{
        checkoutPage.clickRegisterAccount();
        checkoutPage.enterShippingInformation("testregisterCheckout@gmail.com","registerCheckout","Doe","838 Dean St","Brooklyn",
                "New York","11210","7774443333","abc1234");
        checkoutPage.enterShippingOptions();
        checkoutPage.enterCreditCardInfo();
        checkoutPage.clickPlaceMyOrder();
        Assert.assertEquals("Thank You!",checkoutPage.getConfirmationText());
        Screenshot.takeScreenshot(driver);
    }


    @Test
    public void logInCheckout() throws Exception{
        checkoutPage.logIn("testtoday@gmail.com","abc1234");
        checkoutPage.enterShippingInformation();
        checkoutPage.enterShippingOptions();
        checkoutPage.enterCreditCardInfo();
        checkoutPage.clickPlaceMyOrder();
        Assert.assertEquals("Thank You!",checkoutPage.getConfirmationText());
        Screenshot.takeScreenshot(driver);
    }
}

