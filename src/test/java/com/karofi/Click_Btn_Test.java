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

public class Click_Btn_Test extends BaseTest {
    private AndroidDriver driver;
    private LoginScreenObject loginScreen;
    private ChooseCountryScreenObject chooseCountryScreen;
    private HomeScreenObject homeScreen;
    private SettingScreenObject settingScreen;
    private DetailSettingScreenObject detailSettingScreen;
    private String phoneNumber, password, switch1ButtonName, btnName;

    @BeforeTest
    public void beforeTest() throws MalformedURLException {
        driver = getDriver();
        chooseCountryScreen = ScreenGeneratorManager.getChooseCountryScreen(driver);

        phoneNumber = LoginData.PHONE_NUMBER;
        password = LoginData.PASSWORD;
        switch1ButtonName = SwitchData.SWITCH_1_BUTTON_NAME;
        btnName = SwitchData.S1_BTN_NAME;

        //Pre-Conditions
        loginScreen = chooseCountryScreen.clickToContinueButton();
        loginScreen.enterToPhoneNumberTextbox(phoneNumber);
        loginScreen.enterToPasswordTextbox(password);
        homeScreen = loginScreen.clickToLoginButton();
        Assert.assertTrue(homeScreen.isHomeScreenDisplayed());
        settingScreen = homeScreen.chooseDevice(switch1ButtonName);
    }
    @Test
    public void Click_Btn_Test_N_Times(){
        settingScreen.clickBtn(10, btnName);
    }


    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
