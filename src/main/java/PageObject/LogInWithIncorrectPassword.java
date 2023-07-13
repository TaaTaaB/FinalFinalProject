package PageObject;

import DataObject.LogInData;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInWithIncorrectPassword {
    WebDriver driver;

    public LogInWithIncorrectPassword(WebDriver driver) {
        this.driver = driver;
    }

    By
            correctUserData = By.id("user-name"),
            incorrectPasswordData = By.name("password"),
            LogInButton = By.id("login-button");

    @Step("username input")
    public LogInWithIncorrectPassword CorrectUserData(String correctUserName) {
        driver.findElement(this.correctUserData).sendKeys(LogInData.correctUserData);
        return this;
    }

    @Step("password input")
    public LogInWithIncorrectPassword IncorrectPasswordData(String incorrectPasswordData) {
        driver.findElement(this.incorrectPasswordData).sendKeys(LogInData.incorrectUserData);
        return this;
    }

    @Step("Click on Login Button")
    public void clickOnLogInButton() throws InterruptedException {
        driver.findElement(LogInButton).click();
        Thread.sleep(5000);
    }
}
