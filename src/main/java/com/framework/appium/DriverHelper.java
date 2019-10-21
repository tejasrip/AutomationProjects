package com.framework.appium;

import com.utils.PropertyUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;d

public class DriverHelper {
    public void initPageElements(Class page){
        int implicitWait = PropertyUtils.getIntProperty("implicitWait");
        PageFactory.initElements(new AppiumFieldDecorator(DriverFactory.getDriver(DriverFactory.getPlatformType()), implicitWait, TimeUnit.SECONDS), page);
    }


    public AppiumDriver getAppiumDriver(){
        return DriverFactory.getDriver(DriverFactory.getPlatformType());
    }
}
