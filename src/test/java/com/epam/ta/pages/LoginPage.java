package com.epam.ta.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private final String BASE_URL = "https://github.com/login";

    @FindBy(id = "login_field")
    @CacheLookup
    private WebElement inputLogin;

    @FindBy(id = "password")
    @CacheLookup
    private WebElement inputPassword;

    @FindBy(xpath = "//input[@value='Sign in']")
    @CacheLookup
    private WebElement buttonSubmit;

    @FindBy(xpath = "//meta[@name='user-login']")
    @CacheLookup
    private WebElement linkLoggedInUser;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Login page opened");
    }

    public void login(String username, String password) {
        inputLogin.sendKeys(username);
        inputPassword.sendKeys(password);
        buttonSubmit.click();
        logger.info("Login performed");
    }

    public String getLoggedInUserName() {
        return linkLoggedInUser.getAttribute("content");
    }

}
