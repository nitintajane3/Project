package functional.projecttest;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.relevantcodes.extentreports.LogStatus;
import functional.departmenttest.AddDepartmentTest;
import functional.login.LoginTst;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.dashboardpage.DashboardPagElement;
import pages.projectpage.AddProjectElement;
import utilities.NewExtendReport;
import utilities.Reportsextend;
import static functional.login.LoginTst.driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import static utilities.NewExtendReport.*;
import static utilities.Reportsextend.test;

public class AddprojectTest
{

    NewExtendReport editdept =  new NewExtendReport();
    DashboardPagElement dashboardpage = new DashboardPagElement(driver);
    AddProjectElement projectpage = new AddProjectElement(driver);
    ResourceBundle proertiflename = ResourceBundle.getBundle("tamplo5");

   @BeforeTest
   public void loginTest() throws InterruptedException
   {

       editdept.newReport("Add project test","Add_project_test_report");
       logger =  extent.createTest("Login Test");
       LoginTst logintest = new LoginTst();
       logintest.loginTestNew();
       logger.log(Status.PASS, MarkupHelper.createLabel("User login  successfully", ExtentColor.GREEN));
       logger.log(Status.PASS, MarkupHelper.createLabel("Company select successfully", ExtentColor.GREEN));
       extent.flush();
   }

   @Test(priority = 1)
   public void openProjectPage() throws InterruptedException
   {
       logger1 =  extent.createTest("Open Project page Test");

       dashboardpage.lnkprojects();

       logger1.log(Status.PASS, MarkupHelper.createLabel("Project List open successfully", ExtentColor.GREEN));


       extent.flush();
   }

    @Test(priority = 2, enabled = true)
    public void addProjectName() throws InterruptedException
    {
        logger2 =  extent.createTest("Open Add Project form Test");

        projectpage.createproject();
        logger2.log(Status.PASS, MarkupHelper.createLabel("Click  on add project button ", ExtentColor.GREEN));

        Thread.sleep(1000);

        projectpage.selectdptname();

        Thread.sleep(100);

        projectpage.enterprojectname(proertiflename.getString("projectname"));

        logger2.log(Status.PASS, MarkupHelper.createLabel("Project title entered ", ExtentColor.GREEN));

        Thread.sleep(200);

        projectpage.clickemptyspace();

        Thread.sleep(500);

        try
        {

            projectpage.verfifyDuplicatePjectAlert();

            projectpage.okBtnPopup();

            logger2.log(Status.FAIL, MarkupHelper.createLabel("This Project name already exist", ExtentColor.RED));

        }catch (Exception ouputtest)
        {
            projectpage.okBtnPopup();

            logger2.log(Status.PASS, MarkupHelper.createLabel("Project name save successfully", ExtentColor.GREEN));
        }



         extent.flush();
    }

    @Test(priority = 3,enabled = true)
    public void addProjectMngr() throws InterruptedException
    {
        logger3 =  extent.createTest("Add Project manager Test");

        projectpage.clickaddprojectmanager();

        logger3.log(Status.PASS, MarkupHelper.createLabel("Click on add button of manager account", ExtentColor.GREEN));

        AddprojectTest addprojecttest =new AddprojectTest();

        addprojecttest.addUserDetailsTest(logger3,proertiflename.getString("projectuser1"));

        dashboardpage.lftPanelPjectLnk();

        Thread.sleep(1000);

        extent.flush();

    }

    @Test(priority = 4,enabled = true)
    public void addProjctMembr() throws InterruptedException
    {
        logger4 =  extent.createTest("Add Project manager Test");

        projectpage.clickbuttonprojectmember();

        logger4.log(Status.PASS, MarkupHelper.createLabel("Click on add button of member account", ExtentColor.GREEN));

        AddprojectTest addprojecttest =new AddprojectTest();

        addprojecttest.addUserDetailsTest(logger4,proertiflename.getString("projectuser2"));

        dashboardpage.lftPanelPjectLnk();

        Thread.sleep(1000);

        extent.flush();
    }



    public void addUserDetailsTest(ExtentTest logrvrble,String useremailname) throws InterruptedException
    {

            projectpage.entertextAddpeople(useremailname);

            logrvrble.log(Status.PASS, MarkupHelper.createLabel("user email address entered ", ExtentColor.GREEN));

            projectpage.clicksavebutton();

            logrvrble.log(Status.PASS, MarkupHelper.createLabel("Click on save button", ExtentColor.GREEN));

            Thread.sleep(200);

            try
            {
                projectpage.verfyDuplictePjctUserAlrt();

                logrvrble.log(Status.FAIL, MarkupHelper.createLabel("This user already added", ExtentColor.RED));

                projectpage.okBtnPopup();

                projectpage.btnCancelAddUr();

            } catch (Exception ouputtest)
            {
                projectpage.okBtnPopup();

                logrvrble.log(Status.PASS, MarkupHelper.createLabel("User successfully added ", ExtentColor.GREEN));

            }
        }
}


