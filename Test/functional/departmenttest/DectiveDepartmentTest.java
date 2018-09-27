package functional.departmenttest;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import functional.login.LoginTst;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.dashboardpage.DashboardPagElement;
import pages.departmentpage.DectiveDepartmentElement;
import pages.departmentpage.DeleteDepartmentElement;
import utilities.NewExtendReport;

import static functional.login.LoginTst.driver;
import static utilities.NewExtendReport.*;

public class DectiveDepartmentTest
{
    DectiveDepartmentElement deactivateelmnt = new DectiveDepartmentElement(driver);
    DashboardPagElement dashpageelemrnt = new DashboardPagElement(driver);
    DeleteDepartmentElement deletepageelement = new DeleteDepartmentElement(driver);
    NewExtendReport deactivatedptreprz = new NewExtendReport();

// while ruuning test you are import the deletedepartmenttest.class in this you have to comment to two line .newreport and .create report
    // another class create new instance to avoid that remove two line

    @BeforeTest
     public void deactiveDprt() throws InterruptedException
    {
        deactivatedptreprz.newReport("Deactivate_activate department","deactivate_activate_department_report");
        NewExtendReport.logger = extent.createTest("Login Test");
        LoginTst logintest = new LoginTst();
        logintest.loginTestNew();
        logger.log(Status.PASS, MarkupHelper.createLabel("User login  successfully", ExtentColor.GREEN));
        logger.log(Status.PASS, MarkupHelper.createLabel("Company select successfully", ExtentColor.GREEN));
        extent.flush();
    }
     @Test(priority = 1)
     public void openDptTest() throws InterruptedException
     {
         DeleteDepartmentTest opendptdetails = new DeleteDepartmentTest();
         opendptdetails.openDptDetailsTest();

     }

    @Test(priority = 2)
    public void testDprtdeActivate() throws InterruptedException {
        NewExtendReport.logger2 = extent.createTest("Deactivate department Test");

        deactivateelmnt.clickDeactivateBtn();

        logger2.log(Status.PASS, MarkupHelper.createLabel("Click on deactivate option of department", ExtentColor.GREEN));

        deactivateelmnt.confirmBtn();

        logger2.log(Status.PASS, MarkupHelper.createLabel("CLick on confirm button", ExtentColor.GREEN));

        Thread.sleep(200);
        deactivateelmnt.okBtn();

        logger2.log(Status.PASS, MarkupHelper.createLabel("Department Deactivate successfully", ExtentColor.GREEN));

        dashpageelemrnt.leftPanelDeptLink();

        logger2.log(Status.PASS, MarkupHelper.createLabel("Activated Department list display", ExtentColor.GREEN));

        extent.flush();



    }

    @Test(priority = 3)
    public void testDptActivate() throws InterruptedException
    {
        NewExtendReport.logger1 = extent.createTest("Activate department Test");
        int beforeactivatecont = deletepageelement.recentDptCount();

        System.out.println("After deactivate the department,activate department count is " + beforeactivatecont);

        logger1.log(Status.PASS, MarkupHelper.createLabel("After deactivate the department,activate department count is "+ beforeactivatecont, ExtentColor.GREEN));

        deactivateelmnt.deactivateDptDetails();

        logger1.log(Status.PASS, MarkupHelper.createLabel("Deactivate department list display", ExtentColor.GREEN));

        Thread.sleep(1000);

        int beforedeactivatecount = deletepageelement.recentDptCount();

        logger1.log(Status.PASS, MarkupHelper.createLabel("Before De-activate the department, de-activate departments count is "+ beforedeactivatecount, ExtentColor.GREEN));

        System.out.println("Before De-activate the department, de-activate departments count is " + beforedeactivatecount);

        deletepageelement.recentView();

        logger1.log(Status.PASS, MarkupHelper.createLabel("Department select to make activate", ExtentColor.GREEN));

        deletepageelement.clickMenuOver();



        deactivateelmnt.makeActivateDpt();

        logger1.log(Status.PASS, MarkupHelper.createLabel("Click on activate button", ExtentColor.GREEN));

        deactivateelmnt.confirmBtn();

        logger1.log(Status.PASS, MarkupHelper.createLabel("Click on confirm  button", ExtentColor.GREEN));

        deactivateelmnt.okBtn();

        logger1.log(Status.PASS, MarkupHelper.createLabel("Department activate successfully", ExtentColor.GREEN));

        dashpageelemrnt.leftPanelDeptLink();

        logger1.log(Status.PASS, MarkupHelper.createLabel("activated Department list display", ExtentColor.GREEN));

        int afteractivatecont = deletepageelement.recentDptCount();

        logger1.log(Status.PASS, MarkupHelper.createLabel("After activate the department, activate departments count is "+ afteractivatecont, ExtentColor.GREEN));

        System.out.println("After activate the department, activate departments count is " + afteractivatecont);

        deactivateelmnt.deactivateDptDetails();

        logger1.log(Status.PASS, MarkupHelper.createLabel("Deactivate department list display", ExtentColor.GREEN));

        Thread.sleep(1000);

        int afteractivatecount = deletepageelement.recentDptCount();

        logger1.log(Status.PASS, MarkupHelper.createLabel("After De-activate the department, de-activate departments count is "+ afteractivatecount, ExtentColor.GREEN));

        extent.flush();

    }

    /*@AfterTest
    public void endtest()
    {
        extent.flush();
    }*/
}
