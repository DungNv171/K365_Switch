package screenObjects;

import common.BaseScreen;
import common.ScreenGeneratorManager;
import io.appium.java_client.android.AndroidDriver;

public class LoginScreenObject extends BaseScreen {
    AndroidDriver driver;

    String phoneNumberTextbox = "//android.view.View[@content-desc='Số điện thoại']/following-sibling::android.widget.EditText";
    String passwordTextbox = "//android.view.View[@content-desc='Mật khẩu']/following-sibling::android.widget.EditText";
    String loginButton = "//android.widget.Button[@content-desc='Đăng Nhập']";
    String errorNumberPhoneMessage = "//android.view.View[@content-desc= 'Bạn chưa nhập số điện thoại']";
    String errorPasswordMessage = "//android.view.View[@content-desc= 'Mật khẩu từ 6 đến 32 kí tự']";

    public LoginScreenObject(AndroidDriver driver){
        this.driver = driver;
    }

    public void enterToPhoneNumberTextbox(String textValue){
        clickToElement(driver,phoneNumberTextbox);
        sendKeyToElement(driver,phoneNumberTextbox,textValue);
    }

    public void enterToPasswordTextbox(String textValue){
        clickToElement(driver,passwordTextbox);
        sendKeyToElement(driver,passwordTextbox,textValue);
    }

    public HomeScreenObject clickToLoginButton(){
        clickToElement(driver,loginButton);
        return ScreenGeneratorManager.getHomeScreen(driver);
    }

    public boolean isErrorNumberPhoneMessageDisplayed(){
        return isElementDisplayed(driver,errorNumberPhoneMessage);
    }

    public boolean isErrorPasswordTextboxDisplayed(){
        return isElementDisplayed(driver,errorPasswordMessage);
    }

}
