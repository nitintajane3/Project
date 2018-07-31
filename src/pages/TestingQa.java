package pages;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Admin on 3/15/2018.
 */
public class TestingQa {
    WebDriver driver;
    @Test
    public void qaenginerr() throws IOException, InterruptedException {
        ExtentReports extent = new ExtentReports("C:\\Users\\Admin\\IdeaProjects\\Project\\Extent-Reports/failtestreport.html",false);
        ExtentTest test = extent.startTest("Add client Test", "Add client test for enter input");
       System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\IdeaProjects\\Project\\Browsers\\chromedriver.exe");
       driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tamplo.com/#!/home");
        driver.findElement(By.xpath("//button[text()='REGISTER NOWe ']")).click();
        //test.log(LogStatus.FAIL,"take screenshot when error occurs"+test.addScreenCapture("./screenshots/" +TakeScreenshot.takeScreenshot(driver)));
        //test.log(LogStatus.INFO, "url is opened");
        Thread.sleep(1000);
       // test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture("./screenshots/" + takeScreenshot(driver)));
       extent.endTest(test);
        extent.flush();
    }

}
