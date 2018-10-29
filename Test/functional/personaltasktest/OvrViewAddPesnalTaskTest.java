package functional.personaltasktest;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import functional.login.LoginTst;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.dashboardpage.DashboardPagElement;
import pages.personaltaskpage.OvrViewAddPesnalTaskElement;
import utilities.NewExtendReport;

import static functional.login.LoginTst.driver;
import static utilities.NewExtendReport.*;

public class OvrViewAddPesnalTaskTest
{

    NewExtendReport addpersonaltask =  new NewExtendReport();
    static OvrViewAddPesnalTaskElement overviewaddtaskelement = new OvrViewAddPesnalTaskElement(driver);
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
    public void linkPersonalTask()
    {
        logger1 =  extent.createTest("Open personal task  module test");
        DashboardPagElement dashboardpage = new DashboardPagElement(driver);      //dashboard page element object created

        dashboardpage.linkPersonalTask();

        logger1.log(Status.PASS, MarkupHelper.createLabel("Successfully link to personal task", ExtentColor.GREEN));

        overviewaddtaskelement.clkOverView();

        extent.flush();
    }

    @Test(priority = 2)
    public void addTaskIntoOverView() throws InterruptedException

    {
        logger2 =  extent.createTest("Add task into critical next month");

        /*countLessImportantSections(logger2);

        addTaskLessImportntThisMonth(logger2);

        countLessImportantSections(logger2);*/

        Thread.sleep(1000);

        countCriticalSections(logger2);

        addTaskCriticalNextMonth(logger2);

        countCriticalSections(logger2);

        Thread.sleep(1000);

        /*countImportantSections(logger2);

        addTaskImportntNextMonth(logger2);

        countImportantSections(logger2);*/

        extent.flush();
    }



    public void addTaskCriticalThisWeek(ExtentTest criticalthisweek) throws InterruptedException
    {


        overviewaddtaskelement.addBtnCriticalThisWeek();

        criticalthisweek.log(Status.PASS, MarkupHelper.createLabel("Add Task into this week and in critical section", ExtentColor.GREEN));

        overviewaddtaskelement.enterActiontitle();

        criticalthisweek.log(Status.PASS, MarkupHelper.createLabel("Enter the task  title", ExtentColor.GREEN));

        overviewaddtaskelement.selectTodayDate();

        criticalthisweek.log(Status.PASS, MarkupHelper.createLabel("select todays date", ExtentColor.GREEN));

        saveAdClosed(criticalthisweek);

    }

    public void addTaskCriticalThisMonth(ExtentTest criticalthismonth) throws InterruptedException
    {
        overviewaddtaskelement.addBtnCriticalThisMonth();

        criticalthismonth.log(Status.PASS, MarkupHelper.createLabel("Add Task into this month and in critical section", ExtentColor.GREEN));

        overviewaddtaskelement.enterActiontitle();

        criticalthismonth.log(Status.PASS, MarkupHelper.createLabel("Enter the task  title", ExtentColor.GREEN));

        overviewaddtaskelement.selectNextWeekDueDate();

        criticalthismonth.log(Status.PASS, MarkupHelper.createLabel("select this month date", ExtentColor.GREEN));

        saveAdClosed(criticalthismonth);
    }

    public void addTaskCriticalNextMonth(ExtentTest criticalnextmonth) throws InterruptedException
    {
        overviewaddtaskelement.addBtnCriticalNextMonth();

        criticalnextmonth.log(Status.PASS, MarkupHelper.createLabel("Add Task into next month and in critical section", ExtentColor.GREEN));

        overviewaddtaskelement.enterActiontitle();

        criticalnextmonth.log(Status.PASS, MarkupHelper.createLabel("Enter the task  title", ExtentColor.GREEN));

        overviewaddtaskelement.selectNxtMonthCurntDate();

        criticalnextmonth.log(Status.PASS, MarkupHelper.createLabel("select next month date", ExtentColor.GREEN));

        saveAdClosed(criticalnextmonth);
    }

