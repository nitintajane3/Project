package functional.projecttest;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import functional.login.LoginTst;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.dashboardpage.DashboardPagElement;
import pages.departmentpage.DectiveDepartmentElement;
import pages.projectpage.AddProjectElement;
import pages.projectpage.EditProjectElement;
import pages.projectpage.RemveProjectUsrElement;
import utilities.NewExtendReport;

import static functional.login.LoginTst.driver;
import static utilities.NewExtendReport.extent;
import static utilities.NewExtendReport.logger;
import static utilities.NewExtendReport.logger2;
import static utilities.NewExtendReport.logger3;

public class MoveProjectUserTest
{
    NewExtendReport removeprjctuser =  new NewExtendReport();
    EditProjectTest  editprojecttest = new EditProjectTest();
    EditProjectElement editprojectelement = new EditProjectElement(driver);
    RemveProjectUsrElement removeprojectuserelement = new RemveProjectUsrElement(driver);
    RemveProjctUserTest remveprojctusertest = new RemveProjctUserTest();

    @BeforeTest
    public void loginTest() throws InterruptedException
    {

        removeprjctuser.newReport("Move Project User Test","Move_project_user_test_report");
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
    public void MoveUserTest() throws InterruptedException
    {


        remveprojctusertest.openProjctdtlsAdClkEdtBttnTest();

        logger3 =  extent.createTest("User Move test ");

        int befremovemngrcount = editprojectelement.activeManagerPjectCnt();

        logger3.log(Status.PASS, MarkupHelper.createLabel("Before move manager count is = " + befremovemngrcount, ExtentColor.GREEN));

        int beformovemembercount = editprojectelement.activeMemberProjctCont();

        logger3.log(Status.PASS, MarkupHelper.createLabel("Before move member count is = " + beformovemembercount, ExtentColor.GREEN));


        try {


            removeprojectuserelement.clkUserIconBtn();

            logger3.log(Status.PASS, MarkupHelper.createLabel(" Click on user icon", ExtentColor.GREEN));

            String usermovefrmto = removeprojectuserelement.UserMoveOptionSelct();

            logger3.log(Status.PASS, MarkupHelper.createLabel(" User successfully move to " + usermovefrmto + " position", ExtentColor.GREEN));

        }catch (Exception nouserprsetn)
        {
            logger3.log(Status.PASS, MarkupHelper.createLabel("Entered user not present in project", ExtentColor.RED));
        }

        Thread.sleep(1000);

        int aftermovemngrcount = editprojectelement.activeManagerPjectCnt();

        logger3.log(Status.PASS, MarkupHelper.createLabel("After move manager count is = " + aftermovemngrcount, ExtentColor.GREEN));

        int aftermovemembercount = editprojectelement.activeMemberProjctCont();

        logger3.log(Status.PASS, MarkupHelper.createLabel("after move member count is = " + aftermovemembercount, ExtentColor.GREEN));

        extent.flush();
    }
}
