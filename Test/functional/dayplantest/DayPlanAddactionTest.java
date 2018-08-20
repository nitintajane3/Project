package functional.dayplantest;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.relevantcodes.extentreports.LogStatus;
import functional.landingpagetest.SelectCompanyTest;
import functional.login.TestcaseLogin;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.actionspage.AddactionOverviewElement;
import pages.dashboardpage.DashboardPagElement;
import pages.dayplanpage.DyplnMveActionElement;
import utilities.NewExtendReport;

import java.io.IOException;

import static functional.departmenttest.AddDepartmentTest.extend;
import static utilities.NewExtendReport.*;
import static utilities.Reportsextend.test;

import static functional.login.TestcaseLogin.driver;

public class DayPlanAddactionTest
{
    TestcaseLogin logintest = new TestcaseLogin();
    public static DyplnMveActionElement dayplanelements = new DyplnMveActionElement(driver);
    public  static AddactionOverviewElement overviewelement = new AddactionOverviewElement(driver);
    public static NewExtendReport reports = new NewExtendReport();
    public static DashboardPagElement dashboardpage = new DashboardPagElement(driver);


    @BeforeTest
    public void loginTest() throws InterruptedException, IOException
    {
        reports.newReport("Day Plan Add Action Test","Day_Plan_Add_Action_Report");

        NewExtendReport.logger =  extent.createTest("Login Test");

        TestcaseLogin logintest = new TestcaseLogin();    //login test object created

        logintest.validlogintest();

        Thread.sleep(300);

        logger.log(Status.PASS,MarkupHelper.createLabel("User login Successfully",ExtentColor.GREEN));

        SelectCompanyTest selectcompy = new SelectCompanyTest();    // //select company object created

        selectcompy.selectcompanuydropdown();

        logger.log(Status.PASS,MarkupHelper.createLabel("Company select successfully",ExtentColor.GREEN));

        Thread.sleep(900);

        dashboardpage.lnkDayPlan();

        logger.log(Status.PASS,MarkupHelper.createLabel("Successfully click on Day plan Module",ExtentColor.GREEN));

        Thread.sleep(900);

        dayplanelements.clickMyAction();

        logger.log(Status.PASS,MarkupHelper.createLabel("Successfully disable the My action filter option",ExtentColor.GREEN));


        extent.flush();
    }

    public void addActionForm(ExtentTest logg, String importances) throws InterruptedException
    {

        dayplanelements.enterActiontitle();

        logg.log(Status.PASS,MarkupHelper.createLabel("Successfully enter the Action title in "+importances+" section",ExtentColor.GREEN));

        dayplanelements.selectduedate();

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

    @Test(priority = 1)
    public void addActionCritcalDue() throws InterruptedException

    {
        String importance = "Critical";

        NewExtendReport.logger1 =  extent.createTest("Add New Action into Critical Due actions section");

        int befrecritclcount = dayplanelements.dueActionCountImportnt(1,11);   //critical action count before moving
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

             int aftercritclcount = dayplanelements.dueActionCountImportnt(1,11);     //critical action count after moving
             logger1.log(Status.PASS, MarkupHelper.createLabel("After Added Action into Critical due action, count ="+aftercritclcount, ExtentColor.BROWN));

             extent.flush();

        }

        @Test(priority = 2)
        public void addActionImprtntDue() throws InterruptedException
        {
            String importance = "Important";

            NewExtendReport.logger2 =  extent.createTest("Add New Action into Important Due actions section");

            int befreimpotntcount = dayplanelements.dueActionCountImportnt(2,12);   //important action count before moving
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

            int afterimpotntcount = dayplanelements.dueActionCountImportnt(2,12);   //important action count after moving
            logger2.log(Status.PASS, MarkupHelper.createLabel("After moving Action, Important due action count ="+afterimpotntcount, ExtentColor.BROWN));

            extent.flush();
        }

    @Test(priority = 3)
    public void addActionLessImprtntDue() throws InterruptedException
         {
             String importance = "Less Important";

             logger3 =  extent.createTest("Add New Action into Less Important  Due actions section");

             int befrelessimpotntcount = dayplanelements.dueActionCountImportnt(3,17);      //less important action count before moving
             logger3.log(Status.PASS, MarkupHelper.createLabel("Before moving Action, Less Important due action count ="+befrelessimpotntcount, ExtentColor.BROWN));

             Thread.sleep(800);

             dayplanelements.dueAtionAddLessImprtnt();

             logger3.log(Status.PASS,MarkupHelper.createLabel("Successfully Click on Add Less important Action in due action section",ExtentColor.GREEN));

             Thread.sleep(500);
             DayPlanAddactionTest teestaddform = new DayPlanAddactionTest();

             teestaddform.addActionForm(logger3,importance);

             Thread.sleep(700);

             overviewelement.btnClosedPopup();

             logger3.log(Status.PASS,MarkupHelper.createLabel("Successfully closed Less important section pop up",ExtentColor.GREEN));

             int afterlessimpotntcount = dayplanelements.dueActionCountImportnt(3,17);      //less important action count after moving
             logger3.log(Status.PASS, MarkupHelper.createLabel("After moving Action, Less Important due action count ="+afterlessimpotntcount, ExtentColor.BROWN));

             extent.flush();
         }

         @AfterTest
    public void afterTest()
         {

         }
}

