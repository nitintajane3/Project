package functional.actionstest;

import com.relevantcodes.extentreports.LogStatus;
import functional.landingpagetest.SelectCompanyTest;
import functional.login.TestcaseLogin;
import org.testng.annotations.Test;
import pages.actionspage.AddactionOverviewElement;
import pages.dashboardpage.DashboardPagElement;
import utilities.Reportsextend;

import java.util.concurrent.TimeUnit;

import static functional.login.TestcaseLogin.driver;
import static utilities.Reportsextend.test;

public class AddactionOverviewTest
{
    String classname = "Add Action in Overview from actions page";

    @Test
    public void OverviewTest() throws InterruptedException
    {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //extend.reports(classname);

        TestcaseLogin logintest = new TestcaseLogin();    //login test object created

        logintest.validlogintest();

        test.log(LogStatus.INFO,"User  login successfully");

        Thread.sleep(2000);

        SelectCompanyTest selectcompy = new SelectCompanyTest();    // //select company object created

        selectcompy.selectcompanuydropdown();

        test.log(LogStatus.INFO,"Company select successfully");

        DashboardPagElement dashboardpage = new DashboardPagElement(driver);      //dashboard page element object created

        dashboardpage.lnkaction();

        test.log(LogStatus.INFO,"successfully click on action page");

        AddactionOverviewElement overviewelement = new AddactionOverviewElement(driver);     //overview page element object created

        overviewelement.linkOverView();

        test.log(LogStatus.INFO,"successfully click on overview");

        Thread.sleep(200);

        overviewelement.btnAdActionCriWek();      //critical this week  actioon

        Thread.sleep(1000);

        overviewelement.enterActiontitle();

        overviewelement.selectduedate();

        Thread.sleep(300);

        overviewelement.selectProjectOvervw();

        Thread.sleep(300);

        overviewelement.selectActionAssigneeOvervw();

        Thread.sleep(200);

        overviewelement.btnSave();

        Thread.sleep(100);

        overviewelement.btnClosedPopup();

        Thread.sleep(100);

        overviewelement.btnAdActionImportWek();    //important this week  actioon

        Thread.sleep(1000);

        overviewelement.enterActiontitle();

        overviewelement.selectduedate();
        Thread.sleep(300);

        overviewelement.selectProjectOvervw();

        Thread.sleep(300);

        overviewelement.selectActionAssigneeOvervw();

        Thread.sleep(200);

        overviewelement.btnSave();

        Thread.sleep(100);

        overviewelement.btnClosedPopup();

        overviewelement.btnAdActionLesImportWek();      //less important this week  actioon

        Thread.sleep(1000);

        overviewelement.enterActiontitle();

        overviewelement.selectduedate();
        Thread.sleep(300);

        overviewelement.selectProjectOvervw();

        Thread.sleep(300);

        overviewelement.selectActionAssigneeOvervw();

        Thread.sleep(200);

        overviewelement.btnSave();

        Thread.sleep(100);

        overviewelement.btnClosedPopup();

        Reportsextend.extend.endTest(test);
        Reportsextend.extend.flush();

    }


}
