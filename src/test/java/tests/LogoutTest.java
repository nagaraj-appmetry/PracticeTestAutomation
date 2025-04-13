package tests;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @Test(dependsOnMethods = {"tests.LoginTest.loginTest"})
    public void logoutTest() {
        driver.findElement(By.linkText("Log out")).click();
        boolean isLoggedOut = driver.getPageSource().contains("Test Login Page");
        Assert.assertTrue(isLoggedOut, "Logout Failed!");
    }
}
