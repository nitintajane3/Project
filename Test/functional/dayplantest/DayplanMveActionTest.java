package functional.dayplantest;

import com.relevantcodes.extentreports.LogStatus;
import functional.landingpagetest.SelectCompanyTest;
import functional.login.LoginTest;
import functional.login.TestcaseLogin;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.actionspage.AddactionOverviewElement;
import pages.dashboardpage.DashboardPagElement;
import pages.dayplanpage.DyplnMveActionElement;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static functional.departmenttest.AddDepartmentTest.extend;
import static functional.login.TestcaseLogin.driver;
import static utilities.Reportsextend.test;

public class DayplanMveActionTest
{

    private String  classname = "Move due action into day plan";
    DyplnMveActionElement dayplanelements = new DyplnMveActionElement(driver);

    @BeforeTest
    public void dayPlanMovectionTest() throws IOException, InterruptedException {

        extend.reports(classname);

        TestcaseLogin logintest = new TestcaseLogin();    //login test object created

        logintest.validlogintest();

        test.log(LogStatus.INFO,"User  login successfully");

        SelectCompanyTest selectcompy = new SelectCompanyTest();    // //select company object created

        selectcompy.selectcompanuydropdown();

        test.log(LogStatus.INFO,"Company select successfully");

        DashboardPagElement dashboardpage = new DashboardPagElement(driver);      //dashboard page element object created

        dashboardpage.lnkDayPlan();

    }

    @Test(priority = 1)
    public void moveAction() throws InterruptedException
    {
        dayplanelements.clickMyAction();

        Thread.sleep(200);

        dayplanelements.moveCricalAction();

        Thread.sleep(100);
        dayplanelements.moveImportntAction();

        Thread.sleep(100);

        dayplanelements.moveLessImportntAction();

    }

    @Test(priority = 2)
    public void moveActionNextdate() throws InterruptedException
    {
        dayplanelements.dayPlanSelectNextDate();

    }
}
