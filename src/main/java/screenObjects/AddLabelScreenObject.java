package screenObjects;

import common.BaseScreen;
import common.ScreenGeneratorManager;
import io.appium.java_client.android.AndroidDriver;

public class AddLabelScreenObject extends BaseScreen {
    AndroidDriver driver;

    String dynamicLabelByName = "//android.view.View[@content-desc='%s']";
    String dynamicchoosedLableByName = "//android.widget.ImageView[@content-desc='%s']";
    String saveButton = "//android.view.View[@content-desc=\"Lưu\"]";
    String searchTextbox = "//android.widget.ImageView[@text='Tìm kiếm']";
    String backToSettingButton = "//android.view.View[@content-desc=\"Gắn nhãn\"]//preceding-sibling::android.widget.Button";

    public AddLabelScreenObject(AndroidDriver driver){
        this.driver = driver;
    }

    public void addLabel(String labelName){
        if(isElementDisplayed(driver,dynamicLabelByName,labelName)){
            clickToElement(driver,dynamicLabelByName,labelName);
        }
    }

    public void removeLabel(String labelName){
        if(isElementDisplayed(driver,dynamicchoosedLableByName,labelName)) {
            clickToElement(driver, dynamicchoosedLableByName, labelName);
        }
    }

    public void clickSaveButton(){
        clickToElement(driver,saveButton);
    }

    public void searchLabel(String searchValue){
        clickToElement(driver,searchTextbox);
        sendKeyToElement(driver,searchTextbox,searchValue);
    }

    public boolean isLabelDisplayed(String labelName){
        return isElementDisplayed(driver,dynamicLabelByName,labelName) || isElementDisplayed(driver,dynamicchoosedLableByName,labelName);
    }

    public SettingScreenObject clickToBackToSettingButton(){
        clickToElement(driver,backToSettingButton);
        return ScreenGeneratorManager.getSettingScreen(driver);
    }

}
