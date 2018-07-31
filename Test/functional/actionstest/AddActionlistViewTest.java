package functional.actionstest;

import com.relevantcodes.extentreports.LogStatus;
import functional.landingpagetest.SelectCompanyTest;
import functional.login.TestcaseLogin;
import org.testng.annotations.Test;
import pages.actionspage.AddActionslistViewElement;
import pages.actionspage.AddactionProjectElement;
import pages.dashboardpage.DashboardPagElement;
import utilities.Reportsextend;

import java.util.concurrent.TimeUnit;

import static functional.departmenttest.AddDepartmentTest.extend;
import static functional.login.TestcaseLogin.driver;
import static utilities.Reportsextend.test;

public class AddActionlistViewTest
{

    String classname = "Add Action in list view from actions page";
    @Test
    public void listViewtest() throws InterruptedException
    {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        extend.reports(classname);
        TestcaseLogin logintest = new TestcaseLogin();

        logintest.validlogintest();
        Thread.sleep(300);
        SelectCompanyTest selectcompy = new SelectCompanyTest();
        selectcompy.selectcompanuydropdown();
        test.log(LogStatus.INFO,"Company select successfully");
        DashboardPagElement dashboardpage = new DashboardPagElement(driver);
        Thread.sleep(200);
        dashboardpage.lnkaction();

        AddActionslistViewElement actionlistelmnt = new AddActionslistViewElement(driver);
        Thread.sleep(300);
        actionlistelmnt.linkListView();

        AddactionProjectElement actionelment = new AddactionProjectElement(driver);

//Add critical action
        Thread.sleep(200);
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
        actionlistelmnt.selectproject();
        Thread.sleep(200);
        actionlistelmnt.selectactionassigneename();
        Thread.sleep(200);
        test.log(LogStatus.INFO,"Assginee select successfully");
        actionelment.clicksaveaction();
        test.log(LogStatus.INFO,"Action created successfully");
// Add  important action

        Thread.sleep(200);
        actionelment.btnaddimportntaction();
        test.log(LogStatus.INFO,"In critical section action add form open successfully");
        actionelment.enterActiontitle();
        test.log(LogStatus.INFO,"Action title entered successfully");
        Thread.sleep(100);
        actionelment.clickduedate();
        //test.log(LogStatus.INFO,"Today due date select successfully");
        //actionelment.nextmonthduedate();
        test.log(LogStatus.INFO,"Next month due date select successfully");
        Thread.sleep(100);
        actionlistelmnt.selectproject();
        Thread.sleep(200);
        actionlistelmnt.selectactionassigneename();
        Thread.sleep(200);
        test.log(LogStatus.INFO,"Assginee select successfully");
        actionelment.clicksaveaction();
        test.log(LogStatus.INFO,"Action created successfully");
//Add less important action

        Thread.sleep(200);
        actionelment.btnaddlessimportantaction();
        test.log(LogStatus.INFO,"In critical section action add form open successfully");
        actionelment.enterActiontitle();
        test.log(LogStatus.INFO,"Action title entered successfully");
        Thread.sleep(100);
        actionelment.clickduedate();
        //test.log(LogStatus.INFO,"Today due date select successfully");
        //actionelment.nextmonthduedate();
        test.log(LogStatus.INFO,"Next month due date select successfully");
        Thread.sleep(100);
        actionlistelmnt.selectproject();
        Thread.sleep(200);
        actionlistelmnt.selectactionassigneename();
        Thread.sleep(200);
        test.log(LogStatus.INFO,"Assginee select successfully");
        actionelment.clicksaveaction();
        test.log(LogStatus.INFO,"Action created successfully");

        Reportsextend.extend.endTest(test);
        Reportsextend.extend.flush();

    }

}
