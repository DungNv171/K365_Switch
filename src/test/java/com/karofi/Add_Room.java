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

public class Add_Room extends BaseTest {
    private AndroidDriver driver;
    private LoginScreenObject loginScreen;
    private ChooseCountryScreenObject chooseCountryScreen;
    private HomeScreenObject homeScreen;
    private SettingScreenObject settingScreen;
    private DetailSettingScreenObject detailSettingScreen;
    private AddRoomScreenObject addRoomScreen;
    private HouseManageScreenObject houseManageScreen;
    private RoomManageScreenObject roomManageScreen;
    private PersonalScreenObject personalScreen;
    private String phoneNumber, password, switch1ButtonName, newRoomName, houseName;

    @BeforeTest
    public void beforeTest() throws MalformedURLException {
        driver = getDriver();
        chooseCountryScreen = ScreenGeneratorManager.getChooseCountryScreen(driver);

        phoneNumber = LoginData.PHONE_NUMBER;
        password = LoginData.PASSWORD;
        switch1ButtonName = SwitchData.SWITCH_1_BUTTON_NAME;
        newRoomName = "test room";
        houseName = SwitchData.HOUSE_NAME;

        //Pre-Conditions
        loginScreen = chooseCountryScreen.clickToContinueButton();
        loginScreen.enterToPhoneNumberTextbox(phoneNumber);
        loginScreen.enterToPasswordTextbox(password);
        homeScreen = loginScreen.clickToLoginButton();
        Assert.assertTrue(homeScreen.isHomeScreenDisplayed());
        settingScreen = homeScreen.chooseDevice(switch1ButtonName);
    }
    @Test
    public void Add_Room_01_Create_Room(){
        detailSettingScreen = settingScreen.clickToSettingBtnBySwitchName(switch1ButtonName);
        addRoomScreen = detailSettingScreen.openAddRoomScreen();
        addRoomScreen.clickAddRoomIcon();
        addRoomScreen.sendkeyToAddRoomTextBox(newRoomName);
        addRoomScreen.saveRoom();
        Assert.assertTrue(addRoomScreen.isCreatedRoomDisplayed(newRoomName));
        addRoomScreen.clickToBackTotalRoom();
        Assert.assertTrue(addRoomScreen.isRoomDisplayedAtTotalRoom(newRoomName));
    }

    @Test
    public void Add_Room_02_Add_Room(){
        addRoomScreen.clickToWantToAddRoom(newRoomName);
        addRoomScreen.clickToSaveIconToAddRoom();
        Assert.assertTrue(addRoomScreen.isSuccessMessageDisplayed());
        addRoomScreen.clickToReturnAddRoomScreen();
        detailSettingScreen = addRoomScreen.clickToDetailSettingScreen();
        settingScreen = detailSettingScreen.backToSettingScreen();
        homeScreen = settingScreen.backToHomeBySwitchName(switch1ButtonName);
        homeScreen.switchToRoomTab();
        Assert.assertTrue(homeScreen.isRoomDisplayedByName(newRoomName));
        homeScreen.clickToRoomByName(newRoomName);
        // đang bị che chờ tìm hiểu cách scroll trên mobile
        Assert.assertTrue(homeScreen.isAddedRoomSwitchDisplayed(newRoomName,switch1ButtonName));
    }

    @Test
    public void Add_Room_02_Remove_Room() {
        personalScreen = homeScreen.clickToPersonalScreen();
        houseManageScreen = personalScreen.openHouseManageScreen();
        roomManageScreen = houseManageScreen.openRoomManageSceenByHouseName(houseName);
        roomManageScreen.chooseRoomByName(newRoomName);
        roomManageScreen.clickToRemoveRoomBtn();
        roomManageScreen.clickToCancelActionRemove();

        roomManageScreen.clickToRemoveRoomBtn();
        roomManageScreen.clickToActionRemoveRoom();

        Assert.assertFalse(roomManageScreen.isRoomDisplayedByName(newRoomName));

    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
