package com.alfonsoframework.app.util.driver;

import com.alfonsoframework.app.enums.Browser;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private static String pathFormat = System.getProperty("user.dir") + "/src/test/resources/drivers/linux/%s";

    @SneakyThrows
    public static WebDriver get(Browser browser) {

        switch (browser) {
            case chrome:
                System.setProperty("webdriver.chrome.driver", String.format(pathFormat, "chromedriver"));
                return new ChromeDriver();
            case firefox:
                System.setProperty("webdriver.gecko.driver", String.format(pathFormat, "geckodriver"));
                return new FirefoxDriver();
            default:
                throw new IllegalAccessException("Driver not found for browser:" + browser);
        }
    }
}
