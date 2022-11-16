package screenObjects;

import common.BaseScreen;
import common.ScreenGeneratorManager;
import io.appium.java_client.android.AndroidDriver;

public class DetailSettingScreenObject extends BaseScreen {
    AndroidDriver driver;
    public static final String ADD_TO_FAVOURITE_ICON = "//android.view.View[@content-desc=\"Thêm vào yêu thích\"]//following-sibling::android.view.View[1]";
    public static final String BACK_TO_SETTING_SCREEN_BTN = "//android.view.View[@content-desc=\"Cài đặt công tắc\"]//preceding-sibling::android.widget.Button";
    public static final String ADD_ROOM_SCREEN = "//android.view.View[@content-desc=\"Gắn phòng\"]";
    public DetailSettingScreenObject(AndroidDriver driver){
        this.driver = driver;
    }

    public void clickToAddToFavouriteIcon(){
        clickToElement(driver,ADD_TO_FAVOURITE_ICON);
    }

    public SettingScreenObject backToSettingScreen(){
        clickToElement(driver,BACK_TO_SETTING_SCREEN_BTN);
        return ScreenGeneratorManager.getSettingScreen(driver);
    }

    public AddRoomScreenObject openAddRoomScreen() {
        clickToElement(driver,ADD_ROOM_SCREEN);
        return ScreenGeneratorManager.getAddRoomScreen(driver);
    }
}
