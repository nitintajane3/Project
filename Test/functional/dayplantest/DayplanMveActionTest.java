package functional.dayplantest;

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
import utilities.Reportsextend;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static functional.departmenttest.AddDepartmentTest.extend;
import static functional.login.TestcaseLogin.driver;
import static utilities.Reportsextend.test;

public class DayplanMveActionTest
{
    DyplnMveActionElement dayplanelements = new DyplnMveActionElement(driver);
    public static Reportsextend extend = new Reportsextend();

    @BeforeTest
    public void dayPlanMovectionTest() throws IOException, InterruptedException
    {

        extend.reports("Day Plan Automation test Report");


        TestcaseLogin logintest = new TestcaseLogin();    //login test object created

        logintest.validlogintest();

        test.log(LogStatus.INFO,"User  login successfully");

        SelectCompanyTest selectcompy = new SelectCompanyTest();    // //select company object created

        selectcompy.selectcompanuydropdown();

        test.log(LogStatus.INFO,"Company select successfully");

        DashboardPagElement dashboardpage = new DashboardPagElement(driver);      //dashboard page element object created

        dashboardpage.lnkDayPlan();

        test.log(LogStatus.INFO,"Successefully click on day plan link");

    }


    public void moveAction() throws InterruptedException
    {
        Thread.sleep(100);

        dayplanelements.clickMyAction();
        test.log(LogStatus.INFO,"Disable the my action filter");

        Thread.sleep(900);

//critical section

        int befrecritclcount = dayplanelements.dueActionCountImportnt(1,11);   //critical action count before moving
        test.log(LogStatus.INFO,"Before moving Action, Critical due action count ="+befrecritclcount);

        int befredayplancri = dayplanelements.dayPlanActionCount(1,11);
        test.log(LogStatus.INFO,"Before moving Action into day plan, Critical Day Plan count ="+befredayplancri);

        Thread.sleep(900);

        dayplanelements.moveCricalAction();
        test.log(LogStatus.INFO,"Successfully Move Critical action into day plan");

        Thread.sleep(700);

        int aftercritclcount = dayplanelements.dueActionCountImportnt(1,11);     //critical action count after moving
        test.log(LogStatus.INFO,"After moving Action, Critical due action count ="+aftercritclcount);

        int afterdayplancri = dayplanelements.dayPlanActionCount(1,11);
        test.log(LogStatus.INFO,"After moving Action into day plan, Critical Day Plan count ="+afterdayplancri);

        if(befrecritclcount!=aftercritclcount)
        {
            test.log(LogStatus.INFO,"Critical Action move successfully and count update ");
            System.out.println("Critical Action move successfully and count update ");
        }else
            {
                test.log(LogStatus.INFO,"Action moved but count not update");
                System.out.println("Action moved but count not update ");
             }



//important section

        Thread.sleep(1000);

        int befreimpotntcount = dayplanelements.dueActionCountImportnt(2,12);   //important action count before moving
        test.log(LogStatus.INFO,"Before moving Action, Important due action count ="+befreimpotntcount);

        int befredayplanimpotnt = dayplanelements.dayPlanActionCount(2,12);
        test.log(LogStatus.INFO,"Before moving Action into day plan, Important Day Plan count ="+befredayplanimpotnt);

        Thread.sleep(500);

        dayplanelements.moveImportntAction();
        test.log(LogStatus.INFO,"Successfully Move important action into day plan");

        Thread.sleep(700);

        int afterimpotntcount = dayplanelements.dueActionCountImportnt(2,12);   //important action count after moving
        test.log(LogStatus.INFO,"After moving Action, Important due action count ="+afterimpotntcount);

        int afterdayplanimpotnt = dayplanelements.dayPlanActionCount(2,12);
        test.log(LogStatus.INFO,"After moving Action into day plan, Important Day Plan count ="+afterdayplanimpotnt);

        if(befreimpotntcount!=afterimpotntcount)
        {
            test.log(LogStatus.INFO,"Important Action move successfully and count update ");
            System.out.println("Important Action move successfully and count update ");
        }else
        {
            test.log(LogStatus.INFO,"Action moved but count not update");
            System.out.println("Action moved but count not update ");
        }



//Less important section

        Thread.sleep(1000);

        int befrelessimpotntcount = dayplanelements.dueActionCountImportnt(3,17);      //less important action count before moving
        test.log(LogStatus.INFO,"Before moving Action, Less Important due action count ="+befrelessimpotntcount);

        int befredayplanlessimpotnt = dayplanelements.dayPlanActionCount(3,17);
        test.log(LogStatus.INFO,"Before moving Action into day plan, Less Important Day Plan count ="+befredayplanlessimpotnt);

        Thread.sleep(500);

        dayplanelements.moveLessImportntAction();
        test.log(LogStatus.INFO,"Successfully Move less Important action into day plan");

        Thread.sleep(700);
        int afterlessimpotntcount = dayplanelements.dueActionCountImportnt(3,17);      //less important action count after moving
        test.log(LogStatus.INFO,"After moving Action, Less Important due action count ="+afterlessimpotntcount);

        int afterdayplanlessimpotnt = dayplanelements.dayPlanActionCount(3,17);
        test.log(LogStatus.INFO,"After moving Action into day plan, Important Day Plan count ="+afterdayplanlessimpotnt);

        if(befrelessimpotntcount!=afterlessimpotntcount)
        {
            test.log(LogStatus.INFO,"Less Important Action move successfully and count update ");
            System.out.println("Important Action move successfully and count update ");
        }else
        {
            test.log(LogStatus.INFO,"Action moved but count not update");
            System.out.println("Action moved but count not update ");
        }
    }

    @Test(priority = 1)
    public void moveActionintoTodaydate() throws InterruptedException
    {

        //extend.reports("Moving Actions into today Day Plan");
        test.log(LogStatus.INFO,"Move Actions into Today Day Plan");

        DayplanMveActionTest moveactiontest = new DayplanMveActionTest();

        moveactiontest.moveAction();
    }


    @Test(priority = 2)
    public void moveActionNextdate() throws InterruptedException
    {
        //extend.reports("Moving Actions into Next Month Day Plan");

        dayplanelements.dayPlanSelectNextDate();

        test.log(LogStatus.INFO,"* Successfully Select Next Month date *");

        DayplanMveActionTest moveactiontest = new DayplanMveActionTest();

        moveactiontest.moveAction();



    }
    @Test(priority = 3)
    public void moveActionPastDate() throws InterruptedException

    {

        //extend.reports("Moving Actions into Previous Month Day Plan");

        dayplanelements.dayPlanSelectpastDate();

        test.log(LogStatus.INFO,"  * Successfully Select previous Month date * ");

        DayplanMveActionTest moveactiontest = new DayplanMveActionTest();

        moveactiontest.moveAction();

    }

    @AfterTest
    public void testend()
    {
        test.log(LogStatus.INFO,"Action successfully move into Day plan");
        Reportsextend.extend.endTest(test);
        Reportsextend.extend.flush();
    }
}
