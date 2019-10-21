package com.framework.appium;

import com.utils.PropertyUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static com.utils.PropertyUtils.getIntProperty;
import static com.utils.PropertyUtils.getProperty;

public class MobileIosDriver implements Driver {

    private final Logger logger = LogManager.getLogger(this.getClass());

    public IOSDriver driver() {
        try {
            return new IOSDriver(new URL(DriverFactory.getAppiumServerUrl()), buildCapabilities());
        } catch (MalformedURLException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    public DesiredCapabilities buildCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        File apkFile = new File(getProperty("ios.app.name"));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, getProperty("ios.platform"));
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, getProperty("ios.device.name"));
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, getIntProperty("ios.app.timeout"));
        capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + getProperty("ios.app.location") + "/" + apkFile);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, getProperty("ios.app.no.reset"));
        return capabilities;
    }
}

