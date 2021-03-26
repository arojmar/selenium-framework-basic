package com.alfonsoframework.app.util.reporting;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.UUID;

public class ScreenshotHook {

    @Autowired
    private WebDriver driver;

    @Value("${take.screenshot.condition:none}")
    private TakeScreenshotConditions takeScreenshotConditions;

    @After
    public void takeScreenshotAfterScenario(Scenario scenario) {
        if(TakeScreenshotConditions.endOfScenario == takeScreenshotConditions){
            takeScreenshot(scenario);
        }
    }

    @AfterStep
    public void takeScreenshotAfterEveryStep(Scenario scenario) {
        if(TakeScreenshotConditions.everyStep == takeScreenshotConditions){
            takeScreenshot(scenario);
        }
    }

    @After
    public void takeScreenshotAfterFailedScenario(Scenario scenario) {
        if(scenario.isFailed() && TakeScreenshotConditions.scenarioFailed == takeScreenshotConditions){
            takeScreenshot(scenario);
        }
    }

    private void takeScreenshot(Scenario scenario) {

        try {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", UUID.randomUUID().toString());
        } catch (WebDriverException webDriverException) {
            System.out.println("There was an error taking the screenshot: " + webDriverException.getMessage());
        }
    }
}
