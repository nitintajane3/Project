package functional.personaltasktest;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import functional.login.LoginTst;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.actionspage.AddactionProjectElement;
import pages.dashboardpage.DashboardPagElement;
import pages.departmentpage.DectiveDepartmentElement;
import pages.personaltaskpage.AddPersonalTkElement;
import pages.personaltaskpage.DeletPersonlTaskEelment;
import pages.projectpage.RemveProjectUsrElement;
import utilities.NewExtendReport;

import static functional.login.LoginTst.driver;
import static utilities.NewExtendReport.*;

public class DeletePersonalTaskTest
{
    NewExtendReport addpersonaltask =  new NewExtendReport();
    DeletPersonlTaskEelment deltepersnaltaskelement = new DeletPersonlTaskEelment(driver);
    DectiveDepartmentElement deactivedptemementpage = new DectiveDepartmentElement(driver);
    AddPersonalTkElement addpersnaltaskelemet = new AddPersonalTkElement(driver);

    @BeforeTest
    public void loginTest() throws InterruptedException
    {

        addpersonaltask.newReport("Delete personal task test","Delete_personal_Task_test_report");
        logger =  extent.createTest("Login Test ");
        LoginTst logintest = new LoginTst();
        logintest.loginTestNew();
        logger.log(Status.PASS, MarkupHelper.createLabel("User login  successfully", ExtentColor.GREEN));
        logger.log(Status.PASS, MarkupHelper.createLabel("Company select successfully", ExtentColor.GREEN));
        extent.flush();
    }
    @Test(priority = 1)
    public void linkPersonalTask()
    {
        logger1 =  extent.createTest("Open personal task  module test");
        DashboardPagElement dashboardpage = new DashboardPagElement(driver);      //dashboard page element object created

        dashboardpage.linkPersonalTask();
        logger1.log(Status.PASS, MarkupHelper.createLabel("Successfully link to personal task", ExtentColor.GREEN));
        extent.flush();
    }


    @Test(priority = 2,enabled = true)
    public void delteCriticalTaskTest() throws InterruptedException
    {
        logger2 =  extent.createTest("Delete Critical  personal task step");

        String variblename = "Critical";

        int befrecrircalPersonalcount = addpersnaltaskelemet.getCriticalCount();

        logger2.log(Status.PASS,MarkupHelper.createLabel("before delete Critical personal task count is = " + befrecrircalPersonalcount,ExtentColor.GREEN));

        Thread.sleep(500);

        deltepersnaltaskelement.editBtnCriticaltest();

        logger2.log(Status.PASS, MarkupHelper.createLabel("Click on Add button of critical section", ExtentColor.GREEN));

        logger2.log(Status.PASS, MarkupHelper.createLabel("Click on edit button", ExtentColor.GREEN));

        deleteAction(logger2,variblename);

        Thread.sleep(500);

        int aftrcrircalPersonalcount = addpersnaltaskelemet.getCriticalCount();

        logger2.log(Status.PASS,MarkupHelper.createLabel("after delete Critical personal task count is = " + aftrcrircalPersonalcount,ExtentColor.GREEN));


        extent.flush();


    }

    @Test(priority = 3,enabled = true)
    public void delteImportntTaskTest() throws InterruptedException
    {
        logger3 =  extent.createTest("Delete Important  personal task step");

        String variblename = "Important";

        int befreimportnatPersonalcount = addpersnaltaskelemet.getImportntCount();

        logger3.log(Status.PASS,MarkupHelper.createLabel("before delete important personal task count is = " + befreimportnatPersonalcount,ExtentColor.GREEN));


        deltepersnaltaskelement.editBtnImportnt();

        logger3.log(Status.PASS, MarkupHelper.createLabel("Click on Add button of important section", ExtentColor.GREEN));

        logger3.log(Status.PASS, MarkupHelper.createLabel("Click on edit button", ExtentColor.GREEN));

        deleteAction(logger3,variblename);

        Thread.sleep(500);

        int aftrimportnatPersonalcount = addpersnaltaskelemet.getImportntCount();

        logger3.log(Status.PASS,MarkupHelper.createLabel("after delete important personal task count is = " + aftrimportnatPersonalcount,ExtentColor.GREEN));


        extent.flush();
    }

    @Test(priority = 4,enabled = true)
    public void delteLessImportntTaskTest() throws InterruptedException
    {
        logger4 =  extent.createTest("Delete Less important  personal task step");

        String variblename = "Less Important";

        int befrelessimportnatPersonalcount = addpersnaltaskelemet.getLessImportntCount();

        logger4.log(Status.PASS,MarkupHelper.createLabel("before delete less important personal task count is = " + befrelessimportnatPersonalcount,ExtentColor.GREEN));


        deltepersnaltaskelement.editBtnLessImportntTest();

        logger4.log(Status.PASS, MarkupHelper.createLabel("Click on Add button of less important section", ExtentColor.GREEN));

        logger4.log(Status.PASS, MarkupHelper.createLabel("Click on edit button", ExtentColor.GREEN));

        deleteAction(logger4,variblename);

        Thread.sleep(500);

        int afterlessimportnatPersonalcount = addpersnaltaskelemet.getLessImportntCount();

        logger4.log(Status.PASS,MarkupHelper.createLabel("after delete less important personal task count is = " + afterlessimportnatPersonalcount,ExtentColor.GREEN));


        extent.flush();
    }


    public void deleteAction(ExtentTest loggervrible, String nameimportnace)
    {
        try {

            deltepersnaltaskelement.clkThreeDot();

            loggervrible.log(Status.PASS, MarkupHelper.createLabel("Click on Three dot", ExtentColor.GREEN));

            deltepersnaltaskelement.selectDelteOption();

            loggervrible.log(Status.PASS, MarkupHelper.createLabel("Select delete option", ExtentColor.GREEN));

            deactivedptemementpage.confirmBtn();

            loggervrible.log(Status.PASS, MarkupHelper.createLabel("Click on confirm button", ExtentColor.GREEN));

            deactivedptemementpage.okBtn();

            loggervrible.log(Status.PASS, MarkupHelper.createLabel("Personal Task delete successfully from " + nameimportnace, ExtentColor.GREEN));

        }catch (Exception notfinf)
        {
            loggervrible.log(Status.PASS, MarkupHelper.createLabel("Delete button not found", ExtentColor.GREEN));
            System.out.println("Delete button not found");
        }
    }

}
