import DataObject.LogInData;
import PageObject.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.logging.Log;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.time.Duration;

import static DataObject.LogInData.*;

public class LogInTest {
    WebDriver driver;

    @BeforeMethod(description = "Setup browser before testing")

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
    }


    @Test(priority = 2)
    public void LogInData() throws InterruptedException {
        LogInWithFakerData home = new LogInWithFakerData(driver);
        home
                .IncorrectUserlData(incorrectUserData)
                .IncorrectPasswordData(incorrectPasswordData)
                .clickOnLogInButton();
        String actualTitle = driver.getTitle();
        String exspectedTitle = "Swag Labs";
        Assert.assertEquals(actualTitle, exspectedTitle);


    }
    @Test(priority = 1)
    public void LogInWithCorrectUser()throws InterruptedException {
        LogInwithCorrectUser home = new LogInwithCorrectUser(driver);
        home
                .CorrectUserData(correctUserData)
                .CorrectPasswordData(correctPasswordData)
                .clickOnLogInButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));
        wait.until(ExpectedConditions.titleIs("Swag Labs"));
        String expectedResult = "https://www.saucedemo.com/inventory.html";
        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult, "https://www.saucedemo.com/inventory.html");

        if (actualResult.equals(expectedResult)) {
            Assert.assertTrue("User is logged in", home.isLoggedIn());
        } else {
            String errorMessage = String.valueOf(home.getErrorMessage());
            Assert.assertNotNull(errorMessage, "Error message is defined");
        }
        System.out.println("Link is valid: " + actualResult);
    }
    @Test(priority = 3)
    public void LoginWithProblemUserName()throws InterruptedException{
        LogInWithProblemUser home =new LogInWithProblemUser(driver);
        home
                .ProblemUserData(problemUserData)
                .CorrectPasswordData(correctPasswordData)
                .clickOnLogInButton();
    }
    @Test(priority = 4)
    public void LoginWithLockedUserName()throws InterruptedException{
        LogInWithLockedUser home =new LogInWithLockedUser(driver);
        home
                .LockedUserData(lockedUserDara)
                .CorrectPasswordData(correctPasswordData)
                .clickOnLogInButton();

    }
    @Test (priority = 5)
    public void LoginWithBlankData()throws InterruptedException{
        LogInWithBlankData home = new LogInWithBlankData(driver);
        home
                .BlankUserName (blankUserName)
                .BlankPasswordData(blankPasswordData)
                .clickOnLogInButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@data-test='error']")));
        String errorMessage = errorElement.getText();
        System.out.println("Error Message: " + errorMessage);
        Assert.assertTrue("Error element is displayed", errorElement.isDisplayed());
        Assert.assertEquals(errorMessage, "Error text is valid", "Error text is valid");
    }
    @Test(priority = 6)
    public void LogInWithIncorrectPassword()throws InterruptedException{
        LogInWithIncorrectPassword home = new LogInWithIncorrectPassword(driver);
        home
                .CorrectUserData(correctUserData)
                .IncorrectPasswordData(incorrectPasswordData)
                .clickOnLogInButton();
        LogInData invalidPassData = new LogInData() {};
        invalidPassData.passwordTry();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
    @Test(priority = 7)
    public void LogInWithIncorrectUser()throws InterruptedException{
        LogInWithIncorrectUser home = new LogInWithIncorrectUser(driver);
        home
                .InCorrectUserData (incorrectUserData)
                .CorrectPasswordData (correctPasswordData)
                .clickOnLogInButton();
        LogInData invalidUserData = new LogInData() {};
        invalidUserData.nameTry(10);
    }

}


