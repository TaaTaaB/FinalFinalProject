package PageObject;
import DataObject.LogInData;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


public class LogInWithFakerData {
    WebDriver driver;

    public LogInWithFakerData(WebDriver driver) {
        this.driver = driver;
    }

    By
            incorrectUserlData = By.name("user-name"),
            incorrectPasswordData = By.id("password"),
            loginButton = By.name("login-button");

    @Step("username input:{0}")
    public LogInWithFakerData IncorrectUserlData(String username) {
        driver.findElement(incorrectUserlData).sendKeys(LogInData.incorrectUserData);
        return this;
    }

    @Step("password input:{0}")
    public LogInWithFakerData IncorrectPasswordData(String password) {
        driver.findElement(incorrectPasswordData).sendKeys(LogInData.incorrectPasswordData);
        return this;
    }

    @Step("Click on Login Button")
    public void clickOnLogInButton() throws InterruptedException {
        driver.findElement(loginButton).click();
        Thread.sleep(5000);
    }

}
