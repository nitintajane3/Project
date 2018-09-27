package functional.departmenttest;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import functional.login.LoginTst;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.dashboardpage.DashboardPagElement;
import pages.departmentpage.DeleteDepartmentElement;
import utilities.NewExtendReport;

import java.util.List;
import java.util.concurrent.TimeUnit;
import static functional.login.LoginTst.driver;
import static utilities.NewExtendReport.extent;
import static utilities.NewExtendReport.logger;
import static utilities.NewExtendReport.logger2;
import static utilities.NewExtendReport.logger3;

public class DeleteDepartmentTest
{

    NewExtendReport newreportdpt1 =  new NewExtendReport();
    DeleteDepartmentElement deleteelementdpt = new DeleteDepartmentElement(driver);
    @BeforeTest
    public void  loginTest() throws InterruptedException
    {

       driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
       newreportdpt1.newReport("Delete department test","Delete_department_test");
       NewExtendReport.logger2 =  extent.createTest("Login Test");
       LoginTst logintest = new LoginTst();
       logintest.loginTestNew();
       logger2.log(Status.PASS, MarkupHelper.createLabel("User login  successfully", ExtentColor.GREEN));
       logger2.log(Status.PASS, MarkupHelper.createLabel("Company select successfully", ExtentColor.GREEN));

       extent.flush();
    }

    @Test(priority = 1)
    public void openDptDetailsTest() throws InterruptedException
    {
        NewExtendReport.logger3 =  extent.createTest("Open Department details page test");
        DashboardPagElement dashboardpge =new DashboardPagElement(driver);
        Thread.sleep(1000);
        dashboardpge.lnkdepartmet();

        logger3.log(Status.PASS,MarkupHelper.createLabel("Successfully open the department list",ExtentColor.GREEN));

        int rentdptcount = deleteelementdpt.recentDptCount();
        System.out.println("List of activate department count is "+  rentdptcount);
        logger3.log(Status.PASS,MarkupHelper.createLabel("List of activate department count is "+ rentdptcount,ExtentColor.GREEN));

        Thread.sleep(1000);
        deleteelementdpt.recentView();
        //deleteelementdpt.allView();
        logger3.log(Status.PASS,MarkupHelper.createLabel("Department select successfully",ExtentColor.GREEN));

        deleteelementdpt.clickMenuOver();
        logger3.log(Status.PASS,MarkupHelper.createLabel("Successfully click  on menu over flush drop down",ExtentColor.GREEN));

        extent.flush();
    }

    @Test(priority = 2)
    public void removDpt() throws InterruptedException {
        NewExtendReport.logger =  extent.createTest("Delete Department Test");
        deleteelementdpt.clickRemoveBtn();
        logger.log(Status.PASS,MarkupHelper.createLabel("click on remove option",ExtentColor.GREEN));

        deleteelementdpt.delteConfirmBtn();
        logger.log(Status.PASS,MarkupHelper.createLabel("click on confirm button",ExtentColor.GREEN));

        deleteelementdpt.okBtn();
        logger.log(Status.PASS,MarkupHelper.createLabel("Department delete successfully",ExtentColor.GREEN));

        int afterrentdptcount = deleteelementdpt.recentDptCount();
        System.out.println("after delete recent department count ="+  afterrentdptcount);
        logger.log(Status.PASS,MarkupHelper.createLabel("after delete department count is ="+ afterrentdptcount,ExtentColor.GREEN));

        extent.flush();
    }


}
