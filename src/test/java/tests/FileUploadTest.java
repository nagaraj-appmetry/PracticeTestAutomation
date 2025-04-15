package tests;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTest extends BaseTest {

    @Test
    public void fileUpload() {
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement upload = driver.findElement(By.id("file-upload"));
        upload.sendKeys("C:\\VsCode\\java_Codes\\src\\main\\resources\\Nagaraj sample text file.txt"); // Use an actual file path on your machine
        driver.findElement(By.id("file-submit")).click();
        Assert.assertTrue(driver.getPageSource().contains("File Uploaded!"));
    }
}