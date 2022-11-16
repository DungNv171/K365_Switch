package screenObjects;

import common.BaseScreen;
import common.ScreenGeneratorManager;
import io.appium.java_client.android.AndroidDriver;

public class LoginScreenObject extends BaseScreen {
    AndroidDriver driver;

    public static final String PHONE_NUMBER_TEXTBOX = "//android.view.View[@content-desc='Số điện thoại']/following-sibling::android.widget.EditText";
    public static final String PASSWORD_TEXTBOX = "//android.view.View[@content-desc='Mật khẩu']/following-sibling::android.widget.EditText";
    public static final String LOGIN_BUTTON = "//android.widget.Button[@content-desc='Đăng Nhập']";
    public static final String ERROR_NUMBER_PHONE_MESSAGE = "//android.view.View[@content-desc= 'Bạn chưa nhập số điện thoại']";
    public static final String ERROR_PASSWORD_MESSAGE = "//android.view.View[@content-desc= 'Mật khẩu từ 6 đến 32 kí tự']";

    public LoginScreenObject(AndroidDriver driver){
        this.driver = driver;
    }

    public void enterToPhoneNumberTextbox(String textValue){
        clickToElement(driver,PHONE_NUMBER_TEXTBOX);
        sendKeyToElement(driver,PHONE_NUMBER_TEXTBOX,textValue);
    }

    public void enterToPasswordTextbox(String textValue){
        clickToElement(driver,PASSWORD_TEXTBOX);
        sendKeyToElement(driver,PASSWORD_TEXTBOX,textValue);
    }

    public HomeScreenObject clickToLoginButton(){
        clickToElement(driver,LOGIN_BUTTON);
        return ScreenGeneratorManager.getHomeScreen(driver);
    }

    public boolean isErrorNumberPhoneMessageDisplayed(){
        return isElementDisplayed(driver,ERROR_NUMBER_PHONE_MESSAGE);
    }

    public boolean isErrorPasswordTextboxDisplayed(){
        return isElementDisplayed(driver,ERROR_PASSWORD_MESSAGE);
    }

}
