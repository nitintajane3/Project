package functional.dayplantest;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import functional.login.LoginTst;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.dashboardpage.DashboardPagElement;
import pages.dayplanpage.DyplnMveActionElement;
import utilities.NewExtendReport;
import static utilities.NewExtendReport.*;
import static functional.login.LoginTst.driver;

public class DayplanMveActionTest
{
    public static DyplnMveActionElement dayplanelements = new DyplnMveActionElement(LoginTst.driver);
    public static DashboardPagElement dashboardpage = new DashboardPagElement(LoginTst.driver);

    NewExtendReport addpersonaltask =  new NewExtendReport();

    @BeforeTest
    public void loginTest() throws InterruptedException
    {

        addpersonaltask.newReport("Day Plan move Action Test","Day_Plan_move_Action_Report");
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

        Thread.sleep(500);

        dayplanelements.clickMyAction();

        logger4.log(Status.PASS,MarkupHelper.createLabel("Successfully disable the My action filter option",ExtentColor.GREEN));

        extent.flush();
    }




    @Test(priority = 2,enabled = true)
    public void moveActionintoTodaydate() throws InterruptedException
    {
        logger1 = NewExtendReport.extent.createTest("Action move into todays day plan");

        logger1.log(Status.PASS, MarkupHelper.createLabel("Move Actions into Today Day Plan", ExtentColor.BLACK));

        moveCriticalAction(logger1);

        moveImportantAction(logger1);

        moveLessImportantAction(logger1);

        extent.flush();

    }


    @Test(priority = 3,enabled = true)
    public void moveActionNextdate() throws InterruptedException
    {


        logger2 = NewExtendReport.extent.createTest("Action move into next date day plan");

        dayplanelements.selectNxtMonthCurntDate();

        Thread.sleep(500);

        dayplanelements.clickMyAction();

        logger2.log(Status.PASS, MarkupHelper.createLabel("* Successfully Select Next Month date *", ExtentColor.BLACK));

        moveCriticalAction(logger2);

        moveImportantAction(logger2);

        moveLessImportantAction(logger2);

        extent.flush();

    }

    @Test(priority = 4,enabled = true)
    public void moveActionPastDate() throws InterruptedException

    {
        logger3 = NewExtendReport.extent.createTest("Action move into previous date day plan");

        dayplanelements.dayPlanSelectpastDate();

        Thread.sleep(500);

        dayplanelements.clickMyAction();

        logger3.log(Status.PASS, MarkupHelper.createLabel("* Successfully Select previous Month date * *", ExtentColor.BLACK));

        moveCriticalAction(logger3);

        moveImportantAction(logger3);

        moveLessImportantAction(logger3);

        extent.flush();

    }

    public void moveCriticalAction(ExtentTest logg) throws InterruptedException
    {
        Thread.sleep(500);

        int befrecritclcount = dayplanelements.getCriticalCount(); //critical action count before moving
        logg.log(Status.PASS, MarkupHelper.createLabel("Before moving Action, Critical due action count =" + befrecritclcount, ExtentColor.GREEN));

        try {
            int befredayplancri = dayplanelements.getDayPlanCriticalCount();
            logg.log(Status.PASS, MarkupHelper.createLabel("Before moving Action into day plan, Critical Day Plan count =" + befredayplancri, ExtentColor.GREEN));

        } catch (Exception e) {
            logg.log(Status.FAIL, MarkupHelper.createLabel("Before moving Action into day plan, Critical Day Plan count not present", ExtentColor.RED));
            System.out.println("fail");
        }

        Thread.sleep(900);
        dayplanelements.moveCricalAction();
        logg.log(Status.PASS, MarkupHelper.createLabel("Successfully  move the critical action", ExtentColor.GREEN));

        Thread.sleep(700);

        int aftercritclcount = dayplanelements.getCriticalCount();     //critical action count after moving
        logg.log(Status.PASS, MarkupHelper.createLabel("After moving Action, Critical due action count =" + aftercritclcount, ExtentColor.GREEN));

        int afterdayplancri = dayplanelements.getDayPlanCriticalCount();
        logg.log(Status.PASS, MarkupHelper.createLabel("After moving Action into day plan, Critical Day Plan count =" + afterdayplancri, ExtentColor.GREEN));


        if (befrecritclcount != aftercritclcount) {
            logg.log(Status.PASS, MarkupHelper.createLabel("Critical Action move successfully and count update", ExtentColor.GREEN));

        } else
        {
            logg.log(Status.FAIL, MarkupHelper.createLabel("Action moved but count not update ", ExtentColor.BLUE));
        }

    }

