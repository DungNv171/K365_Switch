package com.karofi;

import common.BaseTest;
import common.ScreenGeneratorManager;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import screenObjects.ChooseCountryScreenObject;
import screenObjects.HomeScreenObject;
import screenObjects.LoginScreenObject;

public class Login extends BaseTest {
    private AndroidDriver driver;
    private LoginScreenObject loginScreen;
    private ChooseCountryScreenObject chooseCountryScreen;
    private HomeScreenObject homeScreen;

    @BeforeTest
    public void beforeTest() throws MalformedURLException {
        driver = getDriver();
        chooseCountryScreen = ScreenGeneratorManager.getChooseCountryScreen(driver);
    }

    @Test
    public void TC_01_Login_With_Empty_Data() {
        loginScreen = chooseCountryScreen.clickToContinueButton();
        loginScreen.clickToLoginButton();
        Assert.assertTrue(loginScreen.isErrorNumberPhoneMessageDisplayed());
        Assert.assertTrue(loginScreen.isErrorPasswordTextboxDisplayed());
    }

    @Test
    public void TC_02_Login_With_Empty_Password() {
        loginScreen.enterToPhoneNumberTextbox("0378608231");
        homeScreen = loginScreen.clickToLoginButton();
        Assert.assertTrue(loginScreen.isErrorPasswordTextboxDisplayed());
    }

    @Test
    public void TC_03_Login_Success() {
        loginScreen.enterToPhoneNumberTextbox("0378608231");
        loginScreen.enterToPasswordTextbox("aqws1234");
        homeScreen = loginScreen.clickToLoginButton();
        Assert.assertTrue(homeScreen.isHomeScreenDisplayed());
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
