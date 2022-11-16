package screenObjects;

import common.BaseScreen;
import common.ScreenGeneratorManager;
import io.appium.java_client.android.AndroidDriver;

public class AddRoomScreenObject extends BaseScreen {
    AndroidDriver driver;

    public static final String ADD_ROOM_ICON = "//android.widget.ImageView[@content-desc=\"Thêm phòng\"]";
    public static final String ADD_ROOM_TEXTBOX = "//android.view.View[@content-desc=\"Tạo phòng mới\"]//following-sibling::android.widget.EditText";
    public static final String SAVE_NEW_ROOM = "//android.view.View[@content-desc=\"Lưu\"]";
    public static final String DYNAMIC_CREATED_ROOM_BY_NAME = "//android.view.View[@content-desc=\"Phòng tự tạo\"]//following-sibling::android.view.View//android.view.View[@content-desc=\"%s\"]";
    public static final String BACK_TO_ROOM_TOTAL = "//android.view.View[@content-desc=\"Thêm Phòng\"]//preceding-sibling::android.widget.Button";
    public static final String DYNAMIC_ROOM_IN_HOUSE_BY_NAME = "//android.widget.Button[@content-desc=\"%s\"]";
    public static final String SAVE_ACTION_ADD_ROOM = "//android.view.View[@content-desc=\"Chọn Phòng\"]//following-sibling::android.view.View[@content-desc=\"Lưu\"]";
    public static final String ACTION_ADDED_SUCCESS = "//android.widget.ImageView[@content-desc=\"Thành công\"]";
    public static final String BACK_TO_DETAIL_SETTING_SCREEN = "//android.view.View[@content-desc=\"Chọn Phòng\"]//preceding-sibling::android.widget.Button";
    public AddRoomScreenObject(AndroidDriver driver){
        this.driver = driver;
    }


    public void clickAddRoomIcon() {
        clickToElement(driver, ADD_ROOM_ICON);
    }

    public void sendkeyToAddRoomTextBox(String roomName) {
        clickToElement(driver,ADD_ROOM_TEXTBOX);
        sendKeyToElement(driver,ADD_ROOM_TEXTBOX,roomName);
    }

    public void saveRoom() {
        clickToElement(driver,SAVE_NEW_ROOM);
    }

    public boolean isCreatedRoomDisplayed(String roomName) {
        return isElementDisplayed(driver,DYNAMIC_CREATED_ROOM_BY_NAME,roomName);
    }

    public void clickToBackTotalRoom() {
        clickToElement(driver,BACK_TO_ROOM_TOTAL);
    }

    public boolean isRoomDisplayedAtTotalRoom(String roomName) {
        return isElementDisplayed(driver,DYNAMIC_ROOM_IN_HOUSE_BY_NAME,roomName);
    }

    public void clickToWantToAddRoom(String roomName) {
        clickToElement(driver,DYNAMIC_ROOM_IN_HOUSE_BY_NAME,roomName);
    }

    public void clickToSaveIconToAddRoom() {
        clickToElement(driver,SAVE_ACTION_ADD_ROOM);
    }

    public boolean isSuccessMessageDisplayed() {
        return isElementDisplayed(driver,ACTION_ADDED_SUCCESS);
    }

    public void clickToReturnAddRoomScreen() {
        clickToElement(driver,ACTION_ADDED_SUCCESS);
    }

    public DetailSettingScreenObject clickToDetailSettingScreen() {
        clickToElement(driver,BACK_TO_DETAIL_SETTING_SCREEN);
        return ScreenGeneratorManager.getDetailSettingScreen(driver);
    }
}
