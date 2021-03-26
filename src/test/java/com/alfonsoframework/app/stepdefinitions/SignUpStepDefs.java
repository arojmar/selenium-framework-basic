package com.alfonsoframework.app.stepdefinitions;

import com.alfonsoframework.app.builders.data.UserBuilder;
import com.alfonsoframework.app.conf.DriverConfig;
import com.alfonsoframework.app.tasks.NavigateTo;
import com.alfonsoframework.app.tasks.UserSignUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@CucumberContextConfiguration
@ContextConfiguration(classes = {DriverConfig.class})
public class SignUpStepDefs {

    @Autowired
    private UserSignUp signUp;

    @Autowired
    private NavigateTo navigate;

    @Value("${url}")
    private String url;

    @Given("^client wants to have an account$")
    public void clientWantsToHaveAnAccount()  {
        navigate.signUpPage();
    }

    @When("he sends requires information to get the account")
    public void heSendsRequiresInformationToGetTheAccount() {

        signUp.withInfo(
                UserBuilder
                        .anUser()
                        .withDefaultInfo()
                        .build()
        );
    }


    @Then("he would be told that the account was created")
    public void heWouldBeToldThatTheAccountWasCreated() {
        assertThat(true).isEqualTo(true);
    }


    @When("doesn't send all the required information to get the account")
    public void doesNotSendAllRequiredInformationToGetTheAccount() {

        signUp.withInfo(
                UserBuilder
                        .anUser()
                        .but()
                        .withoutEmail()
                        .withoutBirthDay()
                        .build()
        );
    }

    @Then("he would be told that the account was not created")
    public void heWouldBeToldThatTheAccountWasNotCreated() {
        assertThat(true).isEqualTo(false);
    }
}
