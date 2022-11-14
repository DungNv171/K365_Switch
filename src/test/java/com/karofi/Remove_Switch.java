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

public class Remove_Switch extends BaseTest {
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

        phoneNumber = LoginData.phoneNumber;
        password = LoginData.password;
        switch1ButtonName = SwitchData.switch1ButtonName;

        //Pre-Conditions
        loginScreen = chooseCountryScreen.clickToContinueButton();
        loginScreen.enterToPhoneNumberTextbox(phoneNumber);
        loginScreen.enterToPasswordTextbox(password);
        homeScreen = loginScreen.clickToLoginButton();
        Assert.assertTrue(homeScreen.isHomeScreenDisplayed());
        settingScreen = homeScreen.chooseDevice(switch1ButtonName);
    }
    @Test
    public void Remove_Switch_01_Cancel_Action_Remove(){
        settingScreen.clickToSettingBtnBySwitchName(switch1ButtonName);
        settingScreen.cancelRemoveSwitch();
        homeScreen = settingScreen.backToHomeBySwitchName(switch1ButtonName);
        Assert.assertTrue(homeScreen.isSwitchDisplayedByName(switch1ButtonName));
        settingScreen = homeScreen.chooseDevice(switch1ButtonName);
    }

    @Test
    public void Remove_Switch_02_Accept_Action_Remove(){
        settingScreen.clickToSettingBtnBySwitchName(switch1ButtonName);
        homeScreen = settingScreen.clickRemoveSwitch();
        Assert.assertFalse(homeScreen.isSwitchDisplayedByName(switch1ButtonName));
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}