package functional.departmenttest;

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
import utilities.NewExtendReport;
import utilities.failTestScreenShots;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static functional.login.LoginTst.driver;
import static utilities.NewExtendReport.*;
import static utilities.NewExtendReport.logger3;

public class MakeActiveDeactiveUserFromDptTest
{
    NewExtendReport activedeactuserreports =  new NewExtendReport();
    DeptUserActiveDeactiveElement dptuseractiveelementpage = new DeptUserActiveDeactiveElement(driver);
    DectiveDepartmentElement deactivedptemementpage = new DectiveDepartmentElement(driver);
    @BeforeTest
    public void loginTest() throws InterruptedException
    {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        activedeactuserreports.newReport("Activate and De-activate user from  department test","Activate_and_De-activate_user_from_dpt_report");
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
    public void managerDeactiveTest(ITestResult result) throws InterruptedException
    {
        NewExtendReport.logger1 =  extent.createTest("Deactivate Manager from Department Test");

        int beforemanagerusercount = dptuseractiveelementpage.activeManagerDptcnt();
        logger1.log(Status.PASS, MarkupHelper.createLabel("List of  User before remove = " + beforemanagerusercount, ExtentColor.BLUE));


        String nameget = dptuseractiveelementpage.managerEditButton();
        logger1.log(Status.PASS, MarkupHelper.createLabel("This user select for deactivate in active list = " + nameget, ExtentColor.GREEN));
        System.out.println(nameget);

        try
        {
            dptuseractiveelementpage.selectDeactivateOption();
            logger1.log(Status.PASS, MarkupHelper.createLabel("Click on Deactive button", ExtentColor.GREEN));

            deactivedptemementpage.confirmBtn();
            logger1.log(Status.PASS, MarkupHelper.createLabel("Click on confirm button", ExtentColor.GREEN));

            deactivedptemementpage.okBtn();
            logger1.log(Status.PASS, MarkupHelper.createLabel("User deactivate  successfully", ExtentColor.GREEN));

            int aftermanagerusercount = dptuseractiveelementpage.activeManagerDptcnt();
            logger1.log(Status.PASS, MarkupHelper.createLabel("List of  User after deactivate in active list= " + aftermanagerusercount, ExtentColor.BLUE));

            dptuseractiveelementpage.filterDeactivateUser();
            logger1.log(Status.PASS, MarkupHelper.createLabel("Click on inactive filter option", ExtentColor.GREEN));


        }catch (Exception e)
        {
            logger1.log(Status.PASS, MarkupHelper.createLabel("No User found in Manager lavel", ExtentColor.RED));
        }

        extent.flush();
    }

    @Test(priority = 3,enabled = false)
    public void memberDeacitveTest(ITestResult result) throws InterruptedException {

        NewExtendReport.logger3 =  extent.createTest("Deactivate member from Department test");

        int beforememberusercount = dptuseractiveelementpage.activeMemberDptCont();
        logger3.log(Status.PASS, MarkupHelper.createLabel("List of  User before deactivate in active list = " + beforememberusercount, ExtentColor.BLUE));

        String memberget = dptuseractiveelementpage.memberEditButton();
        logger3.log(Status.PASS, MarkupHelper.createLabel("This user select for deactivate = " + memberget, ExtentColor.GREEN));
        System.out.println(memberget);


        try
        {
            dptuseractiveelementpage.selectDeactivateOption();
            logger3.log(Status.PASS, MarkupHelper.createLabel("Click on deactivate button", ExtentColor.GREEN));

            deactivedptemementpage.confirmBtn();
            logger3.log(Status.PASS, MarkupHelper.createLabel("Click on confirm button", ExtentColor.GREEN));

            deactivedptemementpage.okBtn();
            logger3.log(Status.PASS, MarkupHelper.createLabel("User deactivate  successfully", ExtentColor.GREEN));

            int aftermanagermembercount = dptuseractiveelementpage.activeMemberDptCont();
            logger3.log(Status.PASS, MarkupHelper.createLabel("List of  User after deactivate in active list = " + aftermanagermembercount, ExtentColor.BLUE));

            dptuseractiveelementpage.filterDeactivateUser();
            logger3.log(Status.PASS, MarkupHelper.createLabel("Click on inactive filter option", ExtentColor.GREEN));

        }catch (Exception e)
        {
            logger3.log(Status.PASS, MarkupHelper.createLabel("No User found in member lavel", ExtentColor.RED));
        }
        extent.flush();
    }

    @Test(priority = 2)
    public void deActivateUserSearchName(ITestResult result) throws InterruptedException
    {

        NewExtendReport.logger4 =  extent.createTest("Deactivate user from department");

        int bfordeactimanagercount = dptuseractiveelementpage.activeManagerDptcnt();
        logger4.log(Status.PASS, MarkupHelper.createLabel("List of Active manager count is  = " + bfordeactimanagercount, ExtentColor.BLUE));

        int bfordeactimembrcount = dptuseractiveelementpage.activeMemberDptCont();
        logger4.log(Status.PASS, MarkupHelper.createLabel("List of   Active member  count is  = " + bfordeactimembrcount, ExtentColor.BLUE));


        String testname = dptuseractiveelementpage.searchNameAndRemve();

        logger4.log(Status.PASS, MarkupHelper.createLabel(" user select for Deactivate", ExtentColor.GREEN));

        logger4.log(Status.PASS, MarkupHelper.createLabel(testname + " to deactivate ", ExtentColor.BLUE));

        try {

            dptuseractiveelementpage.deactivateButton();
            logger4.log(Status.PASS, MarkupHelper.createLabel("Click on deactivate button", ExtentColor.GREEN));

            deactivedptemementpage.confirmBtn();
            logger4.log(Status.PASS, MarkupHelper.createLabel("Click on confirm button", ExtentColor.GREEN));

            deactivedptemementpage.okBtn();

            logger4.log(Status.PASS, MarkupHelper.createLabel("User successfully Deactivate from  department", ExtentColor.GREEN));
        }catch (Exception ouputtest)
        {
            logger4.log(Status.PASS, MarkupHelper.createLabel("No User found ", ExtentColor.RED));
        }

        dptuseractiveelementpage.filterDeactivateUser();
        logger4.log(Status.PASS, MarkupHelper.createLabel("Click on inactive filter option", ExtentColor.GREEN));

        Thread.sleep(1000);

        int deactivatemanagernumber = dptuseractiveelementpage.deActiveManagerDptcnt();
        logger4.log(Status.PASS, MarkupHelper.createLabel("Deactivate manager count is = " + deactivatemanagernumber, ExtentColor.GREEN));


        int deactivatemembernumber = dptuseractiveelementpage.deActiveMemberDptCont();

        logger4.log(Status.PASS, MarkupHelper.createLabel("Deactivate member count is = " + deactivatemembernumber, ExtentColor.GREEN));

        dptuseractiveelementpage.filteerActiveUser();

        Thread.sleep(500);

        int aftrdeactimanagercount = dptuseractiveelementpage.activeManagerDptcnt();
        logger4.log(Status.PASS, MarkupHelper.createLabel("List of Active manager count is  = " + aftrdeactimanagercount, ExtentColor.BLUE));

        int aftrdeactimembrcount = dptuseractiveelementpage.activeMemberDptCont();
        logger4.log(Status.PASS, MarkupHelper.createLabel("List of  Active member count is  = " + aftrdeactimembrcount, ExtentColor.BLUE));

        Thread.sleep(500);

        dptuseractiveelementpage.filterDeactivateUser();

        extent.flush();
    }

    @Test(priority = 3)
    public void userDectiveToActiveTest(ITestResult result) throws InterruptedException {

        NewExtendReport.logger5 =  extent.createTest("Activate user from department");

        int deactivatemanagernmbr = dptuseractiveelementpage.deActiveManagerDptcnt();
        logger5.log(Status.PASS, MarkupHelper.createLabel("Deactivate manager count is = " + deactivatemanagernmbr, ExtentColor.GREEN));


        int deactivatemembernmbr = dptuseractiveelementpage.deActiveMemberDptCont();

        logger5.log(Status.PASS, MarkupHelper.createLabel("Deactivate member count is = " + deactivatemembernmbr, ExtentColor.GREEN));


        String dectiveurname = dptuseractiveelementpage.searchNameAndRemve();

        logger5.log(Status.PASS, MarkupHelper.createLabel(" user select for Activate", ExtentColor.GREEN));

        logger5.log(Status.PASS, MarkupHelper.createLabel(dectiveurname + " to Activate ", ExtentColor.BLUE));

        try {

            dptuseractiveelementpage.activateButton();
            logger5.log(Status.PASS, MarkupHelper.createLabel("Click on Activate button", ExtentColor.GREEN));

            deactivedptemementpage.confirmBtn();
            logger5.log(Status.PASS, MarkupHelper.createLabel("Click on confirm button", ExtentColor.GREEN));

            deactivedptemementpage.okBtn();

            logger5.log(Status.PASS, MarkupHelper.createLabel("User successfully Activate from  department", ExtentColor.GREEN));
        }catch (Exception ouputtest)
        {
            logger5.log(Status.PASS, MarkupHelper.createLabel("No User found ", ExtentColor.RED));
        }

        Thread.sleep(500);

        int aftrdeactivatemanagernmbr = dptuseractiveelementpage.deActiveManagerDptcnt();
        logger5.log(Status.PASS, MarkupHelper.createLabel("List of Deactivate manager count is = " + aftrdeactivatemanagernmbr, ExtentColor.GREEN));


        int aftrdeactivatemembernmbr = dptuseractiveelementpage.deActiveMemberDptCont();

        logger5.log(Status.PASS, MarkupHelper.createLabel("List of Deactivate member count is = " + aftrdeactivatemembernmbr, ExtentColor.GREEN));

        Thread.sleep(1000);

        dptuseractiveelementpage.filteerActiveUser();

        int actimanagercount = dptuseractiveelementpage.activeManagerDptcnt();
        logger5.log(Status.PASS, MarkupHelper.createLabel("List of Active manager count is  = " + actimanagercount, ExtentColor.BLUE));

        int actimembrcount = dptuseractiveelementpage.activeMemberDptCont();
        logger5.log(Status.PASS, MarkupHelper.createLabel("List of  Active member count is  = " + actimembrcount, ExtentColor.BLUE));


        extent.flush();
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException
    {
        failTestScreenShots sreenshot = new failTestScreenShots();
        sreenshot.failscreenshot(driver,result);
    }

}
