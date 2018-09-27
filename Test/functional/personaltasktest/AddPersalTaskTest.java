package functional.personaltasktest;

import com.relevantcodes.extentreports.LogStatus;
import functional.landingpagetest.SelectCompanyTest;
import functional.login.TestcaseLogin;
import org.testng.annotations.Test;
import pages.actionspage.AddactionProjectElement;
import pages.dashboardpage.DashboardPagElement;
import utilities.Reportsextend;

import java.util.concurrent.TimeUnit;

import static functional.login.TestcaseLogin.driver;
import static utilities.Reportsextend.test;

public class AddPersalTaskTest
{
    private String  classname = "Add Personal task test";
    @Test
    public void personalTaskAdd() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //extend.reports(classname);

        TestcaseLogin logintest = new TestcaseLogin();    //login test object created

        logintest.validlogintest();

        test.log(LogStatus.INFO,"User  login successfully");

        Thread.sleep(2000);

        SelectCompanyTest selectcompy = new SelectCompanyTest();    // //select company object created

        selectcompy.selectcompanuydropdown();

        test.log(LogStatus.INFO,"Company select successfully");

        DashboardPagElement dashboardpage = new DashboardPagElement(driver);      //dashboard page element object created

        dashboardpage.linkPersonalTask();

        test.log(LogStatus.INFO,"Successfully click on personal task page");

        Thread.sleep(200);

        AddactionProjectElement prsnaltskelemnt = new AddactionProjectElement(driver);

        prsnaltskelemnt.btnaddcriticalaction();

        test.log(LogStatus.INFO,"Successfully click on personal task page");

        Thread.sleep(100);

        prsnaltskelemnt.enterActiontitle();

        test.log(LogStatus.INFO,"Enter the action title into critical section");

        Thread.sleep(100);

        prsnaltskelemnt.clickduedate();

        test.log(LogStatus.INFO,"Due date select successfully");

        Thread.sleep(100);

        prsnaltskelemnt.clicksaveaction();

        test.log(LogStatus.INFO,"Personal Task add successfully in critical section");

        Thread.sleep(300);

        prsnaltskelemnt.btnaddimportntaction();

        prsnaltskelemnt.enterActiontitle();

        test.log(LogStatus.INFO,"Enter the action title into important section");

        prsnaltskelemnt.clickduedate();

        test.log(LogStatus.INFO,"Due date select successfully");

        prsnaltskelemnt.clicksaveaction();

        test.log(LogStatus.INFO,"Personal Task add successfully in important section");


        Thread.sleep(300);

        prsnaltskelemnt.btnaddlessimportantaction();

        prsnaltskelemnt.enterActiontitle();

        test.log(LogStatus.INFO,"Enter the action title into less important section");

        prsnaltskelemnt.clickduedate();

        test.log(LogStatus.INFO,"Due date select successfully");

        prsnaltskelemnt.clicksaveaction();

        test.log(LogStatus.INFO,"Personal Task add successfully in less important section");


        Reportsextend.extend.endTest(test);
        Reportsextend.extend.flush();

    }
}
