package functional.dayplantest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.relevantcodes.extentreports.LogStatus;
import functional.landingpagetest.SelectCompanyTest;
import functional.login.LoginTest;
import functional.login.TestcaseLogin;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.actionspage.AddactionOverviewElement;
import pages.dashboardpage.DashboardPagElement;
import pages.dayplanpage.DyplnMveActionElement;
import utilities.NewExtendReport;
import utilities.Reportsextend;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


import static functional.departmenttest.AddDepartmentTest.extend;
import static functional.login.TestcaseLogin.driver;
import static utilities.NewExtendReport.extent;
import static utilities.Reportsextend.test;

public class DayplanMveActionTest
{
    DyplnMveActionElement dayplanelements = new DyplnMveActionElement(driver);
    ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;
    public static ExtentTest logger1;
    public static ExtentTest logger2;
    public static ExtentTest logger3;

    @BeforeTest
    public void dayPlanMovectionTest() throws IOException, InterruptedException
    {

        htmlReporter = new ExtentHtmlReporter("C:\\Users\\Admin\\IdeaProjects\\Project\\Extent-Reports/Dayplanextentreport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "Tamplo.com");
        extent.setSystemInfo("Environment", "Automation Testing");
        extent.setSystemInfo("Test By", "Nitin Tajane");
        htmlReporter.config().setDocumentTitle("Tamplo automation script");
        htmlReporter.config().setReportName("tamplo test");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
        logger = extent.createTest("Login test");


        //extend.reports("Day Plan Automation test Report");
        //extend.reports("Day Plan  Action count report Before move and after move");


        TestcaseLogin logintest = new TestcaseLogin();    //login test object created

        logintest.validlogintest();
         logger.log(Status.PASS, MarkupHelper.createLabel("User Login successfully", ExtentColor.GREEN));

        SelectCompanyTest selectcompy = new SelectCompanyTest();    // //select company object created

        selectcompy.selectcompanuydropdown();
         logger.log(Status.PASS, MarkupHelper.createLabel("Company select successfully", ExtentColor.GREEN));


        DashboardPagElement dashboardpage = new DashboardPagElement(driver);      //dashboard page element object created
        Thread.sleep(500);
        dashboardpage.lnkDayPlan();
         logger.log(Status.PASS, MarkupHelper.createLabel("Successefully click on day plan link", ExtentColor.GREEN));

        extent.flush();


    }


    public void moveAction(ExtentTest logg) throws InterruptedException
    {

        Thread.sleep(500);
        dayplanelements.clickMyAction();
        logg.log(Status.PASS, MarkupHelper.createLabel("Disable the my action filter", ExtentColor.GREEN));

        Thread.sleep(900);

//critical section

        int befrecritclcount = dayplanelements.dueActionCountImportnt(1,11);   //critical action count before moving
        logg.log(Status.PASS, MarkupHelper.createLabel("Before moving Action, Critical due action count ="+befrecritclcount, ExtentColor.GREEN));

       try {
           int befredayplancri = dayplanelements.dayPlanActionCount(1, 11);
           logg.log(Status.PASS, MarkupHelper.createLabel("Before moving Action into day plan, Critical Day Plan count ="+befredayplancri, ExtentColor.GREEN));

       }catch (Exception  e)
       {
           logg.log(Status.FAIL, MarkupHelper.createLabel("Before moving Action into day plan, Critical Day Plan count not present", ExtentColor.RED));
           System.out.println("fail");
       }

        Thread.sleep(900);
        dayplanelements.moveCricalAction();
          logg.log(Status.PASS, MarkupHelper.createLabel("Successfully  move the critical action", ExtentColor.GREEN));

        Thread.sleep(700);

        int aftercritclcount = dayplanelements.dueActionCountImportnt(1,11);     //critical action count after moving
        logg.log(Status.PASS, MarkupHelper.createLabel("After moving Action, Critical due action count ="+aftercritclcount, ExtentColor.GREEN));

        int afterdayplancri = dayplanelements.dayPlanActionCount(1,11);
        logg.log(Status.PASS, MarkupHelper.createLabel("After moving Action into day plan, Critical Day Plan count ="+afterdayplancri, ExtentColor.GREEN));


        if(befrecritclcount!=aftercritclcount)
        {
            logg.log(Status.PASS, MarkupHelper.createLabel("Critical Action move successfully and count update", ExtentColor.GREEN));
            System.out.println("Critical Action move successfully and count update ");
        }else
            {
                logg.log(Status.FAIL, MarkupHelper.createLabel("Action moved but count not update ", ExtentColor.BLUE));
                System.out.println("Action moved but count not update ");
             }



//important section

        Thread.sleep(1000);

        int befreimpotntcount = dayplanelements.dueActionCountImportnt(2,12);   //important action count before moving
        logg.log(Status.PASS, MarkupHelper.createLabel("Before moving Action, Important due action count ="+befreimpotntcount, ExtentColor.GREEN));

       try
       {
        int befredayplanimpotnt = dayplanelements.dayPlanActionCount(2,12);
           logg.log(Status.PASS, MarkupHelper.createLabel("Before moving Action into day plan, Important Day Plan count ="+befredayplanimpotnt, ExtentColor.GREEN));

          }catch (Exception  e)
       {
           logg.log(Status.FAIL, MarkupHelper.createLabel("Before moving Action into day plan, Important Day Plan count not found", ExtentColor.BLUE));
           System.out.println("fail"); }
        Thread.sleep(500);

        dayplanelements.moveImportntAction();
        logg.log(Status.PASS, MarkupHelper.createLabel("Successfully Move important action into day plan", ExtentColor.GREEN));


        Thread.sleep(700);

        int afterimpotntcount = dayplanelements.dueActionCountImportnt(2,12);   //important action count after moving
        logg.log(Status.PASS, MarkupHelper.createLabel("After moving Action, Important due action count ="+afterimpotntcount, ExtentColor.GREEN));
        //test.log(LogStatus.INFO,"After moving Action, Important due action count ="+afterimpotntcount);

        int afterdayplanimpotnt = dayplanelements.dayPlanActionCount(2,12);
        //extend.test.log(LogStatus.INFO,"After moving Action into day plan, Important Day Plan count ="+afterdayplanimpotnt);
        logg.log(Status.PASS, MarkupHelper.createLabel("After moving Action into day plan, Important Day Plan count ="+afterdayplanimpotnt, ExtentColor.GREEN));

        if(befreimpotntcount!=afterimpotntcount)
        {
           // test.log(LogStatus.INFO,"Important Action move successfully and count update ");
            logg.log(Status.PASS, MarkupHelper.createLabel("Important Action move successfully and count update ", ExtentColor.GREEN));
            System.out.println("Important Action move successfully and count update ");
        }else
        {
            //test.log(LogStatus.INFO,"Action moved but count not update");
            logg.log(Status.FAIL, MarkupHelper.createLabel("Action moved but count not update", ExtentColor.BLUE));
            System.out.println(" ");
        }



//Less important section

        Thread.sleep(1000);

        int befrelessimpotntcount = dayplanelements.dueActionCountImportnt(3,17);      //less important action count before moving
        logg.log(Status.PASS, MarkupHelper.createLabel("Before moving Action, Less Important due action count ="+befrelessimpotntcount, ExtentColor.GREEN));
        //test.log(LogStatus.INFO,"Before moving Action, Less Important due action count ="+befrelessimpotntcount);

        try
        {
           int befredayplanlessimpotnt = dayplanelements.dayPlanActionCount(3,17);
            logg.log(Status.PASS, MarkupHelper.createLabel("Before moving Action into day plan, Less Important Day Plan count ="+befredayplanlessimpotnt, ExtentColor.GREEN));
            //extend.test.log(LogStatus.INFO,"Before moving Action into day plan, Less Important Day Plan count ="+befredayplanlessimpotnt);
               }catch (Exception  e){
            logg.log(Status.FAIL, MarkupHelper.createLabel("Before moving Action into day plan, Less Important Day Plan count not found", ExtentColor.BLUE));
               System.out.println("fail");

                 }
        Thread.sleep(500);

        dayplanelements.moveLessImportntAction();
        logg.log(Status.PASS, MarkupHelper.createLabel("Successfully Move less Important action into day plan", ExtentColor.GREEN));
        //test.log(LogStatus.INFO,"Successfully Move less Important action into day plan");

        Thread.sleep(700);
        int afterlessimpotntcount = dayplanelements.dueActionCountImportnt(3,17);      //less important action count after moving
        logg.log(Status.PASS, MarkupHelper.createLabel("After moving Action, Less Important due action count ="+afterlessimpotntcount, ExtentColor.GREEN));
        //test.log(LogStatus.INFO,"After moving Action, Less Important due action count ="+afterlessimpotntcount);

        int afterdayplanlessimpotnt = dayplanelements.dayPlanActionCount(3,17);
        logg.log(Status.PASS, MarkupHelper.createLabel("After moving Action into day plan, Important Day Plan count ="+afterdayplanlessimpotnt, ExtentColor.GREEN));
        //extend.test.log(LogStatus.INFO,"After moving Action into day plan, Important Day Plan count ="+afterdayplanlessimpotnt);

        if(befrelessimpotntcount!=afterlessimpotntcount)
        {
            //test.log(LogStatus.INFO,"Less Important Action move successfully and count update ");
            logg.log(Status.PASS, MarkupHelper.createLabel("Less Important Action move successfully and count update", ExtentColor.GREEN));
            System.out.println("Important Action move successfully and count update ");
        }else
        {
            //test.log(LogStatus.INFO,"Action moved but count not update");
            logg.log(Status.FAIL, MarkupHelper.createLabel("Action moved but count not update =", ExtentColor.BLUE));
            System.out.println("Action moved but count not update ");
        }

        extent.flush();
    }

    @Test(priority = 1)
    public void moveActionintoTodaydate() throws InterruptedException
    {
        logger1 = extent.createTest("Action move into todays day plan");
        //extend.reports("Moving Actions into today Day Plan");
        //test.log(LogStatus.INFO,"Move Actions into Today Day Plan");
        logger1.log(Status.PASS, MarkupHelper.createLabel("Move Actions into Today Day Plan", ExtentColor.BLACK));

        DayplanMveActionTest moveactiontest = new DayplanMveActionTest();

        moveactiontest.moveAction(logger1);
        extent.flush();


    }


    @Test(priority = 2)
    public void moveActionNextdate() throws InterruptedException
    {
        //extend.reports("Moving Actions into Next Month Day Plan");

        logger2 = extent.createTest("Action move into next date day plan");
        dayplanelements.dayPlanSelectNextDate();

        logger2.log(Status.PASS, MarkupHelper.createLabel("* Successfully Select Next Month date *", ExtentColor.BLACK));
       // test.log(LogStatus.INFO,"* Successfully Select Next Month date *");

        DayplanMveActionTest moveactiontest = new DayplanMveActionTest();

        moveactiontest.moveAction(logger2);
        extent.flush();




    }
    @Test(priority = 3)
    public void moveActionPastDate() throws InterruptedException

    {
        logger3 = extent.createTest("Action move into previous date day plan");
        //extend.reports("Moving Actions into Previous Month Day Plan");

        dayplanelements.dayPlanSelectpastDate();

        logger3.log(Status.PASS, MarkupHelper.createLabel("* Successfully Select previous Month date * *", ExtentColor.BLACK));
        //test.log(LogStatus.INFO,"  * Successfully Select previous Month date * ");

        DayplanMveActionTest moveactiontest = new DayplanMveActionTest();

        moveactiontest.moveAction(logger3);
        extent.flush();

    }

    @AfterTest
    public void testend()
    {
        //test.log(LogStatus.INFO,"Action successfully move into Day plan");
        //logger.log(Status.PASS, MarkupHelper.createLabel("Action successfully move into Day plan", ExtentColor.BLACK));
        //Reportsextend.extend.endTest(extend.test);
       // Reportsextend.extend.flush();
        //extent.flush();

    }
}
