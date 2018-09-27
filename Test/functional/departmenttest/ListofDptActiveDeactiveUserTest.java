package functional.departmenttest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import functional.login.LoginTst;
import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.dashboardpage.DashboardPagElement;
import pages.departmentpage.DeleteDepartmentElement;
import pages.departmentpage.DeptUserActiveDeactiveElement;
import utilities.NewExtendReport;

import java.util.concurrent.TimeUnit;

import static functional.login.LoginTst.driver;
import static utilities.NewExtendReport.*;

public class ListofDptActiveDeactiveUserTest
{
    NewExtendReport useractivatedeactive =  new NewExtendReport();
    DeleteDepartmentElement deleteelementdpt = new DeleteDepartmentElement(driver);
    DashboardPagElement dashboardpge =new DashboardPagElement(driver);
    DeptUserActiveDeactiveElement listofactivateDeactive = new DeptUserActiveDeactiveElement(driver);
    @BeforeTest
    public void loginTest() throws InterruptedException
    {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        useractivatedeactive.newReport("Department user activate_deactivate test"," Department_user_activate_deactivate_test");
        NewExtendReport.logger2 =  extent.createTest("Login Test");

        LoginTst logintest = new LoginTst();
        logintest.loginTestNew();
        logger2.log(Status.PASS, MarkupHelper.createLabel("User login successfully", ExtentColor.GREEN));
        logger2.log(Status.PASS, MarkupHelper.createLabel("Company select successfully", ExtentColor.GREEN));
        extent.flush();

    }
    @Test(priority = 1)
    public void dptUserCount(ITestResult result) throws InterruptedException
    {
        NewExtendReport.logger2 =  extent.createTest("Open the department details  page");
        Thread.sleep(1000);
        dashboardpge.lnkdepartmet();
        logger2.log(Status.PASS, MarkupHelper.createLabel("Successfully open the department list", ExtentColor.GREEN));

        int rentdptcount = deleteelementdpt.recentDptCount();
        System.out.println("List of activate department count is "+  rentdptcount);
        logger2.log(Status.PASS,MarkupHelper.createLabel("List of activate department count is "+ rentdptcount,ExtentColor.GREEN));

        Thread.sleep(500);
        String deptname = deleteelementdpt.dptSelectNdOpenDetails();
        //deleteelementdpt.allView();
        logger2.log(Status.PASS,MarkupHelper.createLabel("#  "+ deptname +"  #"+ " This department details page open",ExtentColor.BLUE));
        extent.flush();
    }

    @Test(priority = 2)
    public void activeUserList()
    {
        NewExtendReport.logger3 =  extent.createTest("Active user count");
        int managerusercount = listofactivateDeactive.activeManagerDptcnt();
        System.out.println("List of active manager present in this department is = " +managerusercount);
        logger3.log(Status.PASS,MarkupHelper.createLabel("List of active manager present in this department is = "+managerusercount,ExtentColor.GREEN));

        int memberusercount =  listofactivateDeactive.activeMemberDptCont();
        System.out.println("List of active member present in this department is = " +memberusercount);
        logger3.log(Status.PASS,MarkupHelper.createLabel("List of active member present in this department is = " +memberusercount,ExtentColor.GREEN));

        extent.flush();
    }

    @Test(priority = 3)
    public void deActiveUserList() throws InterruptedException {
        NewExtendReport.logger1 =  extent.createTest("De-active user count");
        Thread.sleep(1000);

        listofactivateDeactive.filterDeactivateUser();

        Thread.sleep(500);
        int deactivatemanagerusercount = listofactivateDeactive.activeManagerDptcnt();
        System.out.println("List of deactive manager present in this department is = " +deactivatemanagerusercount);
        logger1.log(Status.PASS,MarkupHelper.createLabel("List of deactive manager present in this department is = " +deactivatemanagerusercount,ExtentColor.GREEN));

        int deactivememberusercount =  listofactivateDeactive.activeMemberDptCont();
        System.out.println("List of deactive member present in this department is = " +deactivememberusercount);
        logger1.log(Status.PASS,MarkupHelper.createLabel("List of deactive member present in this department is = " +deactivememberusercount,ExtentColor.GREEN));


        extent.flush();
    }
}
