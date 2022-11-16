package com.karofi;

import common.BaseTest;
import common.ScreenGeneratorManager;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import screenObjects.*;
import testdata.UserData.LoginData;
import testdata.UserData.SwitchData;

import java.net.MalformedURLException;

public class Add_Favourite extends BaseTest {
    private AndroidDriver driver;
    private LoginScreenObject loginScreen;
    private ChooseCountryScreenObject chooseCountryScreen;
    private HomeScreenObject homeScreen;
    private SettingScreenObject settingScreen;
    private DetailSettingScreenObject detailSettingScreen;
    private String phoneNumber, password, switch1ButtonName;

    @BeforeTest
    public void beforeTest() throws MalformedURLException {
        driver = getDriver();
        chooseCountryScreen = ScreenGeneratorManager.getChooseCountryScreen(driver);

        phoneNumber = LoginData.PHONE_NUMBER;
        password = LoginData.PASSWORD;
        switch1ButtonName = SwitchData.SWITCH_1_BUTTON_NAME;

        //Pre-Conditions
        loginScreen = chooseCountryScreen.clickToContinueButton();
        loginScreen.enterToPhoneNumberTextbox(phoneNumber);
        loginScreen.enterToPasswordTextbox(password);
        homeScreen = loginScreen.clickToLoginButton();
        Assert.assertTrue(homeScreen.isHomeScreenDisplayed());
        settingScreen = homeScreen.chooseDevice(switch1ButtonName);
    }
    @Test
    public void Add_Favourite_01_Add(){
        detailSettingScreen = settingScreen.clickToSettingBtnBySwitchName(switch1ButtonName);
        detailSettingScreen.clickToAddToFavouriteIcon();
        settingScreen = detailSettingScreen.backToSettingScreen();
        homeScreen = settingScreen.backToHomeBySwitchName(switch1ButtonName);
        sleepInSecond(7);
        Assert.assertTrue(homeScreen.isFavouriteSwitchDisplayByName(switch1ButtonName));
        settingScreen = homeScreen.chooseDevice(switch1ButtonName);
    }

    @Test
    public void Add_Favourite_02_Remove(){
        detailSettingScreen = settingScreen.clickToSettingBtnBySwitchName(switch1ButtonName);
        detailSettingScreen.clickToAddToFavouriteIcon();
        settingScreen = detailSettingScreen.backToSettingScreen();
        homeScreen = settingScreen.backToHomeBySwitchName(switch1ButtonName);
        sleepInSecond(7);
        Assert.assertFalse(homeScreen.isFavouriteSwitchDisplayByName(switch1ButtonName));
        settingScreen = homeScreen.chooseDevice(switch1ButtonName);
    }


    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
