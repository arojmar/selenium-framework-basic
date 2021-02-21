package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.SignUpPageObject;
import util.RandomNumberGenerator;

public class SignUpStepDefs {


    @Given("^client wants to have an account$")
    public void clientWantsToHaveAnAccount() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/windows/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        SignUpPageObject signUpPageObject = new SignUpPageObject(driver);
        signUpPageObject.go("http://demo.automationtesting.in/Register.html");
        signUpPageObject.writeFirstName("Jose");
        signUpPageObject.writeLastName("Lopez");
        signUpPageObject.writeEmail("jose.lopez@gmail.com");
        signUpPageObject.writePhone(RandomNumberGenerator.get());
        signUpPageObject.selectMale();
        signUpPageObject.selectCountry("Spain");
        signUpPageObject.selectBirthDay("10");
        signUpPageObject.selectBirthMonth("January");
        signUpPageObject.selectBirthYear("1984");
        signUpPageObject.writePassword("QWe324_");
        signUpPageObject.writeConfirmPassword("QWe324_");
        signUpPageObject.clickOnSubmit();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();


    }

    @When("he sends requires information to get the account")
    public void heSendsRequiresInformationToGetTheAccount() {
    }


    @Then("he would be told that the account was created")
    public void heWouldBeToldThatTheAccountWasCreated() {
    }
}
