package screenObjects;

import common.BaseScreen;
import common.ScreenGeneratorManager;
import io.appium.java_client.android.AndroidDriver;

public class DetailSettingScreenObject extends BaseScreen {
    AndroidDriver driver;
    String REMOVE_SWITCH_BTN = "//android.view.View[@content-desc=\"Gỡ bỏ công tắc\"]";
    String CANCEL_ACTION_REMOVE = "//android.view.View[@content-desc=\"Bạn có chắc chắn muốn gỡ thiết bị ra khỏi tài khoản\"]/android.view.View[@content-desc=\"Hủy\"]";
    String ACCEPT_ACTION_REMOVE = "//android.view.View[@content-desc=\"Bạn có chắc chắn muốn gỡ thiết bị ra khỏi tài khoản\"]/android.view.View[@content-desc=\"Chấp nhận\"]";

    public static final String ADD_TO_FAVOURITE_ICON = "//android.view.View[@content-desc=\"Thêm vào yêu thích\"]//following-sibling::android.view.View[1]";
    public static final String BACK_TO_SETTING_SCREEN_BTN = "//android.view.View[@content-desc=\"Cài đặt công tắc\"]//preceding-sibling::android.widget.Button";
//    public static final String ADD_ROOM_SCREEN = "//android.view.View[@content-desc=\"Gắn phòng\"]";
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

//    public AddRoomScreenObject openAddRoomScreen() {
//        clickToElement(driver,ADD_ROOM_SCREEN);
//        return ScreenGeneratorManager.getAddRoomScreen(driver);
//    }

    public HomeScreenObject clickRemoveSwitch() {
        scrollToElementByText(driver,"Gỡ bỏ công tắc");
        clickToElement(driver,REMOVE_SWITCH_BTN);
        clickToAcceptActionRemove();
        return ScreenGeneratorManager.getHomeScreen(driver);
    }
    public void cancelRemoveSwitch(){
        scrollToElementByText(driver,"Gỡ bỏ công tắc");
        clickToElement(driver,REMOVE_SWITCH_BTN);
        clickToCancelActionRemove();
    }


    public void clickToCancelActionRemove(){
        clickToElement(driver,CANCEL_ACTION_REMOVE);
    }

    public void clickToAcceptActionRemove(){
        clickToElement(driver,ACCEPT_ACTION_REMOVE);
    }
}
