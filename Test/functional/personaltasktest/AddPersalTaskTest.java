package functional.personaltasktest;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import functional.login.LoginTst;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.actionspage.AddactionProjectElement;
import pages.dashboardpage.DashboardPagElement;
import pages.personaltaskpage.AddPersonalTkElement;
import utilities.NewExtendReport;
import static functional.login.LoginTst.driver;
import utilities.Reportsextend;
import static utilities.NewExtendReport.extent;
import static utilities.NewExtendReport.logger;
import static utilities.NewExtendReport.logger1;
import static utilities.NewExtendReport.logger2;
import static utilities.NewExtendReport.logger3;
import static utilities.NewExtendReport.logger4;

public class AddPersalTaskTest
{

    NewExtendReport addpersonaltask =  new NewExtendReport();
    AddactionProjectElement prsnaltskelemnt = new AddactionProjectElement(driver);
    AddPersonalTkElement addpersnaltaskelemet = new AddPersonalTkElement(driver);
    @BeforeTest
    public void loginTest() throws InterruptedException
    {

        addpersonaltask.newReport("Add personal task test","Add_personal_Task_test_report");
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
    public void addCritclPesonalTsk() throws InterruptedException
    {

        String taskcategiry = "Critical";

        logger2 = extent.createTest("Add critical personal task");

        int befrecrircalPersonalcount = addpersnaltaskelemet.getCriticalCount();

        logger2.log(Status.PASS,MarkupHelper.createLabel("before adding Critical personal task count is = " + befrecrircalPersonalcount,ExtentColor.GREEN));

        prsnaltskelemnt.btnaddcriticalaction();

        logger2.log(Status.PASS, MarkupHelper.createLabel("Open the critcal personal task form", ExtentColor.GREEN));

        Thread.sleep(100);

        addActionDetails(logger2,taskcategiry);

        Thread.sleep(500);

        int aftrcrircalPersonalcount = addpersnaltaskelemet.getCriticalCount();

        logger2.log(Status.PASS,MarkupHelper.createLabel("after adding Critical personal task count is = " + aftrcrircalPersonalcount,ExtentColor.GREEN));

        extent.flush();
    }


    @Test(priority = 3,enabled = true)
    public void addImprtntPersnalTsk() throws InterruptedException {
        String taskcategiry = "Important";
        logger3 = extent.createTest("Add Important personal task");

        int befreimportnatPersonalcount = addpersnaltaskelemet.getImportntCount();

        logger3.log(Status.PASS,MarkupHelper.createLabel("before adding important personal task count is = " + befreimportnatPersonalcount,ExtentColor.GREEN));

        prsnaltskelemnt.btnaddimportntaction();

        logger3.log(Status.PASS, MarkupHelper.createLabel("Open the important personal task form", ExtentColor.GREEN));

        addActionDetails(logger3,taskcategiry);

        Thread.sleep(500);

        int aftrimportnatPersonalcount = addpersnaltaskelemet.getImportntCount();

        logger3.log(Status.PASS,MarkupHelper.createLabel("after adding important personal task count is = " + aftrimportnatPersonalcount,ExtentColor.GREEN));

        extent.flush();

    }


       @Test(priority = 4,enabled = true)
       public void addLessImprtntPersnlTask() throws InterruptedException
       {
           String taskcategiry = "Less Important";
           logger4 = extent.createTest("Add Less important personal task");

           int befrelessimportnatPersonalcount = addpersnaltaskelemet.getLessImportntCount();

           logger4.log(Status.PASS,MarkupHelper.createLabel("before adding less important personal task count is = " + befrelessimportnatPersonalcount,ExtentColor.GREEN));

           prsnaltskelemnt.btnaddlessimportantaction();

           logger4.log(Status.PASS, MarkupHelper.createLabel("Open the Less important personal task form", ExtentColor.GREEN));

           addActionDetails(logger4,taskcategiry);

           Thread.sleep(500);

           int afterlessimportnatPersonalcount = addpersnaltaskelemet.getLessImportntCount();

           logger4.log(Status.PASS,MarkupHelper.createLabel("after adding less important personal task count is = " + afterlessimportnatPersonalcount,ExtentColor.GREEN));

           extent.flush();
       }



    public void addActionDetails(ExtentTest loggervrible,String variblename) throws InterruptedException
    {
        prsnaltskelemnt.enterActiontitle();

        loggervrible.log(Status.PASS,MarkupHelper.createLabel("Entered  action title ",ExtentColor.GREEN));

        prsnaltskelemnt.clickduedate();

        loggervrible.log(Status.PASS,MarkupHelper.createLabel("Due date select successfully",ExtentColor.GREEN));

        prsnaltskelemnt.clicksaveaction();

        loggervrible.log(Status.PASS,MarkupHelper.createLabel("Click on save button",ExtentColor.GREEN));

        loggervrible.log(Status.PASS,MarkupHelper.createLabel(" Successfully Add the " + variblename + " personal task",ExtentColor.GREEN));
    }
}
