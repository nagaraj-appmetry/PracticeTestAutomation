package tests;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LogoutTest extends BaseTest {

    @Test(dependsOnMethods = {"tests.LoginTest.loginTest"})
    public void logoutTest() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement logoutBtn = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Log out")));
        logoutBtn.click();


        boolean isLoggedOut = driver.getPageSource().contains("Test Login Page");
        Assert.assertTrue(isLoggedOut, "Logout Failed!");
    }
}
