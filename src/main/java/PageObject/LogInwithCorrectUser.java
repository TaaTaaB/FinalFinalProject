package PageObject;

import DataObject.LogInData;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInwithCorrectUser {
    WebDriver driver;

    public LogInwithCorrectUser(WebDriver driver) {
        this.driver = driver;
    }

    By
            correctUserData = By.id("user-name"),
            correctPasswordData = By.name("password"),
            LogInButton = By.id("login-button");

    @Step("username input:{0}")
    public LogInwithCorrectUser CorrectUserData(String username) {
        driver.findElement(correctUserData).sendKeys(LogInData.correctUserData);
        return this;

    }

    @Step("password input:{0}")
    public LogInwithCorrectUser CorrectPasswordData(String password) {
        driver.findElement(correctPasswordData).sendKeys(LogInData.correctPasswordData);
        return this;
    }

    @Step("Click on Login Button")
    public void clickOnLogInButton() throws InterruptedException {
        driver.findElement(LogInButton).click();
        Thread.sleep(5000);
    }

    public boolean isLoggedIn() {
        return true;
    }

    public boolean getErrorMessage() {
        return false;
    }
}
