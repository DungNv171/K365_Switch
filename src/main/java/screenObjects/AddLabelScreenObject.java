package screenObjects;

import common.BaseScreen;
import io.appium.java_client.android.AndroidDriver;

public class AddLabelScreenObject extends BaseScreen {
    AndroidDriver driver;

    String dynamicLabelByName = "//android.view.View[@content-desc='%s']";
    String saveButton = "//android.view.View[@content-desc=\"Lưu\"]";
    String searchTextbox = "//android.widget.ImageView[@text='Tìm kiếm']";

    public AddLabelScreenObject(AndroidDriver driver){
        this.driver = driver;
    }

    public void chooseLabel(String labelName){
        clickToElement(driver,dynamicLabelByName,labelName);
    }

    public void clickSaveButton(){
        clickToElement(driver,saveButton);
    }

    public void searchLabel(String searchValue){
        clickToElement(driver,searchTextbox);
        sendKeyToElement(driver,searchTextbox,searchValue);
    }

    public boolean isLabelDisplayed(String labelName){
        return isElementDisplayed(driver,dynamicLabelByName,labelName);
    }


}
