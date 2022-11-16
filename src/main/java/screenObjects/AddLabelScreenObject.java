package screenObjects;

import common.BaseScreen;
import common.ScreenGeneratorManager;
import io.appium.java_client.android.AndroidDriver;

public class AddLabelScreenObject extends BaseScreen {
    AndroidDriver driver;


    public static final String DYNAMIC_LABEL_BY_NAME = "//android.view.View[@content-desc='%s']";
    public static final String DYNAMIC_CHOOSED_LABLE_BY_NAME = "//android.widget.ImageView[@content-desc='%s']";
    public static final String SAVE_BUTTON = "//android.view.View[@content-desc=\"Lưu\"]";
    public static final String SEARCH_BUTTON = "//android.widget.ImageView[@text='Tìm kiếm']";
    public static final String BACK_TO_SETTING_BUTTON = "//android.view.View[@content-desc=\"Gắn nhãn\"]//preceding-sibling::android.widget.Button";

    public AddLabelScreenObject(AndroidDriver driver){
        this.driver = driver;
    }

    public void addLabel(String labelName){
        if(isElementDisplayed(driver,DYNAMIC_LABEL_BY_NAME,labelName)){
            clickToElement(driver,DYNAMIC_LABEL_BY_NAME,labelName);
        }
    }

    public void removeLabel(String labelName){
        if(isElementDisplayed(driver,DYNAMIC_CHOOSED_LABLE_BY_NAME,labelName)) {
            clickToElement(driver, DYNAMIC_CHOOSED_LABLE_BY_NAME, labelName);
        }
    }

    public void clickSaveButton(){
        clickToElement(driver,SAVE_BUTTON);
    }

    public void searchLabel(String searchValue){
        clickToElement(driver,SEARCH_BUTTON);
        sendKeyToElement(driver,SEARCH_BUTTON,searchValue);
    }

    public boolean isLabelDisplayed(String labelName){
        return isElementDisplayed(driver,DYNAMIC_LABEL_BY_NAME,labelName) || isElementDisplayed(driver,DYNAMIC_CHOOSED_LABLE_BY_NAME,labelName);
    }

    public SettingScreenObject clickToBackToSettingButton(){
        clickToElement(driver,BACK_TO_SETTING_BUTTON);
        return ScreenGeneratorManager.getSettingScreen(driver);
    }

}
