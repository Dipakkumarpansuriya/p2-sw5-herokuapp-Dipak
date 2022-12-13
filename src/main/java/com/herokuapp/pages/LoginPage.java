package com.herokuapp.pages;

import com.herokuapp.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;


public class LoginPage extends Utility {

    LoginPage loginPage;

    public void inIt() {
        loginPage = new LoginPage();
    }

    @CacheLookup
    @FindBy(id = "username")
    WebElement userNameBox;


    @CacheLookup
    @FindBy(id = "password")
    WebElement userPasswordbox;

    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//h2[text()=' Secure Area']")
    WebElement secureAreaText;

    @CacheLookup
    @FindBy(xpath = "//div[@id='flash-messages']")
    WebElement invalidCredentialMessage;


    //******************************************************

    public void enterUserName(String userNameText) {
        Reporter.log("Enter User Name" + userNameBox.toString());
        sendTextToElement(userNameBox, userNameText);
    }

    public void enterPassword(String passwordText) {
        Reporter.log("Enter Password" + userPasswordbox.toString());
        sendTextToElement(userPasswordbox, passwordText);
    }

    public void clickOnLoginButton() {
        Reporter.log("Click On Login Button" + loginButton.toString());
        clickOnElement(loginButton);
    }

    public String getSecureAreaText() {
        Reporter.log("get Secure Area Text" + secureAreaText.toString());
        return getTextFromElement(secureAreaText);
    }

    public String invalidUserAndPasswordMessage() {
        Reporter.log("invalid User And Password Message" + invalidCredentialMessage.toString());
        return getTextFromElement(invalidCredentialMessage).substring(0, 25);
    }
}

