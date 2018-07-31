package functional.actionstest;

import com.relevantcodes.extentreports.LogStatus;
import functional.landingpagetest.SelectCompanyTest;
import functional.login.TestcaseLogin;
import org.testng.annotations.Test;
import pages.actionspage.AddactionProjectElement;
import pages.dashboardpage.DashboardPagElement;
import utilities.Reportsextend;

import java.util.concurrent.TimeUnit;

import static functional.departmenttest.AddDepartmentTest.extend;
import static functional.login.TestcaseLogin.driver;
import static utilities.Reportsextend.test;

public class AddactionTest
{
String classname = "Add Action test";
    @Test
    public void EditProject() throws InterruptedException
    {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        extend.reports(classname);
       TestcaseLogin logintest = new TestcaseLogin();

       logintest.validlogintest();
        Thread.sleep(3000);
        SelectCompanyTest selectcompy = new SelectCompanyTest();
        selectcompy.selectcompanuydropdown();
        test.log(LogStatus.INFO,"Company select successfully");
        DashboardPagElement dashboardpage = new DashboardPagElement(driver);
        AddactionProjectElement actionelment = new AddactionProjectElement(driver);
        Thread.sleep(3000);
        dashboardpage.lnkprojects();
        test.log(LogStatus.INFO,"Project list display successfully");
        Thread.sleep(2000);
        actionelment.clickprojectfirst();
        test.log(LogStatus.INFO,"Project select successfully");
//action added into critical section
        actionelment.btnaddcriticalaction();
        test.log(LogStatus.INFO,"In critical section action add form open successfully");
        actionelment.enterActiontitle();
        test.log(LogStatus.INFO,"Action title entered successfully");
        Thread.sleep(100);
        actionelment.clickduedate();
        //test.log(LogStatus.INFO,"Today due date select successfully");
        //actionelment.nextmonthduedate();
        test.log(LogStatus.INFO,"Next month due date select successfully");
        Thread.sleep(100);
        actionelment.selectactionassignee();
        test.log(LogStatus.INFO,"Assginee select successfully");
        actionelment.clicksaveaction();
        test.log(LogStatus.INFO,"Action created successfully");

 //action added into important  section
        Thread.sleep(400);
        actionelment.btnaddimportntaction();
        test.log(LogStatus.INFO,"In important section action add form open successfully");
        actionelment.enterActiontitle();
        test.log(LogStatus.INFO,"Action title entered successfully");
        Thread.sleep(100);
        actionelment.clickduedate();
        test.log(LogStatus.INFO,"Today due date select successfully");
        actionelment.selectactionassignee();
        test.log(LogStatus.INFO,"Assginee select successfully");
        actionelment.clicksaveaction();
        test.log(LogStatus.INFO,"Action created successfully");


        //action added into less important  section
        Thread.sleep(500);
        actionelment.btnaddlessimportantaction();
        test.log(LogStatus.INFO,"In less important section action added form open successfully");
        actionelment.enterActiontitle();
        test.log(LogStatus.INFO,"Action title entered successfully");
        Thread.sleep(100);
        actionelment.clickduedate();
        test.log(LogStatus.INFO,"Today due date select successfully");
        actionelment.selectactionassignee();
        actionelment.clicksaveaction();
        test.log(LogStatus.INFO,"Action created successfully");




        Reportsextend.extend.endTest(test);
        Reportsextend.extend.flush();

    }


}
