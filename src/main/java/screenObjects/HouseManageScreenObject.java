package screenObjects;

import common.BaseScreen;
import common.ScreenGeneratorManager;
import io.appium.java_client.android.AndroidDriver;

public class HouseManageScreenObject extends BaseScreen {
    AndroidDriver driver;

    public static final String DYNAMIC_CHOOSE_HOUSE_BY_NAME = "//android.widget.ImageView[@content-desc=\"%s\"]";

    public HouseManageScreenObject(AndroidDriver driver){
        this.driver = driver;
    }

    public RoomManageScreenObject openRoomManageSceenByHouseName(String houseName) {
        clickToElement(driver,DYNAMIC_CHOOSE_HOUSE_BY_NAME,houseName);
        return ScreenGeneratorManager.getRoomManageScreen(driver);
    }
}
