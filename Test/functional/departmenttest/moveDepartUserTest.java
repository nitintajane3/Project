package functional.departmenttest;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import functional.login.LoginTst;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.departmentpage.DectiveDepartmentElement;
import pages.departmentpage.DeptUserActiveDeactiveElement;
import pages.departmentpage.moveDprtUserElement;
import utilities.NewExtendReport;
import utilities.failTestScreenShots;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static functional.login.LoginTst.driver;
import static utilities.NewExtendReport.*;

public class moveDepartUserTest
{

    NewExtendReport usermovingreport =  new NewExtendReport();
    DeptUserActiveDeactiveElement dptuseractiveelementpage = new DeptUserActiveDeactiveElement(driver);
    DectiveDepartmentElement deactivedptemementpage = new DectiveDepartmentElement(driver);
    moveDprtUserElement moveuserelement = new moveDprtUserElement(driver);

    @BeforeTest
    public void LoginTestCase() throws InterruptedException
    {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        usermovingreport.newReport("Move Department user","move_dpt_user_from_MngrToMembr_report");
        NewExtendReport.logger =  extent.createTest("Login Test");
        LoginTst logintest = new LoginTst();
        logintest.loginTestNew();
        logger.log(Status.PASS, MarkupHelper.createLabel("User login successfully", ExtentColor.GREEN));
        logger.log(Status.PASS, MarkupHelper.createLabel("Company select successfully", ExtentColor.GREEN));
        extent.flush();
    }

    @Test(priority = 1)
    public void openDptDetailPage(ITestResult result) throws InterruptedException
    {
        ListofDptActiveDeactiveUserTest dptdetailspage = new ListofDptActiveDeactiveUserTest();
        dptdetailspage.dptUserCount(result);
    }

    @Test(priority = 2,enabled = false)
    public void AtiveUsrMveMngerToMebr(ITestResult result) throws InterruptedException
    {
        NewExtendReport.logger1 =  extent.createTest("Active Department Manager move to member position Test");

        moveDepartUserTest activemngrtomembr = new moveDepartUserTest();
        activemngrtomembr.MoveMngrToMembrTest(logger1,result);

        extent.flush();

    }

    @Test(priority = 3,enabled = false)
    public void AtiveUsrMveMebrToMangr(ITestResult result) throws InterruptedException
    {
        NewExtendReport.logger3 =  extent.createTest("Active Department Member move to Manager position Test");

        moveDepartUserTest activemngrtomembr = new moveDepartUserTest();
        activemngrtomembr.moveMembrToMngrTest(logger3,result);

        extent.flush();
    }

    @Test(priority = 2,enabled = true)
    public void DeAtiveUsrMveMngerToMebr(ITestResult result) throws InterruptedException

    {
        NewExtendReport.logger4 =  extent.createTest("De-active Department Manager move to member position Test");

       /* try
        {*/

        dptuseractiveelementpage.filterDeactivateUser();

        logger4.log(Status.PASS, MarkupHelper.createLabel("sucessfully open the deactive user list", ExtentColor.GREEN));

        moveDepartUserTest activemngrtomembr = new moveDepartUserTest();

        activemngrtomembr.MoveMngrToMembrTest(logger4,result);

        /*}catch (Exception errormsg)
        {
            logger4.log(Status.PASS, MarkupHelper.createLabel("Deactivate button not found ", ExtentColor.RED));
        }*/

        extent.flush();
    }

    @Test(priority = 3,enabled = true)
    public void DeAtiveUsrMveMebrToMngr(ITestResult result) throws InterruptedException
    {
        NewExtendReport.logger5 =  extent.createTest("De-active Department Member move to Manager position Test");

        dptuseractiveelementpage.filterDeactivateUser();

        logger5.log(Status.PASS, MarkupHelper.createLabel("sucessfully open the deactive user list", ExtentColor.GREEN));

        moveDepartUserTest activemngrtomembr = new moveDepartUserTest();

        activemngrtomembr.moveMembrToMngrTest(logger5,result);

        extent.flush();
    }

    public void MoveMngrToMembrTest(ExtentTest loggervariavble,ITestResult result) throws InterruptedException
    {

        int bfordeactimvemngrcount = dptuseractiveelementpage.activeManagerDptcnt();
        loggervariavble.log(Status.PASS, MarkupHelper.createLabel("Before move manager count is = " + bfordeactimvemngrcount, ExtentColor.GREEN));

        int bfordeactmvemembrcount = dptuseractiveelementpage.activeMemberDptCont();
        loggervariavble.log(Status.PASS, MarkupHelper.createLabel("Before move member count is = " + bfordeactmvemembrcount, ExtentColor.GREEN));

        String getmanagername = moveuserelement.managerEditButton();
        loggervariavble.log(Status.PASS, MarkupHelper.createLabel(getmanagername + " = select for move to member level", ExtentColor.GREEN));

        try {

            moveuserelement.btnMveToDprtMember();
            loggervariavble.log(Status.PASS, MarkupHelper.createLabel("User successfully move to member level", ExtentColor.GREEN));

            Thread.sleep(1000);

            int aftrdeactimvemngrcount = dptuseractiveelementpage.activeManagerDptcnt();
            loggervariavble.log(Status.PASS, MarkupHelper.createLabel("after move manager count is = " + aftrdeactimvemngrcount, ExtentColor.GREEN));

            int aftrdeactmvemembrcount = dptuseractiveelementpage.activeMemberDptCont();
            loggervariavble.log(Status.PASS, MarkupHelper.createLabel("after move member count is = " + aftrdeactmvemembrcount, ExtentColor.GREEN));

        }catch (Exception  output)
        {
            loggervariavble.log(Status.PASS, MarkupHelper.createLabel("User not found", ExtentColor.RED));
        }

    }


    public void moveMembrToMngrTest(ExtentTest loggervariavble2,ITestResult result) throws InterruptedException
    {
        int bformovemngrcount = dptuseractiveelementpage.activeManagerDptcnt();
        loggervariavble2.log(Status.PASS, MarkupHelper.createLabel("Before move manager count is = " + bformovemngrcount, ExtentColor.GREEN));

        int bformovemembrcount = dptuseractiveelementpage.activeMemberDptCont();
        loggervariavble2.log(Status.PASS, MarkupHelper.createLabel("Before move member count is = " + bformovemembrcount, ExtentColor.GREEN));

        String getmanagername = moveuserelement.memberEditButton();
        loggervariavble2.log(Status.PASS, MarkupHelper.createLabel(getmanagername + " = select for move to member level", ExtentColor.GREEN));

        try {

            moveuserelement.btnMveToDprtManager();
            loggervariavble2.log(Status.PASS, MarkupHelper.createLabel("User successfully move to manager level", ExtentColor.GREEN));

            Thread.sleep(1000);

            int aftrmovemngrcount = dptuseractiveelementpage.activeManagerDptcnt();
            loggervariavble2.log(Status.PASS, MarkupHelper.createLabel("after move manager count is = " + aftrmovemngrcount, ExtentColor.GREEN));

            int aftrmovemembrcount = dptuseractiveelementpage.activeMemberDptCont();
            loggervariavble2.log(Status.PASS, MarkupHelper.createLabel("after move member count is = " + aftrmovemembrcount, ExtentColor.GREEN));

        }catch (Exception  output)
        {
            loggervariavble2.log(Status.PASS, MarkupHelper.createLabel("User not found", ExtentColor.RED));
        }
    }


    @AfterMethod
    public void tearDown(ITestResult result) throws IOException
    {
        failTestScreenShots sreenshot = new failTestScreenShots();
        sreenshot.failscreenshot(driver,result);
    }


}
