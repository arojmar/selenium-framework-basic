package com.alfonsoframework.app.tasks;

import com.alfonsoframework.app.model.User;
import com.alfonsoframework.app.pageobjects.SignUpServices;
import com.alfonsoframework.app.util.RandomNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("cucumber-glue")
@Component
public class UserSignUp {

    @Autowired
    private SignUpServices signUp;

    public void withInfo(User user) {

        signUp.writeFirstName(user.getFirstName());
        signUp.writeLastName(user.getLastName());
        signUp.writeEmail(user.getEmail());
        signUp.writePhone(RandomNumberGenerator.get());
        signUp.selectGender(user.getGender());
        signUp.selectCountry(user.getCountry());
        signUp.selectBirthDay(user.getBirthDay());
        signUp.selectBirthMonth(user.getBirthMonth());
        signUp.selectBirthYear(user.getBirthYear());
        signUp.writePassword(user.getPassword());
        signUp.writeConfirmPassword(user.getPasswordConfirmation());
    }



}
