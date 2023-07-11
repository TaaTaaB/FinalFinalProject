package PageObject;

import DataObject.LogInData;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInWithIncorrectUser {
    WebDriver driver;
    public LogInWithIncorrectUser (WebDriver driver){
        this.driver = driver;
    }
    By
            incorrectUserData = By.id("user-name"),
            correctPasswordData = By.name("password"),
            LogInButton = By.id("login-button");

    @Step("username input")
    public LogInWithIncorrectUser InCorrectUserData (String incorrectUserName) {
        driver.findElement(this.incorrectUserData).sendKeys(LogInData.incorrectUserData);
        return this;
    }
    @Step ("password input")
    public LogInWithIncorrectUser CorrectPasswordData (String correctPasswordData){
        driver.findElement(this.correctPasswordData).sendKeys(LogInData.correctPasswordData);
        return this;
    }
    @Step("Click on Login Button")
    public void clickOnLogInButton() throws InterruptedException {
        driver.findElement(LogInButton).click();
        Thread.sleep(5000);
    }
}
