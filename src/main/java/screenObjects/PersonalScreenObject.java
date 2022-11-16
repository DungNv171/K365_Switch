package screenObjects;

import common.BaseScreen;
import common.ScreenGeneratorManager;
import io.appium.java_client.android.AndroidDriver;

public class PersonalScreenObject extends BaseScreen {
    AndroidDriver driver;
    public static final String HOUSE_MANAGE = "//android.widget.Button[@content-desc=\"Quản Lý Nhà\"]";

    public PersonalScreenObject(AndroidDriver driver){
        this.driver = driver;
    }


    public HouseManageScreenObject openHouseManageScreen() {
        clickToElement(driver,HOUSE_MANAGE);
        return ScreenGeneratorManager.getHouseManageScreen(driver);
    }
}