    public void moveImportantAction(ExtentTest logg) throws InterruptedException {

        Thread.sleep(1000);

        int befreimpotntcount = dayplanelements.getImportntCount();   //important action count before moving
        logg.log(Status.PASS, MarkupHelper.createLabel("Before moving Action, Important due action count =" + befreimpotntcount, ExtentColor.GREEN));

        try {
            int befredayplanimpotnt = dayplanelements.getDayPlanImportntCount();
            logg.log(Status.PASS, MarkupHelper.createLabel("Before moving Action into day plan, Important Day Plan count =" + befredayplanimpotnt, ExtentColor.GREEN));


        } catch (Exception e) {
            logg.log(Status.FAIL, MarkupHelper.createLabel("Before moving Action into day plan, Important Day Plan count not found", ExtentColor.BLUE));
        }
        Thread.sleep(500);

        dayplanelements.moveImportntAction();
        logg.log(Status.PASS, MarkupHelper.createLabel("Successfully Move important action into day plan", ExtentColor.GREEN));

        Thread.sleep(700);

        int afterimpotntcount = dayplanelements.getImportntCount();   //important action count after moving
        logg.log(Status.PASS, MarkupHelper.createLabel("After moving Action, Important due action count =" + afterimpotntcount, ExtentColor.GREEN));

        int afterdayplanimpotnt = dayplanelements.getDayPlanImportntCount();
        logg.log(Status.PASS, MarkupHelper.createLabel("After moving Action into day plan, Important Day Plan count =" + afterdayplanimpotnt, ExtentColor.GREEN));

        if (befreimpotntcount != afterimpotntcount) {
            logg.log(Status.PASS, MarkupHelper.createLabel("Important Action move successfully and count update ", ExtentColor.GREEN));
        } else {
            logg.log(Status.FAIL, MarkupHelper.createLabel("Action moved but count not update", ExtentColor.BLUE));
        }

    }

    public void moveLessImportantAction(ExtentTest logg) throws InterruptedException
    {

        Thread.sleep(1000);

        int befrelessimpotntcount = dayplanelements.getLessImportntCount();      //less important action count before moving
        logg.log(Status.PASS, MarkupHelper.createLabel("Before moving Action, Less Important due action count ="+befrelessimpotntcount, ExtentColor.GREEN));

        try
        {
            int befredayplanlessimpotnt = dayplanelements.getDayPlanLessImportntCount();
            logg.log(Status.PASS, MarkupHelper.createLabel("Before moving Action into day plan, Less Important Day Plan count ="+befredayplanlessimpotnt, ExtentColor.GREEN));

        }catch (Exception  e)
        {
            logg.log(Status.FAIL, MarkupHelper.createLabel("Before moving Action into day plan, Less Important Day Plan count not found", ExtentColor.BLUE));

        }

        Thread.sleep(500);

        dayplanelements.moveLessImportntAction();
        logg.log(Status.PASS, MarkupHelper.createLabel("Successfully Move less Important action into day plan", ExtentColor.GREEN));

        Thread.sleep(700);
        int afterlessimpotntcount = dayplanelements.getLessImportntCount();      //less important action count after moving
        logg.log(Status.PASS, MarkupHelper.createLabel("After moving Action, Less Important due action count ="+afterlessimpotntcount, ExtentColor.GREEN));


        int afterdayplanlessimpotnt = dayplanelements.getDayPlanLessImportntCount();
        logg.log(Status.PASS, MarkupHelper.createLabel("After moving Action into day plan, Important Day Plan count ="+afterdayplanlessimpotnt, ExtentColor.GREEN));


        if(befrelessimpotntcount!=afterlessimpotntcount)
        {
            logg.log(Status.PASS, MarkupHelper.createLabel("Less Important Action move successfully and count update", ExtentColor.GREEN));
        }else
        {
            logg.log(Status.FAIL, MarkupHelper.createLabel("Action moved but count not update =", ExtentColor.BLUE));
        }

        extent.flush();
    }

    @AfterTest
    public void testend()
    {

    }
}
