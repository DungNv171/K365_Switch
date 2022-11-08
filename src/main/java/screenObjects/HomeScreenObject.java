package screenObjects;

import common.BaseScreen;
import common.ScreenGeneratorManager;
import io.appium.java_client.android.AndroidDriver;

public class HomeScreenObject extends BaseScreen {
    AndroidDriver driver;

    String welcomeMessage = "//android.view.View[contains(@content-desc,'Chào')]";
    String dynamicDeviceByName = "//android.view.View[@content-desc='%s']";

    public HomeScreenObject(AndroidDriver driver){
        this.driver = driver;
    }

    public boolean isHomeScreenDisplayed(){
        return isElementDisplayed(driver,welcomeMessage);
    }

    public SettingScreenObject chooseDevice(String deviceName){
        clickToElement(driver,dynamicDeviceByName,deviceName);
        return ScreenGeneratorManager.getSettingScreen(driver);
    }
}
