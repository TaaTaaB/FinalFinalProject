package PageObject;

import DataObject.LogInData;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInWithBlankData {
    WebDriver driver;

    public LogInWithBlankData(WebDriver driver) {
        this.driver = driver;
    }

    By
            blankUserName = By.id("user-name"),
            blankPasswordData = By.name("password"),
            LogInButton = By.id("login-button");

    @Step("username input")
    public LogInWithBlankData BlankUserName (String blankUserName){
        driver.findElement (this.blankUserName).sendKeys(LogInData.blankUserName);
        return this;
    }
    @Step("password input")
    public LogInWithBlankData BlankPasswordData (String blankPasswordData){
        driver.findElement(this.blankPasswordData).sendKeys(LogInData.blankPasswordData);
        return this;
    }

    @Step("Click on Login Button")
    public void clickOnLogInButton() throws InterruptedException {
        driver.findElement(LogInButton).click();
        Thread.sleep(5000);
    }
}
