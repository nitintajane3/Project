package functional.actionstest;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import functional.login.LoginTst;
import functional.personaltasktest.OvrViewAddPesnalTaskTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.actionspage.AddactionOverviewElement;
import pages.actionspage.AddactionProjectElement;
import pages.dayplanpage.DyplnMveActionElement;
import pages.personaltaskpage.OvrViewAddPesnalTaskElement;
import utilities.NewExtendReport;

import static functional.dayplantest.DayPlanAddactionTest.dashboardpage;
import static functional.login.LoginTst.driver;
import static utilities.NewExtendReport.*;

public class AddactionOverviewTest
{
    NewExtendReport addpersonaltask =  new NewExtendReport();
    AddactionProjectElement actionelment = new AddactionProjectElement(driver);
    OvrViewAddPesnalTaskElement overviewpersonalTask = new OvrViewAddPesnalTaskElement(driver);
    AddactionOverviewElement addactionoverviewlelement = new AddactionOverviewElement(driver);
    OvrViewAddPesnalTaskTest overviewAddPersonaltasktest = new OvrViewAddPesnalTaskTest();
    DyplnMveActionElement dayplanelements = new DyplnMveActionElement(LoginTst.driver);


    @BeforeTest
    public void loginTest() throws InterruptedException
    {
        addpersonaltask.newReport("Add action into action list view","Action_Add_Action_into_listview_Report");
        logger =  extent.createTest("Login Test ");
        LoginTst logintest = new LoginTst();
        logintest.loginTestNew();
        logger.log(Status.PASS, MarkupHelper.createLabel("User login  successfully", ExtentColor.GREEN));
        logger.log(Status.PASS, MarkupHelper.createLabel("Company select successfully", ExtentColor.GREEN));
        extent.flush();
    }
    @Test(priority = 1)
    public void linkActionPage() throws InterruptedException
    {
        logger1 =  extent.createTest("Open the Action page ");

        dashboardpage.lnkaction();

        logger1.log(Status.PASS,MarkupHelper.createLabel("Successfully click on action Module",ExtentColor.GREEN));

        dayplanelements.clickMyAction();

        extent.flush();
    }

    @Test(priority = 2)
    public void addActionCriticalOvrVew() throws InterruptedException
    {
        logger2 =  extent.createTest("Add action into critical overview section");

        Thread.sleep(1000);

        overviewAddPersonaltasktest.countCriticalSections(logger2);

        overviewpersonalTask.addBtnCriticalThisWeek();

        logger2.log(Status.PASS,MarkupHelper.createLabel("Click on Add button ",ExtentColor.GREEN));

        addActionDetails(logger2);

        Thread.sleep(500);

        addactionoverviewlelement.btnClosedPopup();

        logger2.log(Status.PASS,MarkupHelper.createLabel("Successfully closed the pop up",ExtentColor.GREEN));

        overviewAddPersonaltasktest.countCriticalSections(logger2);

        extent.flush();

    }

    @Test(priority = 3)
    public void addActionImportntOvrVew() throws InterruptedException
    {
        logger3 =  extent.createTest("Add action into important overview section");

        Thread.sleep(1000);

        overviewAddPersonaltasktest.countImportantSections(logger3);

        overviewpersonalTask.addBtnImportantThisMonth();

        logger3.log(Status.PASS,MarkupHelper.createLabel("Click on Add button ",ExtentColor.GREEN));

        addActionDetails(logger3);

        Thread.sleep(500);

        addactionoverviewlelement.btnClosedPopup();

        logger3.log(Status.PASS,MarkupHelper.createLabel("Successfully closed the pop up",ExtentColor.GREEN));

        overviewAddPersonaltasktest.countImportantSections(logger3);

        extent.flush();

    }

    @Test(priority = 4)
    public void addActionLessImportntOvrVew() throws InterruptedException
    {
        logger4 =  extent.createTest("Add action into less important overview section");

        Thread.sleep(1000);

        overviewAddPersonaltasktest.countLessImportantSections(logger4);

        overviewpersonalTask.addBtnLesImportantNextMonth();

        logger4.log(Status.PASS,MarkupHelper.createLabel("Click on Add button ",ExtentColor.GREEN));

        addActionDetails(logger4);

        Thread.sleep(500);

        addactionoverviewlelement.btnClosedPopup();

        logger4.log(Status.PASS,MarkupHelper.createLabel("Successfully closed the pop up",ExtentColor.GREEN));

        overviewAddPersonaltasktest.countLessImportantSections(logger4);

        extent.flush();

    }

    public void addActionDetails(ExtentTest loggername) throws InterruptedException
    {
        Thread.sleep(1000);

        actionelment.enterActiontitle();

        loggername.log(Status.PASS,MarkupHelper.createLabel("Successfully enter the action title",ExtentColor.GREEN));

        overviewpersonalTask.selectTodayDate();

        loggername.log(Status.PASS,MarkupHelper.createLabel("Successfully select the due date",ExtentColor.GREEN));

        Thread.sleep(500);

        addactionoverviewlelement.selectproject(); // this element require to create beacause this is diffrent from other element

        loggername.log(Status.PASS,MarkupHelper.createLabel("Successfully select the project",ExtentColor.GREEN));

        Thread.sleep(500);

        addactionoverviewlelement.selectActionAssigneeName();

        loggername.log(Status.PASS,MarkupHelper.createLabel("Successfully select the assignee",ExtentColor.GREEN));

        actionelment.clicksaveaction();

        loggername.log(Status.PASS,MarkupHelper.createLabel("Successfully add the action",ExtentColor.GREEN));
    }
}
