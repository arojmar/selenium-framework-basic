package com.alfonsoframework.app.tasks;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("cucumber-glue")
@Component
public class NavigateTo {

    @Autowired
    private WebDriver driver;

    @Value("${url}")
    private String url;

    public void signUpPage(){
        this.driver.get(url);
    }
}
