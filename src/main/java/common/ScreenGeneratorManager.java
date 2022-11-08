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
}
