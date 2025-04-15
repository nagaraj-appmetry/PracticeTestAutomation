package tests;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Paths;
import java.time.Duration;

public class FileDownloadTest extends BaseTest {

    @Test
    public void fileDownload() throws InterruptedException {
        // Set up ChromeOptions to define download path
        ChromeOptions options = new ChromeOptions();
        String downloadDirectory = "C:\\Users\\nagar\\Downloads";  // Specify correct path here
        options.addArguments("download.default_directory=" + downloadDirectory);

        // Initialize WebDriver with ChromeOptions
        driver = new ChromeDriver(options);

        // Navigate to the file download page
        driver.get("https://the-internet.herokuapp.com/download");

        // Trigger the file download by clicking the link
        WebElement fileLink = driver.findElement(By.linkText("test_upload.txt"));
        fileLink.click();

        // Wait for the download to start (check visibility of the file)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("test_upload.txt")));

        // Provide a location for the downloaded file
        String filePath = downloadDirectory + "\\test_upload.txt";  // The file you are downloading

        // Wait for the file to appear in the directory
        File file = new File(filePath);
        int waitTime = 0;
        while (!file.exists() && waitTime < 30) {  // Wait for the file to exist (max 30 seconds)
            Thread.sleep(1000);
            waitTime++;
        }

        // Validate that the file exists in the download folder
        Assert.assertTrue(file.exists(), "File was not downloaded!");
    }
}
