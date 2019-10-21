package com.framework.appium;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public interface Driver {

    AppiumDriver driver();

    DesiredCapabilities buildCapabilities();
}
