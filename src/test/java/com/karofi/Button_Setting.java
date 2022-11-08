package com.karofi;

import common.BaseTest;
import common.ScreenGeneratorManager;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import screenObjects.ChooseCountryScreenObject;
import screenObjects.HomeScreenObject;
import screenObjects.LoginScreenObject;
import screenObjects.SettingScreenObject;

import java.net.MalformedURLException;

public class Button_Setting extends BaseTest {
    private AndroidDriver driver;
    private LoginScreenObject loginScreen;
    private ChooseCountryScreenObject chooseCountryScreen;
    private HomeScreenObject homeScreen;
    private SettingScreenObject settingScreen;

    @BeforeTest
    public void beforeTest() throws MalformedURLException {
        driver = getDriver();
        chooseCountryScreen = ScreenGeneratorManager.getChooseCountryScreen(driver);

        //Pre-Conditions
        loginScreen = chooseCountryScreen.clickToContinueButton();
        loginScreen.enterToPhoneNumberTextbox("0378608231");
        loginScreen.enterToPasswordTextbox("aqws1234");
        homeScreen = loginScreen.clickToLoginButton();
        Assert.assertTrue(homeScreen.isHomeScreenDisplayed());
    }

    @Test
    public void TC_01_Rename_Button_With_15_Characters() {
        settingScreen = homeScreen.chooseDevice("4.nuts");
        settingScreen.renameButton("Nút bấm 3","button 15 chars");
        Assert.assertTrue(settingScreen.isButtonNameDisplayed("button 15 chars"));

        settingScreen.renameButton("button 15 chars", "Nút bấm 3");
    }

    @Test
    public void TC_02_Rename_Button_With_25_Characters() {
        settingScreen.renameButton("Nút bấm 3","button 25 charaterss name");
        Assert.assertTrue(settingScreen.isButtonNameDisplayed("button 25 charaterss name"));

        settingScreen.renameButton("button 25 charaterss name", "Nút bấm 3");
    }

    @Test
    public void TC_03_Rename_Button_With_26_Characters() {
        settingScreen.renameButton("Nút bấm 3","button 25 charaterss names");
        Assert.assertTrue(settingScreen.isButtonNameDisplayed("button 25 charaterss name"));

        settingScreen.renameButton("button 25 charaterss name", "Nút bấm 3");
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
