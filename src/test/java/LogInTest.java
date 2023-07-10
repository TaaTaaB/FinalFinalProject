import PageObject.LogInWithFakerData;
import PageObject.LogInWithLockedUser;
import PageObject.LogInWithProblemUser;
import PageObject.LogInwithCorrectUser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static PageObject.LogInWithProblemUser.*;


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

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

}


