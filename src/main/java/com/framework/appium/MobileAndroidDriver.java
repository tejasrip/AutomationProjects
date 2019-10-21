package com.framework.appium;

import com.utils.PropertyUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static com.utils.PropertyUtils.getProperty;
import static com.utils.PropertyUtils.getIntProperty;

public class MobileAndroidDriver implements Driver {

    private Logger logger = LogManager.getLogger(this.getClass());

    public AndroidDriver driver() {
        try {
            return new AndroidDriver(new URL(getProperty("appium.server.url")), buildCapabilities());
        } catch (MalformedURLException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    public DesiredCapabilities buildCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        File apkFile = new File(getProperty("android.app.name"));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, getProperty("android.platform"));
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, getProperty("android.device.name"));
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, getIntProperty("android.app.timeout"));
        capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + getProperty("android.app.location") + "/" + apkFile);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, getProperty("android.app.no.reset"));
        return capabilities;
    }
 }
