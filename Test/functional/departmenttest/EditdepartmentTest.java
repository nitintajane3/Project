package functional.departmenttest;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.relevantcodes.extentreports.LogStatus;
import functional.login.LoginTst;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static functional.login.LoginTst.driver;
import static utilities.NewExtendReport.extent;
import static utilities.Reportsextend.test;
import static utilities.NewExtendReport.logger2;
import static utilities.NewExtendReport.logger3;
import static utilities.NewExtendReport.logger;
import static utilities.NewExtendReport.logger1;
import pages.departmentpage.AddDepartmetElement;
import pages.departmentpage.EditdepartmentElement;
import utilities.NewExtendReport;
import utilities.Reportsextend;
import utilities.TakeScreenshot;

import java.util.concurrent.TimeUnit;

public class EditdepartmentTest
{
    NewExtendReport editdept =  new NewExtendReport();
    EditdepartmentElement editdeptelement = new EditdepartmentElement(driver);
    AddDepartmetElement adddptemement = new AddDepartmetElement(driver);
    DeleteDepartmentTest deptimport = new  DeleteDepartmentTest();

    @BeforeTest
    public void editDepartmentName() throws InterruptedException
    {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        editdept.newReport("edit department  test","edit department report");
        NewExtendReport.logger =  extent.createTest("Login Test");
        LoginTst logintest = new LoginTst();
        logintest.loginTestNew();
        logger.log(Status.PASS, MarkupHelper.createLabel("User login  successfully", ExtentColor.GREEN));
        logger.log(Status.PASS, MarkupHelper.createLabel("Company select successfully", ExtentColor.GREEN));
        extent.flush();
    }

    @Test(priority = 1)
    public void editDptName() throws InterruptedException
    {
        NewExtendReport.logger2 =  extent.createTest("Department name change test");

        deptimport.openDptDetailsTest();

        logger2.log(Status.PASS, MarkupHelper.createLabel("successfully open the department", ExtentColor.GREEN));

        editdeptelement.clickEditBtn();

        logger2.log(Status.PASS, MarkupHelper.createLabel("Successfully click on edit button", ExtentColor.GREEN));

        editdeptelement.clickDeptName();

        logger2.log(Status.PASS, MarkupHelper.createLabel("CLick on department name", ExtentColor.GREEN));

        editdeptelement.sendDepartment();

        logger2.log(Status.PASS, MarkupHelper.createLabel("Successfully change the department name", ExtentColor.GREEN));

        editdeptelement.clickOutSide();

        extent.flush();
    }

    @Test(priority = 2)
    public void editDeptManager()
    {
        NewExtendReport.logger1 =  extent.createTest("Edit Department manager test");
        try
        {
            adddptemement.addbuttodeprtmaager();

            logger1.log(Status.PASS, MarkupHelper.createLabel("Click on add manager button", ExtentColor.GREEN));

            adddptemement.enteremailid();

            logger1.log(Status.PASS, MarkupHelper.createLabel("Enter user email address", ExtentColor.GREEN));

            adddptemement.clickemailidfield();

            adddptemement.clickonsavebutton();

            logger1.log(Status.PASS, MarkupHelper.createLabel("Click on save button", ExtentColor.GREEN));

            editdeptelement.userAddsucess();

            logger1.log(Status.PASS, MarkupHelper.createLabel("User add successfully", ExtentColor.GREEN));

        }catch (Exception e)
        {
            editdeptelement.userDuplicateAlert();

            logger1.log(Status.PASS, MarkupHelper.createLabel("Found duplicate user .. !", ExtentColor.RED));

            adddptemement.duplicatepopupclosed();

            editdeptelement.btnCancelManager();
        }
        extent.flush();
    }

    @Test(priority = 3)
    public void editDprtMember()
    {

        NewExtendReport.logger3 =  extent.createTest("Edit Department member test");
        try
        {
            adddptemement.setdeparmentmember();

            logger3.log(Status.PASS, MarkupHelper.createLabel("click on add department member button", ExtentColor.GREEN));

            adddptemement.enteremailidmember();

            logger3.log(Status.PASS, MarkupHelper.createLabel("Enter the user email address", ExtentColor.GREEN));

            adddptemement.setemptyclick();

            adddptemement.clickonsavebutton();

            logger3.log(Status.PASS, MarkupHelper.createLabel("Click on save button", ExtentColor.GREEN));

            editdeptelement.userAddsucess();

            logger3.log(Status.PASS, MarkupHelper.createLabel("User add successfully", ExtentColor.GREEN));

        }catch (Exception e)
        {
            editdeptelement.userDuplicateAlert();

            logger3.log(Status.PASS, MarkupHelper.createLabel("Found duplicate user .. !", ExtentColor.RED));

            adddptemement.duplicatepopupclosed();

            editdeptelement.btnCanceMember();
        }
        extent.flush();
    }

}
