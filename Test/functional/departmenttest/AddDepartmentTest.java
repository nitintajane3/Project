package functional.departmenttest;

import functional.login.LoginTst;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.dashboardpage.DashboardPagElement;
import pages.departmentpage.AddDepartmetElement;
import pages.departmentpage.EditdepartmentElement;
import sun.awt.windows.ThemeReader;
import utilities.NewExtendReport;
import static functional.login.LoginTst.driver;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import static utilities.NewExtendReport.extent;



public class AddDepartmentTest

{
    DashboardPagElement dashboardpge =new DashboardPagElement(driver);
    NewExtendReport adddptreport =  new NewExtendReport();
    EditdepartmentElement editdeptelement = new EditdepartmentElement(driver);
    AddDepartmetElement adddptemement = new AddDepartmetElement(driver);

   @BeforeTest
    public void Adddepartmet() throws InterruptedException {

       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

       //adddptreport.newReport("Add Department","add_department_test");

       //NewExtendReport.logger =  extent.createTest("Add Department");

       LoginTst logintest = new LoginTst();

       logintest.loginTestNew();

       Thread.sleep(2000);

       driver.findElement(By.xpath("//a[@href='../app/#!/departments'][text()=' DEPARTMENTS ']")).click();
       //dashboardpge.lnkdepartmet();


       adddptemement.setAddDeptbutton();

       adddptemement.setDprtnametextarea();

       adddptemement.clickemptyspace();

       driver.findElement(By.xpath("//button[text()='OK']")).click();

       Thread.sleep(1000);

      // extent.flush();

   }

   @Test(priority = 1)
    public void addUserManager() {
       try
       {
           adddptemement.addbuttodeprtmaager();

           adddptemement.enteremailid();

           adddptemement.clickemailidfield();

           adddptemement.clickonsavebutton();

           editdeptelement.userAddsucess();

       }catch (Exception e)
       {
           editdeptelement.userDuplicateAlert();

           adddptemement.duplicatepopupclosed();

           editdeptelement.btnCancelManager();
       }

   }

   @Test(priority = 2)
    public void addUserMember() {
       try
       {
           adddptemement.setdeparmentmember();

           adddptemement.enteremailidmember();

           adddptemement.setemptyclick();

           adddptemement.clickonsavebutton();

           editdeptelement.userAddsucess();

       }catch (Exception e)
       {
           editdeptelement.userDuplicateAlert();

           adddptemement.duplicatepopupclosed();

           editdeptelement.btnCanceMember();
       }
   }
}
