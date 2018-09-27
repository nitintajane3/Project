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
import static utilities.NewExtendReport.extent;
import static utilities.NewExtendReport.logger4;
import static utilities.NewExtendReport.logger;
import static utilities.NewExtendReport.logger3;
import static utilities.NewExtendReport.logger1;

public class RemoveDptUserTest
{
    NewExtendReport removeuserreports =  new NewExtendReport();
    DeptUserActiveDeactiveElement userelement = new DeptUserActiveDeactiveElement(driver);

    DectiveDepartmentElement deactiveelementforuser = new DectiveDepartmentElement(driver);
    @BeforeTest
    public void loginTest() throws InterruptedException
    {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        removeuserreports.newReport("Remove  user from Department","Remove_user_from_Department");
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
    public void removeDptUser(ITestResult result) throws InterruptedException {
        NewExtendReport.logger1 =  extent.createTest("Remove Manager from Department Test");

            int beforemanagerusercount = userelement.activeManagerDptcnt();
            logger1.log(Status.PASS, MarkupHelper.createLabel("List of  User before remove = " + beforemanagerusercount, ExtentColor.BLUE));


            String nameget = userelement.managerEditButton();
            logger1.log(Status.PASS, MarkupHelper.createLabel("This user select for remove = " + nameget, ExtentColor.GREEN));
            System.out.println(nameget);

            try
            {
            userelement.selectRemoveOption();
            logger1.log(Status.PASS, MarkupHelper.createLabel("Click on remove button", ExtentColor.GREEN));

            deactiveelementforuser.confirmBtn();
            logger1.log(Status.PASS, MarkupHelper.createLabel("Click on confirm button", ExtentColor.GREEN));

            deactiveelementforuser.okBtn();
            logger1.log(Status.PASS, MarkupHelper.createLabel("User remove  successfully", ExtentColor.GREEN));

            int aftermanagerusercount = userelement.activeManagerDptcnt();
            logger1.log(Status.PASS, MarkupHelper.createLabel("List of  User after remove = " + aftermanagerusercount, ExtentColor.BLUE));


        }catch (Exception e)
        {
            logger1.log(Status.PASS, MarkupHelper.createLabel("No User found in Manager lavel", ExtentColor.RED));
        }
        extent.flush();
    }

    @Test(priority = 3,enabled = false)
    public void removeDptMember(ITestResult result) throws InterruptedException {
        NewExtendReport.logger3 =  extent.createTest("Remove member from Department test");

        int beforememberusercount = userelement.activeMemberDptCont();
        logger3.log(Status.PASS, MarkupHelper.createLabel("List of  User before remove = " + beforememberusercount, ExtentColor.BLUE));

        String memberget = userelement.memberEditButton();
        logger3.log(Status.PASS, MarkupHelper.createLabel("This user select for remove = " + memberget, ExtentColor.GREEN));
        System.out.println(memberget);


        try
        {
            userelement.selectRemoveOption();
            logger3.log(Status.PASS, MarkupHelper.createLabel("Click on remove button", ExtentColor.GREEN));

            deactiveelementforuser.confirmBtn();
            logger3.log(Status.PASS, MarkupHelper.createLabel("Click on confirm button", ExtentColor.GREEN));

            deactiveelementforuser.okBtn();
            logger3.log(Status.PASS, MarkupHelper.createLabel("User remove  successfully", ExtentColor.GREEN));

            int aftermanagermembercount = userelement.activeMemberDptCont();
            logger3.log(Status.PASS, MarkupHelper.createLabel("List of  User after remove = " + aftermanagermembercount, ExtentColor.BLUE));


        }catch (Exception e)
        {
            logger3.log(Status.PASS, MarkupHelper.createLabel("No User found in member lavel", ExtentColor.RED));
        }
        extent.flush();
    }


    @Test(priority = 2)
    public void deleteUserbyName(ITestResult result) throws InterruptedException
    {

        String testname = userelement.searchNameAndRemve();

        NewExtendReport.logger4 =  extent.createTest("Remove" + testname + " from department");

        logger4.log(Status.PASS, MarkupHelper.createLabel("$" + testname + " $"+ "This user select for remove", ExtentColor.GREEN));

        try {
            userelement.removeButton();
            logger4.log(Status.PASS, MarkupHelper.createLabel("Click on remove button", ExtentColor.GREEN));

            deactiveelementforuser.confirmBtn();
            logger4.log(Status.PASS, MarkupHelper.createLabel("Click on confirm button", ExtentColor.GREEN));

            deactiveelementforuser.okBtn();

            logger4.log(Status.PASS, MarkupHelper.createLabel("$" + testname + " $" + "This user successfully removed from  department", ExtentColor.GREEN));
        }catch (Exception ouput)
        {
            logger4.log(Status.PASS, MarkupHelper.createLabel("No User found ", ExtentColor.RED));
        }

        extent.flush();
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException
    {
        failTestScreenShots sreenshot = new failTestScreenShots();
        sreenshot.failscreenshot(driver,result);
    }
}

