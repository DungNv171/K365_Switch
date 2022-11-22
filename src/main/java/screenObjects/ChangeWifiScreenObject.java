package screenObjects;

import common.BaseScreen;
import common.ScreenGeneratorManager;
import io.appium.java_client.android.AndroidDriver;

public class ChangeWifiScreenObject extends BaseScreen {
    AndroidDriver driver;
    public static final String CHANGE_WIFI_BUTTON = "//android.view.View[@content-desc=\"Đổi Wifi\"]";
    public static final String CHANGED_WIFI_NAME = "//android.view.View[contains(@content-desc,\"%s\")]";

    public ChangeWifiScreenObject(AndroidDriver driver){
        this.driver = driver;
    }


    public void clickToChangeWifiButton() {
        clickToElement(driver,CHANGE_WIFI_BUTTON);
    }

    public boolean isChangedWifiDisplayed(String wifiName) {
        return isElementDisplayed(driver,CHANGED_WIFI_NAME,wifiName);
    }
}
