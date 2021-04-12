package com.alfonsoframework.app.stepdefinitions;

import com.alfonsoframework.app.database.User;
import com.alfonsoframework.app.database.UserRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class DatabaseStepDefs {

    @Autowired
    UserRepository userRepository;

    User user = new User();

    @Given("Agent already registered an user")
    public void userAlreadyRegisteredAnUser() {
        user.setEmail("anonimo@gmail.com");
        user.setName("anonimo");

        userRepository.save(user);
    }

    @When("agent asks for the user")
    public void heAsksForTheUser() {
        Optional<User> user1 = userRepository.findById(user.getId());
        System.out.println(user1.get().getEmail());
    }

    @Then("agent should get a registered user")
    public void heShouldGetARegisteredUser() {
    }
}
