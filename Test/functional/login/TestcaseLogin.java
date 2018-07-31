package functional.login;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pages.dashboardpage.DashboardPagElement;
import pages.loginpage.LoginPageElements;
import utilities.DateCoversion;
import utilities.Driver;

import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.Calendar;
import java.util.TimeZone;


public class TestcaseLogin
{

    public static WebDriver driver = Driver.getDriver(Driver.drivertype.Chromedriver);
    ResourceBundle rb = ResourceBundle.getBundle("resource");
    public static ExtentReports extend = new ExtentReports("Extent-Reports/TestCaseforLogin.html", true);
    public static ExtentTest test;
    private int today;

@Test(priority = 0)
    public void validlogintest()
       {

           driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
           rb = ResourceBundle.getBundle("resource");
           driver.get(rb.getString("url"));
        test = extend.startTest("Enter the valid credential details");
        test.log(LogStatus.INFO,"Browser open successfully");

        LoginPageElements loginpge = new LoginPageElements(driver);
           DashboardPagElement landingelement = new DashboardPagElement(driver);
        DateCoversion date22 =  new DateCoversion();

        loginpge.loginbtnclick();
        /*driver.findElement(By.xpath("//*[@id='emailIdLoginPage']")).sendKeys("nitin.tajane@ityss.com");
        driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("1234");*/
        loginpge.usernameenter(rb.getString("validusername"));
        test.log(LogStatus.INFO,"Username entered successfully");
        loginpge.passwordenter(rb.getString("validpassword"));
        test.log(LogStatus.INFO,"password entered successfully");

        loginpge.loginbutton();

       /* String expected = date22.dateconvert();
        String  actual = landingelement.readdate();
        Assert.assertEquals(actual,expected);*/
        test.log(LogStatus.INFO,"Login Successfully");
           today = getCurrentDay();
           System.out.println("Today's number: " + today + "\n");
        extend.endTest(test);
        extend.flush();
    }
    private int getCurrentDay (){
        //Create a Calendar Object
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

        //Get Current Day as a number
        int todayInt = calendar.get(Calendar.DAY_OF_MONTH);


        //Integer to String Conversion
        //String todayStr = Integer.toString(todayInt);
        //System.out.println("Today Str: " + todayStr + "\n");

        return todayInt;
    }

/*@Test(priority = 1)
    public void invalidlogintest() throws IOException
   {
        test = extend.startTest("Enter incorrect credential details");
        test.log(LogStatus.INFO,"Browser open successfully");

        LoginPageElements loginpge = new LoginPageElements(driver);
        LandingPagElement landingelement = new LandingPagElement(driver);
        DateCoversion date22 =  new DateCoversion();

        loginpge.loginbtnclick();
        loginpge.usernameenter(rb.getString("invalidusername"));
        test.log(LogStatus.INFO,"Username entered successfully");

        loginpge.passwordenter(rb.getString("validpassword"));
        test.log(LogStatus.INFO,"password entered successfully"+test.addScreenCapture("/screenshot"+ TakeScreenshot.takeScreenshot(driver)));

        loginpge.loginbutton();

        try
          {
            String expected = date22.dateconvert();
            String  actual = landingelement.readdate();
            Assert.assertEquals(actual,expected);
           test.log(LogStatus.FAIL,"Login Successfully"+test.addScreenCapture("/screenshots"+TakeScreenshot.takeScreenshot(driver)));

           }catch (Exception e)
            {
             String actuallabel = "Wrong test username or password.";
             String  failalert = loginpge.lblfailtologin();
             Assert.assertNotEquals(failalert,actuallabel);
             test.log(LogStatus.INFO,rb.getString("invalidusername") +" This user not able to login to application System show alert  as '" +failalert);
            }
            extend.endTest(test);
            extend.flush();
    }


@Test(priority = 2)
     public void Loginbuttondisale() throws IOException

{
         test = extend.startTest("Enter invalid credential details");
         test.log(LogStatus.INFO,"Browser open successfully");

         LoginPageElements loginpge = new LoginPageElements(driver);

         loginpge.loginbtnclick();
         loginpge.usernameenter(rb.getString("username"));
         test.log(LogStatus.INFO,"Username entered successfully");
         loginpge.passwordenter(rb.getString("password"));
         test.log(LogStatus.INFO,"password entered successfully");

     try  {
            WebElement ele = driver.findElement(By.xpath("//button[@class='btn btn-primary btnStretched ng-binding']"));
            ele.click();
          }catch (NoSuchElementException e)
           {
            test.log(LogStatus.INFO,"Login button not enable please enter the valid email address");
            test.log(LogStatus.FAIL,"login fail"+test.addScreenCapture("/screenshots"+TakeScreenshot.takeScreenshot(driver)));
           }
             extend.endTest(test);
             extend.flush();

     }*/
}
