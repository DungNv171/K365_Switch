package common;

import io.appium.java_client.AppiumFluentWait;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;


public class BaseScreen {
    public static BaseScreen getBaseScreenObject() {
        return new BaseScreen();
    }
    public String getDynamicLocator(String locator, String... dynamicValue){
        return String.format(locator, (Object[])dynamicValue);
    }
    public WebElement getWebElement(AndroidDriver driver, String locator){
        return driver.findElement(By.xpath(locator));
    }

    public WebElement getWebElement(AndroidDriver driver, String locator, String... dynamicValue){
        return driver.findElement(By.xpath(getDynamicLocator(locator, dynamicValue)));
    }

    public void clickToElement(AndroidDriver driver, String locatorType){
        getWebElement(driver,locatorType).click();
    }

    public void clickToElement(AndroidDriver driver, String locatorType,String... dynamicValue){
        getWebElement(driver,getDynamicLocator(locatorType, dynamicValue)).click();
    }

    public void sendKeyToElement(AndroidDriver driver, String locatorType, String textValue){
        WebElement element = getWebElement(driver,locatorType);
        element.clear();
        element.sendKeys(textValue);
    }

    public void sendKeyToElement(AndroidDriver driver, String locatorType, String textValue,String... dynamicValue){
        WebElement element = getWebElement(driver,getDynamicLocator(locatorType,dynamicValue));
        element.clear();
        element.sendKeys(textValue);
    }

    public boolean isElementDisplayed(AndroidDriver driver, String locatorType){
        try {
            return getWebElement(driver,locatorType).isDisplayed();
        } catch (NoSuchElementException e){
            return false;
        }
    }

    public boolean isElementDisplayed(AndroidDriver driver, String locatorType, String... dynamicValue){
        try {
            return getWebElement(driver,locatorType,dynamicValue).isDisplayed();
        } catch (NoSuchElementException e){
            return false;
        }
    }

    public String getElementText(AndroidDriver driver, String locatorType){
        return getWebElement(driver, locatorType).getText();
    }

    public void waitForElementVisible(AndroidDriver driver, String locatorType) {
        AppiumFluentWait explicitWait = new AppiumFluentWait(15);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorType)));
    }

    public void pressToElement(AndroidDriver driver, String locatorType){
        Actions action = new Actions(driver);
        action.clickAndHold(getWebElement(driver,locatorType));
    }

    public void pressToElement(AndroidDriver driver, String locatorType, String... dynamicValue){
        new TouchAction(driver)
                .press(element(getWebElement(driver,locatorType,dynamicValue)))
                .waitAction(waitOptions(ofSeconds(3)))
                .release()
                .perform();
    }

    public void pressKeyEnterInKeyboard(AndroidDriver driver){
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void scrollAndClick(AndroidDriver driver, String locater){
        new TouchActions(driver).scroll(getWebElement(driver,locater), 10, 100).perform();
    }
}
