package functional.projecttest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import functional.login.LoginTst;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.dashboardpage.DashboardPagElement;
import pages.departmentpage.DectiveDepartmentElement;
import pages.projectpage.AddProjectElement;
import pages.projectpage.EditProjectElement;
import pages.projectpage.RemveProjectUsrElement;
import utilities.NewExtendReport;

import java.util.ResourceBundle;

import static functional.login.LoginTst.driver;
import static utilities.NewExtendReport.extent;
import static utilities.NewExtendReport.logger;
import static utilities.NewExtendReport.logger2;
import static utilities.NewExtendReport.logger3;

public class RemveProjctUserTest
{
    NewExtendReport removeprjctuser =  new NewExtendReport();
    EditProjectElement editprojectelement = new EditProjectElement(driver);
    EditProjectTest  editprojecttest = new EditProjectTest();
    RemveProjectUsrElement removeprojectuserelement = new RemveProjectUsrElement(driver);
    DectiveDepartmentElement deactivedpeartmentelement = new DectiveDepartmentElement(driver);

    ResourceBundle proertiflename = ResourceBundle.getBundle("tamplo5");
    @BeforeTest
    public void loginTest() throws InterruptedException
    {

        removeprjctuser.newReport("Remove Project user test","Remove_project_user_test_report");
        logger =  extent.createTest("Login Test ");
        LoginTst logintest = new LoginTst();
        logintest.loginTestNew();
        logger.log(Status.PASS, MarkupHelper.createLabel("User login  successfully", ExtentColor.GREEN));
        logger.log(Status.PASS, MarkupHelper.createLabel("Company select successfully", ExtentColor.GREEN));
        extent.flush();
    }

    @Test(priority = 1)
    public void openProjectModuleTest()
    {
        editprojecttest.openProjectDetails();
    }

    @Test(priority = 2)
    public void openProjctdtlsAdClkEdtBttnTest() throws InterruptedException
    {
        logger2 =  extent.createTest("Open  the project details page and Click  on edit button");


        String getpjctname = editprojectelement.clkProjectName();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//h3[@title='" + getpjctname + "']/preceding-sibling::div[@class='itemOverflush']/span[2]/div/ul/li[1]/a[text()='EDIT']")).click();

        logger2.log(Status.PASS, MarkupHelper.createLabel(getpjctname + " = This project select for  edit ", ExtentColor.GREEN));

        removeprojectuserelement.searchNameAndEditBtn();

        logger2.log(Status.PASS, MarkupHelper.createLabel(getpjctname + " = This project select for  edit ", ExtentColor.GREEN));

        extent.flush();
    }

    @Test(priority = 3,enabled = false)
    public void RemoveUserFrmPject()
    {
        logger3 =  extent.createTest("Click on Remove button test");

        int befremovemngrcount = editprojectelement.activeManagerPjectCnt();

        logger3.log(Status.PASS, MarkupHelper.createLabel("Before Remove manager count is = " + befremovemngrcount, ExtentColor.GREEN));

        int beformovemembercount = editprojectelement.activeMemberProjctCont();

        logger3.log(Status.PASS, MarkupHelper.createLabel("Before Remove member count is = " + beformovemembercount, ExtentColor.GREEN));

        removeprojectuserelement.remveUserButton();

        logger3.log(Status.PASS, MarkupHelper.createLabel("Successfully click on remove button", ExtentColor.GREEN));

        deactivedpeartmentelement.confirmBtn();

        deactivedpeartmentelement.okBtn();

        logger3.log(Status.PASS, MarkupHelper.createLabel("User successfully remove from project", ExtentColor.GREEN));

        int aftermovemngrcount = editprojectelement.activeManagerPjectCnt();

        logger3.log(Status.PASS, MarkupHelper.createLabel("After Remove manager count is = " + aftermovemngrcount, ExtentColor.GREEN));

        int aftermovemembercount = editprojectelement.activeMemberProjctCont();

        logger3.log(Status.PASS, MarkupHelper.createLabel("after Remove member count is = " + aftermovemembercount, ExtentColor.GREEN));

        extent.flush();
    }
}

