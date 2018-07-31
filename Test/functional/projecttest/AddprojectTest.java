package functional.projecttest;

import com.relevantcodes.extentreports.LogStatus;
import functional.landingpagetest.SelectCompanyTest;
import functional.login.TestcaseLogin;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.dashboardpage.DashboardPagElement;
import pages.projectpage.AddProjectElement;
import utilities.Reportsextend;

import java.util.concurrent.TimeUnit;

import static functional.departmenttest.AddDepartmentTest.extend;
import static functional.login.TestcaseLogin.driver;
import static utilities.Reportsextend.test;

public class AddprojectTest {

    String classname = "Add Project test";
    @Test
    public void addproject() throws InterruptedException {

        extend.reports(classname);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       TestcaseLogin logintest = new TestcaseLogin();
        test.log(LogStatus.INFO,"User login successfully");
        logintest.validlogintest();
        Thread.sleep(300);
        SelectCompanyTest selectcompy = new SelectCompanyTest();
        selectcompy.selectcompanuydropdown();
        test.log(LogStatus.INFO,"Company select successfully");
        AddProjectElement projectpage = new AddProjectElement(driver);
        DashboardPagElement dashboardpage = new DashboardPagElement(driver);
         Thread.sleep(300);
        dashboardpage.lnkprojects();
        test.log(LogStatus.INFO,"successfully click on project link");
        projectpage.createproject();
        test.log(LogStatus.INFO,"Successfully click on add project");
        projectpage.selectdptname();
        test.log(LogStatus.INFO,"Department select successfully");

        Thread.sleep(100);
        projectpage.enterprojectname();
        test.log(LogStatus.INFO,"Project name enter successfully");
        Thread.sleep(200);
        projectpage.clickemptyspace();

        try
        {
            projectpage.clickaddprojectmanager();
            projectpage.entertextAddpeople();
            test.log(LogStatus.INFO,"project manager email address enter successfully");
            projectpage.clicksavebutton();

            Thread.sleep(200);
            driver.findElement(By.xpath("//button[text()='OK']")).click();
            test.log(LogStatus.INFO,"User added into project manager account");

            Thread.sleep(300);
            projectpage.clickbuttonprojectmember();
            projectpage.entertextaddpeople2();
            test.log(LogStatus.INFO,"project member email address enter successfully");
            projectpage.clicksavebutton();
            test.log(LogStatus.INFO,"User added into project member account");
            Thread.sleep(300);

            driver.findElement(By.xpath("//button[text()='OK']")).click();
            test.log(LogStatus.INFO,"Project create successfully");

        }catch (Exception er)
            {
            projectpage.clickOKbuttonduplicate();
            test.log(LogStatus.INFO,"Ths Project name already exist");
            }

        Reportsextend.extend.endTest(test);
        Reportsextend.extend.flush();

    }
}