    public void addTaskImportntThisWeek(ExtentTest importntthisweek)throws InterruptedException
    {
        overviewaddtaskelement.addBtnImportantThisWeek();

        importntthisweek.log(Status.PASS, MarkupHelper.createLabel("Add Task into this week and in important section", ExtentColor.GREEN));

        overviewaddtaskelement.enterActiontitle();

        importntthisweek.log(Status.PASS, MarkupHelper.createLabel("Enter the task  title", ExtentColor.GREEN));

        overviewaddtaskelement.selectTodayDate();

        importntthisweek.log(Status.PASS, MarkupHelper.createLabel("select this week date", ExtentColor.GREEN));

        saveAdClosed(importntthisweek);
    }

    public void addTaskImportntThisMonth(ExtentTest importntthismonth)throws InterruptedException
    {

        overviewaddtaskelement.addBtnImportantThisMonth();

        importntthismonth.log(Status.PASS, MarkupHelper.createLabel("Add Task into this month and in important section", ExtentColor.GREEN));

        overviewaddtaskelement.enterActiontitle();

        importntthismonth.log(Status.PASS, MarkupHelper.createLabel("Enter the task  title", ExtentColor.GREEN));

        overviewaddtaskelement.selectNextWeekDueDate();

        importntthismonth.log(Status.PASS, MarkupHelper.createLabel("select this month date", ExtentColor.GREEN));

        saveAdClosed(importntthismonth);
    }

    public void addTaskImportntNextMonth(ExtentTest importntnextmonth)throws InterruptedException
    {

        overviewaddtaskelement.addBtnImportantNextMonth();

        importntnextmonth.log(Status.PASS, MarkupHelper.createLabel("Add Task into next month and in important section", ExtentColor.GREEN));

        overviewaddtaskelement.enterActiontitle();

        importntnextmonth.log(Status.PASS, MarkupHelper.createLabel("Enter the task  title", ExtentColor.GREEN));

        overviewaddtaskelement.selectNxtMonthCurntDate();

        importntnextmonth.log(Status.PASS, MarkupHelper.createLabel("select next month date", ExtentColor.GREEN));

        saveAdClosed(importntnextmonth);
    }

    public void addTaskLessImportntThisWeek(ExtentTest lessimportntthisweek)throws InterruptedException
    {
        overviewaddtaskelement.addBtnLesImportantThisWeek();

        lessimportntthisweek.log(Status.PASS, MarkupHelper.createLabel("Add Task into this week and in less important section", ExtentColor.GREEN));

        overviewaddtaskelement.enterActiontitle();

        lessimportntthisweek.log(Status.PASS, MarkupHelper.createLabel("Enter the task  title", ExtentColor.GREEN));

        overviewaddtaskelement.selectTodayDate();

        lessimportntthisweek.log(Status.PASS, MarkupHelper.createLabel("select todays date", ExtentColor.GREEN));

        saveAdClosed(lessimportntthisweek);
    }

    public void addTaskLessImportntThisMonth(ExtentTest lessimportnthismonth)throws InterruptedException
    {

        overviewaddtaskelement.addBtnLesImportantThisMonth();

        lessimportnthismonth.log(Status.PASS, MarkupHelper.createLabel("Add Task into this month and in less important section", ExtentColor.GREEN));

        overviewaddtaskelement.enterActiontitle();

        lessimportnthismonth.log(Status.PASS, MarkupHelper.createLabel("Enter the task  title", ExtentColor.GREEN));

        overviewaddtaskelement.selectNextWeekDueDate();

        lessimportnthismonth.log(Status.PASS, MarkupHelper.createLabel("select this month date", ExtentColor.GREEN));

        saveAdClosed(lessimportnthismonth);
    }

