package screenObjects;

import common.BaseScreen;
import common.ScreenGeneratorManager;
import io.appium.java_client.android.AndroidDriver;

public class ChooseCountryScreenObject extends BaseScreen {
    AndroidDriver driver;

    public static final String CONTINUE_BUTTON = "//android.widget.Button[@content-desc='Tiếp tục']";

    public ChooseCountryScreenObject(AndroidDriver driver){
        this.driver = driver;
    }

    public LoginScreenObject clickToContinueButton(){
        clickToElement(driver,CONTINUE_BUTTON);
        return ScreenGeneratorManager.getLoginScreen(driver);
    }

}
