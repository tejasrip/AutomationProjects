package com.app.pages;

import com.framework.appium.DriverFactory;
import com.utils.PropertyUtils;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


public class HomePage extends BasePage {

    private static String className = HomePage.class.getName();
    private static Logger logger = LogManager.getLogger(className);

    public HomePage() {
        int implicitWait = PropertyUtils.getIntProperty("implicitWait");
        PageFactory.initElements(new AppiumFieldDecorator(DriverFactory.getDriver(DriverFactory.getPlatformType()), implicitWait, TimeUnit.SECONDS), this);
    }

    @AndroidFindBy(id = "com.adam.qa:id/logoImageView")
    private AndroidElement logoImage;

    @AndroidFindBy(id = "android:id/text1")
    private AndroidElement operatingRoom;

    @AndroidFindBy(id = "com.adam.qa:id/okButton")
    private AndroidElement okButton;

    @AndroidFindBy(className = "UIAKeyboard")
    private AndroidElement keyboard;

    private boolean isLogoImageDisplayed() {
        return logoImage.isDisplayed();
    }

    private boolean isOkButtonDisplayed() {
        return okButton.isDisplayed();
    }

    private boolean isOperatingRoomDisplayed() {
        return operatingRoom.isDisplayed();
    }

    public boolean validateHomePageElements() {
        return isLogoImageDisplayed() && isOperatingRoomDisplayed() && isOkButtonDisplayed();
    }

    public boolean isOperatingRoomDrpdwnDisplayed() {
        return operatingRoom.getText().equalsIgnoreCase("Select Operating Room");
    }

    public void clickOperatingRoom() {
        operatingRoom.click();
        logger.info("==========Operating room dropdown is opened=============");
    }

    public void clickOkButton() {
        okButton.click();
        logger.info("==========Select confimration OK=============");
    }

    public void selectOperatingRoom(String operatingRoomName) {
        DriverFactory.getDriver(DriverFactory.getPlatformType()).findElement(By.xpath("//android.widget.TextView[@text= '" + operatingRoomName + "']")).click();
        logger.info("==========Select Operating Room=============");
    }

    public void navigateToOrdersOfOperatingRoom(String operatingRoomName) {
        clickOperatingRoom();
        selectOperatingRoom(operatingRoomName);
        clickOkButton();
    }
}

