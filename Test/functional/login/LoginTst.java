package functional.login;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.dashboardpage.DashboardPagElement;
import pages.loginpage.LoginPageElements;
import utilities.Driver;
import utilities.NewExtendReport;
import java.util.List;
import java.util.ResourceBundle;
import static utilities.NewExtendReport.extent;
import static utilities.NewExtendReport.logger;
import static utilities.NewExtendReport.logger1;


public class LoginTst
{
    public static WebDriver driver = Driver.getDriver(Driver.drivertype.Chromedriver);
    ResourceBundle rb = ResourceBundle.getBundle("tamplo5");
    NewExtendReport reportstes = new NewExtendReport();


    @Test
    public void loginTestNew() throws InterruptedException
    {


        /*reportstes.newReport("Login test","Login_test");
        NewExtendReport.logger = extent.createTest("login test case");*/

        LoginPageElements loginpge = new LoginPageElements(driver);

        driver.get(rb.getString("tamplo5url"));
        //logger.log(Status.PASS, MarkupHelper.createLabel("URL enter successfully", ExtentColor.GREEN));

        loginpge.loginbtnclick();
        //logger.log(Status.PASS, MarkupHelper.createLabel("Successfully open the login popup", ExtentColor.GREEN));
        /*driver.findElement(By.xpath("//*[@id='emailIdLoginPage']")).sendKeys("nitin.tajane@ityss.com");
        driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("1234");*/
        loginpge.usernameenter(rb.getString("username"));
        //logger.log(Status.PASS, MarkupHelper.createLabel("Username enter successfully", ExtentColor.GREEN));

        loginpge.passwordenter(rb.getString("password"));
        //logger.log(Status.PASS, MarkupHelper.createLabel("password enter successfully", ExtentColor.GREEN));

        loginpge.loginbutton();
        //logger.log(Status.PASS, MarkupHelper.createLabel("User  login successfully", ExtentColor.GREEN));

        Thread.sleep(2000);
        DashboardPagElement dashelement = new DashboardPagElement(driver);

        String  actualcompany=rb.getString("companynametest");
        dashelement.dropdowncompany();
        List<WebElement> compnycount = driver.findElements(By.xpath("//*[@id='jq-dropdown-3']/ul/li"));
        int activecompnycount = compnycount.size();
        for(int i=1;i<=activecompnycount;i++)
        {

            try {

                WebElement readcompanyname = driver.findElement(By.xpath("//*[@id='jq-dropdown-3']/ul/li[" + i + "]"));
                String getcompanyname = readcompanyname.getText();
                System.out.println("list of company = " + getcompanyname);
                if (getcompanyname.equals(actualcompany)) {
                    driver.findElement(By.xpath("//*[@id='jq-dropdown-3']/ul/li[" + i + "]/a")).click();
                    //logger.log(Status.PASS,MarkupHelper.createLabel(actualcompany + "= This company select successfully",ExtentColor.GREEN));
                    System.out.println("click on expected company");

                }
            }catch (Exception e44){
                System.out.println("condition not match");
                //logger.log(Status.PASS,MarkupHelper.createLabel("company not select",ExtentColor.RED));
            }
        }
        //extent.flush();
    }

    /*@Test(priority = 2)
    public void selectcompanuydropdown() throws InterruptedException {


        Thread.sleep(2000);
        logger1= extent.createTest("Company select");
        DashboardPagElement dashelement = new DashboardPagElement(driver);

        String  actualcompany=rb.getString("companynametest");
        dashelement.dropdowncompany();
        List<WebElement> compnycount = driver.findElements(By.xpath("//*[@id='jq-dropdown-3']/ul/li"));

        int activecompnycount = compnycount.size();
        for(int i=1;i<=activecompnycount;i++)
        {

            try {

                WebElement readcompanyname = driver.findElement(By.xpath("//*[@id='jq-dropdown-3']/ul/li[" + i + "]"));
                String getcompanyname = readcompanyname.getText();
                System.out.println("list of company = " + getcompanyname);
                if (getcompanyname.equals(actualcompany)) {
                    driver.findElement(By.xpath("//*[@id='jq-dropdown-3']/ul/li[" + i + "]/a")).click();
                    logger1.log(Status.PASS,MarkupHelper.createLabel(actualcompany + "= This company select successfully",ExtentColor.GREEN));
                    System.out.println("click on expected company");

                }
            }catch (Exception e44){
                System.out.println("condition not match");
                logger1.log(Status.PASS,MarkupHelper.createLabel("company not select",ExtentColor.RED));
            }
        }
          extent.flush();
    }
*/
}
