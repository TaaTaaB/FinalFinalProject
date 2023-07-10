package DataObject;

import com.github.javafaker.Faker;

public interface LogInData {
    Faker faker = new Faker();
    String
            incorrectUserData = faker.name().firstName(),
            incorrectPasswordData = faker.internet().password(),
            problemUserData = "problem_user",
            lockedUserDara = "problem_user",
            correctUserData = "standard_user",
            correctPasswordData = "secret_sauce";
}
