package screenObjects;

import common.BaseScreen;
import common.ScreenGeneratorManager;
import io.appium.java_client.android.AndroidDriver;

public class RoomManageScreenObject extends BaseScreen {
    AndroidDriver driver;

    public static final String DYNAMIC_CHOOSE_ROOM_BY_NAME = "//android.view.View[contains(@content-desc,\"%s\")]";
    public static final String REMOVE_ROOM = "//android.widget.Button[@content-desc=\"Xóa Phòng\"]";
    public static final String CANCEL_ACTION_REMOVE_ROOM = "//android.widget.Button[@content-desc=\"Hủy\"]";
    public static final String ACTION_REMOVE_ROOM = "//android.widget.Button[@content-desc=\"Xóa\"]";

    public RoomManageScreenObject(AndroidDriver driver){
        this.driver = driver;
    }

    public void chooseRoomByName(String roomName) {
        clickToElement(driver,DYNAMIC_CHOOSE_ROOM_BY_NAME,roomName);
    }

    public void clickToRemoveRoomBtn() {
        clickToElement(driver,REMOVE_ROOM);
    }

    public void clickToCancelActionRemove() {
        clickToElement(driver,CANCEL_ACTION_REMOVE_ROOM);
    }

    public void clickToActionRemoveRoom() {
        clickToElement(driver,ACTION_REMOVE_ROOM);
    }

    public boolean isRoomDisplayedByName(String roomName) {
        return isElementDisplayed(driver,DYNAMIC_CHOOSE_ROOM_BY_NAME,roomName);
    }
}
