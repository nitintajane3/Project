package functional.personaltasktest;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import functional.login.LoginTst;
import functional.login.TestcaseLogin;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.actionspage.AddactionOverviewElement;
import pages.dashboardpage.DashboardPagElement;
import pages.dayplanpage.DyplnMveActionElement;
import pages.personaltaskpage.ChangeDueDatePersonalTaskElement;
import pages.personaltaskpage.OvrViewAddPesnalTaskElement;
import utilities.NewExtendReport;

import static functional.login.LoginTst.driver;
import static utilities.NewExtendReport.extent;
import static utilities.NewExtendReport.logger;
import static utilities.NewExtendReport.logger1;

public class ChangeDueDatePersonalTaskTest
{
    NewExtendReport addpersonaltask =  new NewExtendReport();
    OvrViewAddPesnalTaskElement overviewaddtaskelement = new OvrViewAddPesnalTaskElement(driver);
    ChangeDueDatePersonalTaskElement changeduedateelement = new ChangeDueDatePersonalTaskElement(driver);
    @BeforeTest
    public void loginTest() throws InterruptedException
    {

        addpersonaltask.newReport("Add personal task from overview test","add_personal_Task_from_oveview_test_report");
        logger =  extent.createTest("Login Test ");
        LoginTst logintest = new LoginTst();
        logintest.loginTestNew();
        logger.log(Status.PASS, MarkupHelper.createLabel("User login  successfully", ExtentColor.GREEN));
        logger.log(Status.PASS, MarkupHelper.createLabel("Company select successfully", ExtentColor.GREEN));
        extent.flush();
    }
    @Test(priority = 1)
    public void linkPersonalTask() throws InterruptedException {
        logger1 =  extent.createTest("Open personal task  module test");
        DashboardPagElement dashboardpage = new DashboardPagElement(driver);      //dashboard page element object created

        dashboardpage.linkPersonalTask();

        logger1.log(Status.PASS, MarkupHelper.createLabel("Successfully link to personal task", ExtentColor.GREEN));

        changeduedateelement.editBtnCriticaltest();

        extent.flush();
    }
}
