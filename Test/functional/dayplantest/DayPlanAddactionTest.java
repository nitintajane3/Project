package functional.dayplantest;

import com.relevantcodes.extentreports.LogStatus;
import functional.landingpagetest.SelectCompanyTest;
import functional.login.TestcaseLogin;
import org.testng.annotations.Test;
import pages.actionspage.AddactionOverviewElement;
import pages.dashboardpage.DashboardPagElement;
import pages.dayplanpage.DyplnMveActionElement;
import static functional.departmenttest.AddDepartmentTest.extend;
import static utilities.Reportsextend.test;

import static functional.login.TestcaseLogin.driver;

public class DayPlanAddactionTest
{
    private String  classname = "Add Personal task test";

    @Test
    public void dayPlanActionAdd() throws InterruptedException

    {

        extend.reports(classname);

            TestcaseLogin logintest = new TestcaseLogin();    //login test object created

            logintest.validlogintest();

            test.log(LogStatus.INFO, "User  login successfully");

            SelectCompanyTest selectcompy = new SelectCompanyTest();    // //select company object created

            selectcompy.selectcompanuydropdown();

            test.log(LogStatus.INFO, "Company select successfully");

            DashboardPagElement dashboardpage = new DashboardPagElement(driver);      //dashboard page element object created

            dashboardpage.lnkDayPlan();

            DyplnMveActionElement dayplanelements = new DyplnMveActionElement(driver);

            AddactionOverviewElement overviewelement = new AddactionOverviewElement(driver);     //overview page element object created

            dayplanelements.clickMyAction();

            Thread.sleep(200);

            dayplanelements.dueAtionAddCritcal();

            Thread.sleep(100);

            dayplanelements.enterActiontitle();

            dayplanelements.selectduedate();

            Thread.sleep(100);

            dayplanelements.selectProjectOvervw();

            overviewelement.selectActionAssigneeOvervw();

            overviewelement.btnSave();

            Thread.sleep(100);

            overviewelement.btnClosedPopup();


        }
}

