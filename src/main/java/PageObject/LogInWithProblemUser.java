package PageObject;

import DataObject.LogInData;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInWithProblemUser {
    WebDriver driver;
    public LogInWithProblemUser(WebDriver driver){
        this.driver = driver;}

    By
            problemUserData = By.name("user-name"),
            correctPasswordData = By.id("password"),
            loginButton = By.name("login-button");

    @Step("username input:{0}")
    public LogInWithProblemUser ProblemUserData(String username){
        driver.findElement(problemUserData).sendKeys(LogInData.problemUserData);
        return this;
    }


    @Step("password input:{0}")
    public LogInWithProblemUser CorrectPasswordData(String password) {
        driver.findElement(correctPasswordData).sendKeys(LogInData.correctPasswordData);
        return this;
    }

    @Step("Click on Login Button")
    public void clickOnLogInButton() throws InterruptedException {
        driver.findElement(loginButton).click();
        Thread.sleep(5000);
    }
}
