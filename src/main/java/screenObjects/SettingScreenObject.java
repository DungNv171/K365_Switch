package screenObjects;

import common.BaseScreen;
import common.ScreenGeneratorManager;
import io.appium.java_client.android.AndroidDriver;

public class SettingScreenObject extends BaseScreen {
    AndroidDriver driver;
    String dynamicSwitchByName = "//android.view.View[@content-desc=\"%s\"]";
    String saveSwitchNameButton = "//android.view.View[@content-desc=\"Lưu\"]";
    String cancelSaveSwitchNameBtn = "//android.view.View[@content-desc=\"Hủy\"]";
    String dynamicButtonByName = "//android.widget.ImageView[@content-desc='%s']";
    String buttonNameTextbox = "//android.view.View[@content-desc=\"Cài đặt nút bấm \n" +
            "Tên nút bấm\"]/android.view.View/android.widget.EditText";
    String closePopup = "//android.view.View[@content-desc=\"Cài đặt nút bấm \n" +
            "Tên nút bấm\"]/android.widget.ImageView[1]";

    String addLabel = "//android.widget.ImageView[contains(@content-desc,\"Gắn nhãn\")]";
    String dynamicLableByName = "//android.widget.ImageView[@content-desc=\"Gắn nhãn\n" +
            "%s\"]";
    String dynamicRenameSwitchBtn = "//android.view.View[@content-desc=\"%s\"]//following-sibling::android.widget.ImageView";
    String switchNameTextbox = "//android.view.View[@content-desc=\"Đặt tên công tắc\n" +
            "Tên công tắc\"]/android.view.View[1]/android.widget.EditText";

    String dynamicSettingBtnByName = "//android.view.View[@content-desc=\"%s\"]/parent::android.view.View/parent::android.view.View/following-sibling::android.widget.ImageView";

    String dynamicBackToHomeBySwitchName = "//android.view.View[@content-desc=\"%s\"]/parent::android.view.View/parent::android.view.View//preceding-sibling::android.widget.Button";
    String removeSwitchBtn = "//android.view.View[@content-desc=\"Gỡ bỏ công tắc\"]";
    String cancelActionRemove = "//android.view.View[@content-desc=\"Bạn có chắc chắn muốn gỡ thiết bị ra khỏi tài khoản\"]/android.view.View[@content-desc=\"Hủy\"]";
    String acceptActionRemove = "//android.view.View[@content-desc=\"Bạn có chắc chắn muốn gỡ thiết bị ra khỏi tài khoản\"]/android.view.View[@content-desc=\"Chấp nhận\"]";
    public SettingScreenObject(AndroidDriver driver){
        this.driver = driver;
    }

    public void pressToButton(String buttonName){
        pressToElement(driver,dynamicButtonByName,buttonName);
    }

    public void enterToRename(String valueText){
        clickToElement(driver,buttonNameTextbox);
        sendKeyToElement(driver,buttonNameTextbox,valueText);
        pressKeyEnterInKeyboard(driver);
    }

    public void closePopup(){
        clickToElement(driver,closePopup);
    }

    public void renameButton(String currentName, String expectedName){
        pressToButton(currentName);
        enterToRename(expectedName);
        closePopup();
    }

    public boolean isButtonNameDisplayed(String buttonName){
        return isElementDisplayed(driver,dynamicButtonByName,buttonName);
    }

    public AddLabelScreenObject clickToAddLabel(){
        clickToElement(driver,addLabel);
        return ScreenGeneratorManager.getAddLabelScreen(driver);
    }

    public boolean isLabelAdded(String lableName){
        return isElementDisplayed(driver,dynamicLableByName, lableName);
    }

    public void sendkeyToRenameSwitch(String switchName, String newName){
        clickToElement(driver,dynamicRenameSwitchBtn, switchName);
        clickToElement(driver,switchNameTextbox);
        sendKeyToElement(driver,switchNameTextbox,newName);
    }

    public void clickToSaveNewNameSwitchBtn(){
        clickToElement(driver,saveSwitchNameButton);
    }

    public void renameSwitch(String switchName, String newName){
        sendkeyToRenameSwitch(switchName, newName );
        clickToSaveNewNameSwitchBtn();
    }

    public void cancelSaveNewNameSwitchBtn(){
        clickToElement(driver,cancelSaveSwitchNameBtn);
    }

    public boolean isSwitchNameDisplayed(String switchName){
        return isElementDisplayed(driver,dynamicSwitchByName, switchName);
    }

    public DetailSettingScreenObject clickToSettingBtnBySwitchName(String switchName){
        clickToElement(driver,dynamicSettingBtnByName,switchName);
        return ScreenGeneratorManager.getDetailSettingScreen(driver);
    }

    public HomeScreenObject backToHomeBySwitchName(String switchName){
        clickToElement(driver,dynamicBackToHomeBySwitchName,switchName);
        return ScreenGeneratorManager.getHomeScreen(driver);
    }

    public HomeScreenObject clickRemoveSwitch() {
        clickToElement(driver,removeSwitchBtn);
        clickToAcceptActionRemove();
        return ScreenGeneratorManager.getHomeScreen(driver);
    }
    public void cancelRemoveSwitch(){
        clickToElement(driver,removeSwitchBtn);
        clickToCancelActionRemove();
    }

    public void clickToCancelActionRemove(){
        clickToElement(driver,cancelActionRemove);
    }

    public void clickToAcceptActionRemove(){
        clickToElement(driver,acceptActionRemove);
    }
}
