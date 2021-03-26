package com.alfonsoframework.app.builders.data;

import com.alfonsoframework.app.enums.Gender;
import com.alfonsoframework.app.model.User;
import com.alfonsoframework.app.util.RandomNumberGenerator;

public class UserBuilder {

    private User user;

    private UserBuilder() {
        user = User.builder().build();
    }

    public static UserBuilder anUser() {
        return new UserBuilder();
    }

    public UserBuilder but(){
        return withDefaultInfo();
    }

    public UserBuilder withDefaultInfo() {
        this.user = User.builder()
                .firstName("TestName")
                .lastName("TestLastName")
                .email("test@testmail.com")
                .gender(Gender.male)
                .country("Spain")
                .birthDay("1")
                .birthMonth("March")
                .birthYear("1980")
                .phone(RandomNumberGenerator.get())
                .password("Wrt_23?")
                .passwordConfirmation("Wrt_23?")
                .build();

        return this;
    }

    public UserBuilder withoutEmail(){
        user.setEmail("");
        return this;
    }

    public UserBuilder withoutBirthDay(){
        user.setBirthDay("");
        return this;
    }

    public User build(){
        return this.user;
    }

}
