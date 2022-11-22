package screenObjects;

import common.BaseScreen;
import common.BaseTest;
import common.ScreenGeneratorManager;
import io.appium.java_client.android.AndroidDriver;

public class SettingWifiScreenObject extends BaseScreen {
    AndroidDriver driver;

    public static final String BUTTON_CLICK_TO_LIST_WIFI = "//android.widget.EditText[@text=\"Chọn Wi-Fi\"]/android.widget.ImageView";
    public static final String REFRESH_LIST_BUTTON = "//android.view.View[@content-desc=\"Mạng Wi-Fi khả dụng\"]/android.widget.ImageView";
    public static final String CANCEL_LIST_BUTTON = "//android.view.View[@content-desc=\"Mạng Wi-Fi khả dụng\"]/android.view.View";
    public static final String LOADING_IMAGE = "//android.view.View[@content-desc=\"Mạng Wi-Fi khả dụng\n" +
            "Đang lấy danh sách Wi-Fi\"]";
    public static final String DYNAMIC_CHOOSE_WIFI_BY_NAME = "//android.widget.ImageView[@content-desc=\"%s\"]";
    public static final String PASSWORD_TEXTBOX = "//android.widget.EditText[@text=\"Nhập mật khẩu\"]";
    public static final String CONNECT_BUTTON = "//android.widget.Button[@content-desc=\"Kết nối\"]";
    public static final String SUCCESS_CHANGE_WIFI_MESSAGE = "//android.widget.ImageView[@content-desc=\"Cấu hình Wifi cho mạch thành công\"]";
    public static final String FAIL_CHANGE_WIFI_MESSAGE = "//android.widget.ImageView[@content-desc=\"Cấu hình Wifi cho mạch thất bại\"]";
    public static final String CANCEL_CHANGE_WIFI = "//android.view.View[@content-desc=\"Mạng Wi-Fi khả dụng\"]/android.view.View[1]";
    public SettingWifiScreenObject(AndroidDriver driver){
        this.driver = driver;
    }

    public void clickButtonToListWifi() {
        clickToElement(driver,BUTTON_CLICK_TO_LIST_WIFI);
    }

    public void changeWifi(String wifiName, String wifiPassword) {
        while(isElementDisplayed(driver,REFRESH_LIST_BUTTON)){
            clickToElement(driver,REFRESH_LIST_BUTTON);
        }
        scrollToElementByText(driver,wifiName);
        clickToElement(driver,DYNAMIC_CHOOSE_WIFI_BY_NAME,wifiName);
        clickToElement(driver,PASSWORD_TEXTBOX);
        sendKeyToElement(driver,PASSWORD_TEXTBOX,wifiPassword);
        clickToElement(driver,CONNECT_BUTTON);
        while(isElementDisplayed(driver,FAIL_CHANGE_WIFI_MESSAGE)){
            clickToElement(driver,FAIL_CHANGE_WIFI_MESSAGE);
            clickToElement(driver,CONNECT_BUTTON);
        }
    }

    public boolean isSucessChageWifiMessage() {
        return isElementDisplayed(driver,SUCCESS_CHANGE_WIFI_MESSAGE);
    }

    public ChangeWifiScreenObject clickToSettingWifiScreen() {
        clickToElement(driver,SUCCESS_CHANGE_WIFI_MESSAGE);
        return ScreenGeneratorManager.getChangeWifiScreen(driver);
    }

    public void cancelChangeWifi() {
        clickToElement(driver,CANCEL_CHANGE_WIFI);
    }
}
