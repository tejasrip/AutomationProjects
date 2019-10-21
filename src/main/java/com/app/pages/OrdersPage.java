package com.app.pages;

import com.framework.appium.DriverFactory;
import com.utils.PropertyUtils;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class OrdersPage extends BasePage {

    public OrdersPage() {
        int implicitWait = PropertyUtils.getIntProperty("implicitWait");
        PageFactory.initElements(new AppiumFieldDecorator(DriverFactory.getDriver(DriverFactory.getPlatformType()), implicitWait, TimeUnit.SECONDS), this);
    }

    @AndroidFindBy(id = "com.adam.qa:id/surgeryTimeTextView")
    private AndroidElement surgeryTime;

    @AndroidFindBy(id = "com.adam.qa:id/surgeonNameTextView")
    private AndroidElement surgeonName;

    public boolean isSurgeryTimeDisplayed() {
        return surgeryTime.isDisplayed();
    }

    public boolean isSurgeonNameDisplayed() {
        return surgeonName.isDisplayed();
    }

    public void selectOrder(String surgeonName, String surgeryTime){
        DriverFactory.getDriver(DriverFactory.getPlatformType()).findElement(By.xpath("//android.widget.TextView[@text='" + surgeonName +"' and @text='"+surgeryTime+"']))//following-sibling::android.widget.Button[@id='com.adam.qa:id/selectProcedureButton']")).click();
    }
}
