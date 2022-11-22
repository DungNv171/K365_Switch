package com.karofi;

import common.AppAndDeviceData;
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

public class Change_Wifi extends BaseTest {
    private AndroidDriver driver;
    private LoginScreenObject loginScreen;
    private ChooseCountryScreenObject chooseCountryScreen;
    private HomeScreenObject homeScreen;
    private SettingScreenObject settingScreen;
    private DetailSettingScreenObject detailSettingScreen;
    private ChangeWifiScreenObject changeWifiScreen;
    private SettingWifiScreenObject settingWifiScreen;
    private String phoneNumber, password, switch1ButtonName, wifiName, wifiPassword;

    @BeforeTest
    public void beforeTest() throws MalformedURLException {
        driver = getDriver();
        chooseCountryScreen = ScreenGeneratorManager.getChooseCountryScreen(driver);

        phoneNumber = LoginData.PHONE_NUMBER;
        password = LoginData.PASSWORD;
        switch1ButtonName = SwitchData.SWITCH_1_BUTTON_NAME;
        wifiName = AppAndDeviceData.WIFI_NAME;
        wifiPassword = AppAndDeviceData.WIFI_PASSWORD;

        //Pre-Conditions
        loginScreen = chooseCountryScreen.clickToContinueButton();
        loginScreen.enterToPhoneNumberTextbox(phoneNumber);
        loginScreen.enterToPasswordTextbox(password);
        homeScreen = loginScreen.clickToLoginButton();
        Assert.assertTrue(homeScreen.isHomeScreenDisplayed());
        settingScreen = homeScreen.chooseDevice(switch1ButtonName);
    }
    @Test
    public void Change_Wifi_01_Add(){
        detailSettingScreen = settingScreen.clickToSettingBtnBySwitchName(switch1ButtonName);
        detailSettingScreen.clickToNavigateByNameScreen(driver, "Chỉnh sửa Wi-Fi");
        //Đợi mạch
        sleepInSecond(5);
        changeWifiScreen = ScreenGeneratorManager.getChangeWifiScreen(driver);
        changeWifiScreen.clickToChangeWifiButton();
        settingWifiScreen = ScreenGeneratorManager.getSettingWifiScreen(driver);

        // thoat khoi list danh sach wifi -> test nut cancel
        settingWifiScreen.clickButtonToListWifi();
        settingWifiScreen.cancelChangeWifi();

        //test chuc nang thay doi wifi
        settingWifiScreen.clickButtonToListWifi();
        settingWifiScreen.changeWifi(wifiName, wifiPassword);
        Assert.assertTrue(settingWifiScreen.isSucessChageWifiMessage());
        changeWifiScreen = settingWifiScreen.clickToSettingWifiScreen();
        sleepInSecond(30);
        Assert.assertTrue(changeWifiScreen.isChangedWifiDisplayed(wifiName));
    }
    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
