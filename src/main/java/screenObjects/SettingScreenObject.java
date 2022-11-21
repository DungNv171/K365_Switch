package screenObjects;

import common.BaseScreen;
import common.ScreenGeneratorManager;
import io.appium.java_client.android.AndroidDriver;

public class SettingScreenObject extends BaseScreen {
    AndroidDriver driver;
    String DYNAMIC_SWITCH_BY_NAME = "//android.view.View[@content-desc=\"%s\"]";
    String SAVE_SWITCH_NAME_BUTTON = "//android.view.View[@content-desc=\"Lưu\"]";
    String CANCEL_SAVE_SWITCH_NAME_BTN = "//android.view.View[@content-desc=\"Hủy\"]";
    String DYNAMIC_BUTTON_BY_NAME = "//android.widget.ImageView[@content-desc='%s']";
    String BUTTON_NAME_TEXTBOX = "//android.view.View[@content-desc=\"Cài đặt nút bấm \n" +
            "Tên nút bấm\"]/android.view.View/android.widget.EditText";
    String CLOSE_POPUP = "//android.view.View[@content-desc=\"Cài đặt nút bấm \n" +
            "Tên nút bấm\"]/android.widget.ImageView[1]";
    String ADD_LABEL = "//android.widget.ImageView[contains(@content-desc,\"Gắn nhãn\")]";
    String DYNAMIC_LABEL_BY_NAME = "//android.widget.ImageView[@content-desc=\"Gắn nhãn\n" +
            "%s\"]";
    String DYNAMIC_RENAME_SWITCH_BTN = "//android.view.View[@content-desc=\"%s\"]//following-sibling::android.widget.ImageView";
    String SWITCH_NAME_TEXTBOX = "//android.view.View[@content-desc=\"Đặt tên công tắc\n" +
            "Tên công tắc\"]/android.view.View[1]/android.widget.EditText";
    String DYNAMIC_SETTING_BTN_BY_NAME = "//android.view.View[@content-desc=\"%s\"]/parent::android.view.View/parent::android.view.View/following-sibling::android.widget.ImageView";
    String DYNAMIC_BACK_TO_HOME_BY_SWITCH_NAME = "//android.view.View[@content-desc=\"%s\"]/parent::android.view.View/parent::android.view.View//preceding-sibling::android.widget.Button";
    public SettingScreenObject(AndroidDriver driver){
        this.driver = driver;
    }

    public void pressToButton(String buttonName){
        pressToElement(driver,DYNAMIC_BUTTON_BY_NAME,buttonName);
    }

    public void enterToRename(String valueText){
        clickToElement(driver,BUTTON_NAME_TEXTBOX);
        sendKeyToElement(driver,BUTTON_NAME_TEXTBOX,valueText);
        pressKeyEnterInKeyboard(driver);
    }

    public void closePopup(){
        clickToElement(driver,CLOSE_POPUP);
    }

    public void renameButton(String currentName, String expectedName){
        pressToButton(currentName);
        enterToRename(expectedName);
        closePopup();
    }

    public boolean isButtonNameDisplayed(String buttonName){
        return isElementDisplayed(driver,DYNAMIC_BUTTON_BY_NAME,buttonName);
    }

    public AddLabelScreenObject clickToAddLabel(){
        clickToElement(driver,ADD_LABEL);
        return ScreenGeneratorManager.getAddLabelScreen(driver);
    }

    public boolean isLabelAdded(String lableName){
        return isElementDisplayed(driver,DYNAMIC_LABEL_BY_NAME, lableName);
    }

    public void sendkeyToRenameSwitch(String switchName, String newName){
        clickToElement(driver,DYNAMIC_RENAME_SWITCH_BTN, switchName);
        clickToElement(driver,SWITCH_NAME_TEXTBOX);
        sendKeyToElement(driver,SWITCH_NAME_TEXTBOX,newName);
    }

    public void clickToSaveNewNameSwitchBtn(){
        clickToElement(driver,SAVE_SWITCH_NAME_BUTTON);
    }

    public void renameSwitch(String switchName, String newName){
        sendkeyToRenameSwitch(switchName, newName );
        clickToSaveNewNameSwitchBtn();
    }

    public void cancelSaveNewNameSwitchBtn(){
        clickToElement(driver,CANCEL_SAVE_SWITCH_NAME_BTN);
    }

    public boolean isSwitchNameDisplayed(String switchName){
        return isElementDisplayed(driver,DYNAMIC_SWITCH_BY_NAME, switchName);
    }

    public DetailSettingScreenObject clickToSettingBtnBySwitchName(String switchName){
        clickToElement(driver,DYNAMIC_SETTING_BTN_BY_NAME,switchName);
        return ScreenGeneratorManager.getDetailSettingScreen(driver);
    }

    public HomeScreenObject backToHomeBySwitchName(String switchName){
        clickToElement(driver,DYNAMIC_BACK_TO_HOME_BY_SWITCH_NAME,switchName);
        return ScreenGeneratorManager.getHomeScreen(driver);
    }


}
