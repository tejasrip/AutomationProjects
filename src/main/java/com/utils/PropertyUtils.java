package com.utils;

import com.app.pages.HomePage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static java.util.Objects.isNull;

public final class PropertyUtils {

    private static PropertyUtils propertyUtils = null;
    private final Properties props = new Properties();
    String applicationProps = "application.properties";
    String testDataProperties = "testdata.properties";

    private PropertyUtils() {
        this.loadProperties();
    }

    private static PropertyUtils getInstance() {
        if (isNull(PropertyUtils.propertyUtils)) {
            propertyUtils = new PropertyUtils();
        }
        return propertyUtils;
    }

    private void loadProperties() {
        InputStream appProps = getClass().getClassLoader().getResourceAsStream(applicationProps);
        InputStream dataProps = getClass().getClassLoader().getResourceAsStream(testDataProperties);

        try {
            props.load(appProps);
            props.load(dataProps);
            appProps.close();
            dataProps.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return PropertyUtils.getInstance().props.getProperty(key);
    }

    public static int getIntProperty(String key) {
        return Integer.parseInt(PropertyUtils.getInstance().props.getProperty(key));
    }

}
