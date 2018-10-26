package functional.dayplantest;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import functional.login.LoginTst;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.actionspage.AddactionOverviewElement;
import pages.dashboardpage.DashboardPagElement;
import pages.dayplanpage.DyplnMveActionElement;
import pages.personaltaskpage.OvrViewAddPesnalTaskElement;
import utilities.NewExtendReport;

import java.io.IOException;
import static utilities.NewExtendReport.*;
import static utilities.Reportsextend.test;

import static functional.login.LoginTst.driver;

public class DayPlanAddactionTest
{
    public static DyplnMveActionElement dayplanelements = new DyplnMveActionElement(driver);
    public  static AddactionOverviewElement overviewelement = new AddactionOverviewElement(driver);
    public static DashboardPagElement dashboardpage = new DashboardPagElement(driver);
    OvrViewAddPesnalTaskElement addpersonaltaskelement = new OvrViewAddPesnalTaskElement(driver);

    NewExtendReport addpersonaltask =  new NewExtendReport();

    @BeforeTest
    public void loginTest() throws InterruptedException
    {

        addpersonaltask.newReport("Day Plan Add Action Test","Day_Plan_Add_Action_Report");
        logger =  extent.createTest("Login Test ");
        LoginTst logintest = new LoginTst();
        logintest.loginTestNew();
        logger.log(Status.PASS, MarkupHelper.createLabel("User login  successfully", ExtentColor.GREEN));
        logger.log(Status.PASS, MarkupHelper.createLabel("Company select successfully", ExtentColor.GREEN));
        extent.flush();
    }
    @Test(priority = 1)
    public void linkDayplan() throws InterruptedException
    {
        logger4 =  extent.createTest("Open Day plan module test");
           //dashboard page element object created

        dashboardpage.lnkDayPlan();

        logger4.log(Status.PASS,MarkupHelper.createLabel("Successfully click on Day plan Module",ExtentColor.GREEN));

        Thread.sleep(900);

        dayplanelements.clickMyAction();

        logger4.log(Status.PASS,MarkupHelper.createLabel("Successfully disable the My action filter option",ExtentColor.GREEN));

        extent.flush();
    }

    public void addActionForm(ExtentTest logg, String importances) throws InterruptedException
    {

        dayplanelements.enterActiontitle();

        logg.log(Status.PASS,MarkupHelper.createLabel("Successfully enter the Action title in "+importances+" section",ExtentColor.GREEN));

        addpersonaltaskelement.selectTodayDate();

        logg.log(Status.PASS,MarkupHelper.createLabel("Successfully select due date in "+importances+" section",ExtentColor.GREEN));

        Thread.sleep(100);

        dayplanelements.selectProjectOvervw();

        logg.log(Status.PASS,MarkupHelper.createLabel("Successfully select the project  in "+importances+" section",ExtentColor.GREEN));

        Thread.sleep(400);

        overviewelement.selectActionAssigneeOvervw();

        logg.log(Status.PASS,MarkupHelper.createLabel("Successfully select the Assignee  in "+importances+" section",ExtentColor.GREEN));

        Thread.sleep(400);

        overviewelement.btnSave();

        logg.log(Status.PASS,MarkupHelper.createLabel("Successfully click on save button",ExtentColor.GREEN));
    }

    @Test(priority = 2)
    public void addActionCritcalDue() throws InterruptedException

    {
        String importance = "Critical";

        NewExtendReport.logger1 =  extent.createTest("Add New Action into Critical Due actions section");

        int befrecritclcount = dayplanelements.getCriticalCount();   //critical action count before moving
        logger1.log(Status.PASS, MarkupHelper.createLabel("Before adding Action into Critical due action, count ="+befrecritclcount, ExtentColor.BROWN));

        Thread.sleep(800);

             dayplanelements.dueAtionAddCritcal();

             logger1.log(Status.PASS,MarkupHelper.createLabel("Successfully Click on Add Critical Action in due action section",ExtentColor.GREEN));

             Thread.sleep(500);

             DayPlanAddactionTest teestaddform = new DayPlanAddactionTest();

             teestaddform.addActionForm(logger1,importance);
             //addActionForm(logger1);

             Thread.sleep(700);

             overviewelement.btnClosedPopup();

             logger1.log(Status.PASS,MarkupHelper.createLabel("Successfully closed critical section pop up",ExtentColor.GREEN));

             int aftercritclcount = dayplanelements.getCriticalCount();     //critical action count after moving
             logger1.log(Status.PASS, MarkupHelper.createLabel("After Added Action into Critical due action, count ="+aftercritclcount, ExtentColor.BROWN));

             extent.flush();

        }

        @Test(priority = 3,enabled = true)
        public void addActionImprtntDue() throws InterruptedException
        {
            String importance = "Important";

            NewExtendReport.logger2 =  extent.createTest("Add New Action into Important Due actions section");

            int befreimpotntcount = dayplanelements.getImportntCount();   //important action count before moving
            logger2.log(Status.PASS, MarkupHelper.createLabel("Before moving Action, Important due action count ="+befreimpotntcount, ExtentColor.BROWN));

            Thread.sleep(800);


            dayplanelements.dueAtionAddImprnt();

            logger2.log(Status.PASS,MarkupHelper.createLabel("Successfully Click on Add Important Action in due action section",ExtentColor.GREEN));

            Thread.sleep(500);

            DayPlanAddactionTest teestaddform = new DayPlanAddactionTest();

            teestaddform.addActionForm(logger2,importance);

            Thread.sleep(700);

            overviewelement.btnClosedPopup();

            logger2.log(Status.PASS,MarkupHelper.createLabel("Successfully closed Important section pop up",ExtentColor.GREEN));

            int afterimpotntcount = dayplanelements.getImportntCount();   //important action count after moving

            logger2.log(Status.PASS, MarkupHelper.createLabel("After moving Action, Important due action count ="+afterimpotntcount, ExtentColor.BROWN));

            extent.flush();
        }

    @Test(priority = 4,enabled = true)
    public void addActionLessImprtntDue() throws InterruptedException
         {
             String importance = "Less Important";

             logger3 =  extent.createTest("Add New Action into Less Important  Due actions section");

             int befrelessimpotntcount = dayplanelements.getLessImportntCount();     //less important action count before moving

             logger3.log(Status.PASS, MarkupHelper.createLabel("Before moving Action, Less Important due action count ="+befrelessimpotntcount, ExtentColor.BROWN));

             Thread.sleep(800);

             dayplanelements.dueAtionAddLessImprtnt();

             logger3.log(Status.PASS,MarkupHelper.createLabel("Successfully Click on Add Less important Action in due action section",ExtentColor.GREEN));

             Thread.sleep(500);

             addActionForm(logger3,importance);

             Thread.sleep(700);

             overviewelement.btnClosedPopup();

             logger3.log(Status.PASS,MarkupHelper.createLabel("Successfully closed Less important section pop up",ExtentColor.GREEN));

             int afterlessimpotntcount = dayplanelements.getLessImportntCount();       //less important action count after moving

             logger3.log(Status.PASS, MarkupHelper.createLabel("After moving Action, Less Important due action count ="+afterlessimpotntcount, ExtentColor.BROWN));

             extent.flush();
         }

         @AfterTest
    public void afterTest()
         {

         }
}