    public void addTaskLessImportntNextMonth(ExtentTest lessimportntnextmonth)throws InterruptedException
    {
        overviewaddtaskelement.addBtnLesImportantNextMonth();

        lessimportntnextmonth.log(Status.PASS, MarkupHelper.createLabel("Add Task into next month and in less important section", ExtentColor.GREEN));

        overviewaddtaskelement.enterActiontitle();

        lessimportntnextmonth.log(Status.PASS, MarkupHelper.createLabel("Enter the task  title", ExtentColor.GREEN));

        overviewaddtaskelement.selectNxtMonthCurntDate();

        lessimportntnextmonth.log(Status.PASS, MarkupHelper.createLabel("select next month date", ExtentColor.GREEN));

        saveAdClosed(lessimportntnextmonth);
    }

    public void saveAdClosed(ExtentTest loggername)
    {
        overviewaddtaskelement.btnSave();

        loggername.log(Status.PASS, MarkupHelper.createLabel("Personal task  save successfully", ExtentColor.GREEN));

        overviewaddtaskelement.btnClosedPopUp();

        loggername.log(Status.PASS, MarkupHelper.createLabel(" Pop up closed successfully" , ExtentColor.GREEN));
    }

    public static void countCriticalSections(ExtentTest logername) throws InterruptedException

    {
        Thread.sleep(1000);

        int countallcritical = overviewaddtaskelement.getCountAllCritical();

        logername.log(Status.PASS, MarkupHelper.createLabel(" sum of all critical count is = " + countallcritical, ExtentColor.GREEN));

        int countcriticalthisweek = overviewaddtaskelement.getCountCritcalThisWeek();

        logername.log(Status.PASS, MarkupHelper.createLabel("critical this week count is = " + countcriticalthisweek, ExtentColor.GREEN));

        int countcriticalthismonth = overviewaddtaskelement.getCountCritcalThisMonth();

        logername.log(Status.PASS, MarkupHelper.createLabel("critical this month count is = " + countcriticalthismonth, ExtentColor.GREEN));

        int countcriticalnextmonth = overviewaddtaskelement.getCountCritcalNextMonth();

        logername.log(Status.PASS, MarkupHelper.createLabel("critical next month count is = " + countcriticalnextmonth, ExtentColor.GREEN));

    }

    public static void countImportantSections(ExtentTest logername) throws InterruptedException
    {
        Thread.sleep(1000);

        int countallimportant = overviewaddtaskelement.getCountAllImportant();

        logername.log(Status.PASS, MarkupHelper.createLabel(" sum of all Important count is = " + countallimportant, ExtentColor.GREEN));

        int countimportantthisweek = overviewaddtaskelement.getCountImportntThisWeek();

        logername.log(Status.PASS, MarkupHelper.createLabel("Important this week count is = " + countimportantthisweek, ExtentColor.GREEN));

        int countimportantthismonth = overviewaddtaskelement.getCountImportntThisMonth();

        logername.log(Status.PASS, MarkupHelper.createLabel("important this month count is = " + countimportantthismonth, ExtentColor.GREEN));

        int countimportntnextmonth = overviewaddtaskelement.getCountImportntNextMonth();

        logername.log(Status.PASS, MarkupHelper.createLabel("important next month count is = " + countimportntnextmonth, ExtentColor.GREEN));
    }

    public static void countLessImportantSections(ExtentTest logername) throws InterruptedException
    {
        Thread.sleep(1000);

        int countalllessimportant = overviewaddtaskelement.getCountAllessImportant();

        logername.log(Status.PASS, MarkupHelper.createLabel(" sum of all Less Important count is = " + countalllessimportant, ExtentColor.GREEN));

        int countlessimportantthisweek = overviewaddtaskelement.getCountLessImportntThisWeek();

        logername.log(Status.PASS, MarkupHelper.createLabel("Less Important this week count is = " + countlessimportantthisweek, ExtentColor.GREEN));

        int countlessimportantthismonth = overviewaddtaskelement.getCountLessImportntThisMonth();

        logername.log(Status.PASS, MarkupHelper.createLabel("Less important this month count is = " + countlessimportantthismonth, ExtentColor.GREEN));

        int countlessimportntnextmonth = overviewaddtaskelement.getCountLessImportntNextMonth();

        logername.log(Status.PASS, MarkupHelper.createLabel("Less important next month count is = " + countlessimportntnextmonth, ExtentColor.GREEN));

    }

}
