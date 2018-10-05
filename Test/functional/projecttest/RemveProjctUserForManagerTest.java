package functional.projecttest;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import functional.login.LoginTst;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.departmentpage.DectiveDepartmentElement;
import pages.projectpage.EditProjectElement;
import pages.projectpage.RemveProjectUsrElement;
import utilities.NewExtendReport;

import java.util.ResourceBundle;

import static functional.login.LoginTst.driver;
import static utilities.NewExtendReport.extent;
import static utilities.NewExtendReport.logger;
import static utilities.NewExtendReport.logger1;
import static utilities.NewExtendReport.logger2;

public class RemveProjctUserForManagerTest
{
    NewExtendReport removeprjctuser =  new NewExtendReport();
    EditProjectTest  editprojecttest = new EditProjectTest();
    RemveProjectUsrElement removeprojectuserelement = new RemveProjectUsrElement(driver);
    DectiveDepartmentElement deactivedpeartmentelement = new DectiveDepartmentElement(driver);
    ResourceBundle proertiflename = ResourceBundle.getBundle("tamplo5");
    @BeforeTest
    public void loginTest() throws InterruptedException
    {

        removeprjctuser.newReport("Remove Project user for manager account test","Remove_project_user_mnger_account_test_report");
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
    public void removeProjectMembrTest() throws InterruptedException
    {
        logger2 =  extent.createTest("Remove Project member");

        removeprojectuserelement.clkProjectName();

        logger2.log(Status.PASS, MarkupHelper.createLabel("Project Select successfuly", ExtentColor.GREEN));

        try
        {
            Thread.sleep(500);
            removeprojectuserelement.clkOnTeamMemberlist();
            logger2.log(Status.PASS, MarkupHelper.createLabel("Successfully open the team member list", ExtentColor.GREEN));

            try {

                Thread.sleep(1000);
                boolean ispensne = driver.findElement(By.xpath("//div[@class='userSection ng-scope']/div[1]/ul[@class='projectActionsList']/li/div[4]/button")).isDisplayed();
                System.out.println("bollen out put is =  " + ispensne);

                logger2.log(Status.PASS, MarkupHelper.createLabel("Login User not a project manager ", ExtentColor.RED));


            }catch (Exception userstatus)
            {
                String membername = removeprojectuserelement.memberEditButton();

                logger2.log(Status.PASS, MarkupHelper.createLabel(membername + " = This member select then Click on edit button", ExtentColor.GREEN));

                removeprojectuserelement.remveUserButton();

                logger2.log(Status.PASS, MarkupHelper.createLabel("Click on remove button", ExtentColor.GREEN));

                deactivedpeartmentelement.confirmBtn();

                logger2.log(Status.PASS, MarkupHelper.createLabel("Click on confirm button", ExtentColor.GREEN));

                deactivedpeartmentelement.okBtn();

                logger2.log(Status.PASS, MarkupHelper.createLabel("User successfully removed form  member position", ExtentColor.GREEN));
            }



        }catch (Exception nouserpresnrt)
        {
            System.out.println("No user present in this project");
            logger2.log(Status.PASS, MarkupHelper.createLabel("No user present in this project", ExtentColor.RED));
            logger2.log(Status.PASS, MarkupHelper.createLabel("Either login user not a project member", ExtentColor.RED));
        }
        extent.flush();
    }
}
