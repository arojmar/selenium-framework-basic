package com.alfonsoframework.app.util.driver;

import com.alfonsoframework.app.enums.Browser;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.Map;

@Component
public class DriverFactory {

    private static String pathFormat = System.getProperty("user.dir") + "/src/test/resources/drivers/linux/%s";

    @Value("${grid.url}")
    private String gridUrl;

    @Value("${remote.execution}")
    private boolean remoteExecution;

    @SneakyThrows
    public WebDriver get(Browser browser) {

        if (remoteExecution) {
            return getRemoteWebDriver(browser);
        }
        if (Browser.chrome == browser) {
            System.setProperty("webdriver.chrome.driver", String.format(pathFormat, "chromedriver"));
            return new ChromeDriver();
        }
        if (Browser.firefox == browser) {
            System.setProperty("webdriver.gecko.driver", String.format(pathFormat, "geckodriver"));
            return new FirefoxDriver();
        }
        throw new IllegalAccessException("Driver not found for browser:" + browser);
    }


    @SneakyThrows
    private RemoteWebDriver getRemoteWebDriver(Browser browser) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browser.name());
        capabilities.setCapability( "enableVNC", true);
        capabilities.setCapability( "enableVideo", true);
        return new RemoteWebDriver(URI.create(gridUrl).toURL(), capabilities);
    }
}
