package screenObjects;

import common.BaseScreen;
import common.ScreenGeneratorManager;
import io.appium.java_client.android.AndroidDriver;

public class DetailSettingScreenObject extends BaseScreen {
    AndroidDriver driver;
    String AddToFavouriteIcon = "//android.view.View[@content-desc=\"Thêm vào yêu thích\"]//following-sibling::android.view.View[1]";
    String backToSettingScreenBtn = "//android.view.View[@content-desc=\"Cài đặt công tắc\"]//preceding-sibling::android.widget.Button";
    public DetailSettingScreenObject(AndroidDriver driver){
        this.driver = driver;
    }

    public void clickToAddToFavouriteIcon(){
        clickToElement(driver,AddToFavouriteIcon);
    }

    public SettingScreenObject backToSettingScreen(){
        clickToElement(driver,backToSettingScreenBtn);
        return ScreenGeneratorManager.getSettingScreen(driver);
    }

}
