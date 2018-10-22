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
import pages.personaltaskpage.ChangeImportancePersnalTaskElement;
import pages.personaltaskpage.ChangeStatusElement;
import pages.personaltaskpage.DeletPersonlTaskEelment;
import utilities.NewExtendReport;

import static functional.login.LoginTst.driver;
import static utilities.NewExtendReport.*;
import static utilities.NewExtendReport.logger2;

public class ChngeImportancePernalTaskTest
{
    NewExtendReport addpersonaltask =  new NewExtendReport();
    DeletPersonlTaskEelment deltepersnaltaskelement = new DeletPersonlTaskEelment(driver);
    DectiveDepartmentElement deactivedptemementpage = new DectiveDepartmentElement(driver);
    AddPersonalTkElement addpersnaltaskelemet = new AddPersonalTkElement(driver);
    ChangeStatusElement changestatuselement = new ChangeStatusElement(driver);
    ChangeImportancePersnalTaskElement importnceelement = new ChangeImportancePersnalTaskElement(driver);

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
        logger2 =  extent.createTest("Change Importance of personal task  step");

        String variblename = "Critical";

        int befrecrircalPersonalcount = addpersnaltaskelemet.getCriticalCount();

        logger2.log(Status.PASS,MarkupHelper.createLabel("before change Critical personal task Importance count is = " + befrecrircalPersonalcount,ExtentColor.GREEN));

        Thread.sleep(500);

        deltepersnaltaskelement.editBtnCriticaltest();

        logger2.log(Status.PASS, MarkupHelper.createLabel("Critical Personal task select  by title", ExtentColor.GREEN));

        logger2.log(Status.PASS, MarkupHelper.createLabel("Click on importance button", ExtentColor.GREEN));

        ChangeImportanceTest(logger2);

        Thread.sleep(500);

        int aftrcrircalPersonalcount = addpersnaltaskelemet.getCriticalCount();

        logger2.log(Status.PASS,MarkupHelper.createLabel("after change Critical personal task importance count is = " + aftrcrircalPersonalcount,ExtentColor.GREEN));

        extent.flush();

    }

    public void ChangeImportanceTest(ExtentTest loogername)
    {
        importnceelement.btnImportance();

        importnceelement.selectImportance(loogername);
    }
}
