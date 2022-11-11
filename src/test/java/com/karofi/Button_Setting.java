package com.karofi;

import common.BaseTest;
import common.ScreenGeneratorManager;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import screenObjects.*;
import testdata.UserData.SwitchData;
import testdata.UserData.LoginData;

import java.net.MalformedURLException;

public class Button_Setting extends BaseTest {
    private AndroidDriver driver;
    private LoginScreenObject loginScreen;
    private ChooseCountryScreenObject chooseCountryScreen;
    private HomeScreenObject homeScreen;
    private SettingScreenObject settingScreen;
    private AddLabelScreenObject addLabelScreen;
    private String phoneNumber, password, switch1ButtonName, s1BtnName;

    @BeforeTest
    public void beforeTest() throws MalformedURLException {
        driver = getDriver();
        chooseCountryScreen = ScreenGeneratorManager.getChooseCountryScreen(driver);

        phoneNumber = LoginData.phoneNumber;
        password = LoginData.password;
        switch1ButtonName = SwitchData.switch1ButtonName;
        s1BtnName = SwitchData.s1BtnName;


        //Pre-Conditions
        loginScreen = chooseCountryScreen.clickToContinueButton();
        loginScreen.enterToPhoneNumberTextbox(phoneNumber);
        loginScreen.enterToPasswordTextbox(password);
        homeScreen = loginScreen.clickToLoginButton();
        Assert.assertTrue(homeScreen.isHomeScreenDisplayed());
    }

    @Test
    public void TC_01_Rename_Button_With_15_Characters() {
        settingScreen = homeScreen.chooseDevice(switch1ButtonName);
        settingScreen.renameButton(s1BtnName,"button 15 chars");
        Assert.assertTrue(settingScreen.isButtonNameDisplayed("button 15 chars"));

        settingScreen.renameButton("button 15 chars", s1BtnName);
    }

    @Test
    public void TC_02_Rename_Button_With_25_Characters() {
        settingScreen.renameButton(s1BtnName,"button 25 charaterss name");
        Assert.assertTrue(settingScreen.isButtonNameDisplayed("button 25 charaterss name"));

        settingScreen.renameButton("button 25 charaterss name", s1BtnName);
    }

   @Test
    public void TC_03_Rename_Button_With_26_Characters() {
        settingScreen.renameButton(s1BtnName,"button 25 charaterss names");
        Assert.assertTrue(settingScreen.isButtonNameDisplayed("button 25 charaterss name"));

        settingScreen.renameButton("button 25 charaterss name", s1BtnName);
    }

    @Test
    public void TC_04_Search_Label() {
        settingScreen.pressToButton(s1BtnName);
        addLabelScreen = settingScreen.clickToAddLabel();
        addLabelScreen.searchLabel("Đèn");
        Assert.assertTrue(addLabelScreen.isLabelDisplayed("Đèn"));
    }

    @Test
    public void TC_05_Add_Label() {
        addLabelScreen.chooseLabel("Đèn");
        addLabelScreen.clickSaveButton();
    }




    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
