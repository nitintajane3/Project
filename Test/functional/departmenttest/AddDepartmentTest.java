package functional.departmenttest;


import com.relevantcodes.extentreports.LogStatus;
import functional.landingpagetest.SelectCompanyTest;
import functional.login.TestcaseLogin;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.dashboardpage.DashboardPagElement;
import pages.departmentpage.AddDepartmetElement;
import utilities.Reportsextend;
import utilities.TakeScreenshot;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static functional.login.TestcaseLogin.driver;
import static utilities.Reportsextend.test;


public class AddDepartmentTest

{
    String classname = "Add Department test";

    public static Reportsextend extend = new Reportsextend();
   @Test
    public void Adddepartmet() throws InterruptedException, IOException {

       extend.reports(classname);
       driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
       TestcaseLogin logintest = new TestcaseLogin();
       Reportsextend.test.log(LogStatus.INFO,"User login successfully");
       logintest.validlogintest();
       Thread.sleep(300);
       DashboardPagElement dashboardpge =new DashboardPagElement(driver);
        AddDepartmetElement departmetpage = new AddDepartmetElement(driver);
        SelectCompanyTest selectcompy = new SelectCompanyTest();

          selectcompy.selectcompanuydropdown();
          Reportsextend.test.log(LogStatus.INFO,"Company select successfully");
          Thread.sleep(300);
          dashboardpge.lnkdepartmet();
          Reportsextend.test.log(LogStatus.INFO,"Successfully click on Department");
          Thread.sleep(300);
          departmetpage.setAddDeptbutton();
          Reportsextend.test.log(LogStatus.INFO,"Successfully click on Add department button");
          departmetpage.setDprtnametextarea();
          Reportsextend.test.log(LogStatus.INFO,"Successfully enter the department name");
          Thread.sleep(100);
          departmetpage.clickemptyspace();
          Thread.sleep(200);
           try
           {
               Thread.sleep(500);
               departmetpage.addbuttodeprtmaager();
               Reportsextend.test.log(LogStatus.INFO,"Successfully click on add department manager button");
               departmetpage.enteremailid();
               Reportsextend.test.log(LogStatus.INFO,"Successfully enter the email  id");
               departmetpage.clickemailidfield();
               departmetpage.clickonsavebutton();
               Reportsextend.test.log(LogStatus.INFO,"Successfully add user into department manager position");
               Thread.sleep(300);
               driver.findElement(By.xpath("//button[text()='OK']")).click();

               departmetpage.setdeparmentmember();
               departmetpage.enteremailidmember();
               departmetpage.setemptyclick();
               departmetpage.clickonsavebutton();
               Thread.sleep(700);
               driver.findElement(By.xpath("//button[text()='OK']")).click();
               Reportsextend.test.log(LogStatus.INFO,"Department added successfully");

           }catch (Exception e)
                   {

                       departmetpage.duplicatepoppresent();
                       test.log(LogStatus.INFO,"Department already exist in system"+test.addScreenCapture("/screenshot"+ TakeScreenshot.takeScreenshot(driver)));
                       departmetpage.duplicatepopupclosed();departmetpage.duplicatepoppresent();
                       test.log(LogStatus.INFO,"Department already exist in system"+test.addScreenCapture("/screenshot"+ TakeScreenshot.takeScreenshot(driver)));
                       departmetpage.duplicatepopupclosed();

                    }

           Reportsextend.extend.endTest(test);
           Reportsextend.extend.flush();

   }
}
