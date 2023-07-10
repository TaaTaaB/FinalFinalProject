package PageObject;

import DataObject.LogInData;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInWithLockedUser {
    WebDriver driver;
    public LogInWithLockedUser(WebDriver driver){
        this.driver = driver;}

    By
            lockedUserDara = By.name("user-name"),
            correctPasswordData = By.id("password"),
            loginButton = By.name("login-button");

    @Step("username input:{0}")
    public LogInWithLockedUser LockedUserData(String username){
        driver.findElement(lockedUserDara).sendKeys(LogInData.lockedUserDara);
        return this;
    }


    @Step("password input:{0}")
    public LogInWithLockedUser CorrectPasswordData(String password) {
        driver.findElement(correctPasswordData).sendKeys(LogInData.correctPasswordData);
        return this;
    }

    @Step("Click on Login Button")
    public void clickOnLogInButton() throws InterruptedException {
        driver.findElement(loginButton).click();
        Thread.sleep(5000);
    }
}

