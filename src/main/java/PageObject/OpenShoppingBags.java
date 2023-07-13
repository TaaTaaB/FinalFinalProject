package PageObject;

import DataObject.LogInData;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenShoppingBags {
    WebDriver driver;

    public OpenShoppingBags(WebDriver driver) {
        this.driver = driver;
    }

    By
            correctUserData = By.id("user-name"),
            correctPasswordData = By.name("password"),
            LogInButton = By.id("login-button"),
            buyItem = By.xpath("//div[@class='inventory_item'][1]//button"),
            oppenBags = By.className("shopping_cart_badge"),
            RemoveButton = By.id("remove-sauce-labs-backpack");


    @Step("username input:{0}")
    public OpenShoppingBags CorrectUserData(String username) {
        driver.findElement(this.correctUserData).sendKeys(LogInData.correctUserData);
        return this;

    }

    @Step("password input:{0}")
    public OpenShoppingBags CorrectPasswordData(String password) {
        driver.findElement(this.correctPasswordData).sendKeys(LogInData.correctPasswordData);
        return this;
    }

    @Step("Click on Login Button")
    public void clickOnLogInButton() throws InterruptedException {
        driver.findElement(LogInButton).click();

    }

    @Step("Click on Inventory Item")
    public void clickOnItem() throws InterruptedException {
        driver.findElement(buyItem).click();


    }

    @Step("Click on Shopping Cart Badge")
    public void clickOnShoppingBags() throws InterruptedException {
        driver.findElement(oppenBags).click();
        Thread.sleep(5000);
    }


}
