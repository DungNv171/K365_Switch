package screenObjects;

import common.BaseScreen;
import common.ScreenGeneratorManager;
import io.appium.java_client.android.AndroidDriver;

public class HomeScreenObject extends BaseScreen {
    AndroidDriver driver;
    public static final String WELCOME_MESSAGE = "//android.view.View[contains(@content-desc,'Chào')]";
    public static final String DYNAMIC_DEVICE_BY_NAME = "//android.view.View[@content-desc='%s']";
    public static final String FAVOURITE_SWITCH_BY_NAME = "//android.view.View[@content-desc=\"YÊU THÍCH\"]//android.widget.Button[contains(@content-desc,\"%s\")]";
    public static final String DYNAMIC_ROOM_BY_UPPERCASE_NAME = "//android.view.View[contains(@content-desc,'%s')]";
    public static final String ROOM_TAB = "//android.view.View[contains(@content-desc,'PHÒNG')]";
    public static final String DYNAMIC_DEVICE_IN_ROOM_BY_ROOM_NAME_AND_DEVICE_NAME = "//android.view.View[contains(@content-desc,'%s')]//android.view.View[@content-desc='%s']";
    public static final String PERSIONAL_SETTING = "//android.widget.ImageView[contains(@content-desc,'Cá nhân')]";
    public HomeScreenObject(AndroidDriver driver){
        this.driver = driver;
    }

    public boolean isHomeScreenDisplayed(){
        return isElementDisplayed(driver,WELCOME_MESSAGE);
    }

    public SettingScreenObject chooseDevice(String deviceName){
        clickToElement(driver,DYNAMIC_DEVICE_BY_NAME,deviceName);
        return ScreenGeneratorManager.getSettingScreen(driver);
    }

    public boolean isFavouriteSwitchDisplayByName(String switchName){
        return isElementDisplayed(driver,FAVOURITE_SWITCH_BY_NAME,switchName);
    }

    public boolean isSwitchDisplayedByName(String switchName) {
        return isElementDisplayed(driver,DYNAMIC_DEVICE_BY_NAME,switchName);
    }

    public void switchToRoomTab() {
        clickToElement(driver,ROOM_TAB);
    }

    public boolean isRoomDisplayedByName(String roomName) {
        return isElementDisplayed(driver,DYNAMIC_ROOM_BY_UPPERCASE_NAME,roomName.toUpperCase());
    }

    public void scrollToRoomByName(String roomName){
        scrollToElementByText(driver,roomName.toUpperCase());
    }

    public void scrollToSwitchByName(String switchName){
        scrollToElementByText(driver,switchName);
    }

    public void clickToRoomByName(String roomName) {
        clickToElement(driver,DYNAMIC_ROOM_BY_UPPERCASE_NAME,roomName.toUpperCase());
    }

    public boolean isAddedRoomSwitchDisplayed(String roomName, String switchName) {
        return isElementDisplayed(driver,DYNAMIC_DEVICE_IN_ROOM_BY_ROOM_NAME_AND_DEVICE_NAME,roomName.toUpperCase(),switchName);
    }

    public PersonalScreenObject clickToPersonalScreen() {
        clickToElement(driver,PERSIONAL_SETTING);
        return ScreenGeneratorManager.getPersonalScreen(driver);
    }

}
