package DataObject;

import com.github.javafaker.Faker;

public interface LogInData {
    Faker faker = new Faker();
    int interactionCount = 5;
    String
            incorrectUserData = faker.name().firstName(),
            incorrectPasswordData = faker.internet().password(),
            blankUserName = "",

    blankPasswordData = "",

    problemUserData = "problem_user",
            lockedUserDara = "locked_out_user",
            correctUserData = "standard_user",
            correctPasswordData = "secret_sauce";

    default void passwordTry() {
        int count = 0;

        while (count < interactionCount) {
            String password = faker.internet().password();
            System.out.println("Password options " + (count + 1) + ": " + password);
            count++;
        }
    }

    default void nameTry(int interactionCount) {
        for (int i = 0; i < interactionCount; i++) {
            String name = faker.name().firstName();
            System.out.println("Name options " + (i + 1) + ": " + name);
        }
    }

    static void fakerUsernameAndPassword() {
        for (int count = 0; count < 5; count++) {
            String username = faker.name().firstName();
            String password = faker.internet().password();
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
            System.out.println();
        }
    }
}




