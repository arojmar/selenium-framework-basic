package com.alfonsoframework.app.conf;

import com.alfonsoframework.app.enums.Browser;
import com.alfonsoframework.app.util.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.net.MalformedURLException;

@Configuration
public class DriverConfig {

    @Value("${driver.type}")
    private Browser driverType;

    @Value("${element.wait.timeout.seconds}")
    private int webDriverWaitTimeOut;

    @Autowired
    private DriverFactory driverFactory;

    @Scope("cucumber-glue")
    @Bean(destroyMethod = "quit")
    public WebDriver webDriver() {
        return driverFactory.get(driverType);
    }

    @Scope("cucumber-glue")
    @Bean
    public WebDriverWait waitFor() throws MalformedURLException {
        return new WebDriverWait(webDriver(), webDriverWaitTimeOut);
    }
}
