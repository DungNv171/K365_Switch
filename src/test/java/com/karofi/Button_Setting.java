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

        phoneNumber = LoginData.PHONE_NUMBER;
        password = LoginData.PASSWORD;
        switch1ButtonName = SwitchData.SWITCH_1_BUTTON_NAME;
        s1BtnName = SwitchData.S1_BTN_NAME;


        //Pre-Conditions
        loginScreen = chooseCountryScreen.clickToContinueButton();
        loginScreen.enterToPhoneNumberTextbox(phoneNumber);
        loginScreen.enterToPasswordTextbox(password);
        homeScreen = loginScreen.clickToLoginButton();
        Assert.assertTrue(homeScreen.isHomeScreenDisplayed());
        settingScreen = homeScreen.chooseDevice(switch1ButtonName);
    }
    @Test
    public void TC_01_Rename_Switch_01_With_15_Charaters(){
        settingScreen.renameSwitch(switch1ButtonName,"switch 15 chars");
        settingScreen.isSwitchNameDisplayed("switch 15 chars");
        settingScreen.renameSwitch("switch 15 chars",switch1ButtonName);
        settingScreen.isSwitchNameDisplayed(switch1ButtonName);
    }
    @Test
    public void TC_02_Rename_Switch_02_With_25_Charaters(){
        settingScreen.renameSwitch(switch1ButtonName,"switch 15 charaterss name");
        settingScreen.isSwitchNameDisplayed("switch 15 charaterss name");
        settingScreen.renameSwitch("switch 15 charaterss name",switch1ButtonName);
        settingScreen.isSwitchNameDisplayed(switch1ButtonName);
    }
    @Test
    public void TC_03_Rename_Switch_03_With_26_Charaters(){
        settingScreen.renameSwitch(switch1ButtonName,"switch 15 charaterss names");
        settingScreen.isSwitchNameDisplayed("switch 15 charaterss name");
        settingScreen.renameSwitch("switch 15 charaterss name",switch1ButtonName);
        settingScreen.isSwitchNameDisplayed(switch1ButtonName);
    }

    @Test
    public void TC_04_Rename_Switch_04_Cancel_Action(){
        settingScreen.sendkeyToRenameSwitch(switch1ButtonName,"switch 15 charaterss names");
        settingScreen.cancelSaveNewNameSwitchBtn();
        settingScreen.isSwitchNameDisplayed(switch1ButtonName);
    }

    @Test
    public void TC_05_Rename_Button_01_With_15_Characters() {
        settingScreen.renameButton(s1BtnName,"button 15 chars");
        Assert.assertTrue(settingScreen.isButtonNameDisplayed("button 15 chars"));

        settingScreen.renameButton("button 15 chars", s1BtnName);
    }

    @Test
    public void TC_06_Rename_Button_02_With_25_Characters() {
        settingScreen.renameButton(s1BtnName,"button 25 charaterss name");
        Assert.assertTrue(settingScreen.isButtonNameDisplayed("button 25 charaterss name"));

        settingScreen.renameButton("button 25 charaterss name", s1BtnName);
    }

   @Test
    public void TC_07_Rename_Button_03_With_26_Characters() {
        settingScreen.renameButton(s1BtnName,"button 25 charaterss names");
        Assert.assertTrue(settingScreen.isButtonNameDisplayed("button 25 charaterss name"));

        settingScreen.renameButton("button 25 charaterss name", s1BtnName);
    }

    @Test
    public void TC_08_Label_01_Search_Label() {
        settingScreen.pressToButton(s1BtnName);
        addLabelScreen = settingScreen.clickToAddLabel();
        addLabelScreen.searchLabel("Đèn");
        Assert.assertTrue(addLabelScreen.isLabelDisplayed("Đèn"));
    }

    @Test
    public void TC_09_Label_02_Add_Label() {
        addLabelScreen.addLabel("Đèn");
        addLabelScreen.clickSaveButton();
        settingScreen = addLabelScreen.clickToBackToSettingButton();
        settingScreen.isLabelAdded("Đèn");
    }

    @Test
    public void TC_10_Label_03_Change_Label() {
        addLabelScreen.addLabel("Tivi");
        addLabelScreen.clickSaveButton();
        settingScreen = addLabelScreen.clickToBackToSettingButton();
        settingScreen.isLabelAdded("Tivi");
    }

    @Test
    public void TC_11_Label_04_Remove_Label() {
        addLabelScreen = settingScreen.clickToAddLabel();
        addLabelScreen.removeLabel("Đèn");
        addLabelScreen.clickSaveButton();
        settingScreen = addLabelScreen.clickToBackToSettingButton();
        settingScreen.isLabelAdded("");
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
