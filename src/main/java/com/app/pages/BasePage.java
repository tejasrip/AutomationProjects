package com.app.pages;

import io.appium.java_client.android.AndroidElement;

public class BasePage {

        public BasePage()  {


    }

    public void waitForElementVisible(AndroidElement ele) {
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, 30);
//            wait.until(ExpectedConditions.visibilityOf(ele));
//        } catch (StaleElementReferenceException staleException) {
//            throw staleException;
//        }
    }
}
