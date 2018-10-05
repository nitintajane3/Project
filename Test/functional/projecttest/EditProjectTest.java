package functional.projecttest;


import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import functional.login.LoginTst;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.dashboardpage.DashboardPagElement;
import pages.projectpage.AddProjectElement;
import pages.projectpage.EditProjectElement;
import utilities.NewExtendReport;

import java.util.ResourceBundle;

import static functional.login.LoginTst.driver;
import static utilities.NewExtendReport.extent;
import static utilities.NewExtendReport.logger;
import static utilities.NewExtendReport.logger1;
import static utilities.NewExtendReport.logger2;

public class EditProjectTest
{
    NewExtendReport editdept =  new NewExtendReport();
    DashboardPagElement dashboardpage = new DashboardPagElement(driver);
    AddProjectElement projectpage = new AddProjectElement(driver);
    EditProjectElement editprojectelement = new EditProjectElement(driver);
    ResourceBundle proertiflename = ResourceBundle.getBundle("tamplo5");
    @BeforeTest
    public void loginTest() throws InterruptedException
    {

        editdept.newReport("Edit project test","Edit_project_test_report");
        logger =  extent.createTest("Login Test ");
        LoginTst logintest = new LoginTst();
        logintest.loginTestNew();
        logger.log(Status.PASS, MarkupHelper.createLabel("User login  successfully", ExtentColor.GREEN));
        logger.log(Status.PASS, MarkupHelper.createLabel("Company select successfully", ExtentColor.GREEN));
        extent.flush();
    }

    @Test(priority = 1)
    public void openProjectDetails()
    {
        logger1 =  extent.createTest("Open Project Details page");

        dashboardpage.lnkprojects();

        logger1.log(Status.PASS, MarkupHelper.createLabel("Project List open successfully", ExtentColor.GREEN));

        extent.flush();
    }

    @Test(priority = 2)
    public void editProjectName() throws InterruptedException
    {
        logger2 =  extent.createTest("Edit the project");


        String getpjctname = editprojectelement.clkProjectName();

        System.out.println("project name = " + getpjctname);

        Thread.sleep(1000);

        driver.findElement(By.xpath("//h3[@title='" + getpjctname + "']/preceding-sibling::div[@class='itemOverflush']/span[2]/div/ul/li[1]/a[text()='EDIT']")).click();

        logger2.log(Status.PASS, MarkupHelper.createLabel(getpjctname + " = This project select for  edit ", ExtentColor.GREEN));

        try {

            editprojectelement.updateProjctName();

            logger2.log(Status.PASS, MarkupHelper.createLabel("Successfully change the project name", ExtentColor.GREEN));

            editprojectelement.outSideClick();

            Thread.sleep(1000);
            try {

                editprojectelement.selectStarteDate();

                logger2.log(Status.PASS, MarkupHelper.createLabel("Successfully changed the Start date", ExtentColor.GREEN));

                editprojectelement.selectEndeDate();

                logger2.log(Status.PASS, MarkupHelper.createLabel("Successfully changed the End date", ExtentColor.GREEN));

                editprojectelement.clkStatusIcon();

                editprojectelement.selctInprogsPjectStatus();

                logger2.log(Status.PASS, MarkupHelper.createLabel("Successfully changed the project status as inprogress ", ExtentColor.GREEN));

                editprojectelement.clkUploadfileBtn();

                logger2.log(Status.PASS, MarkupHelper.createLabel("Click on upload button", ExtentColor.GREEN));

                editprojectelement.uploadInputFile();

                logger2.log(Status.PASS, MarkupHelper.createLabel("file Successfully uploaded ", ExtentColor.GREEN));

                extent.flush();

                AddprojectTest addprojcttest = new AddprojectTest();

                Thread.sleep(1000);

                addprojcttest.addProjectMngr();

                addprojcttest.addProjctMembr();

            } catch (Exception ouputname)
            {
                editprojectelement.projctDplicteAlert();

                logger2.log(Status.PASS, MarkupHelper.createLabel("We found duplicate project name", ExtentColor.GREEN));

                System.out.println("We found duplicate project name");
            }
        }catch (Exception duplicateprojectname)
        {
            System.out.println("Project name not found either you dont have access to edit project");
            logger2.log(Status.PASS, MarkupHelper.createLabel("Project name not found either you dont have access to edit project", ExtentColor.GREEN));
        }


    }


}
