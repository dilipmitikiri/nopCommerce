package com.nopcommerce.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver localdriver;

    public LoginPage(WebDriver remotedriver) {
        localdriver = remotedriver;
        PageFactory.initElements(remotedriver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Log in')]")
    WebElement loginLink;

    @FindBy(xpath = "//input[@id='Email']")
    WebElement emailIdTextField;

    @FindBy(xpath = "//input[@id='Password']")
    WebElement passwordTextField;

    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    WebElement loginButton;

    public void clickLoginLink() {
        loginLink.click();
    }

    public void setEmailId(String user) {
        emailIdTextField.sendKeys(user);
    }

    public void setPassword(String pswd) {
        passwordTextField.sendKeys(pswd);
    }

    public void clickLoginButton() {
        loginButton.click();
    }


}
