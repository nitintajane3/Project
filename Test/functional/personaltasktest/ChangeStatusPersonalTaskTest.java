package functional.personaltasktest;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import functional.login.LoginTst;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.dashboardpage.DashboardPagElement;
import pages.departmentpage.DectiveDepartmentElement;
import pages.personaltaskpage.AddPersonalTkElement;
import pages.personaltaskpage.ChangeStatusElement;
import pages.personaltaskpage.DeletPersonlTaskEelment;
import utilities.NewExtendReport;

import static functional.login.LoginTst.driver;
import static utilities.NewExtendReport.*;
import static utilities.NewExtendReport.logger2;

public class ChangeStatusPersonalTaskTest
{
    NewExtendReport addpersonaltask =  new NewExtendReport();
    DeletPersonlTaskEelment deltepersnaltaskelement = new DeletPersonlTaskEelment(driver);
    DectiveDepartmentElement deactivedptemementpage = new DectiveDepartmentElement(driver);
    AddPersonalTkElement addpersnaltaskelemet = new AddPersonalTkElement(driver);
    ChangeStatusElement changestatuselement = new ChangeStatusElement(driver);

    @BeforeTest
    public void loginTest() throws InterruptedException
    {

        addpersonaltask.newReport("Change personal task Status test","change_personal_Task_status_test_report");
        logger =  extent.createTest("Login Test ");
        LoginTst logintest = new LoginTst();
        logintest.loginTestNew();
        logger.log(Status.PASS, MarkupHelper.createLabel("User login  successfully", ExtentColor.GREEN));
        logger.log(Status.PASS, MarkupHelper.createLabel("Company select successfully", ExtentColor.GREEN));
        extent.flush();
    }
    @Test(priority = 1)
    public void linkPersonalTask()
    {
        logger1 =  extent.createTest("Open personal task  module test");
        DashboardPagElement dashboardpage = new DashboardPagElement(driver);      //dashboard page element object created

        dashboardpage.linkPersonalTask();
        logger1.log(Status.PASS, MarkupHelper.createLabel("Successfully link to personal task", ExtentColor.GREEN));
        extent.flush();
    }

    @Test(priority = 2,enabled = true)
    public void delteCriticalTaskTest() throws InterruptedException
    {
        logger2 =  extent.createTest("Change Critical personal task Status step");

        String variblename = "Critical";

        int befrecrircalPersonalcount = addpersnaltaskelemet.getCriticalCount();

        logger2.log(Status.PASS,MarkupHelper.createLabel("before change Critical personal task status count is = " + befrecrircalPersonalcount,ExtentColor.GREEN));

        Thread.sleep(500);

        deltepersnaltaskelement.editBtnCriticaltest();

        logger2.log(Status.PASS, MarkupHelper.createLabel("Critical Personal task select  by title", ExtentColor.GREEN));

        logger2.log(Status.PASS, MarkupHelper.createLabel("Click on Status button", ExtentColor.GREEN));

        ChangeStatusTest(logger2);

        Thread.sleep(500);

        int aftrcrircalPersonalcount = addpersnaltaskelemet.getCriticalCount();

        logger2.log(Status.PASS,MarkupHelper.createLabel("after change Critical personal task status count is = " + aftrcrircalPersonalcount,ExtentColor.GREEN));

        extent.flush();

    }

    @Test(priority = 3,enabled = true)
    public void delteImportntTaskTest() throws InterruptedException
    {
        logger3 =  extent.createTest("Change important personal task Status step");

        String variblename = "Important";

        int befreimportnatPersonalcount = addpersnaltaskelemet.getImportntCount();

        logger3.log(Status.PASS,MarkupHelper.createLabel("before change important personal task status count is = " + befreimportnatPersonalcount,ExtentColor.GREEN));


        deltepersnaltaskelement.editBtnImportnt();

        logger3.log(Status.PASS, MarkupHelper.createLabel("Critical Personal task select by title", ExtentColor.GREEN));

        logger3.log(Status.PASS, MarkupHelper.createLabel("Click on status button", ExtentColor.GREEN));

        ChangeStatusTest(logger3);

        Thread.sleep(500);

        int aftrimportnatPersonalcount = addpersnaltaskelemet.getImportntCount();

        logger3.log(Status.PASS,MarkupHelper.createLabel("after change important personal task status count is = " + aftrimportnatPersonalcount,ExtentColor.GREEN));


        extent.flush();
    }

    @Test(priority = 4,enabled = true)
    public void delteLessImportntTaskTest() throws InterruptedException
    {
        logger4 =  extent.createTest("Change Less important  personal task Status step");

        String variblename = "Less Important";

        int befrelessimportnatPersonalcount = addpersnaltaskelemet.getLessImportntCount();

        logger4.log(Status.PASS,MarkupHelper.createLabel("before change less important personal task status count is = " + befrelessimportnatPersonalcount,ExtentColor.GREEN));


        deltepersnaltaskelement.editBtnLessImportntTest();

        logger4.log(Status.PASS, MarkupHelper.createLabel("Critical Personal task select by title", ExtentColor.GREEN));

        logger4.log(Status.PASS, MarkupHelper.createLabel("Click on status button", ExtentColor.GREEN));

        ChangeStatusTest(logger4);

        Thread.sleep(500);

        int afterlessimportnatPersonalcount = addpersnaltaskelemet.getLessImportntCount();

        logger4.log(Status.PASS,MarkupHelper.createLabel("after change less important personal task status count is = " + afterlessimportnatPersonalcount,ExtentColor.GREEN));


        extent.flush();
    }

    public void ChangeStatusTest(ExtentTest reprotvarible)
    {
        changestatuselement.btnStatusList();

        reprotvarible.log(Status.PASS, MarkupHelper.createLabel("Click on Status icon", ExtentColor.GREEN));

        changestatuselement.selectStatus(reprotvarible);

        reprotvarible.log(Status.PASS,MarkupHelper.createLabel("Successfully change the personal task  status",ExtentColor.GREEN));
    }

}
