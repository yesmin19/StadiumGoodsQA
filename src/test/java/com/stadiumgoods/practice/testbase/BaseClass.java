package com.stadiumgoods.practice.testbase;

import com.stadiumgoods.practice.pageobject.CheckoutPage;
import com.stadiumgoods.practice.pageobject.HomePage;
import com.stadiumgoods.practice.utility.Constant;
import com.stadiumgoods.practice.utility.Screenshot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseClass {
    protected WebDriver driver;
    protected HomePage homePage;
    protected CheckoutPage checkoutPage;


    @BeforeMethod
    public void beforeClass(){
        System.setProperty(Constant.chromeDriverKey, Constant.chromeDriverPath);
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        checkoutPage = new CheckoutPage(driver);
        String URL = "http://" + Constant.userNameStage + ":" + Constant.passwordStage + "@" + Constant.baseURLStage;
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get(URL);
        driver.manage().window().maximize();

        homePage.cancelPopUp();
        homePage.clickFooterSupreme();
        homePage.clickAddToCart();
        homePage.clickCheckout();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }



}
