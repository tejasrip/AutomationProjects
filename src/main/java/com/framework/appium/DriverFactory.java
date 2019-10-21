package com.framework.appium;

import com.utils.PropertyUtils;
import io.appium.java_client.AppiumDriver;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class DriverFactory {
    private static String className = DriverFactory.class.getName();
    private static Logger logger = LogManager.getLogger(className);

    private static AppiumDriver driver;

    public static String getPlatformType() {
        return PropertyUtils.getProperty("platform.type");
    }

    public static String getAppiumServerUrl() {
        return PropertyUtils.getProperty("appium.server.url");
    }

    public static AppiumDriver getDriver(String osType) {
        if (driver == null) {
            driver = getWebDriver(osType);
        }
        logger.info("==========driver is set============");
        return driver;
    }

    private static AppiumDriver getWebDriver(String osType) {
        switch (osType) {
            case "Android":
                driver = new MobileAndroidDriver().driver();
                break;
            case "Ios":
                driver = new MobileIosDriver().driver();
                break;
            default:
                driver = new MobileAndroidDriver().driver();
                break;
        }
        return driver;
    }

    public static void quitDriver(){
        driver.quit();
        logger.info("=============driver quit==============");
    }
}
