package com.alfonsoframework.app.pageobjects;

import com.alfonsoframework.app.enums.Gender;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("cucumber-glue")
@Component
public class SignUpServices {

    @Autowired
    private SignUpPageObject signUpPageObject;

    @Autowired
    private WebDriver driver;

    @Autowired
    private WebDriverWait wait;

    public void go(String url) {
        driver.get(url);
    }

    public void writeFirstName(String firstname) {
        this.wait.until(ExpectedConditions.visibilityOf(this.signUpPageObject.getFirstName()));
        this.signUpPageObject.getFirstName().sendKeys(firstname);
    }

    public void writeLastName(String lastname) {
        this.signUpPageObject.getLastName().sendKeys(lastname);
    }

    public void writeEmail(String email) {
        this.signUpPageObject.getEmailAddress().sendKeys(email);
    }

    public void writePhone(String phone) {
        this.signUpPageObject.getPhone().sendKeys(phone);
    }

    private void selectMale() {
        this.signUpPageObject.getGenderMale().click();
    }

    private void selectFemale() {
        this.signUpPageObject.getGenderFemale().click();
    }

    public void selectCountry(String country) {
        Select selectCountry = new Select(this.signUpPageObject.getCountry());
        this.wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(String.format("#countries > option[value='%s']", country))));
        selectCountry.selectByValue(country);
    }

    public void selectBirthDay(String day) {
        new Select(this.signUpPageObject.getDateOfBirthDay()).selectByValue(day);
    }

    public void selectBirthMonth(String month) {
        new Select(this.signUpPageObject.getDateOfBirthMonth()).selectByValue(month);
    }

    public void selectBirthYear(String year) {
        new Select(this.signUpPageObject.getDateOfBirthYear()).selectByValue(year);
    }

    public void writePassword(String password) {
        this.signUpPageObject.getPassword().sendKeys(password);
    }

    public void writeConfirmPassword(String password) {
        this.signUpPageObject.getConfirmPassword().sendKeys(password);
    }

    public void clickOnSubmit() {
        this.signUpPageObject.getSubmit().click();
    }

    public void selectGender(Gender gender) {
        if(gender == Gender.female){
            selectFemale();
        } else {
            selectMale();
        }
    }

}
