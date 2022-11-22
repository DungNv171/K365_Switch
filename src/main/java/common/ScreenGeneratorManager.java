package common;

import io.appium.java_client.android.AndroidDriver;
import screenObjects.*;

public class ScreenGeneratorManager {
    public static LoginScreenObject getLoginScreen(AndroidDriver driver) {
        return new LoginScreenObject(driver);
    }

    public static ChooseCountryScreenObject getChooseCountryScreen(AndroidDriver driver) {
        return new ChooseCountryScreenObject(driver);
    }

    public static HomeScreenObject getHomeScreen(AndroidDriver driver) {
        return new HomeScreenObject(driver);
    }

    public static SettingScreenObject getSettingScreen(AndroidDriver driver) {
        return new SettingScreenObject(driver);
    }

    public static AddLabelScreenObject getAddLabelScreen(AndroidDriver driver) {
        return new AddLabelScreenObject(driver);
    }

    public static DetailSettingScreenObject getDetailSettingScreen(AndroidDriver driver) {
        return new DetailSettingScreenObject(driver);
    }

    public static AddRoomScreenObject getAddRoomScreen(AndroidDriver driver) {
        return new AddRoomScreenObject(driver);
    }

    public static HouseManageScreenObject getHouseManageScreen(AndroidDriver driver) {
        return new HouseManageScreenObject(driver);
    }

    public static PersonalScreenObject getPersonalScreen(AndroidDriver driver) {
        return new PersonalScreenObject(driver);
    }

    public static RoomManageScreenObject getRoomManageScreen(AndroidDriver driver) {
        return new RoomManageScreenObject(driver);
    }

    public static ChangeWifiScreenObject getChangeWifiScreen(AndroidDriver driver) {
        return new ChangeWifiScreenObject(driver);
    }
    public static SettingWifiScreenObject getSettingWifiScreen(AndroidDriver driver) {
        return new SettingWifiScreenObject(driver);
    }

}
