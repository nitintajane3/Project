package functional.register;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.failTestScreenShots;


import java.io.IOException;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;


/**
 * Created by Admin on 3/20/2018.
 */
public class RegisteredTest {
public static WebDriver driver;
    public static ExtentReports extend = new ExtentReports("Extent-Reports/screenshiot.html", false);
    public static ExtentTest test;
    @Test
    public void test222() throws IOException {
        driver = Driver.getDriver(Driver.drivertype.Firefoxdriver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        ResourceBundle rb = ResourceBundle.getBundle("resource");

        test = extend.startTest("Enter the in valid credential details");

        driver.get(rb.getString("url"));
       //RegisteredElements elementregister = new RegisteredElements(driver);
        driver.findElement(By.xpath("//button[text()='REGISTER NOWe ']")).click();
        //test.log(LogStatus.INFO,"loigin  jnot possible");
        //test.log(LogStatus.FAIL,"take screenshot when error occurs"+test.addScreenCapture("./screenshots/" + TakeScreenshot.takeScreenshot(driver)));
       /* elementregister.buttonregistered();
        elementregister.namecompany();
        elementregister.enteremailid();
        elementregister.buttonverifyemail();*/
        extend.endTest(test);
        extend.flush();
    }
    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {

        failTestScreenShots sreenshot = new failTestScreenShots();
        sreenshot.failscreenshot(driver,result);
        driver.close();

        }
    }