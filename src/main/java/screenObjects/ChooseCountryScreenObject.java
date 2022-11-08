package screenObjects;

import common.BaseScreen;
import common.ScreenGeneratorManager;
import io.appium.java_client.android.AndroidDriver;

public class ChooseCountryScreenObject extends BaseScreen {
    AndroidDriver driver;

    String continueButton = "//android.widget.Button[@content-desc='Tiếp tục']";

    public ChooseCountryScreenObject(AndroidDriver driver){
        this.driver = driver;
    }

    public LoginScreenObject clickToContinueButton(){
        clickToElement(driver,continueButton);
        return ScreenGeneratorManager.getLoginScreen(driver);
    }

}
