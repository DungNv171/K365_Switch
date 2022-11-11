package screenObjects;

import common.BaseScreen;
import common.ScreenGeneratorManager;
import io.appium.java_client.android.AndroidDriver;

public class SettingScreenObject extends BaseScreen {
    AndroidDriver driver;
    String dynamicButtonByName = "//android.widget.ImageView[@content-desc='%s']";
    String buttonNameTextbox = "//android.view.View[@content-desc=\"Cài đặt nút bấm \n" +
            "Tên nút bấm\"]/android.view.View/android.widget.EditText";
    String closePopup = "//android.view.View[@content-desc=\"Cài đặt nút bấm \n" +
            "Tên nút bấm\"]/android.widget.ImageView[1]";

    String addLabel = "//android.widget.ImageView[@content-desc=\"Gắn nhãn\"]";

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

}
