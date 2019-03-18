package com.stadiumgoods.practice.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage {
    WebDriver driver;

    @FindBy(xpath = "//*[@version='1.1']")
    WebElement popUp;
    @FindBy(xpath = "//span[@class='icon-search svg-icon']")
    WebElement searchIcon;
    @FindBy(xpath = "//input[@placeholder='What are you looking for?']")
    WebElement searchBox;

    @FindBy(xpath = "//button[@title='Add to Cart']")
    WebElement addToCart;

    @FindBy(xpath = "//button[@title='Checkout']")
    WebElement checkout;

    @FindBy(xpath = "//h2[contains(text(),'adidas Yeezy')]")
    WebElement footerSupreme;

    @FindBy(xpath = "//ul[@class='products-grid column-count-3 first last odd']/li[1]")
    WebElement item;

    @FindBy(xpath = "//div[@class='product-sizes']//div[contains(@class,'product-sizes__selected')]")
    WebElement size;

    @FindBy(xpath = "//div[@id='product-options-wrapper']//label[1]")
    WebElement selectSize;





    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void cancelPopUp(){
        popUp.click();
    }

    public void searchAnItem(String item){
        searchIcon.click();
        searchBox.sendKeys(item);
        searchBox.submit();
    }

    public void clickAddToCart(){
        addToCart.click();
    }
    public void clickCheckout(){
        checkout.click();
    }

    public void clickFooterSupreme(){
        footerSupreme.click();
        item.click();
        size.click();
        selectSize.click();
    }


}
